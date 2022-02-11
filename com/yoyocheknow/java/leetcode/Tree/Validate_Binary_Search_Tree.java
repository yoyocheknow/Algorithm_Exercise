package leetcode.Tree;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Validate_Binary_Search_Tree {
    public boolean isValidBST(TreeNode root) {
        List<Integer>inOrderList = new ArrayList<>();
        inOrder(inOrderList,root);
        for(int i=0;i<inOrderList.size()-1;i++){
            if(inOrderList.get(i)>=inOrderList.get(i+1)){
                return false;
            }
        }
        return true;
    }
    private void  inOrder(List<Integer> inOrderList ,TreeNode root){
        if(root.left!=null){
            inOrder(inOrderList,root.left);
        }
        if(root!=null){
            inOrderList.add(root.val);
        }
        if(root.right!=null){
            inOrder(inOrderList,root.right);
        }
        return;
    }


    public static void main(String []args){
        TreeNode root1 =new TreeNode(5);
        TreeNode root2 =new TreeNode(4);
        TreeNode root3 =new TreeNode(6);
        TreeNode root4 =new TreeNode(2);
        TreeNode root5 =new TreeNode(4);
        TreeNode root6 =new TreeNode(3);
        TreeNode root7 =new TreeNode(7);

        root1.left=root2;
        root1.right=root3;
//       root2.left=root4;
//       root2.right=root5;
       root3.left=root6;
       root3.right=root7;
        System.out.println(new Validate_Binary_Search_Tree().isValidBST(root1));

    }
}
