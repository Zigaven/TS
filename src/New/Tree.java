package New;

import java.util.LinkedList;

public class Tree {
    private AVL<Integer,Integer> avlTree;
    private String eTour;
    public IndexETour root;
    public IndexETour tail;

    public Tree(){}

    public Tree(String eTour) {
        this.eTour = eTour;
        String[] tour = eTour.split(" ");

        avlTree = new AVL<>();

        IndexETour prev = new IndexETour(Integer.parseInt(tour[0]),null,null);
        root = prev;
        avlTree.add(Integer.valueOf(tour[0]), Integer.valueOf(tour[0]),root);
        for (int i = 1; i < tour.length; i++){
            IndexETour index = new IndexETour(Integer.parseInt(tour[i]),prev,null);
            prev.next = index;
            prev = index;
            avlTree.add(Integer.valueOf(tour[i]), Integer.valueOf(tour[i]),index);
        }
        tail = prev;
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

//    public void remakeAvl(){
//        avlTree = new AVL<>();
//        String[] tour = eTour.split(" ");
//        for (int i = 0; i < tour.length; i++){
////            IndexETour index = new IndexETour(Integer.parseInt(tour[i]));
//            avlTree.add(Integer.valueOf(tour[i]), Integer.valueOf(tour[i]),);
////            eTourList.add(index);
//        }
//
//    }

    public void reMakeETour(IndexETour index){
        if (index != root){
            IndexETour nextRoot = root.next;

            tail.next = nextRoot;
            nextRoot.prev = tail;

            IndexETour prevIndex = index.prev;
            IndexETour newIndex = new IndexETour(index.value,prevIndex,null);
            prevIndex.next = newIndex;
            tail = newIndex;

            index.prev = null;
            root = index;
        }
    }

    public void printETour(){
        IndexETour i = root;
        while (i != null){
            System.out.print(i.value + " ");
            i = i.next;
        }
        System.out.println();
    }

}
