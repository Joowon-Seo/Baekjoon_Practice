import java.io.*;
import java.util.*;


public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    // 데이터를 입력 받습니다.
    // permutation을 통해 층을 정하고,
    // permutation을 통해 기존 각 층을 n번 회전시킵니다.
    // bfs를 통해 인덱스가 1인 곳을 이동하고 목표점에 도달하면 최값을 갱신합니다.
    
    // 백트래킹 부분 : 층과, 회전 수가 정해진 큐브에서 시작점이 0 or 도착점이 0 이라면 순회를 하지 않고 넘어갑니다.

    public static int[][][] map;
    public static int[][][] copyMap;
    public static boolean[][][] visited;

    public static int[] dz = {-1, 1, 0, 0, 0, 0};
    public static int[] dx = {0, 0, -1, 1, 0, 0};
    public static int[] dy = {0, 0, 0, 0, -1, 1};

    public static int[] target = {0, 1, 2, 3, 4};
    public static int[] result = new int[5];

    public static int ans = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {

        map = new int[5][5][5];


        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 5; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        int[] arr = {0,1,2,3,4};
        int[] out = new int[5];
        boolean[] vi = new boolean[5];
        permutation(arr, out, 0, vi);

        if (ans == Integer.MAX_VALUE){
            bw.write(-1 + "");

        } else {
            bw.write(ans + "");
        }




        br.close();
        bw.close();


    }

    // 중복 5개를 순열 0,1,2
    public static void RedundantPermutation(int[] target, int[] result, int depth) {

        if (depth == 5) {
            if (result[4] != 0){
                copyMap[4] = turn(copyMap[4]);
            }

            // 탈출시작
            visited = new boolean[5][5][5];
            bfs();

//            for (int i = 0; i < 5; i++) {
//                for (int j = 0; j < 5; j++) {
//                    System.out.println(Arrays.toString(copyMap[i][j]));
//                }
//            }
//
//            System.out.println("==========================");

            return;
        }
        if (depth == 4) {
            if (result[4] != 0){
                copyMap[3] = turn(copyMap[3]);
            }

        }
        if (depth == 3) {
            if (result[4] != 0){
                copyMap[2] = turn(copyMap[2]);
            }

        }
        if (depth == 2) {
            if (result[4] != 0){
                copyMap[1] = turn(copyMap[1]);
            }

        }
        if (depth == 1) {
            if (result[4] != 0){
                copyMap[0] = turn(copyMap[0]);
            }

        }

        for (int i = 0; i < 5; i++) {
            result[depth] = target[i];
            RedundantPermutation(target, result, depth + 1);
        }


    }

    public static void permutation(int[] arr, int[] out, int depth, boolean[] visited){

        if (depth == 5){
            copyMap = new int[5][5][5];

            for (int i = 0; i < 5; i++) {
                copyMap[i] = map[out[i]];
            }



            RedundantPermutation(target, result, 0);

            return;
        }

        for (int i = 0; i < 5; i++) {
            if (!visited[i]){
                visited[i] = true;
                out[depth] = arr[i];
                permutation(arr, out, depth + 1, visited);
                visited[i] = false;
            }
        }



    }

    public static int[][] turn (int[][] arr){

        int[][] rotate = new int[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                rotate[i][j] = arr[4 - j][i];
            }
        }

        return rotate;

    }

    public static void bfs(){

        if (copyMap[0][0][0] == 0 || copyMap[4][4][4] == 0){
            return;
        }

        int[][][] min = new int[5][5][5];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0,0,0});
        visited[0][0][0] = true;
//        min[0][0][0] = 1;

        while (!queue.isEmpty()){

            int[] cur = queue.poll();

            for (int i = 0; i < 6; i++) {

                int nextZ = cur[0] + dz[i];
                int nextX = cur[1] + dx[i];
                int nextY = cur[2] + dy[i];


                if (nextZ < 0 || nextX < 0 || nextY < 0 || nextZ >= 5 || nextX >= 5 || nextY >= 5){
                    continue;
                }

                if (visited[nextZ][nextX][nextY]){
                    continue;
                }

                if (copyMap[nextZ][nextX][nextY] != 1){
                    continue;
                }

                queue.offer(new int[]{nextZ, nextX, nextY});
                visited[nextZ][nextX][nextY] = true;
                min[nextZ][nextX][nextY] = min[cur[0]][cur[1]][cur[2]] + 1;




            }

        }

        if (min[4][4][4] == 0){
            return;
        }

        ans = Math.min(ans, min[4][4][4]);


    }


}
















