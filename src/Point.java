import java.lang.Math;

public class Point {

    private int x;
    private int y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point(int x, int y) {
        setX(x);
        setY(y);
    }

    public  static double findDistance(Point point1, Point point2) {
        int x1 = point1.getX();
        int y1 = point1.getY();
        int x2 = point2.getX();
        int y2 = point2.getY();
        double distance = Math.sqrt((x2 - x1)*(x2-x1) + (y2-y1)*(y2-y1));
        return distance;
    }

    public static Point midpoint(Point point1, Point point2) {
        int x1 = point1.getX();
        int y1 = point1.getY();
        int x2 = point2.getX();
        int y2 = point2.getY();
        int x = (x1 + x2)/2;
        int y = (y1 + y2)/2;
        Point point = new Point(x, y);
        return point;
    }

    public double distance(Point point) {
        return Math.hypot(getX() - point.getX(), getY() - point.getY());
    }

    public Point subtract(Point point) {
        return new Point(getX() - point.getX(), getY() - point.getY());
    }

    // Signed area / determinant thing
    public double cross(Point p) {
        return getX() * p.getY() - getY() * p.getX();
    }

    @Override
    public String toString() {
        return String.format("Point with x = %d and y = %d coordinates" , getX(), getY());
    }
}
