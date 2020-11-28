import java.util.Stack;
import java.util.HashMap;
import java.util.function.BiFunction;

public class test {
    public static void main(String args[]) {

        String[] expression = new String[]{"1", "2", "3", "+", "2", "*", "-"};
        
        System.out.println(reverseNotation(expression));
        System.out.println(polishNotationCalculator(expression));
    }

    public static double polishNotationCalculator(String[] expression){

        Stack<Double> numberStack = new Stack<Double>();// number stack of numbers awaiting operation
        double num1;
        double num2;

        for(String item : expression){
            try {// try to parse input as double
                double num = Double.parseDouble(item);
                numberStack.push(num);

            } catch (Exception e){ // if not double must be operator

                switch (item) {
                    case "+":
                        num1 = numberStack.pop();
                        num2 = numberStack.pop();
                        numberStack.push(num1 + num2);
                        break;
                    case "-":
                        num1 = numberStack.pop();
                        num2 = numberStack.pop();
                        numberStack.push(num2 - num1);
                        break;
                    case "*":
                        num1 = numberStack.pop();
                        num2 = numberStack.pop();
                        numberStack.push(num2 * num1);
                        break;
                    case "/":
                        num1 = numberStack.pop();
                        num2 = numberStack.pop();
                        numberStack.push(num2 / num1);
                        break;
                }
            }
        }
        return numberStack.pop();
    }

    public static double reverseNotation(String[] expression) {

        // create stack that will hold equation elements
        Stack<String> stack = new Stack<String>(); 

        // operator hashmap (consumer is function interface)
        HashMap<String, BiFunction<String, String, String>> operands = new HashMap<>();

        operands.put("+", (String a, String b) -> addStrings(a, b));
        operands.put("-", (String a, String b) -> subtractStrings(a, b));
        operands.put("*", (String a, String b) -> multiplyStrings(a, b));
        operands.put("/", (String a, String b) -> divideStrings(a, b));

        // read from expression
        for (String element : expression) {          

            if (operands.containsKey(element)){

                String add2 = stack.pop();
                String add1 = stack.pop();

                String result = operands.get(element).apply(add1, add2);

                stack.push(result);

            } else {

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