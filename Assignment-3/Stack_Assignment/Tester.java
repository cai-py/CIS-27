public class Tester {
    public static void main(String[] args) {
        String infixExpression = "3+2+5*5-(3*9)";
        System.out.println(infixExpression);
        String postfixExpression = InfixToPostfix.convert(infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression); // 32+55*+39*-

        System.out.println("Result: " + EvaluatePostfix.convert(postfixExpression));
    }
}

/*
32
++
 */



//import java.util.Scanner;
//
//class Tester {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter an infix expression: ");
//        String infixExpression = scanner.nextLine();
//        scanner.close();
//
//        // Convert infix to postfix
//        String postfixExpression = InfixToPostfix.convert(infixExpression);
//        System.out.println("Postfix Expression: " + postfixExpression);
//
//        // Evaluate the postfix expression
//        int result = EvaluatePostfix.evaluate(postfixExpression);
//        System.out.println("Final Result: " + result);
//    }
//}
