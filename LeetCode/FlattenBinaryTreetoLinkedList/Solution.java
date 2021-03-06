/*
 * Flatten Binary Tree to Linked List - Oct 14 '12 - 7105 / 21371
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
Hints:
If you notice carefully in the flattened tree, 
each node's right child points to the next node of a pre-order traversal.
 */

package FlattenBinaryTreetoLinkedList;

import Helper.TreeNode;

// AC on 1st try :)
public class Solution {
	public void flatten(TreeNode root) {
		if(root != null) visit(root);
	}
	
	// move left node to right, return the most right node
	public TreeNode visit(TreeNode node) {
		TreeNode left = node.left, right = node.right;
		
		if(left == null && right == null) return node;
		else if(left == null) return visit(right);
		else {
			node.left = null;
			node.right = left;
			TreeNode lastLeft = visit(left);
			if(right == null) return lastLeft;
			lastLeft.right = right;
			lastLeft.left = null;
			return visit(right);
		}
	}
}
