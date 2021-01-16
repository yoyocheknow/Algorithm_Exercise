package leetcode.Tree;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树根节点到叶子结点组成数字的和
 *
 * @author zhihua on 2021/1/16
 */
public class Sum_Root_to_Leaf_Numbers {
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        //return dfs(root,0);
        List<List<Integer>> result =new ArrayList<>();
        deeptrack(new ArrayList<>(),result,root);
        int sum=0;
        for(int i=0;i<result.size();i++){
            int num=0;
            int local=1;
            for(int j=result.get(i).size()-1;j>=0;j--){
                num = num+result.get(i).get(j)*local;
                local*=10;
            }
            sum =sum+num;
        }
        return sum;
    }
    //回溯法
    public void deeptrack(List<Integer> deep,List<List<Integer>> result,TreeNode root){

        deep.add(root.val);
        if(root.left==null && root.right==null){
            result.add(new ArrayList<>(deep));
            return;
        }


        if(root.left!=null){
            deeptrack(deep,result,root.left);
            deep.remove(deep.size()-1);
        }

        if(root.right!=null){
            deeptrack(deep,result,root.right);
            deep.remove(deep.size()-1);
        }

    }
    //深度遍历解法
    public int dfs(TreeNode root, int sum){
        if(root==null){
            return 0;
        }
        sum = sum*10+root.val;

        if(root.right==null && root.left==null){
            return sum;
        }
        return dfs(root.left,sum)+dfs(root.right,sum);
    }

    public static void main(String[] args){
        TreeNode root1 =new TreeNode(4);
        TreeNode root2 =new TreeNode(9);
        TreeNode root3 =new TreeNode(0);
        TreeNode root4 =new TreeNode(5);
        TreeNode root5 =new TreeNode(1);

        root1.left=root2;
        root1.right=root3;
        root2.left=root4;
        root2.right=root5;

        System.out.println(new Sum_Root_to_Leaf_Numbers().sumNumbers(root1));
    }
}