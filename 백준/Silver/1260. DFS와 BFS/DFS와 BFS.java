import java.io.*;
import java.util.*;
public class Main {

    static int[][] map;
    static boolean[] visit;
    static int n, m, v;

    public static void dfs(int i){
        visit[i] = true;
        System.out.print(i + " ");

        for (int j = 1; j <n+1; j++) {
            if (map[i][j] == 1 && visit[j] == false){
                dfs(j);
            }
        }
    }

    public static void bfs(int i){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visit[i] = true;

        while (!queue.isEmpty()){
            int tmp = queue.poll();
            System.out.print(tmp + " ");

            for (int j = 1; j < n + 1; j++) {
                if (map[tmp][j] == 1 && visit[j] == false){
                    queue.offer(j);
                    visit[j] = true;
                }
            }
        }
    }




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        visit = new boolean[n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
            map[y][x] = 1;

        }

        dfs(v);
        System.out.println();
        Arrays.fill(visit, false);
        bfs(v);




    }
}







