import java.util.Stack;
import java.util.HashMap;
import java.util.function.BiFunction;

import javax.lang.model.element.Element; 

public class test {
    public static void main(String args[]) {
        
    }

    public static double reverseNotation(String[] expression) {

        // create stack that will hold equation elements
        Stack<String> stack = new Stack<String>();

        // operator hashmap (consumer is function interface)
        HashMap<String, BiFunction<String, String, String>> operands = new HashMap<>();

        operands.put("+", (String a, String b) -> addStrings(a, b));
        operands.put("-", (String a, String b) -> subtractStrings(a, b));
        operands.put("*", (String a, String b) -> multiplyStrings(a, b));
        operands.put("+", (String a, String b) -> divideStrings(a, b));

        // read from expression
        for (String element : expression) {
            if (operands.containsKey(element)) {

                String num1 = stack.pop();
                String num2 = stack.pop();
                
                String result = (num1,num2) -> operands.get(element);

                stack.push(result);
            }
        }
        

        return 0.0;
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