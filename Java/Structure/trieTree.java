import com.sun.org.apache.xpath.internal.operations.String;

import sun.applet.Main;
import sun.security.mscapi.KeyStore.ROOT;

/**
*@author: Luke
*/

public class trieTree{
	
	 class TrieNode {
	        Map<Character, TrieNode> children;
	        boolean isWord;
	        int value;
	        
	        public TrieNode() {
	            children = new HashMap<Character, TrieNode>();
	            isWord = false;
	            value = 0;
	        }
	 }
	 TrieNode root;
     public trieTree(){
    	 this.root = new TrieNode();
     }
     
     public void insert(String key, int val) {
         TrieNode curr = root;
         for (char c : key.toCharArray()) {
             TrieNode next = curr.children.get(c);
             if (next == null) {
                 next = new TrieNode();
                 curr.children.put(c, next);
             }
             curr = next;
         }
         curr.isWord = true;
         curr.value = val;
     }
     public void insert(String key) {
    	 this.insert(key, 1);
     }
     public int sum(String prefix) {
         TrieNode curr = root;
	 	for (char c : prefix.toCharArray()) {
	 	    TrieNode next = curr.children.get(c);
	 	    if (next == null) {
	 	        return 0;
	 	    }
	 	    curr = next;
         }
         return dfs(curr);
     }
     private int dfs(TrieNode root) {
         int sum = 0;
         for (char c : root.children.keySet()) {
             sum += dfs(root.children.get(c));
         }
         return sum + root.value;
     }
     
     public static void main(String[] args) {
    	 trieTree t = new trieTree();
    	 
    	 String[] input = {"skf", "asxf", "as", "arg", "sk"};
    	 
    	 for (String s : input){
    		 t.insert(s);
    	 }
    	 
    	 System.out.println(t.sum("a"));
	}
}