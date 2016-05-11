package old;

import java.util.List;

public class Edge {
    public Integer key;
    public String value;
    public Edge left;
    public Edge right;

    public Edge(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "old.Edge{" +
                "key=" + key +
                ", value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static Edge getNextRoot(List<Edge> list){
        if (list.size() == 1){
            return list.get(0);
        } else {
            Edge edge = list.get(list.size() / 2);
            if (list.size() != 2) {
                edge.left = getNextRoot(list.subList(0, list.size() / 2));
                edge.right = getNextRoot(list.subList(list.size() / 2 + 1, list.size()));
            } else {
                edge.left = getNextRoot(list.subList(0, list.size() / 2));
            }

            return edge;
        }
    }
}
