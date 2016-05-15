package New;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Forest {
    private ArrayList<Tree> trees;

    //amount of nodes in forest
    public static Integer globalMax = 1;

    public Forest(List<String> eToursList) {
        trees = new ArrayList<>();
        for (int i = 0; i < eToursList.size(); i++) {
            Tree tree = new Tree(eToursList.get(i));
            this.getTrees().add(tree);
        }
    }

    public void addEdge(Integer u, Integer v) {
        AVL.Node node1 = null;
        AVL.Node node2 = null;

        Tree tree1 = null;
        Tree tree2 = null;

        AVL.Node root1 = null;
        AVL.Node root2 = null;

        Iterator<Tree> treeIterator = trees.iterator();
        while (treeIterator.hasNext() && (node1 == null || node2 == null)) {
            Tree tree = treeIterator.next();
            if (node1 == null) {
                node1 = tree.getAvlTree().get(u);
                if (node1 != null) { //нашли вершину
                    root1 = tree.getAvlTree().getRoot();
                    tree1 = tree;
                }
            }
            if (node2 == null) {
                node2 = tree.getAvlTree().get(v);
                if (node2 != null) { //нашли вершину
                    root2 = tree.getAvlTree().getRoot();
                    tree2 = tree;
                }
            }
        }
        if (root1 != null && root2 != null) {
            if (root1.equals(root2)) {
                System.out.println("Вершины лежат в одном дереве");
            } else {
                tree2.reMakeETour(node2.first);
                IndexETour index1 = node1.first;
                IndexETour nextIndex = index1.next;

                IndexETour tree2Tail = tree2.tail;
                IndexETour newTail = new IndexETour(index1.value, tree2Tail, nextIndex);
                tree2Tail.next = newTail;
                nextIndex.prev = newTail;

                IndexETour tree2Root = tree2.root;
                tree2Root.prev = index1;
                index1.next = tree2Root;

                tree2.root = null;
                tree2.tail = null;

                trees.remove(tree2);
                tree1.printETour();
            }
        } else {
            System.out.println("Вершины не существует");
        }
    }

    public void deleteEdge(Integer u, Integer v) {
        if (u > v) {
            Integer c = u;
            u = v;
            v = c;
        }
        AVL.Node node1 = null;
        AVL.Node node2 = null;

        Tree tree1 = null;

        boolean find1 = false;
        boolean find2 = false;
        
        Iterator<Tree> treeIterator = trees.iterator();
        while (treeIterator.hasNext() && (find1 == find2)) {
            Tree tree = treeIterator.next();
            if (node1 == null) {
                node1 = tree.getAvlTree().get(u);
                if (node1 != null) { //нашли вершину
                    tree1 = tree;
                    find1 = true;
                }
            }
            if (node2 == null) {
                node2 = tree.getAvlTree().get(v);
                if (node2 != null) { //нашли вершину
                    tree1 = tree;
                    find2 = true;
                }
            }


        }

        if (find1 && find2){
            IndexETour newRootOfTree2 = node2.first;
            IndexETour newTailOfTree2 = node2.last;

            IndexETour prevNewRoot = newRootOfTree2.prev;
            IndexETour nextNewTail = newTailOfTree2.next;

            newRootOfTree2.prev = null;
            newTailOfTree2.next = null;

            Tree newTree = new Tree();
            newTree.root = newRootOfTree2;
            newTree.tail = newTailOfTree2;

            IndexETour nextNextNewTail = nextNewTail.next;
            nextNewTail.next = null;
            if (nextNextNewTail != null) {
                nextNextNewTail.prev = prevNewRoot;
                prevNewRoot.next = nextNextNewTail;
            }else{
                prevNewRoot.next = null;
            }

            trees.add(newTree);
            tree1.printETour();
            newTree.printETour();
        }else{
            System.out.println("Вершины лежат в РАЗНЫХ деревьях");
        }

    }

    public ArrayList<Tree> getTrees() {
        return trees;
    }

    public void setTrees(ArrayList<Tree> trees) {
        this.trees = trees;
    }
}
