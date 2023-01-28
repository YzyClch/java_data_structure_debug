package com.yzy.test;

import org.junit.Test;

public class TreeTest {




//    @Test
    public int testmaxDepth() {
        return getHigh(new TreeNode());
    }


    public int getHigh(TreeNode root){
        return root==null?0:Math.max(getHigh(root.left),getHigh(root.right))+1;
    }

    public boolean isValidBST(TreeNode root) {
        return leftLtTight(root,Long.MAX_VALUE,Long.MIN_VALUE);

    }

    public boolean leftLtTight(TreeNode treeNode,long maxValue,long minValue){
        if (treeNode==null){
            return true;
        }
        if (treeNode.val>=maxValue || treeNode.val<=minValue){
            return false;
        }
        return leftLtTight(treeNode.left,treeNode.val,minValue) &&
                leftLtTight(treeNode.right,maxValue,treeNode.val);
    }



    @Test
    public void testisValidBST(){
        TreeNode treeNode = new TreeNode(5);
        treeNode.left=new TreeNode(1);
        treeNode.right=new TreeNode(4);
        treeNode.right.left=new TreeNode(3);
        treeNode.right.right=new TreeNode(6);
        System.out.println(isValidBST(treeNode));
    }



    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
}
