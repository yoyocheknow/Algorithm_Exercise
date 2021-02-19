package leetcode.Array;

/**
 * 实现一个字符串前缀树
 *
 * @author zhihua on 2021/2/19
 */

/**
 * TrieNode 是一个这样一个数据结构：
 *    ROOT
 *    |---------------------------|
 *    |isEnd:false                |
 *    |abcdefghijkLmnopqrstuvwxyz |
 *    |___________________________|
 *                 |
 *    NODE         |
 *    |---------------------------|
 *    |isEnd:false                |
 *    |abcdEfghijklmnopqrstuvwxyz |
 *    |___________________________|
 *                 |
 *    NODE         |
 *    |---------------------------|
 *    |isEnd:false                |
 *    |abcdEfghijklmnopqrstuvwxyz |
 *    |___________________________|
 *                 |
 *    NODE         |
 *    |---------------------------|
 *    |isEnd:false                |
 *    |abcdefghijklmnopqrsTuvwxyz |
 *    |___________________________|
 *                 |
 *    NODE         |
 *    |---------------------------|
 *    |isEnd:true                 |
 *    |abcdefghijklmnopqrstuvwxyz |
 *    |___________________________|
 *    如上所示。大写字符代表这个节点所装填的字符。上面展示的是leet 所代表的前缀树。
 *    如果新插入多个字符串的话，有可能从root节点分出26叉个子节点。
 */
class TrieNode {

    // R links to node children
    private TrieNode[] links;
    //R 代表一共26个字母
    private final int R = 26;

    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }
    //判断一个node里面有没有该字符，就判断这个位置的字符是否为空
    public boolean containsKey(char ch) {
        return links[ch -'a'] != null;
    }
    //get操作返回的也是一个TrieNode，相当于返回了下一个节点
    public TrieNode get(char ch) {
        return links[ch -'a'];
    }
    //put操作表示该位置已有一个node
    //用字母所在的位置来代表该字母
    public void put(char ch, TrieNode node) {
        links[ch -'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}

class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter)) {
                node = node.get(curLetter);
            } else {
                return null;
            }
        }
        return node;
    }
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}

public class Implement_Trie_Prefix_Tree {
    public static void main(String[] args){
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
}