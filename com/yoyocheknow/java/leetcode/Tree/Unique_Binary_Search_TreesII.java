package leetcode.Tree;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 构造不同的二叉搜索树II
 *
 * @author zhihua on 2020/11/21
 */
public class Unique_Binary_Search_TreesII {
    /**
     * 整体思路：
     * 从1到n计算可以生成的二叉搜索树，二叉搜索树的性质是右子树比根节点大，左子树比根节点小。
     * 所以可以从1-n，依次遍历作为根节点，生成不同的搜索树。
     * 生成一个结果list，存放结果，List<TreeNode> result。
     * 由于序列是有序的，所以根节点的左边都属于左子树，右边都属于右子树。这些子树节点都存放在list中。
     * 递归遍历生成左子树和右子树。
     * 左子树为空时，那么新生成的root节点的left为null，右子树为rightArray.get(i),分别生成这样新的root节点。
     * 右子树为空时，那么新生成的root节点的right为null，左子树为leftArray.get(i).分别生成这样新的root节点。
     * 当左右子树均不为空时，针对当前遍历的节点i，构造新的root节点。这样的组合有leftArray.length * rightArray.length 中。
     * 分别让leftArray.get(j), rightArray.get(k) 作为左右子节点，构成新的节点。
     */
    public List<TreeNode> generateTrees(int n) {

        List<Integer> array = new ArrayList<>();
        for(int i=0;i<n;i++){
            array.add(i+1);
        }
        return backTrack(array);

    }

    public List<TreeNode> backTrack(List<Integer> array){
        if(array.size()==0){
            return new ArrayList<>();
        }
        if(array.size()==1){
            return Arrays.asList(new TreeNode(array.get(0)));
        }
        List<TreeNode> result = new ArrayList<>();
        for(int i=0;i<array.size();i++){

            List<TreeNode> leftArray = backTrack(array.subList(0,i));
            List<TreeNode> rightArray= backTrack(array.subList(i+1,array.size()));
            if(leftArray.size()==0){
                for(int k=0;k<rightArray.size();k++){
                    result.add(new TreeNode(array.get(i),null,rightArray.get(k)));
                }
            }
            if(rightArray.size()==0){
                for(int k=0;k<leftArray.size();k++){
                    result.add(new TreeNode(array.get(i),leftArray.get(k),null));
                }
            }

            for(int j=0;j<leftArray.size();j++){
                for(int k=0;k<rightArray.size();k++){
                    result.add(new TreeNode(array.get(i),leftArray.get(j),rightArray.get(k)));
                }
            }
        }
        return result;
    }
    public List<TreeNode> generateTrees1(int n) {
        List<TreeNode> ans = BST(1,n);
        return ans;
    }

    public List<TreeNode> BST(int start, int end){
        if(start>end){
            List<TreeNode> nullList = new ArrayList<>();
            nullList.add(null);
            return nullList;
        }
        List<TreeNode> ans = new ArrayList<>();
        for(int i=start;i<=end;i++){
            List<TreeNode> left = BST(start,i-1);
            List<TreeNode> right = BST(i+1,end);
            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Unique_Binary_Search_TreesII u= new Unique_Binary_Search_TreesII();
        List<TreeNode> result = u.generateTrees1(4);
        for(int i=0;i<result.size();i++){
            System.out.print(result.get(i).val);
        }

    }
}