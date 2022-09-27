package com.belyf;

import java.math.BigInteger;
import java.util.*;


class HandshakeCalculator {
    private static final Map<BigInteger, String> RULES = new LinkedHashMap<>();
    private static final BigInteger wink = new BigInteger("1", 2);
    private static final BigInteger doubleBlink = new BigInteger("10", 2);
    private static final BigInteger closeYourEyes = new BigInteger("100", 2);
    private static final BigInteger jump = new BigInteger("1000", 2);
    private static final BigInteger reverse = new BigInteger("10000", 2);

    HandshakeCalculator(){
        RULES.put(wink, "WINK");
        RULES.put(doubleBlink, "DOUBLE_BLINK");
        RULES.put(closeYourEyes, "CLOSE_YOUR_EYES");
        RULES.put(jump, "JUMP");
        RULES.put(reverse, "REVERSE");
    }

    List<Signal> calculateHandshake(int number) {
        BigInteger binary = new BigInteger(String.valueOf(number));
        List<Signal> result = new ArrayList<>();
        boolean reverse = false;

        while(binary.compareTo(new BigInteger("0")) > 0) {
            if(binary.compareTo(HandshakeCalculator.reverse) >= 0) {
                reverse = !reverse;
                binary = binary.subtract(HandshakeCalculator.reverse);
            } else if(binary.compareTo(HandshakeCalculator.jump) >= 0) {
                result.add(0, Signal.JUMP);
                binary = binary.subtract(HandshakeCalculator.jump);
            } else if(binary.compareTo(HandshakeCalculator.closeYourEyes) >= 0) {
                result.add(0, Signal.CLOSE_YOUR_EYES);
                binary = binary.subtract(HandshakeCalculator.closeYourEyes);
            } else if(binary.compareTo(HandshakeCalculator.doubleBlink) >= 0) {
                result.add(0, Signal.DOUBLE_BLINK);
                binary = binary.subtract(HandshakeCalculator.doubleBlink);
            } else if(binary.compareTo(HandshakeCalculator.wink) >= 0) {
                result.add(0, Signal.WINK);
                binary = binary.subtract(HandshakeCalculator.wink);
            }
        }

        if(reverse)
            Collections.reverse(result);
        return result;
    }
}

enum Signal {
    WINK,
    DOUBLE_BLINK,
    CLOSE_YOUR_EYES,
    JUMP;
}
