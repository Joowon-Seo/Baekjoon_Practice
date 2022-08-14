import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 데이터를 입력 받습니다.
    // 인덱스 값이 2, 1 이라면 건너 뜁니다.
    // 0이라면, 1을 대입시킵니다.
    // dfs를 통해서 3번 벽을 쌓을 때 까지 반복합니다.
    // 2차 배열을 순회하면서, 2일 때 bfs로 바이러스가 퍼지는 개수를 확인합니다.
    // 각 경우에 대해서 최소값을 갱신하면 결과 값을 출력합니다.

    public static int N, M;

    public static int[][] map;
    public static int[][] copyMap;
    public static boolean[][] visited;

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static int max = Integer.MIN_VALUE;
    public static int cnt = 0;


    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        bw.write(max + "");


        br.close();
        bw.close();


    }

    public static void dfs(int depth) {

        if (depth == 3) {
            // 벽 3개를 세웠을 때 바이러스의 확산 개수를 카운트 합니다.
            copyMap = new int[N][M];
            cnt = 0;


            for (int i = 0; i < N; i++) {
                System.arraycopy(map[i], 0, copyMap[i], 0, M);
                Arrays.fill(visited[i], false);
            }


            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 2) {
                        bfs(i, j);
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (copyMap[i][j] == 0) {
                        cnt++;
                    }
                }
            }

//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < M; j++) {
//                    System.out.print(copyMap[i][j] + " ");
//                }
//
//                System.out.println();
//            }


            max = Math.max(max, cnt);

            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {

                    map[i][j] = 1;
                    dfs(depth + 1);
                    map[i][j] = 0;
                }
            }
        }


    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {

            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + dx[i];
                int nextY = cur[1] + dy[i];


                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }

                if (visited[nextX][nextY]) {
                    continue;
                }

                if (map[nextX][nextY] == 0) {
                    copyMap[nextX][nextY] = 2;
                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY});
                }

            }

        }
    }


}
















