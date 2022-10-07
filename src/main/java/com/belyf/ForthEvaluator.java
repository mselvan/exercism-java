package com.belyf;

import java.util.*;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;

class ForthEvaluator {
    public static final String COLON = ":";
    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String ASTERISK = "*";
    public static final String SLASH = "/";
    public static final String DUPLICATE = "dup";
    public static final String DROP = "drop";
    public static final String SWAP = "swap";
    public static final String OVER = "over";
    private Stack<Integer> stack = new Stack<>();
    private Map<String, List<String>> macros = new HashMap<>();

    List<Integer> evaluateProgram(List<String> commands) {
        for (String command : commands) {
            evaluateCommand(command.toLowerCase().trim());
        }
        return stack;
    }

    private void evaluateCommand(String command) {
        List<String> words = Arrays.stream(command.split("\\s+")).collect(Collectors.toList());
        while (!words.isEmpty()) {
            String word = words.get(0);
            words.remove(0);

            if (isNumber(word))
                stack.push(Integer.parseInt(word));
            else if (macros.containsKey(word))
                words.addAll(0, macros.get(word));
            else
                executeCommand(word, words);
        }
    }

    public static void main(String[] args) {
        ForthEvaluator evaluator = new ForthEvaluator();
        evaluator.executeCommand("+", Arrays.asList("1"));
    }

    private void executeCommand(String operator, List<String> words) {
        switch (operator) {
            case COLON:
                recordMacro(words);
                break;
            case PLUS:
                binaryOperation("Addition", (a, b) -> a + b);
                break;
            case MINUS:
                binaryOperation("Subtraction", (a, b) -> a - b);
                break;
            case ASTERISK:
                binaryOperation("Multiplication", (a, b) -> a * b);
                break;
            case SLASH:
                if (!stack.empty() && stack.peek() == 0) {
                    throw new IllegalArgumentException("Division by 0 is not allowed");
                }
                binaryOperation("Division", (a, b) -> a / b);
                break;
            case DUPLICATE:
                dup();
                break;
            case DROP:
                drop();
                break;
            case SWAP:
                swap();
                break;
            case OVER:
                over();
                break;
            default:
                throw new IllegalArgumentException(String.format("No definition available for operator \"%s\"", operator));
        }
    }

    private boolean isNumber(String word) {
        try {
            Integer.parseInt(word, 10);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private int[] pop(int n, String operation) {
        int[] operands = new int[n];
        for (int i = 1; i <= n; i++) {
            if (stack.empty()) {
                throw new IllegalArgumentException(String.format("%s requires that the stack contain at least %d value%s", operation, n, n == 1 ? "" : "s"));
            }
            operands[n - i] = stack.pop();
        }
        return operands;
    }

    private void checkEnoughElements(int n, String err) throws IllegalArgumentException {
        if (stack.size() < n) {
            throw new IllegalArgumentException(err);
        }
    }

    private void binaryOperation(String operation, IntBinaryOperator op) {
        int[] operands = pop(2, operation);
        stack.push(op.applyAsInt(operands[0], operands[1]));
    }

    private void dup() {
        int[] element = pop(1, "Duplicating");
        stack.push(element[0]);
        stack.push(element[0]);
    }

    private void drop() {
        pop(1, "Dropping");
    }

    private void swap() {
        int[] operands = pop(2, "Swapping");
        stack.push(operands[1]);
        stack.push(operands[0]);
    }

    private void over() {
        int[] operands = pop(2, "Overing");
        stack.push(operands[0]);
        stack.push(operands[1]);
        stack.push(operands[0]);
    }

    private void recordMacro(List<String> words) {
        String macroName = words.get(0);
        words.remove(0);
        if (isNumber(macroName))
            throw new IllegalArgumentException("Cannot redefine numbers");

        if (words.get(words.size() - 1).equals(";"))
            words.remove(words.size() - 1);
        else
            throw new IllegalArgumentException("Macro does not end with \";\"");

        // the macro definition may contain macros that need to be expanded
        while (expandMacrosInMacroDefinition(words)) {
        }

        macros.put(macroName, new ArrayList<>(words)); // _copy_ the macro
        while (!words.isEmpty()) words.remove(0); // and consume the rest of the command.
    }

    private boolean expandMacrosInMacroDefinition(List<String> words) {
        boolean hasExpanded = false;
        for (int i = words.size() - 1; i >= 0; i--) {
            String word = words.get(i);
            if (macros.containsKey(word)) {
                words.remove(i);
                words.addAll(i, macros.get(word));
                hasExpanded = true;
            }
        }
        return hasExpanded;
    }
}