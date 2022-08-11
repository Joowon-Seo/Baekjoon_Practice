import java.io.*;
import java.util.*;


public class Main {

    // 미로를 입력 받는다.
    // 불이 먼저 4방향으로 번진다
    // 지훈이는 "."인 부분으로 이동한다.
    // 미로의 가장자리 부분에 도착하면 탈출 한 것으로 간주한다.
    
    // 메모리초과 : queue 를 하나로 관리한다. 기존은 불과, J 두개로 했었음

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static boolean[][] visited;
    public static ArrayList<int[]> fire;

    public static char[][] maze;
    public static int[][] map;

    public static class Location{
        int x;
        int y;
        char type;

        public Location(int x, int y, char type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        maze = new char[R][C];
        map = new int[R][C];
        visited = new boolean[R][C];
        fire = new ArrayList<>();
        int[] locate = new int[2];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();

            for (int j = 0; j < C; j++) {
                maze[i][j] = str.charAt(j);
                if (maze[i][j] == 'F'){
                    fire.add(new int[] {i, j});
                    continue;
                }

                if (maze[i][j] == 'J'){
                    locate[0] = i;
                    locate[1] = j;
                }
            }
        }

        Queue<Location> queue = new LinkedList<>();
//        Queue<int[]> fQueue = new LinkedList<>();

        boolean escape = false;
        map[locate[0]][locate[1]] = 1;


        for (int i = 0; i < fire.size(); i++) {
            queue.add(new Location(fire.get(i)[0], fire.get(i)[1], 'F'));
        }

        queue.add(new Location(locate[0], locate[1], 'J'));
        visited[locate[0]][locate[1]] = true;

        while (!queue.isEmpty()){

//            System.out.println("============");
//            for (int i = 0; i < R; i++) {
//                for (int j = 0; j < C; j++) {
//                    System.out.print(maze[i][j]);
//                }
//                System.out.println();
//            }


            Location cur = queue.poll();

            if (cur.x == 0 || cur.x == R - 1) {
                if (cur.type == 'J'){
                    escape = true;
                    locate[0] = cur.x;
                    locate[1] = cur.y;
                    break;
                }
            }

            if (cur.y == 0 || cur.y == C - 1) {
                if (cur.type == 'J') {
                    escape = true;
                    locate[0] = cur.x;
                    locate[1] = cur.y;
                    break;
                }
            }


            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C){
                    continue;
                }

                if (cur.type == 'F' && maze[nextX][nextY] == '.'){
                    maze[nextX][nextY] = 'F';
                    queue.add(new Location(nextX, nextY, 'F'));
                }

                if (cur.type == 'J' && maze[nextX][nextY] == '.' && !visited[nextX][nextY]){
                    queue.add(new Location(nextX, nextY, 'J'));
                    visited[nextX][nextY] = true;
                    map[nextX][nextY] = map[cur.x][cur.y] + 1;
                    maze[nextX][nextY] = 'J';
                }

            }


        }

        if (escape){
            bw.write(String.valueOf(map[locate[0]][locate[1]]));
        } else {
            bw.write("" + "IMPOSSIBLE");
        }





        br.close();
        bw.close();


    }




}
















