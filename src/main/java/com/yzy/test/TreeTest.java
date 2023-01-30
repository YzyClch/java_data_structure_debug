package com.yzy.test;

import com.sun.jmx.remote.internal.ArrayQueue;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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


    public boolean isSymmetric(TreeNode root) {
        return treeEquals(root,root);
    }

    public boolean treeEquals(TreeNode left,TreeNode right){
        if (left==null && right==null){
            return true;
        }
        if (left==null || right==null){
            return false;
        }

        if (left.left!=null && right.right!=null){
            if (left.left.val != right.right.val){
                return false;
            }
        }
        if (left.right!=null && right.left!=null){
            if (left.right.val != right.left.val){
                return false;
            }
        }

        if ((left.left==null && right.right!=null)||(left.left!=null && right.right==null)){
            return false;
        }

        if ((right.left==null && left.right!=null)||(right.left!=null && left.right==null)){
            return false;
        }

        return treeEquals(left.left,right.right) && treeEquals(left.right,right.left);
    }



    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null) return Collections.emptyList();
        ArrayList<List<Integer>> result = new ArrayList<>();
        getLeftAndRight(Arrays.asList(root),result);
        return result;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
//
//        TreeNode middle = new TreeNode(nums[nums.length / 2]);
//
//        System.out.println(Arrays.spliterator(nums, 0, nums.length / 2));
//        System.out.println(Arrays.spliterator(nums, nums.length / 2, nums.length ));
//
//        middle.left= new TreeNode(nums.length/2/2);
////        middle.right = new TreeNode()
//
//
//        ArrayQueue<TreeNode> treeNodes = new ArrayQueue<TreeNode>(nums.length);
//        for (int num : nums) {
//            treeNodes.add(new TreeNode(num));
//        }
//        return null;
        return getNode(nums,0,nums.length-1);
    }


    public TreeNode getNode(int[]nums,int start,int end){
        if (start>end){
            return null;
        }
        int mid = (start+end)/2;
        System.out.println(mid);
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left=getNode(nums,start,mid-1);
        treeNode.right=getNode(nums,mid+1,end);
        return treeNode;
    }



    public int firstBadVersion(int n) {

        int left = 0;
        int right = n;
        int pos =0;

        while (right>=left){
            int key = (left - right) / 2 + right;
            if (!isBadVersion(key)){
                // 不是，说明在右区间
              left=key+1;
          }else {
                // 是，说明在左区间
              right=key-1;
          }
            pos =left;
        }
        return pos;

    }

    @Test
    public void testfirstBadVersion(){
        System.out.println(firstBadVersion(6));
    }


    public boolean isBadVersion(int n){
        return n >= 3;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0;
        int j=0;
        int index=0;
        int[] temp = new int[m+n];
        while (i<m && j<n){
            if (nums1[i]<nums2[j]){
                temp[index++]=nums1[i++];
            }else {
                temp[index++]=nums2[j++];
            }
        }
        while (i!=m){
            temp[index++]=nums1[i++];
        }
        while (j!=n){
            temp[index++]=nums2[j++];
        }
        System.arraycopy(temp, 0, nums1, 0, temp.length);
    }
    @Test
    public void testmerge(){
        int[] ints = {1, 2, 3, 0, 0, 0};
        merge(ints,3,new int[]{2,5,6},3);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }






    @Test
    public void testsortedArrayToBST(){
        System.out.println(sortedArrayToBST(new int[]{-10,-3,0,5,9}));
    }

    private void getLeftAndRight(List<TreeNode> treeNodes,ArrayList<List<Integer>> result) {
        if (treeNodes.isEmpty()){
            return;
        }
        ArrayList<TreeNode> newTreeNodes = new ArrayList<>();
        ArrayList<Integer> intArrays = new ArrayList<>();
        for (TreeNode treeNode : treeNodes) {
            intArrays.add(treeNode.val);
            if (treeNode.left!=null){
                newTreeNodes.add(treeNode.left);
            }
            if (treeNode.right!=null){
                newTreeNodes.add(treeNode.right);
            }
        }
        result.add(intArrays);
        getLeftAndRight(newTreeNodes,result);

    }






    @Test
    public void testlevelOrder(){
        TreeNode treeNode = new TreeNode(3);
        treeNode.left=new TreeNode(9);
        treeNode.right=new TreeNode(20);
//        treeNode.left.left=new TreeNode(3);
//        treeNode.left.right=new TreeNode(4);
        treeNode.right.left=new TreeNode(15);
        treeNode.right.right=new TreeNode(7);
        System.out.println(levelOrder(treeNode));
    }


    @Test
    public void testisSymmetric(){
        TreeNode treeNode = new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(2);
        treeNode.left.left=new TreeNode(3);
        treeNode.left.right=new TreeNode(4);
        treeNode.right.left=new TreeNode(4);
        treeNode.right.right=new TreeNode(3);
        System.out.println(treeEquals(treeNode,treeNode));
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
