public class EvaluatePostfix {

    public static int evaluate(String postfix) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            // If character is an operand, push to stack
            if (Character.isDigit(c)) {
                stack.push(c - '0');  // Convert char to int
            }
            // If operator, pop two operands and apply the operator
            else if (isOperator(c)) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = applyOperator(c, operand1, operand2);
                stack.push(result);
            }
        }

        return stack.pop(); // Final result
    }

    // Helper function to apply the operator to operands
    private static int applyOperator(char operator, int operand1, int operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
        }
        return 0;
    }

    // Helper function to check if a character is an operator
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}
