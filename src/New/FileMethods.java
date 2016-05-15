package New;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

public class FileMethods {

    public static void generateFile(){
        File file = new File("input.txt");
        PrintStream in = null;

        try
        {
            in = new PrintStream(file);
            Random random = new Random();
            for (int j = 0; j < 100; j++) {
                int countNode = 1000 + 2000 * j;
                while (countNode > 0){
                        Integer number = random.nextInt(countNode) + 1;
                        countNode -= number;
                        in.print(number + " ");
                }
                in.println();
            }
            in.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}
