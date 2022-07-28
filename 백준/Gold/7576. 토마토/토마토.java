import java.io.*;
import java.util.*;


public class Main {

    // 주어진 데이터를 입력 받는다
    // 인접한 데이터의 값을 탐색하면서, 최소값을 찾기 때문에 bfs 를 이용한다.
    // 다만 익은 토마토의 개수가 여러개 일 수 있다.
    // 따라서 bfs의 queue 에 모든 1의 위치정보를 넣어준 다음 돌린다.

    public static int M, N;
    public static int[][] map;
    public static int[] dx = {-1, 1, 0 ,0};//상하좌우
    public static int[] dy = {0, 0, -1 ,1};

    public static ArrayList<int[]> list;


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1){
                    list.add(new int[] {i,j});
                }
            }
        }

        bfs(list);


        int result = check();

        bw.write(String.valueOf(result));






        br.close();
        bw.close();


    }

    public static void bfs(ArrayList<int[]> list){

        Queue<int[]> queue = new LinkedList<>(list);

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M){
                    if (map[nextX][nextY] == 0){
                        map[nextX][nextY] = map[curX][curY] + 1;
                        queue.offer(new int[] {nextX, nextY});
                    }
                }
            }

        }


    }

    public static int check(){

        int cnt = 0;


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0){
                    return -1;
                }

                cnt = Math.max(cnt, map[i][j]);
            }
        }

        return cnt - 1;

    }


}
















