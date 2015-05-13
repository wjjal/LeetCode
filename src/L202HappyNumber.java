import java.util.HashSet;

public class L202HappyNumber {
	public class Solution {
	    public boolean isHappy(int n) {
	        HashSet<Integer> hash = new HashSet<Integer>();
	        while(!hash.contains(n)){
	            hash.add(n);
	            int k = 0;
	            while(n!=0){
	                int last = n%10;
	                n /= 10;
	                k += last*last;
	            }
	            if(k==1)
	              return true;
	            n = k;               
	        }
	        return false;
	    }
	}
}
