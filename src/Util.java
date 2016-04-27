import java.util.Stack;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class Util {
    public static void makeETour(){
        String test = "00101100001111";
        int maxV = 1;
        String eTour = "";

        Stack<Integer> stack = new Stack<>();
        stack.push(1);

        for (int i = 0; i < test.length();i++){
            char c = test.charAt(i);

            if (c == '0'){
                maxV++;
                Integer v = maxV;
                Integer a = stack.peek();
                eTour = eTour + a + v + " ";
                stack.push(v);
            }else if (c == '1'){
                Integer a = stack.pop();
                Integer b = stack.peek();

                eTour = eTour + a + b + " ";
            }
        }

        System.out.println(eTour);
    }
}
