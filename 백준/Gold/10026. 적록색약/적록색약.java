import java.io.*;
import java.util.*;


public class Main {

    // 특정 인덱스에 대해 주변 인덱스를 순회함으로, bfs를 사용합니다.
    // 하지만 두가지의 bfs를 구현해야합니다.
    // 각 색을 구별하는 bfs는 3가지 색으로 구분을 합니다.
    // 적록색약을 가진 사람이 보는 bfs는 R or G을 한 색상으로 간주하고 B와 구분합니다.

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static int N;

    public static char[][] map;
    public static boolean[][] visited;
    public static boolean[][] visited2;




    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        visited = new boolean[N][N];
        visited2 = new boolean[N][N];

        int general = 0;
        int special = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]){
                    generalBfs(i,j);
                    general++;
                }
                if (!visited2[i][j]){
                    colorWeaknessBfs(i, j);
                    special++;
                }
            }
        }



        bw.write(String.valueOf(general + " "));
        bw.write(String.valueOf(special));





        br.close();
        bw.close();


    }

    public static void generalBfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x,y});
        visited[x][y] = true;

        while (!queue.isEmpty()){

            int[] cur = queue.poll();
            char curColor = map[cur[0]][cur[1]];


            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + dx[i];
                int nextY = cur[1] + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N){
                    continue;
                }

                char nextColor = map[nextX][nextY];

                if (visited[nextX][nextY] || curColor != nextColor) {
                    continue;
                }

                queue.offer(new int[] {nextX, nextY});
                visited[nextX][nextY] = true;

            }


        }

    }

    public static void colorWeaknessBfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x,y});
        visited2[x][y] = true;

        while (!queue.isEmpty()){

            int[] cur = queue.poll();
            char curColor = map[cur[0]][cur[1]];


            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + dx[i];
                int nextY = cur[1] + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N){
                    continue;
                }

                char nextColor = map[nextX][nextY];

                if (curColor != nextColor){
                    if (curColor == 'B' || nextColor == 'B'){
                        continue;
                    }
                }

                if (visited2[nextX][nextY]) {
                    continue;
                }

                queue.offer(new int[] {nextX, nextY});
                visited2[nextX][nextY] = true;




            }


        }

    }




}
















