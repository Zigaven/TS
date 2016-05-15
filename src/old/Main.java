package old;

import java.util.List;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class Main {
    public static void main(String[] args) {
        //generate input.txt file
        FileMethods.generateFile();

        //get list of all lines from input.txt file
        List<String> list = FileMethods.getDataFromFile();

        //get list of tours of all trees in one forest
        List<String> listOfTour = GenerateTreeCode.getListOfTour(list);

        System.out.println(listOfTour);

        Tree tree1 = new Tree("000101110011");
        Tree tree2 = new Tree("0101");

        System.out.println(tree1.getList().toString());
        System.out.println(tree2.getList().toString());
    }
}