package leetcode.Tree;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树迭代器
 *
 * @author zhihua on 2021/1/19
 */
public class Binary_Search_Tree_Iterator {
    List<TreeNode> inOrder;
    int index;
    public Binary_Search_Tree_Iterator(TreeNode root) {
        this.inOrder = new ArrayList<>();
        getInOrder(this.inOrder,root);
        this.index=0;
    }
    public List<TreeNode> getInOrder(List<TreeNode> r,TreeNode root){
        if(root==null){
            return r;
        }
        getInOrder(r,root.left);
        r.add(root);
        getInOrder(r,root.right);
        return r;
    }
    public int next() {
        if(this.index<this.inOrder.size()){
            return this.inOrder.get(this.index++).val;
        }
        return -1;

    }

    public boolean hasNext() {
        if(this.index<this.inOrder.size()){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        TreeNode root1 =new TreeNode(7);
        TreeNode root2 =new TreeNode(3);
        TreeNode root3 =new TreeNode(15);
        TreeNode root4 =new TreeNode(9);
        TreeNode root5 =new TreeNode(20);

        root1.left=root2;
        root1.right=root3;
        root3.left=root4;
        root3.right=root5;

        Binary_Search_Tree_Iterator iterator = new Binary_Search_Tree_Iterator(root1);
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }
}