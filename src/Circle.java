public class Circle {

    private static final double MULTIPLICATIVE_EPSILON = 1 + 1e-14;
    private Point center;
    private double radius;

    public void setCenter(Point center) {
        this.center = center;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    public Circle(Point c, double r) {
        setCenter(c);
        setRadius(r);
    }

    public static Circle CircleByTwoPoints(Point a, Point b) {
        Point circleCenter = Point.midpoint(a, b);
        double circleRadius = (Point.findDistance(a, b))/2;
        return new Circle(circleCenter, circleRadius);
    }

    public static  Circle CircleByThreePoints(Point point1, Point point2, Point point3) {
        int ox = (Math.min(Math.min(point1.getX(), point2.getX()), point3.getX()) + Math.max(Math.min(point1.getX(), point2.getX()), point3.getX())) / 2;
        int oy = (Math.min(Math.min(point1.getY(), point2.getY()), point3.getY()) + Math.max(Math.min(point1.getY(), point2.getY()), point3.getY())) / 2;
        int ax = point1.getX() - ox,  ay = point1.getY() - oy;
        int bx = point2.getX() - ox,  by = point2.getY() - oy;
        int cx = point3.getX() - ox,  cy = point3.getY() - oy;
        int d = (ax * (by - cy) + bx * (cy - ay) + cx * (ay - by)) * 2;
        if (d == 0)
            return null;
        int x = ((ax*ax + ay*ay) * (by - cy) + (bx*bx + by*by) * (cy - ay) + (cx*cx + cy*cy) * (ay - by)) / d;
        int y = ((ax*ax + ay*ay) * (cx - bx) + (bx*bx + by*by) * (ax - cx) + (cx*cx + cy*cy) * (bx - ax)) / d;
        Point p = new Point(ox + x, oy + y);
        double r = Math.max(Math.max(p.distance(point1), p.distance(point2)), p.distance(point3));
        return new Circle(p, r);
    }


    public boolean contains(Point point) {

         return getCenter().distance(point) <= radius * MULTIPLICATIVE_EPSILON;

    }

    @Override
    public String toString() {
        return String.format("The center is " + getCenter().toString() + " and radius: " + getRadius());
    }
}
