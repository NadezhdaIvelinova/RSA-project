import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(50);
        PointGenerator  pointGenerator = new PointGenerator();
        ArrayList<Point> points = pointGenerator.generateRandomPointsInRange(0, 10000, 5);
        SmallestEnclosingCircle smallestEnclosingCircle = new SmallestEnclosingCircle(new Point(0, 0), 10240);

        int[] indexes = new int[points.size()];
        for(int i = 0; i < points.size(); i++) {
            indexes[i] = i;
        }
        Combinations combinations = new Combinations();
        ArrayList<CombinationByTwoPoints> combinationByTwoPoints = combinations.makeCombinationByTwo(indexes, points.size(), 2);
        ArrayList<CombinationByThreePoints> combinationByThreePoints = combinations.makeCombinationByThree(indexes, points.size(), 3);

        for(int i = 0; i < Combinations.factorial(5)/(Combinations.factorial(2)*Combinations.factorial(3)); i++) {

            TesterByTwoPoints testerByTwoPoints = new TesterByTwoPoints(combinationByTwoPoints.get(i), points, smallestEnclosingCircle);
            executor.execute(testerByTwoPoints);

        }
        for(int i = 0; i < Combinations.factorial(5)/(Combinations.factorial(3)*Combinations.factorial(2)); i++) {

            TesterByThreePoints testerByThreePoints = new TesterByThreePoints(combinationByThreePoints.get(i), points, smallestEnclosingCircle);
            executor.execute(testerByThreePoints);


        }
        System.out.println(smallestEnclosingCircle.toString());
        executor.shutdown();
    }
}
