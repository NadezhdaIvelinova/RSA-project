import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//for now it is generated with Math.random
public class PointGenerator {

    private ArrayList<Point> generatedPoints;
    private Random random;

    public PointGenerator() {
        generatedPoints = new ArrayList<>();
        random = new Random();
    }

    public ArrayList<Point> generateRandomPointsInRange(int min, int max, double numberOfPoints) {

        for(int i = min; i < numberOfPoints; i++)
        {
            int x = random.nextInt(max);
            int y = random.nextInt(max);
            Point point = new Point(x, y);
            generatedPoints.add(point);
        }

        return generatedPoints;
    }

    public ArrayList<Point> readRandomPoints(String pathname) {
        ArrayList<Point> points = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(pathname));
            int numberOfPoints = scanner.nextInt();

            while (scanner.hasNextInt()) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                Point point = new Point(x, y);
                points.add(point);
            }
        } catch (FileNotFoundException fnException) {
            System.out.println(fnException);
        }
        return  points;
    }

    @Override
    public String toString() {
        return Arrays.toString(generatedPoints.toArray());
    }
}
