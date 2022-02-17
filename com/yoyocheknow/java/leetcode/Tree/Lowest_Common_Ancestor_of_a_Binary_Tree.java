package leetcode.Tree;

import dataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 最近公共祖先
 *
 * @author zhihua on 2020/11/18
 */
public class Lowest_Common_Ancestor_of_a_Binary_Tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode dummy1=root;
        TreeNode dummy2=root;
        List<TreeNode> pList = new ArrayList<>();
        List<TreeNode> qList = new ArrayList<>();
//        dfs(root,p,pList,new ArrayList<>());
//        dfs(root,q,qList,new ArrayList<>());
        preorder(root,p,pList,new ArrayList<>(),false);
        preorder(root,q,qList,new ArrayList<>(),false);
        pList.stream().forEach(item->System.out.print(item.val+" "));
        System.out.println();
        qList.stream().forEach(item->System.out.print(item.val+" "));
        System.out.println();
        int left=0;
        int right=0;
        TreeNode resultNode = new TreeNode(0);
        while(left<pList.size() && right<qList.size()){
            if(pList.get(left).val==qList.get(right).val){
                resultNode=pList.get(left);
                left++;
                right++;
            }else{
                return resultNode;
            }
        }
        return resultNode;
    }
    //前序遍历，找到目标节点的路径。
    //path存放路径，result存放结果，防止在递归的时候，把正常的路径节点remove掉。
    //find表示一旦找到目标节点，就返回。停止继续遍历。
    public void preorder(TreeNode root, TreeNode target,List<TreeNode> result,List<TreeNode> path,boolean find){
        if(root==null || find){
            return;
        }
        path.add(root);
        if(root==target){
            find=true;
            result.addAll(path);
        }
        preorder(root.left,target,result,path,find);
        preorder(root.right,target,result,path,find);
        path.remove(path.size()-1);
    }
    public void dfs(TreeNode root, TreeNode target,List<TreeNode> result,List<TreeNode> path){
        if(root==null || root==target){
            result.addAll(path);
            return;
        }
        path.add(root);

        dfs(root.left,target,result,path);
        dfs(root.right,target,result,path);
        path.remove(path.size()-1);
    }


    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

        //如果p<root && q<root ,那么p，q的共同祖先一定在root左子树中
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor1(root.left, p, q);
        }
        //如果p>root && q>root ,那么p，q的共同祖先一定在root右子树中
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor1(root.right, p, q);
        }
        //如果p ，q 在root两边，或者 p / q是其中一个root，那么公共祖先一定是root
        return root;


    }


    public static  void  main(String[] args){
        TreeNode root1 =new TreeNode(6);
        TreeNode root2 =new TreeNode(2);
        TreeNode root3 =new TreeNode(8);
        TreeNode root4 =new TreeNode(0);
        TreeNode root5 =new TreeNode(4);
        TreeNode root6 =new TreeNode(7);
        TreeNode root7 =new TreeNode(9);
        TreeNode root8 =new TreeNode(3);
        TreeNode root9 =new TreeNode(5);
        root1.left=root2;
        root1.right=root3;
        root2.left=root4;
        root2.right=root5;
        root3.left=root6;
        root3.right=root7;
        root5.left=root8;
        root5.right=root9;
        Lowest_Common_Ancestor_of_a_Binary_Tree l= new Lowest_Common_Ancestor_of_a_Binary_Tree();
        System.out.println(l.lowestCommonAncestor(root1,root2,root8).val);
    }
}