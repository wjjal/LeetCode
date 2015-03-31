//Follow up for "Remove Duplicates":
//What if duplicates are allowed at most twice?
//
//For example,
//Given sorted array A = [1,1,1,2,2,3],
//
//Your function should return length = 5, and A is now [1,1,2,2,3].

public class L080RemoveDuplicatesFromSortedArrayII {public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length==0)
            return 0;
        int count = 1;
        int num = 1;
        for(int i = 1;i<A.length;i++){
            if(A[i]==A[i-1])
               count++;
            else
               count = 1;
            if(count<=2)
               A[num++] = A[i];
        }
        return num;
    }
}}
