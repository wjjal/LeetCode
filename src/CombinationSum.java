import java.util.ArrayList;
import java.util.Arrays;

//Given a set of candidate numbers (C) and a target number (T),
//find all unique combinations in C where the candidate numbers sums to T.
//
//The same repeated number may be chosen from C unlimited number of times.
//
//Note:
//All numbers (including target) will be positive integers.
//Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. 
//(ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
//The solution set must not contain duplicate combinations.
//For example, given candidate set 2,3,6,7 and target 7, 
//A solution set is: 
//[7] 
//[2, 2, 3] 

public class CombinationSum {
	public class Solution {
	    public ArrayList<ArrayList<Integer>> combinationSum(int[] a, int target) {
	        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
	        ArrayList<Integer> l=new ArrayList<Integer>();
	        Arrays.sort(a);
	        solve(a,target,0,0,l,res);
	        return res;
	    }

		public void solve(int[] a, int target, int sum, int i,
				ArrayList<Integer> l, ArrayList<ArrayList<Integer>> res){
	        if(sum==target){ res.add(l); return;}
	        if(sum>target||i>=a.length) return;
	        int n=0;
	        while(n*a[i]+sum<=target){
	            solve(a,target,sum+n*a[i],i+1,l,res);
	            ArrayList<Integer> tmp=new ArrayList<Integer>(l);
	            l=tmp;
	            l.add(a[i]);
	            n++;
	        }
	        return;
	    }
	}
}
