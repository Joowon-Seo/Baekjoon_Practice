import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    // 주어진 데이터를 받는다
    // 데이터를 받는 과정에서 cctv를 나타내는 데이터는
    // cctv 클래스로 관리한다
    // 각 cctv의 특징에 따라 보는 방향이 다르다는 점을 통해
    // 순열을 통해 각 cctv가 보는 방향을 정해주고 여러 케이스를 찾느다
    // 찾을 케이스를 통해 사각지대의 cnt를 구하고
    // 결과 cnt 값을 받고, 최소 값보다 작을 때마다 업데이트를 해준다.

    public static int N, M; // 가로세로의 크기
    public static int[][] map;
    public static ArrayList<CCTV> cctvArrayList;
    public static int[][] copyMap;
    public static int[] out; // 순열의 결과값을 나타내는 배열
    public static int[] dx = {-1, 0, 1, 0}; // 상 우 하 좌
    public static int[] dy = {0, 1, 0, -1};
    public static int result = Integer.MAX_VALUE;

    public static class CCTV {
        int num;
        int x;
        int y;

        public CCTV(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }



    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cctvArrayList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6){
                    cctvArrayList.add(new CCTV(map[i][j], i, j));
                }
            }
        }

        out = new int[cctvArrayList.size()];

        permutation(0, cctvArrayList.size());

        bw.write(String.valueOf(result));


        br.close();
        bw.close();


    }

    public static void permutation(int dep, int r){

        if (dep == r){

            copyMap = new int[N][M];

            for (int i = 0; i < N; i++) {
                System.arraycopy(map[i], 0, copyMap[i], 0, M);
            }

            for (int i = 0; i < cctvArrayList.size(); i++) {
                direction(cctvArrayList.get(i), out[i]);
            }

            getMin();

            return;
        }

        for (int i = 0; i < 4; i++) {
            out[dep] = i;
            permutation(dep + 1, r);
        }

    }

    public static void direction(CCTV cctv, int d){
        int cctvNum = cctv.num;

        if (cctvNum == 1){
            watch(cctv, d);
        } else if (cctvNum == 2){
            if (d == 0 || d == 2){// 일 때는 상하
                watch(cctv, 0);
                watch(cctv, 2);
            } else { // 우좌
                watch(cctv, 1);
                watch(cctv, 3);
            }
        } else if (cctvNum == 3){
            if (d == 0){// 상 우
                watch(cctv, 0);
                watch(cctv, 1);
            } else if (d == 1){ // 우 하
                watch(cctv, 1);
                watch(cctv, 2);
            } else if (d == 2){ // 하 좌
                watch(cctv, 2);
                watch(cctv, 3);
            } else if (d == 3){ // 좌 상
                watch(cctv, 3);
                watch(cctv, 0);
            }
        } else if (cctvNum == 4){
            if (d == 0){// 좌 상 우
                watch(cctv, 0);
                watch(cctv, 1);
                watch(cctv, 3);
            } else if (d == 1){// 상 우 하
                watch(cctv, 0);
                watch(cctv, 1);
                watch(cctv, 2);
            } else if (d == 2){// 우 하 좌
                watch(cctv, 1);
                watch(cctv, 2);
                watch(cctv, 3);
            } else if (d == 3){// 하 좌 상
                watch(cctv, 2);
                watch(cctv, 3);
                watch(cctv, 0);
            }
        } else if (cctvNum == 5){
            // 상 하 좌 우
            watch(cctv, 0);
            watch(cctv, 1);
            watch(cctv, 2);
            watch(cctv, 3);
        }

    }

    public static void watch(CCTV cctv, int d){
        Queue<CCTV> queue = new LinkedList<>();

        queue.add(cctv);

        while (!queue.isEmpty()){
            CCTV cur = queue.poll();
            int nextX = cur.x + dx[d];
            int nextY = cur.y + dy[d];

            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M || copyMap[nextX][nextY] == 6){
                break;
            }

            if (copyMap[nextX][nextY] == 0){
                copyMap[nextX][nextY] = -1;
            }

            queue.add(new CCTV(cctv.num, nextX, nextY));

        }


    }

    public static void getMin(){

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0){
                    cnt++;
                }
            }
        }

        result = Math.min(cnt, result);

    }


}
















