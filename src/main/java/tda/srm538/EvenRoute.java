package tda.srm538;

/**
 * problem:
 * http://community.topcoder.com/stat?c=round_overview&rd=14729
 */
public class EvenRoute {

    public String isItPossible(int[] x, int[] y, int wantedParity) {
        int parity = Math.abs(sumOfDistances(x) + sumOfDistances(y)) % 2;
        return parity == wantedParity ? "CAN" : "CANNOT";
    }

    private int sumOfDistances(int[] x) {
        int summ = 0;
        for (int i = 0; i < x.length; i++) {
            summ += (i > 0 ? x[i-1] : 0) - x[i];
        }
        return summ;
    }
}
