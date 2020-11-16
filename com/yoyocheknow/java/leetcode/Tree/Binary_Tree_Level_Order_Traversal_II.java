package leetcode.Tree;

import dataStructure.TreeNode;

import java.util.*;

/**
 * 二叉树层序遍历II
 *
 * @author zhihua on 2020/11/16
 */
public class Binary_Tree_Level_Order_Traversal_II {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);
        while(!stack.isEmpty()){
            int size = stack.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = stack.pollLast();
                level.add(node.val);
                if(node.left!=null){
                    stack.push(node.left);
                }
                if(node.right!=null){
                    stack.push(node.right);
                }
            }
            result.add(level);
        }
        Collections.reverse(result);
        return result;

    }
    public static void main(String[] args){
        TreeNode root1 =new TreeNode(1);
        TreeNode root2 =new TreeNode(2);
        TreeNode root3 =new TreeNode(3);
        TreeNode root4 =new TreeNode(4);
        TreeNode root5 =new TreeNode(5);
        TreeNode root6 =new TreeNode(6);
        TreeNode root7 =new TreeNode(7);

        root1.left=root2;
        root1.right=root3;
        root2.left=root4;
        root2.right=root5;
        root3.left=root6;
        root3.right=root7;
        System.out.println(new Binary_Tree_Level_Order_Traversal_II().levelOrderBottom(root1).toString());
    }
}