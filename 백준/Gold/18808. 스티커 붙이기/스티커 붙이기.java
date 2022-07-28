import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

    // 노트북 쿠기와, 스티커 개수를 입력 받는다.
    // 스티커 개수 반큼 반복합니다.
    // 노트북 공간에, 그자리에 스티커가 들어갈 수 있는지 확인합니다.
    // 확인은 최대 4번까지 할 수 있음
    // 1. 스티커의 최대 행과 열의 크기를 비교
    // 2. 스티커가 들어갈 수 있는 빈칸이 있는지
    // 3. 그렇지 않다면 시계방향으로 90도 회전

    // 위 4번의 반복을 실패하면 다음 스티커로 넘어갑니다.

    // 최종적으로 노트북 공간에 1의 개수를 출력합니다.

    public static int N, M, K;
    public static int[][] map; // 노트북 공간
    public static int[][] copyMap; //
    public static int cnt;


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];


        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            int[][] arr = new int[row][col];

            for (int j = 0; j < row; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < col; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 0; j < 4; j++) {
                if (solution(arr)){
                    break;
                } else {
                    arr = rotate(arr);
                }
            }

        }



        count();
        bw.write(String.valueOf(cnt));

        br.close();
        bw.close();


    }
    public static boolean solution(int[][] arr2){

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (check(i,j,arr2)){
                    return true;
                }
            }
        }

        return false;


    }

    public static boolean check(int x, int y, int[][] arr2){
        if(x + arr2.length > map.length || y + arr2[0].length > map[0].length){
            return false;
        }


        copyMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0,copyMap[i], 0, M);
        }

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                if (i + x >= N || j + y >= M){
                    return false;
                }
                if (arr2[i][j] == 1){
                    if (copyMap[i + x][j + y] == 1){
                        return false;
                    } else {
                        copyMap[i + x][j + y] = 1;
                    }
                }
            }
        }

        map = copyMap;
        return true;
    }

    public static int[][] rotate(int[][] arr2){
        int n = arr2.length;
        int m = arr2[0].length;

        int[][] rotate = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotate[i][j] = arr2[n - 1 - j][i];
            }
        }

        return rotate;

    }

    public static void count(){

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1){
                    cnt++;
                }
            }
        }

    }


}
















