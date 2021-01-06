package leetcode.Tree;

import dataStructure.ListNode;
import dataStructure.TreeNode;

/**
 * 将有序链表转化为二叉搜索树
 *
 * @author zhihua on 2021/1/6
 */
public class Convert_Sorted_List_to_Binary_Search_Tree {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        int count = count(head);
        return DFS(head,0,count-1);
    }

    public TreeNode DFS(ListNode head,int left,int right){
        if(head ==null || left>right){
            return null;
        }
        int mid = left +(right-left)/2;
        ListNode midNode = findMid(head,mid);
        TreeNode root = new TreeNode(midNode.val);

        root.left = DFS(head,left,mid-1);
        root.right = DFS(head,mid+1,right);
        return root;
    }
    public int count(ListNode head){
        int count =0;
        while(head!=null){
            count++;
            head = head.next;
        }
        return count;
    }

    public ListNode findMid(ListNode head,int count){
        if(head==null){
            return null;
        }
        ListNode slow = head;
        while(slow!=null &&count >0){
            slow = slow.next;
            count --;
        }
        return slow;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(-10);
        ListNode l2 = new ListNode(-3);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(9);

        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;

        TreeNode root = new Convert_Sorted_List_to_Binary_Search_Tree().sortedListToBST(l1);
        Inorder(root);
    }

    public static void Inorder(TreeNode root){
        if(root.left!=null){
            Inorder(root.left);
        }

        System.out.println(root.val);
        if(root.right!=null){
            Inorder(root.right);
        }

    }
}