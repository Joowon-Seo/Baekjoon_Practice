import java.io.*;
import java.util.*;


public class Main {

    static int N, E; //정점과, 간선의 개수
    static boolean[] visited;
    static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    static int cnt;


    static class Node{

        int id;
        int next;

        public Node(int id, int next) {
            this.id = id;
            this.next = next;
        }
    }




   public static void main(String[] args) throws IOException {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//       StringTokenizer st = new StringTokenizer(br.readLine());


       N = Integer.parseInt(br.readLine());
       E = Integer.parseInt(br.readLine());

       visited = new boolean[N + 1];
       cnt = 0;



       for (int i = 1; i <= N; i++) {
           map.put(i, new ArrayList<>());
       }

       for (int i = 0; i < E; i++) {
           StringTokenizer st = new StringTokenizer(br.readLine());
           int from = Integer.parseInt(st.nextToken());
           int to = Integer.parseInt(st.nextToken());
           map.get(from).add(to);
           map.get(to).add(from);
       }



       dfs(1);


       bw.write(String.valueOf(cnt - 1));



       br.close();
       bw.close();


    }

    public static void dfs(int n){
        visited[n] = true;
        cnt++;

        for (int i = 0; i < map.get(n).size(); i++) {
            int cur = map.get(n).get(i);

            if (!visited[cur]){
                dfs(cur);
            }

        }
    }


}
















