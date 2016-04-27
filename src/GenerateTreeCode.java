import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateTreeCode {

    public static String generateTreeCode(Integer nodes) {
        String tour = "";

        Integer countNumbersInTour = 0;
        Integer countZero = 0;
        Integer countOne = 0;

        if (nodes > 1) {
            tour += "0";
            countZero++;
            countNumbersInTour++;
        } else {
            tour += "1";
            return tour;
        }

        Random random = new Random();

        while (countNumbersInTour != (2 * nodes - 2)){
            Integer number = random.nextInt(2);

            if (number == 0 && countZero < ((2 * nodes - 2)/2)){
                tour += "0";
                countZero++;
                countNumbersInTour++;
            } else {
                if (countZero >= countOne){
                    tour += "1";
                    countOne++;
                    countNumbersInTour++;
                }
            }

        }

        return tour;
    }

    public static List<String> getListOfTour(List listOfTrees){
        List list = new ArrayList<>();

        for (Object lineFromListOfTrees: listOfTrees){
            String[] array = ((String) lineFromListOfTrees).split(" ");

            for (int i = 0; i < array.length; i++){
                list.add(generateTreeCode(Integer.parseInt(array[i])));
            }
        }

        return list;
    }

}
