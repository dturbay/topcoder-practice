package tda.srm696;

import java.util.HashMap;
import java.util.Map;

/**
 * Hero has two arrays, A and B, each containing the same number of integers.
 * He wants to change A into an array that will resemble B as closely as possible.
 * More precisely, the difference between two arrays of equal length is the number of indices where
 * the two arrays differ. Hero wants to minimize the distance between the modified array A and
 * the original array B. Hero can only modify A by using stickers. He has a collection of stickers.
 * Each sticker contains a single integer. Each sticker can be used to cover a single element of A.
 * Hero must use each sticker exactly once, and he cannot use multiple stickers on the same element of A.
 * You are given the original arrays in the s A and B, and the collection of stickers in the F.
 * Return the smallest possible difference between A and B after all stickers from F have been used
 * to replace some elements of A.
 */
public class Arrfix {

  public int mindiff(int[] A, int[] B, int[] F) {
    Map<Integer, Integer> stickers = new HashMap<>();
    for(int st: F) {
      if (stickers.containsKey(st)) {
        stickers.put(st, stickers.get(st) + 1);
      } else {
        stickers.put(st, 1);
      }
    }
    int sameCount = 0;
    Map<Integer, Integer> same = new HashMap<>();
    for (int i = 0 ; i < B.length ; i++) {
      if (B[i] != A[i]) {
        Integer stickerCount = stickers.get(B[i]);
        if(stickerCount != null) {
          sameCount++;
          stickerCount--;
          if (stickerCount == 0) {
            stickers.remove(B[i]);
          } else {
            stickers.put(B[i], stickerCount);
          }
        }
      } else {
        sameCount++;
        Integer numberCount = same.getOrDefault(B[i], 0);
        same.put(B[i], numberCount + 1);
      }
    }

    int stickersLeft = 0;
    for (Map.Entry<Integer, Integer> entry : stickers.entrySet()) {
      Integer count = same.get(entry.getKey());
      if (count != null) {
        stickersLeft += entry.getValue() - Math.min(entry.getValue(), count);
      } else {
        stickersLeft += entry.getValue();
      }
    }
    sameCount -= stickersLeft;
    if (sameCount < 0) {
      sameCount = 0;
    }
    return A.length - sameCount;
  }

}
