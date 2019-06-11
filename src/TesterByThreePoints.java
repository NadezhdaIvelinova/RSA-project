import java.util.ArrayList;

public class TesterByThreePoints implements Runnable {

    private CombinationByThreePoints combination;
    private ArrayList<Point> points;
    private SmallestEnclosingCircle smallestEnclosingCircle;
    private Circle circle;

    public TesterByThreePoints(CombinationByThreePoints combination, ArrayList<Point> points, SmallestEnclosingCircle smallestEnclousingCircle) {
        this.combination = combination;
        this.points = points;
        this.smallestEnclosingCircle = smallestEnclousingCircle;
    }

    @Override
    public void run() {

       Circle circle = Circle.CircleByThreePoints(points.get(combination.getFirstPoint()), points.get(combination.getSecondPoint()), points.get(combination.getThirdPoint()));
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
