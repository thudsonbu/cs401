import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.function.BiFunction;

public class test {
    public static void main(String args[]) {

        String[] expression = new String[]{"1", "2", "3", "+", "2", "*", "-"};
        
        System.out.println(reverseNotation(expression));
        System.out.println(polishNotationCalculator(expression));
    }

    // improved solution
    public static double polishNotationCalculator(String[] expression){

        ArrayDeque<Double> numStack = new ArrayDeque<Double>();// number ArrayDeque of numbers awaiting operation
        double num1;
        double num2;

        // operator hashmap (consumer is function interface)
        HashMap<String, BiFunction<Double, Double, Double>> operands = new HashMap<>();

        operands.put("+", (Double a, Double b) -> add(a, b));
        operands.put("-", (Double a, Double b) -> sub(a, b));
        operands.put("*", (Double a, Double b) -> mult(a, b));
        operands.put("/", (Double a, Double b) -> div(a, b));

        for(String item : expression){
            try {// try to parse input as double
                double num = Double.parseDouble(item);
                numStack.push(num);

            } catch (Exception e){ // if not double must be operator

                num1 = numStack.pop();
                num2 = numStack.pop();
                numStack.push(operands.get(item).apply(num1, num2));
            }
        }
        return numStack.pop();
    }

    public static double reverseNotation(String[] expression) {

        // create ArrayDeque that will hold equation elements
        ArrayDeque<String> ArrayDeque = new ArrayDeque<String>(); 

        // operator hashmap (consumer is function interface)
        HashMap<String, BiFunction<String, String, String>> operands = new HashMap<>();

        operands.put("+", (String a, String b) -> addStrings(a, b));
        operands.put("-", (String a, String b) -> subtractStrings(a, b));
        operands.put("*", (String a, String b) -> multiplyStrings(a, b));
        operands.put("/", (String a, String b) -> divideStrings(a, b));

        // read from expression
        for (String element : expression) {          

            if (operands.containsKey(element)){

                String add2 = ArrayDeque.pop();
                String add1 = ArrayDeque.pop();

                String result = operands.get(element).apply(add1, add2);

                ArrayDeque.push(result);

            } else {

                ArrayDeque.push(element);
            }
            
        }
        return Double.parseDouble(ArrayDeque.pop());
    }

    public static double add(double a, double b){
        return b + a;
    }

    public static double sub(double a, double b){
        return b - a;
    }

    public static double mult(double a, double b){
        return b * a;
    }

    public static double div(double a, double b){
        return b / a;
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