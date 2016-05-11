package New;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

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

            if (number == 0 && countZero < ((2 * nodes - 2)/2) || (countZero == countOne)){
                tour += "0";
                countZero++;
                countNumbersInTour++;
            } else {
                if (countZero > countOne){
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

    public static String generateETourOfTree(String str){
        String eTour = String.valueOf(Forest.globalMax);
        Stack<Integer> stack = new Stack<>();
        stack.push(Forest.globalMax);

        for (int i = 0; i < str.length();i++){
            char c = str.charAt(i);
            if (c == '0'){
                Forest.globalMax++;
                eTour = eTour + " " +Forest.globalMax;
                stack.push(Forest.globalMax);
            }else if (c == '1'){
                if (str.length() > 1) {
                    stack.pop();
                    Integer b = stack.peek();
                    eTour = eTour + " " + b;
                }
            }
        }
        Forest.globalMax++;
        return eTour;
    }

    public static List<String> getListOfETour(List<String> listOfTours){
        List list = new ArrayList<>();

        for (String tourOfTree: listOfTours){
            list.add(generateETourOfTree(tourOfTree));
        }

        return list;
    }

}
