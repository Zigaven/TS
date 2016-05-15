package old;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class Tree {
    private ArrayList<Edge> list;
    private SplayBST splayTree;


    public Tree(String s){
        makeEdges(s);
    }

    public ArrayList<Edge> getList() {
        return list;
    }

    public void setList(ArrayList<Edge> list) {
        this.list = list;
    }

    public SplayBST getSplayTree() {
        return splayTree;
    }

    public void setSplayTree(SplayBST splayTree) {
        this.splayTree = splayTree;
    }

    public ArrayList<Edge> makeEdges(String test){
        list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(Forest.globalMax);

        for (int i = 0; i < test.length();i++){
            char c = test.charAt(i);
            Forest.globalKey++;
            if (c == '0'){
                Forest.globalMax++;
                Integer v = Forest.globalMax;
                Integer a = stack.peek();
                list.add(new Edge(Forest.globalKey,a + " " + v));
                stack.push(v);
            }else if (c == '1'){
                if (test.length() > 1) {
                    Integer a = stack.pop();
                    Integer b = stack.peek();
                    list.add(new Edge(Forest.globalKey,a + " " + b));
                }else{
                   list.add(new Edge(Forest.globalKey,Forest.globalMax + " " + Forest.globalMax));
                }
            }
        }
        Forest.globalMax++;
        return list;
    }

}
