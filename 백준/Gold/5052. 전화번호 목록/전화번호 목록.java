import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean isLeafNode;
    }

    static class Trie {
        Node head = new Node();

        public void addNum(String num) {
            Node curr = this.head;
            for (char c : num.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new Node());
                }
                curr = curr.children.get(c);
            }
            curr.isLeafNode = true;
        }
        public boolean getResult(String num) {
            Node curr = this.head;

            for (int i = 0; i < num.length(); i++) {
                curr = curr.children.get(num.charAt(i));
                if (i < num.length() - 1 && curr.isLeafNode){
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            Trie trie = new Trie();
            int n = Integer.parseInt(br.readLine());

            String[] nums = new String[n];
            for (int i = 0; i < n; i++) {
                nums[i] = br.readLine();
                trie.addNum(nums[i]);
                }

            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (!trie.getResult(nums[i])){
                    flag = false;
                    break;
                }
            }

            if (flag){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }



        }
    }
}





