import java.util.ArrayList;

public class Combinations {

    private ArrayList<CombinationByTwoPoints> combinationsByTwo;
    private ArrayList<CombinationByThreePoints> combinationsByThree;

    public Combinations() {
        combinationsByTwo = new ArrayList<>();
        combinationsByThree = new ArrayList<>();
    }

    static int factorial(int n) {
        int fact = 1;
        int i = 1;
        while(i <= n) {
            fact *= i;
            i++;
        }
        return fact;
    }

    public void combinationUtilByTwo(int arr[], int data[], int start, int end, int index, int r) {
        // Current combination is ready to be printed, print it
        if (index == r)
        {
            CombinationByTwoPoints combination = new CombinationByTwoPoints(data[0], data[1]);
            combinationsByTwo.add(combination);
            return;
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[index] = arr[i];
            combinationUtilByTwo(arr, data, i+1, end, index+1, r);
        }
    }

    public void combinationUtilByThree(int arr[], int data[], int start, int end, int index, int r) {
        // Current combination is ready to be printed, print it
        if (index == r)
        {
            CombinationByThreePoints combination = new CombinationByThreePoints(data[0], data[1], data[2]);
            combinationsByThree.add(combination);
            return;
        }

        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[index] = arr[i];
            combinationUtilByThree(arr, data, i+1, end, index+1, r);
        }
    }

    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    public ArrayList<CombinationByTwoPoints> makeCombinationByTwo(int arr[], int n, int r) {
        // A temporary array to store all combination one by one
        int data[]=new int[r];

        // Print all combination using temprary array 'data[]'
        combinationUtilByTwo(arr, data, 0, n-1, 0, r);
        return combinationsByTwo;
    }

    public ArrayList<CombinationByThreePoints> makeCombinationByThree(int arr[], int n, int r) {
        // A temporary array to store all combination one by one
        int data[]=new int[r];

        // Print all combination using temprary array 'data[]'
        combinationUtilByThree(arr, data, 0, n-1, 0, r);
        return combinationsByThree;
    }

    @Override
    public String toString() {
        return String.format(combinationsByTwo.toString());
    }
}
