import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Double> temps = (ArrayList<Double>)getListOfRandomDoubles(31, -25.0, 25.0);


        printList(temps);
    }


    static void printList(List<Double> list) {

        System.out.println("\n###################################################");
        System.out.print("       mo     tu     we     th     fi     sa     su");

        for (int i = 0,  j = 1; i < list.size(); i++) {
            if ( i == 0 || i % 7 == 0) {
                System.out.printf("%n%d.", j++);
            }
            System.out.printf("%7.1f", list.get(i));
        }

        System.out.println("\n###################################################\n");
        System.out.printf("The min temperature:%10.1f%n" , minTemp(list));
        System.out.printf("The max temperature:%10.1f%n" , maxTemp(list));
        System.out.printf("The average temperature:%6.1f%n" , averageTemp(list));
    }


    static List<Double> getListOfRandomDoubles(int size, double origin, double bound) {

        List<Double> result = new ArrayList<>();
        double[] randomDoubles = new Random().doubles(size, origin, bound).toArray();

        for (int i = 0; i < size; i++) {
            result.add(roundAvoid(randomDoubles[i],1));
        }

        return result;
    }


    static double roundAvoid(double value, int places) {

        double scale = Math.pow(10, places);

        return Math.round(value * scale) / scale;
    }


    static double minTemp(List<Double> list) {

        double min = list.get(0);

        for (double temp: list) {
            if (temp < min) min = temp;
        }

        return min;
    }


    static double maxTemp(List<Double> list) {

        double max = list.get(0);

        for (double temp: list) {
            if (temp > max) max = temp;
        }

        return max;
    }


    static double averageTemp(List<Double> list) {

        double sum = 0;

        for (double temp: list) {
            sum += temp;
        }

        return roundAvoid(sum / list.size(),1);
    }
}
