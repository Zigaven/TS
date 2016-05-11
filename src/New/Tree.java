package New;

public class Tree {
    private AVL<Integer,Integer> avlTree;
    private String eTour;

    public Tree(String eTour) {
        this.eTour = eTour;

        String[] tour = eTour.split(" ");

        avlTree = new AVL<>();

        for (int i = 0; i < tour.length; i++){
            avlTree.add(Integer.valueOf(tour[i]), Integer.valueOf(tour[i]), i);
        }
    }

    public AVL<Integer, Integer> getAvlTree() {
        return avlTree;
    }

    public void setAvlTree(AVL<Integer, Integer> avlTree) {
        this.avlTree = avlTree;
    }

    public String geteTour() {
        return eTour;
    }

    public void seteTour(String eTour) {
        this.eTour = eTour;
    }



}
