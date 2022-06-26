import java.io.*;
import java.util.*;
public class Main {


    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; //상하
    static int[] dy = {0, 0, -1, 1}; // 좌우
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];


        List<Integer> result = new ArrayList<>();



        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]){
                    map[i][j] = 0;
                    visited[i][j] = true;
                    result.add(bfs(i,j));
                }
            }
        }

        Collections.sort(result);

        System.out.println(result.size());

        for (int i : result){
            System.out.println(i);
        }





    }

    public static int bfs(int x, int y){

        int cnt = 1;

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {x, y});

        while (!queue.isEmpty()){

            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];


                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N){
//                    System.out.println(nextX + " " + nextY);
                    continue;
                }

                if (map[nextX][nextY] == 0 || visited[nextX][nextY]){
//                    System.out.println(nextX + " " + nextY);
                    continue;
                }


                map[nextX][nextY] = 0;
                queue.offer(new int[] {nextX, nextY});
                visited[nextX][nextY] = true;
                cnt++;



            }
        }


        return cnt;
    }



}







