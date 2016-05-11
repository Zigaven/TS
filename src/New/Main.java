package New;


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

        //get list of tours all trees in one forest
        List<String> listOfTour = GenerateTreeCode.getListOfTour(list);
        System.out.println(listOfTour);

        //get list of eTours all trees in one forest
        List<String> listOfETour = GenerateTreeCode.getListOfETour(listOfTour);
        System.out.println(listOfETour);

        Forest forest = new Forest(listOfETour);
        System.out.println(forest.getTrees());

        for (Tree tree: forest.getTrees()){
            tree.getAvlTree().print();
            System.out.println();
        }
    }
}
