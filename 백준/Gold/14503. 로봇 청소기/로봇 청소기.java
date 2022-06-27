import java.io.*;
import java.util.*;
public class Main {

    static int[][] map;
    static int r,c,d;
    static int result;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        cnt = 0;
        result = 0;

        while (true){
            if (cnt == 4){
                if (backCheck()){
                    break;
                } else {
                    back();
                }
            }

            // 해당 위치 청소
            if (map[r][c] == 0){
                map[r][c] = -1;
                result++;
            }

            // 왼쪽 청소하지 않은 빈 공간 존재 확인
            if(leftCheck()){
                //청소x 빈 공간이 있다면 전진
                LL();
                go();
            } else {
                LL();
            }

        }


        bw.write(Integer.toString(result));
        br.close();
        bw.close();

    }

        // 뒤에 장애물 유무 확인
        // 벽이 있다면 true 반환
        public static boolean backCheck(){

            if (d == 0){
                return  map[r+1][c] == 1;
            } else if (d == 1){
                return map[r][c-1] == 1;
            } else if (d== 2){
                return map[r-1][c] == 1;
            } else{
                return map[r][c+1] == 1;
            }

        }

        //후진 방향은 그대로임
        //후진 후 cnt 초기화
        public static void back(){
            if (d==0){
                r++;
            } else if (d==1){
                c--;
            } else if (d==2){
                r--;
            } else {
                c++;
            }

            cnt = 0;
        }

        // 왼쪽에 청소하지 않은 빈 공간이 존재 확인
        // 빈공간 이면 true 반환
        public static boolean leftCheck(){

            if (d==0){
                return map[r][c-1]==0;
            } else if (d==1){
                return map[r-1][c]==0;
            } else if (d==2){
                return map[r][c+1]==0;
            } else {
                return map[r+1][c]==0;
            }

        }

        // 방향 전환
        // 방향 전활 할 때 cnt 증가
        public static void LL(){
            if (d==0){
                d=3;
            } else {
                d--;
            }
            cnt++;
        }


        //각 방향별 직진
        // 직진하면 연속 회전 횟 수 초기화
        public static void go(){

            if (d==0){
                r--;
            } else if (d==1){
                c++;
            } else if (d==2){
                r++;
            } else {
                c--;
            }

            cnt=0;

        }





    }









