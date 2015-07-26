package lc.p20150724;

import java.util.*;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where
 * each word is a valid dictionary word.
 * Return all such possible sentences.
 * <p>
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * <p>
 * A solution is ["cats and dog", "cat sand dog"].
 */
public class WordBreak2 {

    public List<String> wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.isEmpty() || wordDict.isEmpty()) {
            return Collections.emptyList();
        }
        int maxDictWordSize = -1;
        for (String word : wordDict) {
            if (word.length() > maxDictWordSize) {
                maxDictWordSize = word.length();
            }
        }
        Sol[] solutions = new Sol[s.length()];
        for (int i = 0; i < s.length(); i++) {
            List<WordPos> variants = new LinkedList<>();
            if (i <= maxDictWordSize) {
                String currentWord = s.substring(0, i + 1);
                if (wordDict.contains(currentWord)) {
                    variants.add(new WordPos(0, i + 1));
                }
            }
            for (int k = Math.max(i - maxDictWordSize, 0); k < i; k++) {
                Sol solution = solutions[k];
                String lastWord = s.substring(k + 1, i + 1);
                if (solution != null && wordDict.contains(lastWord)) {
                    variants.add(new WordPos(k + 1, i + 1));
                }
            }
            if (!variants.isEmpty()) {
                solutions[i] = new Sol(variants);
            }
        }
        Sol finalSolution = solutions[solutions.length - 1];
        if (finalSolution != null) {
            return createFinalVariants(finalSolution.variants, solutions, s);
        } else {
            return Collections.emptyList();
        }
    }

    private List<String> createFinalVariants(List<WordPos> variants, Sol[] solutions, String s) {
        List<String> result = new ArrayList<>();
        for (WordPos variant : variants) {
            if (variant.start == 0) {
                result.add(s.substring(0, variant.end));
            } else {
                String word = s.substring(variant.start, variant.end);
                for (String leadingStr : createFinalVariants(solutions[variant.start - 1].variants, solutions, s)) {
                    result.add(leadingStr + " " + word);
                }
            }
        }
        return result;
    }

    static class Sol {
        List<WordPos> variants;

        public Sol(List<WordPos> variants) {
            this.variants = variants;
        }
    }

    static class WordPos {
        int start, end;

        public WordPos(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
