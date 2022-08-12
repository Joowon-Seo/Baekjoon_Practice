import java.io.*;
import java.util.StringTokenizer;


public class Main {

    // 주사위가 동서남북으로 움직인다. 한번 움직을 때 4개의 면이 바뀐다.
    // 하지만 경우는 총 4가지 만 있기 때문에 움직임에 대한 주사위를 구현하면 된다.

    // 주사위가 움직였을 때 주사위의 윗 부분을 출력한다. (이동하지 않을 때도 있음)
    // 주사위가 움직였을 때 아래가 행해짐
    // map의 숫자가 0일때 주사위 바닥 숫자를 칸에 복사한다.
    // 그렇지 않을 때 칸에 쓰여 있는 수를 주사위 바닥에 복사한다.

    public static int[] dice = {0, 0, 0, 0, 0, 0, 0}; // 0번인덱스는 그냥 여백으로 둔다
    // 문제에 주어진 전개도의 주사위 번호는 각 인덱스를 의미한다.
    public static int N, M, X, Y, K;
    public static int[][] map;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int cmd = Integer.parseInt(st.nextToken());

            int top = roll(cmd);

            if (top == -1) {
                continue;
            }

            if (i == K-1){
                bw.write(top+"");
                break;
            }

            bw.write(top + "\n");
        }


        br.close();
        bw.close();


    }

    public static int roll(int cmd) {
        if (cmd == 1) {

            if (Y == M - 1) {
                return -1;
            }

            int tmp = dice[1];
            dice[1] = dice[3];
            dice[3] = dice[6];
            dice[6] = dice[4];
            dice[4] = tmp;
            Y++;
            copyNum();
            return dice[6];
        } else if (cmd == 2) {

            if (Y == 0) {
                return -1;
            }

            int tmp = dice[1];
            dice[1] = dice[4];
            dice[4] = dice[6];
            dice[6] = dice[3];
            dice[3] = tmp;
            Y--;
            copyNum();
            return dice[6];
        } else if (cmd == 3) {

            if (X == 0) {
                return -1;
            }

            int tmp = dice[1];
            dice[1] = dice[2];
            dice[2] = dice[6];
            dice[6] = dice[5];
            dice[5] = tmp;

            X--;
            copyNum();
            return dice[6];
        } else {
            // cmd == 4

            if (X == N - 1) {
                return -1;
            }

            int tmp = dice[1];
            dice[1] = dice[5];
            dice[5] = dice[6];
            dice[6] = dice[2];
            dice[2] = tmp;

            X++;
            copyNum();
            return dice[6];

        }
    }

    public static void copyNum() {
        if (map[X][Y] == 0) {
            map[X][Y] = dice[1];
        } else {
            dice[1] = map[X][Y];
            map[X][Y] = 0;
        }
    }


}
















