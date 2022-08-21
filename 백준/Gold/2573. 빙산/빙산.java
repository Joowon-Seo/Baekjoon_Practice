import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 빙산의 데이터를 입력 받습니다.
    // bfs 를 통해 몇 등분으로 나누어져 있는지 확인합니다.
    // 이 때 2등분 이상으로 나누어져 있으면 시간을 출력합니다.(0등분 이라면 0출력)
    // 하나로 이어져 있다면, 각 인덱스의 숫자가 0이 아닐 때 bfs를 통해 몇 면이 바다로 이루어져 있는지
    // 확인하고 해당 면 만틈 감소 시킵니다.(음수가 되면 0으로 처리)

    // 위의 내용을 반복합니다.

    public static int[][] map;
    public static int[][] copyMap;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static int N, M;
    public static int time;
    public static int cnt;

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        time = 0;

        while (true) {

            // 몇 등분?
            // 0등분 : 0 출력
            // 1등분 : 통과
            // 2등분 이상 : 현재 시간 출력

            visited = new boolean[N][M];
            cnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != 0 && !visited[i][j]) {
                        partition(i, j);
                        cnt++;
                    }
                }
            }

//            System.out.println("cnt = " + cnt);
            if (cnt == 0) {
                bw.write(0 + "");
                break;
            } else if (cnt >= 2) {
                bw.write(time + "");
                break;
            }


            // 빙산 녹음
            copyMap = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != 0){
                        melt(i, j);
                    }
                }
            }

            map = copyMap;

            time++;
        }


        br.close();
        bw.close();


    }

    public static void partition(int x, int y) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {

            Node cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }

                if (visited[nextX][nextY] || map[nextX][nextY] == 0) {
                    continue;
                }

                queue.offer(new Node(nextX, nextY));
                visited[nextX][nextY] = true;

            }


        }


    }

    public static void melt(int x, int y) {

        Node cur = new Node(x, y);

        int height = map[cur.x][cur.y];
        int sea = 0;

        for (int i = 0; i < 4; i++) {
            int nextX = cur.x + dx[i];
            int nextY = cur.y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                continue;
            }

            if (map[nextX][nextY] != 0) {
                continue;
            }

            sea++;

        }

        height -= sea;

        if (height < 0) {
            height = 0;
        }

        copyMap[cur.x][cur.y] = height;


    }


}
















