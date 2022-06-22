import java.io.*;
import java.util.*;
//
//class Node{
//    Long key;
//    Node left;
//    Node right;
//
//    public Node(Long key, Node left, Node right) {
//        this.key = key;
//        this.left = left;
//        this.right = right;
//    }
//}
//
//class BinarySearchTree {
//    Node head;
//
//    BinarySearchTree() {
//    }
//
//    BinarySearchTree(Long key) {
//        if (this.head == null) {
//            this.head = new Node(key, null, null);
//        }
//    }
//
//    public void addNode(long key){
//        if (this.head == null){
//            this.head = new Node(key, null, null);
//        } else {
//            Node cur = this.head;
//
//            while (true){
//
//                Node pre = cur;
//
//                if (key < cur.key){
//                    cur = cur.left;
//
//                    if (cur == null){
//                        pre.left = new Node(key, null, null);
//                        break;
//                    }
//                } else {
//
//                    cur = cur.right;
//
//                    if (cur == null){
//                        pre.right = new Node(key, null, null);
//                        break;
//                    }
//
//                }
//            }
//
//
//        }
//    }
//
//
//    public boolean search(long key){
//        Node cur = this.head;
//
//        while (true){
//            if (cur == null) {
//                return false;
//            }
//
//            if (cur.key == key){
//                return true;
//            }
//
//            if (key < cur.key){
//                cur = cur.left;
//            } else {
//                cur = cur.right;
//            }
//
//        }
//    }
//
//}
//
//

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (Arrays.binarySearch(arr, num) >= 0){
                bw.write("1 ");
            } else {
                bw.write("0 ");
            }
        }

        bw.close();
        br.close();
    }
}





