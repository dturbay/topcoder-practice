package lc.p20150717;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces.
 * The integer division should truncate toward zero.
 * You may assume that the given expression is always valid.
 */
public class BasicCalculator2 {

    public int calculate(String s) {
        return processOp(new Tockenizer(s));
    }

    private int processOp(Tockenizer tockenizer) {
        Integer left = processExpression(tockenizer);
        if (left == null) {
            return 0;
        }
        String operation;
        while ((operation = readOp(tockenizer)) != null) {
            Integer right = processExpression(tockenizer);
            if (operation.equals("+")) {
                left = left + right;
            } else {
                left = left - right;
            }
        }
        return left;
    }

    private String readOp(Tockenizer tockenizer) {
        String token = tockenizer.nextToken();
        if (token == null) {
            return null;
        }
        if (token.length() != 1 || !Tockenizer.isOperation(token.charAt(0))) {
            throw new IllegalStateException("Unexpected char: " + token);
        }
        return token;
    }

    private Integer processExpression(Tockenizer tockenizer) {
        String left = tockenizer.nextToken();
        if (left == null) {
            return null;
        }
        Integer result = Integer.parseInt(left);
        String operation;
        while ((operation = tockenizer.nextToken()) != null) {
            if (!Tockenizer.MULT_OPS.contains(operation)) {
                tockenizer.pushBack();
                break;
            }
            String right = tockenizer.nextToken();
            if (operation.equals("*")) {
                result = result * Integer.parseInt(right);
            } else {
                result = result / Integer.parseInt(right);
            }
        }
        return result;
    }

    static class Tockenizer {
        private int index;
        private int prevTokenIndex;
        private final String str;
        public static final Set<String> MULT_OPS =
                Collections.unmodifiableSet(new HashSet<>(Arrays.asList("*", "/")));
        public static final Set<String> ADD_OPS =
                Collections.unmodifiableSet(new HashSet<>(Arrays.asList("+", "-")));

        public Tockenizer(String s) {
            this.index = 0;
            this.str = s;
            this.prevTokenIndex = 0;
        }

        public String nextToken() {
            skipSpaces();
            if (!checkIndex()) {
                return null;
            }
            prevTokenIndex = index;
            if (isOperation(str.charAt(index))) {
                return Character.toString(str.charAt(index++));
            } else if (Character.isDigit(str.charAt(index))) {
                return readNumber();
            }
            throw new IllegalStateException("Unknown symbol: " + str.charAt(index));
        }

        public static boolean isOperation(char ch) {
            return MULT_OPS.contains(Character.toString(ch))
                || ADD_OPS.contains(Character.toString(ch));
        }

        private boolean checkIndex() {
            return index < str.length();
        }

        private String readNumber() {
            if (!checkIndex()) {
                return null;
            }
            String number = "";
            while (checkIndex() && Character.isDigit(str.charAt(index))) {
                number += str.charAt(index);
                index++;
            }
            return number;
        }

        private void skipSpaces() {
            while (checkIndex() && str.charAt(index) == ' ') {
                index++;
            }
        }

        public void pushBack() {
            if (prevTokenIndex == index) {
                throw new IllegalStateException("There is nothing to push back");
            }
            index = prevTokenIndex;
        }
    }
}
