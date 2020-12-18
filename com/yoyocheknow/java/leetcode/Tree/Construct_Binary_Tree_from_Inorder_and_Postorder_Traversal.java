package leetcode.Tree;

import dataStructure.TreeNode;

import java.util.Arrays;

/**
 * 从中序和后序遍历中构造二叉树
 *
 * @author zhihua on 2020/12/18
 */
public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length<1){
            return null;
        }
        if(inorder.length<1){
            return null;
        }
        //后序遍历root为 最后一个元素
        int rootValue = postorder[postorder.length-1];
        //从中序遍历中找到这个root 下标，下标左侧为左子树，右侧为右子树
        int rootIndex = findNode(inorder,rootValue);
        TreeNode root = new TreeNode(rootValue);
        root.left = buildTree(build(inorder,0,rootIndex),build(postorder,0,rootIndex));
        root.right = buildTree(build(inorder,rootIndex+1,inorder.length),build(postorder,rootIndex,postorder.length-1));
        return root;
    }

    public int findNode(int[] order,int target){
        for(int i=0;i<order.length;i++){
            if(target==order[i]){
                return i;
            }
        }
        return -1;
    }

    public int[] build(int[] order,int start,int end){
        int[] newOrder = Arrays.copyOfRange(order, start, end);
        return newOrder;
    }

    public static void main(String args[]){
        Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal c= new Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal();
        int[] inorder =new int[]{9,3,15,20,7};
        int[] preorder =new int[]{9,15,7,20,3};
        System.out.println(c.buildTree(inorder,preorder).val);
    }
}