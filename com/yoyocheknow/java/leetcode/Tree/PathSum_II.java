package leetcode.Tree;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 二叉树路径之和
 *
 * @author zhihua on 2020/11/17
 */
public class PathSum_II {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        preorder(sum,new ArrayList<>(),result,root);
        return result;
    }

    public void preorder(int sum,List<Integer> temp,List<List<Integer>>result ,TreeNode root){

        if(root==null){
            return;
        }
        temp.add(root.val);
        if(root.left==null && root.right==null && getSum(temp)==sum){
            List<Integer> list = new ArrayList<>();
            list.addAll(temp);
            result.add(list);
        }

        preorder(sum,temp,result,root.left);

        preorder(sum,temp,result,root.right);

        temp.remove(temp.size()-1);

    }

    public int getSum(List<Integer> temp){
        int sum =0;
        for(int i=0;i<temp.size();i++){
            sum =sum+temp.get(i);
        }
        return sum;
    }
    public static void main(String []args){
        TreeNode root1 =new TreeNode(5);
        TreeNode root2 =new TreeNode(4);
        TreeNode root3 =new TreeNode(8);
        TreeNode root4 =new TreeNode(11);
        TreeNode root5 =new TreeNode(13);
        TreeNode root6 =new TreeNode(4);
        TreeNode root7 =new TreeNode(7);
        TreeNode root8 =new TreeNode(2);
        TreeNode root9 =new TreeNode(5);
        TreeNode root10 =new TreeNode(1);

        root1.left=root2;
        root1.right=root3;
       root2.left=root4;

       root3.left=root5;
       root3.right=root6;
       root4.left=root7;
       root4.right=root8;
       root6.left=root9;
       root6.right=root10;
       System.out.println(new PathSum_II().pathSum(root1,22).toString());
    }
}