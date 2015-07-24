package lc.p20150718;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -,
 * non-negative integers and empty spaces .
 * You may assume that the given expression is always valid.
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 */
public class BasicCalculator {
    public int calculate(String s) {
        return processOp(new Tokenizer(s));
    }

    private int processOp(Tokenizer tokenizer) {
        Integer left = processExpression(tokenizer);
        if (left == null) {
            return 0;
        }
        String operation;
        while ((operation = readOp(tokenizer)) != null) {
            Integer right = processExpression(tokenizer);
            if (operation.equals("+")) {
                left = left + right;
            } else if (operation.equals("-")) {
                left = left - right;
            } else {
                return left;
            }
        }
        return left;
    }

    private String readOp(Tokenizer tokenizer) {
        String token = tokenizer.nextToken();
        if (token == null) {
            return null;
        }
        if (token.equals(Tokenizer.END_PARENTHESIS)) {
            tokenizer.pushBack();
            return null;
        }
        if (token.length() != 1 || !Tokenizer.isOperation(token.charAt(0))) {
            throw new IllegalStateException("Unexpected char: " + token);
        }
        return token;
    }

    private Integer processExpression(Tokenizer tokenizer) {
        String left = tokenizer.nextToken();
        if (left == null) {
            return null;
        }
        Integer result;
        if (left.equals(Tokenizer.START_PARENTHESIS)) {
            result = processOp(tokenizer);
            assert tokenizer.nextToken().equals(Tokenizer.END_PARENTHESIS);
        } else {
            result = Integer.parseInt(left);
        }
        String operation;
        while ((operation = tokenizer.nextToken()) != null) {
            if (!Tokenizer.MULT_OPS.contains(operation)) {
                tokenizer.pushBack();
                break;
            }
            String right = tokenizer.nextToken();
            if (operation.equals("*")) {
                result = result * Integer.parseInt(right);
            } else {
                result = result / Integer.parseInt(right);
            }
        }
        return result;
    }

    static class Tokenizer {
        private int index;
        private int prevTokenIndex;
        private final String str;
        public static final Set<String> MULT_OPS =
                Collections.unmodifiableSet(new HashSet<>(Arrays.asList("*", "/")));
        public static final Set<String> ADD_OPS =
                Collections.unmodifiableSet(new HashSet<>(Arrays.asList("+", "-")));
        public static final String START_PARENTHESIS = "(";
        public static final String END_PARENTHESIS = ")";

        public Tokenizer(String s) {
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
            char ch = str.charAt(index);
            if (isOperation(ch)) {
                return Character.toString(str.charAt(index++));
            } else if (Character.isDigit(ch)) {
                return readNumber();
            } else if (Character.toString(ch).equals(Tokenizer.START_PARENTHESIS)
                    || Character.toString(ch).equals(Tokenizer.END_PARENTHESIS)) {
                index++;
                return Character.toString(ch);
            }
            throw new IllegalStateException("Unknown symbol: " + ch);
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
