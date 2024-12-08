package problems.java;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/* https://leetcode.com/problems/median-of-two-sorted-arrays
Median of Two Sorted Arrays

Given two sorted arrays nums1 and nums2 of size m and n respectively,
return the median of the two sorted arrays.

Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
* */

public class p1 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int j : nums1) {
            array.add(j);
        }
        for (int j : nums2) {
            array.add(j);
        }
        Collections.sort(array);

        if(array.size() % 2 == 0) {
            int secondPos = array.size()/2;
            int firstPos = secondPos-1;

            return (array.get(firstPos) + array.get(secondPos))/2.0;
        } else {
            return array.get(array.size()/2);
        }
    }

    @Disabled
    @Test
    public void test() {
        double result = findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        assertEquals(2.0, result, "Median of {1,3} {2}");

        result = findMedianSortedArrays(new int[]{1, 2}, new int[]{3,4});
        assertEquals(2.5, result, "Median of {1,2} {3,4}");

        result = findMedianSortedArrays(new int[]{2,2,4,4}, new int[]{2,2,2,4,4});
        assertEquals(2.0, result, "Median of {2,2,4,4} {2,2,2,4,4}");
    }
}
