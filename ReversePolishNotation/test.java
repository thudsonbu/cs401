import java.util.Stack;
import java.util.HashMap;
import java.util.function.BiFunction;

public class test {
    public static void main(String args[]) {

        String[] expression = new String[]{"1", "2", "3", "+", "2", "*", "-"};
        
        System.out.println(reverseNotation(expression));
    }

    public static double reverseNotation(String[] expression) {

        // create stack that will hold equation elements
        Stack<String> stack = new Stack<String>(); 

        // read from expression
        for (String element : expression) {          

            switch(element) {
                case "+":
                    String add2 = stack.pop();
                    String add1 = stack.pop();

                    String addResult = addStrings(add1, add2);

                    stack.push(addResult);
                    break;
                case "-":
                    String subtract2 = stack.pop();
                    String subtract1 = stack.pop();
                    
                    String subtractResult = subtractStrings(subtract1, subtract2);

                    stack.push(subtractResult);
                    break;
                case "*":
                    String multiply2 = stack.pop();
                    String multiply1 = stack.pop();
                    

                    String multiplyResult = multiplyStrings(multiply1, multiply2);

                    stack.push(multiplyResult);
                    break;
                case "/":
                    String divide2 = stack.pop();
                    String divide1 = stack.pop();
                    

                    String divideResult = divideStrings(divide1, divide2);

                    stack.push(divideResult);
                    break;
                default:
                    stack.push(element);
            }
        }
        return Double.parseDouble(stack.pop());
    }

    public static String addStrings(String a, String b) {
        
        double aNum = Double.parseDouble(a);
        double bNum = Double.parseDouble(b);

        return String.valueOf(aNum + bNum);
    }

    public static String subtractStrings(String a, String b) {
        
        double aNum = Double.parseDouble(a);
        double bNum = Double.parseDouble(b);

        return String.valueOf(aNum - bNum);
    }

    public static String multiplyStrings(String a, String b) {
        
        double aNum = Double.parseDouble(a);
        double bNum = Double.parseDouble(b);

        return String.valueOf(aNum * bNum);
    }

    public static String divideStrings(String a, String b) {
        
        double aNum = Double.parseDouble(a);
        double bNum = Double.parseDouble(b);

        return String.valueOf(aNum / bNum);
    }
}