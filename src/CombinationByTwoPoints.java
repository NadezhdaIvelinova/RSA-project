public class CombinationByTwoPoints {

    private int firstPoint;
    private int secondPoint;

    public CombinationByTwoPoints(int first, int second) {
       firstPoint = first;
       secondPoint = second;
    }

    public int getFirstPoint() {
        return firstPoint;
    }

    public int getSecondPoint() {
        return secondPoint;
    }

    @Override
    public String toString() {
        return String.format("firstindex: %d, secondindex: %d", getFirstPoint(), getSecondPoint());
    }
}
