package com.belyf;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogLevels {
    private static Pattern pattern = Pattern.compile("^\\[(INFO|DEBUG|ERROR)\\]: ([\\w\\s]+)");

    public static String message(String logLine) {
        Matcher matcher = pattern.matcher(logLine);
        matcher.matches();
        return matcher.group(2).trim();
    }

    public static String logLevel(String logLine) {
        Matcher matcher = pattern.matcher(logLine);
        matcher.matches();
        return matcher.group(1).toLowerCase();
    }

    public static String reformat(String logLine) {
        return String.format("%s (%s)", message(logLine), logLevel(logLine));
    }

    public static void main(String[] args) {
        System.out.println(LogLevels.reformat("[ERROR]: \t Corrupt disk\t \t \r\n"));
    }

    public String twofer(String name) {
        return String.format("One for %s, one for me.", name != null && !"".equals(name.trim()) ? name: "you" );
    }
}
