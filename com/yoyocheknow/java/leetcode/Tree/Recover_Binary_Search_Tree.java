package leetcode.Tree;

import dataStructure.TreeNode;

/**
 * 恢复二叉搜索树
 *
 * @author zhihua on 2020/11/23
 */
public class Recover_Binary_Search_Tree {
    /**
     * 整体思路：
     * 通过中序遍历二叉树，因为这样遍历出来的二叉搜索树是有序的。
     * prev代表上一个节点。first，secord代表要交换的两个节点
     * 当prev>root时，说明此两个节点位置不对，需要交换。记录下此两个节点，最后交换即可。
     */
    TreeNode prev =null;
    TreeNode first =null;
    TreeNode second =null;
    public void recoverTree(TreeNode root) {
        inorder(root);
        //交换两个节点的值
        int t =first.val;
        first.val=second.val;
        second.val=t;

    }

    public void inorder(TreeNode root){
        if(root==null){
            return;
        }

        inorder(root.left);

        if(prev!=null && prev.val>root.val){
            if(second==null){
                second=prev;
            }
            first=root;
        }
        prev=root;
        inorder(root.right);
    }

    public static void main(String[] args){
        TreeNode root1=new TreeNode(3);
        TreeNode root2=new TreeNode(1);
        TreeNode root3=new TreeNode(4);
        TreeNode root4=new TreeNode(2);

        root1.left=root2;
        root1.right=root3;
        root3.left=root4;
        Recover_Binary_Search_Tree r = new Recover_Binary_Search_Tree();
        r.recoverTree(root1);
    }
}