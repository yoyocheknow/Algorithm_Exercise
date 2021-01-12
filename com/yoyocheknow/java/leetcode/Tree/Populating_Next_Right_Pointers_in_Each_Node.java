package leetcode.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 在二叉树的每个节点填充next指针指向右边的节点
 * 给的是一个perfect binary tree 完美二叉树
 * @author zhihua on 2021/1/12
 */
public class Populating_Next_Right_Pointers_in_Each_Node {
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        Deque<Node> stack = new ArrayDeque();
        stack.push(root);

        while(!stack.isEmpty()){

            int row=stack.size();
            for(int i=0;i<row;i++){
                Node father = stack.pollLast();

                if(i<row-1){
                    father.next = stack.peekLast();
                }else{
                    father.next=null;
                }

                if(father.left!=null){
                    stack.push(father.left);
                }
                if(father.right!=null){
                    stack.push(father.right);
                }

            }
        }
        return root;
    }

    public static void main(String[] args){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=node6;
        node3.right=node7;

        System.out.println(new Populating_Next_Right_Pointers_in_Each_Node().connect(node1));
    }
}