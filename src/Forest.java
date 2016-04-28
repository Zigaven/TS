import java.util.ArrayList;
import java.util.List;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class Forest {
    private ArrayList<Tree> trees;

    public Forest(List<String> list){
        trees = new ArrayList<>();
        for (String treeLine : list){
            Tree tree = new Tree(treeLine);
            trees.add(tree);
        }
    }

    public ArrayList<Tree> getTrees() {
        return trees;
    }

    public void setTrees(ArrayList<Tree> trees) {
        this.trees = trees;
    }
}
