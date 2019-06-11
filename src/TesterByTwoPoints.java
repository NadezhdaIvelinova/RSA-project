import java.util.ArrayList;

public class TesterByTwoPoints implements Runnable{

    private CombinationByTwoPoints combination;
    private ArrayList<Point> points;
    private Circle circle;
    private SmallestEnclosingCircle smallestEnclosingCircle;

    public TesterByTwoPoints(CombinationByTwoPoints combination, ArrayList<Point> points, SmallestEnclosingCircle smallestEnclousingCircle) {
        this.combination = combination;
        this.points = points;
        this.smallestEnclosingCircle = smallestEnclousingCircle;
    }

    @Override
    public void run() {

        Circle circle = Circle.CircleByTwoPoints(points.get(combination.getFirstPoint()), points.get(combination.getSecondPoint()));
        int counter = 0;
        for(Point point : points) {
            if(circle.contains(point)) {
                counter++;

            }
            else {
                break;
            }
        }
        if(counter == points.size()) {
            this.circle = circle;
            smallestEnclosingCircle.checkCircle(circle);
        }

    }

    public Circle getCircle() {
        return circle;
    }
}
