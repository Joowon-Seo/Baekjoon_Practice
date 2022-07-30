import java.io.*;
import java.util.*;


public class Main {

    // 미로의 크기를 입력받고
    // 미로에 대한 정보를 입력 받는다
    // 각 인덱스의 값이 주변 인덱스에서 해당 인덱스로 오기 위한 가중치라고 생각한다.

    public static int N, M;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0 ,0};
    public static int[] dy = {0, 0, -1 ,1};




    public static class Node implements Comparable<Node>{
        int x;
        int y;
        int weight;

        public Node(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }



    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int result = bfs(0,0);

        bw.write(String.valueOf(result));





        br.close();
        bw.close();


    }

    public static int bfs(int x, int y){
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.offer(new Node(x, y, map[x][y]));
        visited[x][y] = true;

        while (!pq.isEmpty()){

            Node cur = pq.poll();

            if (cur.x == N - 1 && cur.y == M - 1){
                return cur.weight;
            }

            for (int i = 0; i < dx.length; i++) {

                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M){
                    continue;
                }

                if (visited[nextX][nextY]){
                    continue;
                }

                pq.offer(new Node(nextX, nextY, cur.weight + map[nextX][nextY]));
                visited[nextX][nextY] = true;

            }

        }

        return -1 ;

    }


}
















