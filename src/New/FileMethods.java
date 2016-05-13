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
                for (int i = 0; i < random.nextInt(15) + 1; i++) {
                    Integer number = random.nextInt(50) + 1;
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
