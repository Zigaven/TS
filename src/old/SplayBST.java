package old;

import java.lang.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SplayBST {

    public void deep(Queue<Edge> queue){
        Queue<Edge> queue1 = new LinkedList<Edge>();
        while (!queue.isEmpty()){
            Edge edge = queue.poll();
            System.out.print(edge.value + " ");

            if (edge.left != null) {
                queue1.add(edge.left);
            }
            if (edge.right != null) {
                queue1.add(edge.right);
            }
        }

        System.out.println();

        if (queue1.size() != 0){
            deep(queue1);
        }
    }

    public SplayBST(List<Edge> list) {
        root = Edge.getNextRoot(list);
    }

    private Edge root;   // root of the BST


    public boolean contains(Integer key) {
        return get(key) != null;
    }

    // return value associated with the given key
    // if no such value, return null
    public String get(Integer key) {
        root = splay(root, key);
        int cmp = key.compareTo(root.key);
        if (cmp == 0) return root.value;
        else return null;
    }

    /***************************************************************************
     * Splay tree insertion.
     ***************************************************************************/
    public void put(Integer key, String value) {
        // splay key to root
        if (root == null) {
            root = new Edge(key, value);
            return;
        }

        root = splay(root, key);

        int cmp = key.compareTo(root.key);

        // Insert new node at root
        if (cmp < 0) {
            Edge n = new Edge(key, value);
            n.left = root.left;
            n.right = root;
            root.left = null;
            root = n;
        }

        // Insert new node at root
        else if (cmp > 0) {
            Edge n = new Edge(key, value);
            n.right = root.right;
            n.left = root;
            root.right = null;
            root = n;
        }

        // It was a duplicate key. Simply replace the value
        else if (cmp == 0) {
            root.value = value;
        }

    }

    public void remove(Integer key) {
        if (root == null) return; // empty tree

        root = splay(root, key);

        int cmp = key.compareTo(root.key);

        if (cmp == 0) {
            if (root.left == null) {
                root = root.right;
            } else {
                Edge x = root.right;
                root = root.left;
                splay(root, key);
                root.right = x;
            }
        }

        // else: it wasn't in the tree to remove
    }

    private Edge splay(Edge h, Integer key) {
        if (h == null) return null;

        int cmp1 = key.compareTo(h.key);

        if (cmp1 < 0) {
            // key not in tree, so we're done
            if (h.left == null) {
                return h;
            }
            int cmp2 = key.compareTo(h.left.key);
            if (cmp2 < 0) {
                h.left.left = splay(h.left.left, key);
                h = rotateRight(h);
            } else if (cmp2 > 0) {
                h.left.right = splay(h.left.right, key);
                if (h.left.right != null)
                    h.left = rotateLeft(h.left);
            }

            if (h.left == null) return h;
            else return rotateRight(h);
        } else if (cmp1 > 0) {
            // key not in tree, so we're done
            if (h.right == null) {
                return h;
            }

            int cmp2 = key.compareTo(h.right.key);
            if (cmp2 < 0) {
                h.right.left = splay(h.right.left, key);
                if (h.right.left != null)
                    h.right = rotateRight(h.right);
            } else if (cmp2 > 0) {
                h.right.right = splay(h.right.right, key);
                h = rotateLeft(h);
            }

            if (h.right == null) return h;
            else return rotateLeft(h);
        } else return h;
    }


    /***************************************************************************
     * Helper functions.
     ***************************************************************************/

    // height of tree (1-node tree has height 0)
    public int height() {
        return height(root);
    }

    private int height(Edge x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }


    public int size() {
        return size(root);
    }

    private int size(Edge x) {
        if (x == null) return 0;
        else return 1 + size(x.left) + size(x.right);
    }

    // right rotate
    private Edge rotateRight(Edge h) {
        Edge x = h.left;
        h.left = x.right;
        x.right = h;
        return x;
    }

    // left rotate
    private Edge rotateLeft(Edge h) {
        Edge x = h.right;
        h.right = x.left;
        x.left = h;
        return x;
    }


    // test client
    public static void main(String[] args) {
//        old.SplayBST<Integer, Integer> st1 = new old.SplayBST<Integer, Integer>();
//        st1.put(5, 5);
//        st1.put(9, 9);
//        st1.put(13, 13);
//        st1.put(11, 11);
//        st1.put(1, 1);


//        old.SplayBST st = new old.SplayBST();
//        st.put(1, "128.112.136.11");
//        st.put(1, "128.112.136.12");
//        st.put(1, "128.112.136.13");
//        st.put(2,    "128.112.128.15");
//        st.put(3,      "130.132.143.21");
//        st.put(4,     "209.052.165.60");
//        System.out.println("The size 0 is: " + st.size());
//        st.remove(1);
//        System.out.println("The size 1 is: " + st.size());
//        st.remove(2);
//        System.out.println("The size 2 is: " + st.size());
//        st.remove(1);
//        System.out.println("The size 3 is: " + st.size());
//        System.out.println();

        Edge edge1 = new Edge(1,"12");
        Edge edge2 = new Edge(2,"23");
        Edge edge3 = new Edge(3,"32");
        Edge edge4 = new Edge(4,"24");
        Edge edge5 = new Edge(5,"42");

        ArrayList arrayList = new ArrayList();
        arrayList.add(edge1);
        arrayList.add(edge2);
        arrayList.add(edge3);
        arrayList.add(edge4);
        arrayList.add(edge5);

        SplayBST splayBST = new SplayBST(arrayList);
        Queue<Edge> queue = new LinkedList<Edge>();
        queue.add(splayBST.root);
        splayBST.deep(queue);

    }

}