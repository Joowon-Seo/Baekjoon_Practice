import java.io.*;
import java.util.*;
public class Main {

    static int n, m, v;
    static int[][] map;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        visited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 1;
            map[y][x] = 1;
        }

        dfs(v);
        System.out.println();
        visited = new boolean[n + 1];
        bfs(v);


    }

    public static void dfs(int i){
        visited[i] = true;
        System.out.print(i + " ");

        for (int j = 1; j < n+1; j++) {
            if (map[i][j] == 1 && !visited[j]){
                dfs(j);
            }
        }
    }

    public static void bfs(int i){
        Queue<Integer> queue = new LinkedList<>();
        visited[i] = true;
        queue.add(i);

        while (!queue.isEmpty()){
            int cur = queue.poll();
            System.out.print(cur + " ");

            for (int j = 1; j < n + 1; j++) {
                if (map[cur][j] == 1 && !visited[j]){
                    queue.add(j);
                    visited[j] = true;
                }

            }

        }
    }



}







