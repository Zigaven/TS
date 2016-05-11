package New;

import java.util.ArrayList;
import java.util.List;

public class Forest {
    private ArrayList<Tree> trees;

    //amount of nodes in forest
    public static Integer globalMax = 1;

    public Forest(List<String> eToursList){
        trees = new ArrayList<>();
        for (int i = 0; i < eToursList.size(); i++) {
            Tree tree = new Tree(eToursList.get(i));
            this.getTrees().add(tree);
        }
    }

    public ArrayList<Tree> getTrees() {
        return trees;
    }

    public void setTrees(ArrayList<Tree> trees) {
        this.trees = trees;
    }
}
