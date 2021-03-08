import dataStructure.TreeNode;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

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

        HashMap<Integer, String> categoryInfoMap = new HashMap();
        categoryInfoMap.put(4,"1");
        categoryInfoMap.put(2,"2");
        categoryInfoMap.put(5,"3");
        categoryInfoMap.put(1,"4");
        categoryInfoMap.put(3,"5");

        for(Integer key:categoryInfoMap.keySet()){
            System.out.println(key+" "+categoryInfoMap.get(key));
        }
        System.out.println("---------------------");
        //categoryInfoMap.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey()));
        categoryInfoMap = categoryInfoMap.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (oldVal, newVal) -> oldVal,
                                LinkedHashMap::new
                        )
                );

        for(Integer key:categoryInfoMap.keySet()){
            System.out.println(key+" "+categoryInfoMap.get(key));
        }
    }
}