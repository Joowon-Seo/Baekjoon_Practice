import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 익은 토마토는 6방향으로 영향을 미치기 때문에 bfs를 이용합니다.
    // 입력받은 데이터를 순회하며, 인덱스의 값이 1 이라면 bfs를 합니다.
    // bfs를 하면서 최대값을 갱신 합니다.

    public static int[][][] map;
    public static boolean[][][] visited;

    public static int[] dh = {-1, 1, 0, 0, 0, 0,};
    public static int[] dx = {0, 0, -1, 1, 0, 0,};
    public static int[] dy = {0, 0, 0, 0, -1, 1};

    public static Queue<Node> queue = new LinkedList<>();


    public static int N, M, H;
    public static int max;

    public static class Node {

        int h;
        int x;
        int y;

        public Node(int h, int x, int y) {
            this.h = h;
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        visited = new boolean[H][N][M];

        max = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int cur = Integer.parseInt(st.nextToken());
                    if (cur == 1) {
                        queue.offer(new Node(i, j, k));
                        visited[i][j][k] = true;
                    }

                    map[i][j][k] = cur;
                }
            }
        }

        bfs();

        if (check()) {
            bw.write(max + "");
        } else {
            bw.write(-1 + "");
        }


        br.close();
        bw.close();


    }

    public static void bfs() {

        while (!queue.isEmpty()) {

            Node cur = queue.poll();

            for (int i = 0; i < 6; i++) {

                int nextH = cur.h + dh[i];
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if (nextH < 0 || nextX < 0 || nextY < 0 ||
                        nextH >= H || nextX >= N || nextY >= M) {
                    continue;
                }

                if (visited[nextH][nextX][nextY] || map[nextH][nextX][nextY] != 0) {
                    continue;
                }

                queue.offer(new Node(nextH, nextX, nextY));
                map[nextH][nextX][nextY] = map[cur.h][cur.x][cur.y] + 1;
                visited[nextH][nextX][nextY] = true;
                max = Math.max(max, map[cur.h][cur.x][cur.y]);


            }

        }


    }

    public static boolean check() {

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[i][j][k] == 0) {
                        return false;
                    }
                }
            }
        }


        return true;
    }


}
















