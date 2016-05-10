import java.util.ArrayList;
import java.util.List;

public class TestClass {
    public static void main(String[] args) {
        ArrayList arr = new ArrayList();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        System.out.println(arr);

        String result = "";

        System.out.println(getIndex(arr.subList(0, arr.size() / 2 + 1), 3, result));
    }

    public static int getIndex(List arr, Integer lastIndex, String result){
        result += lastIndex;
        while (arr.size() != 1){
            if (lastIndex == 2){
                getIndex(arr.subList(0, arr.size() / 2), lastIndex / 2, result);
            } else {
                getIndex(arr.subList(0, arr.size() / 2 + 1), lastIndex / 2 + 1, result);
            }
            break;
        }
        return (Integer) arr.get(0);
    }
}
