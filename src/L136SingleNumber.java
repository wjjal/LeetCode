//Given an array of integers, every element appears twice except for one. 
//Find that single one.
//
//Note:
//Your algorithm should have a linear runtime complexity. 
//Could you implement it without using extra memory?

public class L136SingleNumber {
	public class Solution {
	    public int singleNumber(int[] A) {
	        int re = A[0];
	        for(int i = 1;i<A.length;i++){
	            re ^= A[i];
	        }
	        return re;
	    }
	}
}
