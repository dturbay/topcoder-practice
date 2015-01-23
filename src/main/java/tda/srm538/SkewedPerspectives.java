package tda.srm538;

import java.util.*;

/**
 * problem:
 * http://community.topcoder.com/stat?c=round_overview&rd=14729
 */
public class SkewedPerspectives {

    public static final String INVALID = "invalid";
    public static final String VALID = "valid";

    public String[] areTheyPossible(int[] cubes, int B, int w, String[] views) {
        String[] result = new String[views.length];

        for (int viewInd = 0 ; viewInd < views.length ; viewInd++) {
            result[viewInd] = areTheyPossible(cubes.clone(), B, w, views[viewInd], Collections.EMPTY_LIST, 0);
        }
        return result;
    }

    private String areTheyPossible(int[] cubes, int B, int w, String view, List<Integer> incFree, int currentHeight) {
        int currentColumn = 0;
        List<Integer> free = new ArrayList<>(incFree);
        char[] viewChars = view.toCharArray();
        for (int i = 0 ; i < viewChars.length ; i++) {
            char ch = viewChars[i];
            if (Character.isDigit(ch)) { // regular cube
                int color = Integer.parseInt("" + ch);
                if (cubes[color] == 0) {
                    return INVALID;
                } else {
                    cubes[color]--;
                    currentHeight++;
                }
            } else { // black case
                if (B == 0 || viewChars.length == 1 ||
                        (currentHeight == 0 && viewChars[i + 1] != 'b')) {
                    return INVALID;
                }
                B--;
                if (i < viewChars.length -1 && viewChars[i + 1] == 'b') {
                    if (currentHeight == 0) {
                        currentHeight += 2;
                        i++;
                    } else {
                        Set<String> resp = new HashSet<>();
                        resp.add(areTheyPossible(cubes.clone(), B, w - currentColumn,
                                view.substring(i + 2), free, currentHeight + 2));
                        free.add(currentHeight-1);
                        resp.add(areTheyPossible(cubes.clone(), B, w - currentColumn - 1,
                                view.substring(i + 1), free, currentHeight + 1));
                        if (resp.contains(VALID)) return VALID; else return INVALID;
                    }
                } else {
                    if (currentColumn == w) {
                        return INVALID;
                    }
                    currentColumn++;
                    free.add(currentHeight - 1);
                    currentHeight += 1;
                }
            }
        }
        int regularCount = cubes[0] + cubes[1] + cubes[2];
        for (Integer col : free) {
            if (col / 2 >= B) {
                col -= B * 2;
                B = 0;
            } else {
                B -= (col / 2);
                col = col % 2;
            }
            regularCount -= col;
            if (regularCount < 0) { // insufficient cubes to fill empty space
                return INVALID;
            }
        }
        return VALID;
    }

}
