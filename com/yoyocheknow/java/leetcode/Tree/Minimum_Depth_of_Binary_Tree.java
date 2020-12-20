package leetcode.Tree;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的最小深度
 *
 * @author zhihua on 2020/12/20
 */
public class Minimum_Depth_of_Binary_Tree {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        List<List<TreeNode>> result =new ArrayList<>();
        deepList(result,new ArrayList<>(),root);
        int min=Integer.MAX_VALUE;
        for(int i=0;i<result.size();i++){
            min = Math.min(min, result.get(i).size());
        }
        return min;
    }

    public void deepList(List<List<TreeNode>> result,List<TreeNode> temp,TreeNode root){
        if(root.right==null && root.left==null){
            temp.add(root);
            result.add(new ArrayList<>(temp));
            return;
        }
        temp.add(root);
        if(root.left!=null) {
            deepList(result,temp,root.left);
            temp.remove(temp.size()-1);
        }
        if(root.right!=null){
            deepList(result,temp,root.right);
            temp.remove(temp.size()-1);
        }
    }

    public static  void  main(String[] args){
        TreeNode root1 =new TreeNode(3);
        TreeNode root2 =new TreeNode(9);
        TreeNode root3 =new TreeNode(20);
        TreeNode root4 =new TreeNode(15);
        TreeNode root5 =new TreeNode(7);

        root1.left=root2;
        root1.right=root3;
        root3.left=root4;
        root4.right=root5;

        Minimum_Depth_of_Binary_Tree l= new Minimum_Depth_of_Binary_Tree();
        System.out.println(l.minDepth(root1));
    }
}