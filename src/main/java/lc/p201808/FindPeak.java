package lc.p201808;

public class FindPeak {

    public int findPeak(int[] arr) {
        int startInd = 0;
        int endInd = arr.length - 1;
        if (arr.length == 1) {
            return arr[0];
        }
        if (arr[0] >= arr[1]) {
            return 0;
        }
        if (arr[endInd] >= arr[endInd - 1]) {
            return endInd;
        }
        while (startInd < endInd) {
            int mid = (startInd + endInd) / 2;
            if (isPeak(arr, mid)) {
                return mid;
            }
            if (arr[mid] > arr[mid + 1]) {
                endInd = mid;
            } else {
                startInd = mid;
            }
        }
        return -1; // incorrect result
    }

    private boolean isPeak(int[] arr, int mid) {
        return arr[mid] >= arr[mid-1] && arr[mid] >= arr[mid+1];
    }

    public static void main(String[] args) {
        System.out.println(new FindPeak().findPeak(new int[]  {10, 20, 30, 40, 50}));
        System.out.println(new FindPeak().findPeak(new int[]  {5, 10, 20, 15}));
        System.out.println(new FindPeak().findPeak(new int[]  {10, 20, 15, 2, 23, 90, 67}));
        System.out.println(new FindPeak().findPeak(new int[]  {100, 80, 60, 50, 20}));
    }
}
