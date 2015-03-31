//Given an array where elements are sorted in ascending order, 
//convert it to a height balanced BST.

public class L108ConvertSortedArrayToBinarySearchTree {
	public class Solution {
	    public TreeNode sortedArrayToBST(int[] num) {
	        return sortedArrayToBST(num,0,num.length-1);
	    }
	    
	    private TreeNode sortedArrayToBST(int[] num, int begin, int end){
	        if(begin > end)
	           return null;
	        int mid = begin + (end-begin)/2;
	        TreeNode node = new TreeNode(num[mid]);
	        node.left = sortedArrayToBST(num,begin,mid-1);
	        node.right = sortedArrayToBST(num,mid+1,end);
	        return node;
	    }
}
}
