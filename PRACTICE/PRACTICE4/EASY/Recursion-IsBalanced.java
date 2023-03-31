import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        boolean result = isBalanced(str);
        System.out.println(result);
    }
    
    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (isOpeningBracket(c)) {
                stack.push(c);
            } else if (isClosingBracket(c)) {
                if (stack.isEmpty() || !isMatch(stack.peek(), c)) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    
    public static boolean isOpeningBracket(char c) {
        return c == '(' || c == '{' || c == '[';
    }
    
    public static boolean isClosingBracket(char c) {
        return c == ')' || c == '}' || c == ']';
    }
    
    public static boolean isMatch(char open, char close) {
        return (open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']');
    }
}
