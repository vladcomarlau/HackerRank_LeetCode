package problems.java;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
https://leetcode.com/problems/h-index
H-INDEX
Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.

According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.

Example 1:

Input: citations = [3,0,6,1,5]
Output: 3
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
Example 2:

Input: citations = [1,3,1]
Output: 1

Constraints:

n == citations.length
1 <= n <= 5000
0 <= citations[i] <= 1000
 */
public class p2 {
    public static int hIndex(int[] citations) {
        ArrayList<Integer> sorted = new ArrayList<>();
        for (int citation : citations) {
            sorted.add(citation);
        }
        Collections.sort(sorted, Collections.reverseOrder());

        for(int i = 0; i < sorted.size(); i++) {
            if((sorted.get(i) <= (i))) {
                return i;
            }
            if(i == sorted.size()-1) {
                return i+1;
            }
        }
        return 0;
    }

    @Disabled
    @Test
    public void test() {
        int result = hIndex(new int[]{3,0,6,1,5});
        assertEquals(3, result, "H-Index of [3,0,6,1,5]");

        result = hIndex(new int[]{1,3,1});
        assertEquals(1, result, "H-Index of [1,3,1]");

        result = hIndex(new int[]{0});
        assertEquals(0, result, "H-Index of [0]");

        result = hIndex(new int[]{1});
        assertEquals(1, result, "H-Index of [1]");

        result = hIndex(new int[]{11, 15});
        assertEquals(2, result, "H-Index of [11, 15]");
    }
}
