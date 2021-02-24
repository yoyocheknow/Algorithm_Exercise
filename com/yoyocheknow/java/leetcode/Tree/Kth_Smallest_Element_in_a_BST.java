package leetcode.Tree;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到一个二叉搜索树中第K小的元素
 *
 * @author zhihua on 2021/2/24
 */
public class Kth_Smallest_Element_in_a_BST {
    public int kthSmallest(TreeNode root, int k) {
        if(root==null){
            return -1;
        }
        List<Integer> inOrder = new ArrayList<>();
        inOrder(root,inOrder);
        for(int i : inOrder){
            System.out.print(i+ " ");
        }
        return inOrder.get(k-1);

    }

    public void inOrder(TreeNode root, List<Integer> inOrder){
        if(root==null){
            return ;
        }

        if(root.left!=null){
            inOrder(root.left,inOrder);
        }
        inOrder.add(root.val);
        if(root.right!=null){
            inOrder(root.right,inOrder);
        }
    }

    public static void main(String[] args){
        TreeNode root1 =new TreeNode(5);
        TreeNode root2 =new TreeNode(3);
        TreeNode root3 =new TreeNode(6);
        TreeNode root4 =new TreeNode(2);
        TreeNode root5 =new TreeNode(4);
        TreeNode root6 =new TreeNode(1);

        root1.left=root2;
        root1.right=root3;
        root2.left=root4;
        root2.right=root5;

        root4.left=root6;

        System.out.println(new Kth_Smallest_Element_in_a_BST().kthSmallest(root1,6));
    }
}