public class InfixToPostfix {

    public static String convert(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack <Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            Character c = infix.charAt(i);

            if (Character.isDigit(c)) {
                postfix.append(c); // DONOTSUBMIT: doesnt handle multiple digit numbers yet
            }else if (c == '(') {
                stack.push(c);
            }else if (c == ')') {
                while (stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
            }else if (isOperator(c)) {
                if (stack.isEmpty() || precedence(c) > precedence(stack.peek()) || stack.peek() == '(') {
                    stack.push(c);
                }else {
                    while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                        postfix.append((stack.pop()));
                    }
                    stack.push(c);
                }
            }else if (c == ' ') {
                continue;
            }else {System.out.println("ERROR");}



            // 5 - 3 + 1
            // 5 - (3 + 1)

            System.out.println("***********");
            System.out.println(postfix); //
            System.out.println(stack);
            System.out.println(c);

        }

        System.out.println(postfix);

        return postfix.toString();
    }

    private static int precedence(char operator) {
        return switch (operator) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> -1; //ERROR
        };
    }

    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }


}
















//public class InfixToPostfix {
//
//    public static String convert(String infix) {
//        StringBuilder postfix = new StringBuilder();
//        Stack<Character> stack = new Stack<>();
//
//        for (int i = 0; i < infix.length(); i++) {
//            char c = infix.charAt(i);
//
//            // If character is an operand, add to postfix expression
//            if (Character.isDigit(c)) {
//                postfix.append(c);
//            }
//            // If character is '(', push to stack
//            else if (c == '(') {
//                stack.push(c);
//            }
//            // If character is ')', pop and append to postfix until '(' is found
//            else if (c == ')') {
//                while (!stack.isEmpty() && stack.peek() != '(') {
//                    postfix.append(stack.pop());
//                }
//                stack.pop(); // Remove '(' from the stack
//            }
//            // If an operator, pop operators from stack to postfix based on precedence
//            else if (isOperator(c)) {
//                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
//                    postfix.append(stack.pop());
//                }
//                stack.push(c);
//            }
//        }
//
//        // Pop remaining operators in the stack
//        while (!stack.isEmpty()) {
//            postfix.append(stack.pop());
//        }
//
//        return postfix.toString();
//    }
//
//    // Helper function to check if a character is an operator
//    private static boolean isOperator(char c) {
//        return c == '+' || c == '-' || c == '*' || c == '/';
//    }
//
//    // Helper function to return precedence of operators
//    private static int precedence(char operator) {
//        switch (operator) {
//            case '+':
//            case '-':
//                return 1;
//            case '*':
//            case '/':
//                return 2;
//        }
//        return -1;
//    }
//}

