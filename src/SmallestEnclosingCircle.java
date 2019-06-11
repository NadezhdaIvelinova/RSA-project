import java.util.ArrayList;
import java.util.List;

public class SmallestEnclosingCircle {


    private Circle circle;
    public SmallestEnclosingCircle(Point point, double maxValue) {
        this.circle = new Circle(point, maxValue);
    }
    public Circle checkCircle(Circle circle) {
       if(circle.getRadius() <= this.circle.getRadius()) {
           this.circle = circle;
       }
       return this.circle;
    }

    /*
    Returns the smallest circle that encloses all the given points.
    Note: if 0 points are given, null is returned. If 1 point is given,
    a circle of radius 0 is returned.
    */
    public static Circle makeCircle(ArrayList<Point> points) {
        Circle circle = null;
        for(int i = 0; i < points.size(); i++) {
            Point point = points.get(i);
            if(circle == null || !circle.contains(point)) {
                circle = makeCircleOnePoint(points.subList(0, i+1), point);
            }
        }
        return circle;
    }


    //one boundary point known
    private static  Circle makeCircleOnePoint(List<Point> points, Point point) {
        Circle circle = new Circle(point, 0);
        for(int i = 0; i < points.size(); i++) {
            Point point1 = points.get(i);
            if(!circle.contains(point1)) {
                if(circle.getRadius() == 0) {
                    circle = Circle.CircleByTwoPoints(point, point1);
                }
                else {
                    circle = makeCircleTwoPoints(points.subList(0, i+1), point, point1);
                }
            }
        }
        return circle;
    }
    //two boundary points known
    private static Circle makeCircleTwoPoints(List<Point> points, Point p, Point q) {
        Circle circ = Circle.CircleByTwoPoints(p, q);
        Circle left  = null;
        Circle right = null;

        // For each point not in the two-point circle
        Point pq = q.subtract(p);
        for (Point r : points) {
            if (circ.contains(r))
                continue;

            // Form a circumcircle and classify it on left or right side
            double cross = pq.cross(r.subtract(p));
            Circle c = Circle.CircleByThreePoints(p, q, r);
            if (c == null)
                continue;
            else if (cross > 0 && (left == null || pq.cross(c.getCenter().subtract(p)) > pq.cross(left.getCenter().subtract(p))))
                left = c;
            else if (cross < 0 && (right == null || pq.cross(c.getCenter().subtract(p)) < pq.cross(right.getCenter().subtract(p))))
                right = c;
        }

        // Select which circle to return
        if (left == null && right == null)
            return circ;
        else if (left == null)
            return right;
        else if (right == null)
            return left;
        else
            return left.getRadius() <= right.getRadius() ? left : right;
    }

    @Override
    public String toString() {
        return circle.toString();
    }
}
