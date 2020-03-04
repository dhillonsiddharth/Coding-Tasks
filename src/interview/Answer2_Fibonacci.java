import java.util.HashMap;
import java.util.Map;

 
public class Solution
{
 private Map<Integer, Integer> calculatedValues = new HashMap<>();
       public int solution(int N) {
        // Example base cases
        if (N == 0) {
            return 0;
        }

        if (N == 1 || N == 2) {
            calculatedValues.putIfAbsent(N, 1);
            return 1;
        }

        // For example if  fib(n) is already computed
        if (calculatedValues.get(N) != null) {
            return calculatedValues.get(N);
        }

        int k = (N & 1) == 1 ? (int) ((N + 1L) / 2) : N / 2;

        // Applying above formula [Note value n & 1 is 1 if n is odd, else 0]
        long fibK = (long) solution(k);
        long fibK_1 = (long) solution(k - 1);
        int res;
        if ((N & 1) == 1) {
            res = (int)((fibK * fibK + fibK_1 * fibK_1) % 1000000);
        } else {
            res = (int)(((2L * fibK_1 + fibK) * fibK) % 1000000);
        }
        calculatedValues.put(N, res);
        return res;
    }
}