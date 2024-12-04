package problems.java;

import java.lang.reflect.Array;
import java.util.*;

public class p2 {
    public static int hIndex(int[] citations) {
        ArrayList<Integer> sorted = new ArrayList<>();
        for(int i = 0; i < citations.length; i++) {
            sorted.add(citations[i]);
        }
        Collections.sort(sorted, Collections.reverseOrder());
        System.out.println(sorted + " citations sorted");

        for(int i = 0; i < sorted.size(); i++) {
            System.out.println(sorted.get(i) + " " + (i+1));
            if((sorted.get(i) <= (i+1))) {
                System.out.println("------" + (i+1));
                return i+1;
            }
            if(i == sorted.size()-1) {
                return i+1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("expected: 3; " + hIndex(new int[]{3,0,6,1,5}));
        System.out.println("");
        System.out.println("expected: 1; " + hIndex(new int[]{1,3,1}));
        System.out.println("");
        System.out.println("expected: 0; " + hIndex(new int[]{0}));
        System.out.println("");
        System.out.println("expected: 1; " + hIndex(new int[]{1}));
        System.out.println("");
        System.out.println("expected: 2; " + hIndex(new int[]{11, 15}));
    }
}
