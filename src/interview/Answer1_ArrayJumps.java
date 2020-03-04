import java.util.*;
class Solution {

    public int solution(int[] A) {
        // edge cases
        if (A == null || A.length == 0) {
            return -1;
        }
        boolean[] hasBeen = new boolean[A.length];
        // only because next address can potentially overflow with int
        long index = 0;
        int steps = 0;
        while (index < A.length && index >= 0) {
            steps++;
            int curIndex = (int) index;
            if (hasBeen[curIndex]) {
                return -1;
            } else {
                hasBeen[curIndex] = true;
            }
            index += A[curIndex];
        }
        return steps;
    }
}
