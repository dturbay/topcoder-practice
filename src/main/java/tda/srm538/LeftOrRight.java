package tda.srm538;


/**
 * problem:
 * http://community.topcoder.com/stat?c=round_overview&rd=14729
 */

public class LeftOrRight {
    public int maxDistance(String program) {
        return Math.max(maxDistance(program, 1), maxDistance(program, -1));
    }

    private int maxDistance(String program, int step) {
        int maxDist = 0;
        int dist = 0;
        for (char ch : program.toCharArray()) {
            switch (ch) {
                case 'R':
                    dist += 1;
                    break;
                case 'L':
                    dist -= 1;
                    break;
                case '?':
                    dist += step;
                    break;
            }
            maxDist = Math.max(maxDist, Math.abs(dist));
        }
        return maxDist;
    }
}
