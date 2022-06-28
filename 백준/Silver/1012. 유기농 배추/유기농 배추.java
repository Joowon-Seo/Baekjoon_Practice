import javax.swing.*;
import java.io.*;
import java.util.*;
public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int M, N, K;
    static int result;
    // 상, 하, 좌, 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[M][N];
            visited = new boolean[M][N];
            result = 0;
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine()," ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;

            }

            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[j][k] == 1 && !visited[j][k]){
                        result++;
                        dfs(j, k);
                    }
                }
            }

            System.out.println(result);


        }






    }

//    public static void solution() throws IOException {
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        M = Integer.parseInt(st.nextToken());
//        N = Integer.parseInt(st.nextToken());
//        K = Integer.parseInt(st.nextToken());
//
//        map = new int[M][N];
//        visited = new boolean[M][N];
//        result = 0;
//        for (int i = 0; i < K; i++) {
//            st = new StringTokenizer(br.readLine());
//            int x = Integer.parseInt(st.nextToken());
//            int y = Integer.parseInt(st.nextToken());
//            map[x][y] = 1;
//        }
//
//        for (int i = 0; i < M; i++) {
//            for (int j = 0; j < N; j++) {
//                if (map[i][j] == 1 && !visited[i][j]){
//                    result++;
//                    dfs(i, j);
//                }
//            }
//        }
//
//
//        System.out.println(result);
//
//
//
//
//    }

    public static void dfs(int x, int y){
        visited[x][y] = true;
        map[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextY >= 0 && nextX < M && nextY < N){
                if (map[nextX][nextY] == 1 && !visited[nextX][nextY]){
                    dfs(nextX, nextY);
                }
            }
        }
    }

}








