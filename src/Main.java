import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<Double> temps = (ArrayList<Double>)getListOfRandomDoubles(31, - 25.0,25.0);


        printTemps(temps);
    }


    static void printTemps(List<?> toPrint) {

        System.out.println("\n###################################################");
        System.out.print("       mo     tu     we     th     fi     sa     su");

        for (int i = 0,  j = 1; i < toPrint.size(); i++) {
            if ( i == 0 || i % 7 == 0) {
                System.out.printf("%n%d.", j++);
            }
            System.out.printf("%7.1f", toPrint.get(i));
        }

        System.out.println("\n###################################################");
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
}