import java.io.*;
import java.util.*;
public class Main {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dX = {-1, 1, 0, 0};
    static int[] dY = {0, 0, -1, 1};



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        visited[0][0] = true;
        bfs(0,0);

        System.out.println(map[n-1][m-1]);



    }

    public static void bfs(int x, int y){

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while (!queue.isEmpty()){

            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dX[i];
                int nextY = curY + dY[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m){
                    continue;
                }

                if (map[nextX][nextY] == 0 || visited[nextX][nextY]){
                    continue;
                }

                queue.add(new int[] {nextX, nextY});
                visited[nextX][nextY] = true;
                map[nextX][nextY] = map[curX][curY] + 1;

            }

        }


    }



}







