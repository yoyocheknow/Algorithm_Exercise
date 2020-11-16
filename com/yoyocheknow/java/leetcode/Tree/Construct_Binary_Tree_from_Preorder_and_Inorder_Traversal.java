package leetcode.Tree;

import dataStructure.TreeNode;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Arrays;

/**
 * 从前序遍历和中序遍历中构造二叉树
 *
 * @author zhihua on 2020/11/16
 */
public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length<1){
            return null;
        }
        if(inorder.length<1){
            return null;
        }
        int rootIndex =getRootIndexFromOrder(preorder[0],inorder);
        TreeNode root = build(inorder[rootIndex]);

        root.left = buildTree(buildOrder(preorder,1,rootIndex+1),buildOrder(inorder,0,rootIndex));
        root.right=buildTree(buildOrder(preorder,rootIndex+1,preorder.length),buildOrder(inorder,rootIndex+1,inorder.length));
        return root;
    }
    public int getRootIndexFromOrder(int root,int[] inorder){
        for(int i=0;i<inorder.length;i++){
            if(root==inorder[i]){
                return i;
            }
        }
        return -1;
    }

    public TreeNode build(int root){
        TreeNode node = new TreeNode(root);
        return node;
    }
   public int[] buildOrder(int[] array,int start,int end){
       int[] newOrder = Arrays.copyOfRange(array, start, end);
       return newOrder;
   }

   public static void main(String args[]){
       Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal c= new Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal();
        int[] inorder =new int[]{4,2,5,1,6,3,7};
       int[] preorder =new int[]{1,2,4,5,3,6,7};
       System.out.println(c.buildTree(preorder,inorder).val);
   }
}