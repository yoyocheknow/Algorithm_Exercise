import dataStructure.TreeNode;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

/**
 * java SE Test
 *
 * @author zhihua on 2020/12/28
 */
public class TestJava {

    public List<Integer> rightSideView(TreeNode root){
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> order = new ArrayList<>();
        if(root==null){
            return result;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> layer = new ArrayList<>();
            int ordersize = queue.size();
            for(int i=0;i<ordersize;i++){
                TreeNode current = queue.poll();
                layer.add(current.val);
                if(current.left!=null){
                    queue.add(current.left);
                }
                if(current.right!=null){
                    queue.add(current.right);
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
        ThreadLocal local = new ThreadLocal();
        ThreadLocal local1 = new ThreadLocal();
        local.set("111");

        local1.set("112");
        System.out.println(local.get());
        System.out.println(local1.get());
        //System.out.println(new TestJava().findMax("qqqq"));
    }
}