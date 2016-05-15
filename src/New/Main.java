package New;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //generate input.txt file
        FileMethods.generateFile();

        File inputFile = new File("input.txt");
        File outputFileAdd = new File("resultAdd.txt");
        File outputFileDelete = new File("resultDelete.txt");

        Scanner scanner = new Scanner(inputFile);
        PrintStream outputAdd = new PrintStream(outputFileAdd);
        PrintStream outputDelete = new PrintStream(outputFileDelete);

        while (scanner.hasNextLine()){
            String str = scanner.nextLine();
            String[] arrStr = str.split(" ");
            LinkedList<String> listOfTour = new LinkedList<>();

            Collections.addAll(listOfTour, arrStr);
            List<String> eTour = GenerateTreeCode.getListOfETour(GenerateTreeCode.getListOfTour(listOfTour));

            Forest forest = new Forest(eTour);
            Forest copyforest = new Forest(eTour);

            for (Tree tree: forest.getTrees()){
                tree.getAvlTree().print();
                System.out.println();
            }

            Random random = new Random();

            long startAdd = System.nanoTime();
            forest.addEdge(random.nextInt(Forest.globalMax) + 1,random.nextInt(Forest.globalMax) + 1);
            long timeOfAdd = System.nanoTime() - startAdd;

            outputAdd.print(Forest.globalMax - 1 + " ");
            outputAdd.println(timeOfAdd);

            long startDelete = System.nanoTime();
            copyforest.deleteEdge(random.nextInt(Forest.globalMax) + 1,random.nextInt(Forest.globalMax) + 1);
            long timeOfDelete = System.nanoTime() - startDelete;

            outputDelete.print(Forest.globalMax - 1 + " ");
            outputDelete.println(timeOfDelete);
            Forest.globalMax = 1;
        }

        scanner.close();
        outputAdd.close();
        outputDelete.close();
    }
}
