import java.io.*;
import java.util.*;


public class Main {

    static int N, E; //정점과, 간선의 개수
    static boolean[] visited;
    static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    static int cnt;
    
    // haspMap에 각 정정에 대한 간선의 정보를 기입해줍니다
    // dfs를 통해 각 정점에서 연결된 정점중 방문하지 않은 정점들을 방문합니다.
    // 방문할 때 방문기록을 남기고 cnt++를 진행합니다
    // 결과는 1번 컴퓨터를 포함해 연결된 컴퓨터의 개수가 나옵니다
    // 출력은 결과값인 cnt - 1을 하면 됩니다.




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
















