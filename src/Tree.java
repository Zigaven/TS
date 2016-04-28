import java.util.Stack;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class Tree {
    private String eTour;

    public Tree(String s){
        eTour = makeETour(s);
    }

    public String getETour() {
        return eTour;
    }

    public void setETour(String eTour) {
        this.eTour = eTour;
    }

    public static String makeETour(String test){
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
                if (test.length() > 1) {
                    Integer a = stack.pop();
                    Integer b = stack.peek();
                    eTour = eTour + a + b + " ";
                }else{
                    return "1";
                }
            }
        }
        eTour = eTour.trim();
        return eTour;
    }

}
