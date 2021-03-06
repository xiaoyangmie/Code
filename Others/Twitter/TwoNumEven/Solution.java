/*
 * Write a function:
class Solution { public int solution(int[] A); }
that, given an array A consisting of N integers, returns the number of pairs (P, Q) such that 0 ≤ P < Q < N and (A[P] + A[Q]) is even. The function should return −1 if the number of such pairs exceeds 1,000,000,000.
For example, given array A such that:
A[0] = 2, A[1] = 1, A[2] = 5, A[3] = −6, A[4] = 9
the function should return 4, because there are four pairs that fulfill the above condition, namely (0,3), (1,2), (1,4), (2,4).
Assume that:
N is an integer within the range [0..1,000,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
Complexity:
expected worst-case time complexity is O(N);
expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
 */

package Twitter.TwoNumEven;

public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(new int[]{1, 1, 1, 1, 1}));
	}
	
	public int solution(int[] A) {
        if(A == null || A.length < 2) return 0;
        int even = 0, odd = 0, res = 0;
        
        for(int i = 0; i < A.length; i++) {
            if(A[i] % 2 == 0) even++;
            else odd++;
        }
        
        if(even > 0) res = even * (even - 1) / 2;
        if(odd > 0) res += odd * (odd - 1) / 2;
        
        return res;
	}
}
