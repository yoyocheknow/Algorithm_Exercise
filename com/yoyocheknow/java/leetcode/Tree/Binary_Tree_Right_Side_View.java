package leetcode.Tree;

import dataStructure.TreeNode;

import java.util.*;

/**
 * 二叉树右视图
 *
 * @author zhihua on 2020/12/27
 */
public class Binary_Tree_Right_Side_View {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> order = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> layer = new ArrayList<>();
            int ordersize = queue.size();
            for(int i=0;i<ordersize;i++){
                TreeNode curr = queue.poll();
                layer.add(curr.val);
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }
            }
            order.add(layer);
        }
        for(int i=0;i<order.size();i++){
            int end = order.get(i).size();
            result.add(order.get(i).get(end-1));
        }
        return result;
    }

    public static void main(String[] args){
        TreeNode root1 =new TreeNode(1);
        TreeNode root2 =new TreeNode(2);
        TreeNode root3 =new TreeNode(3);
        TreeNode root4 =new TreeNode(5);
        TreeNode root5 =new TreeNode(4);

        root1.left=root2;
        root1.right=root3;

        root2.right=root4;

        root3.right=root5;

        System.out.println(new Binary_Tree_Right_Side_View().rightSideView(root1).toString());
    }
}
