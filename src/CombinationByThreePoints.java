public class CombinationByThreePoints {
    private int firstPoint;
    private int secondPoint;
    private int thirdPoint;

    public CombinationByThreePoints(int first, int second, int third) {
        firstPoint = first;
        secondPoint = second;
        thirdPoint = third;
    }

    public int getFirstPoint() {
        return firstPoint;
    }

    public int getSecondPoint() {
        return secondPoint;
    }

    public int getThirdPoint() {
        return thirdPoint;
    }

    @Override
    public String toString() {
        return String.format("firstindex: %d, secondindex: %d, thirdindex: %d", getFirstPoint(), getSecondPoint(), getThirdPoint());
    }
}
