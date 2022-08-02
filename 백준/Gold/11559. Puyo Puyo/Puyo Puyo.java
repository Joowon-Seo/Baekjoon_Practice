import java.io.*;
import java.util.*;


public class Main {

    // 데이터를 입력받습니다.
    // bfs를 이용해서 연결된 인덱스가 4이상이면 연결된 인덱스의 값을 "."으로 바꿉니다.
    // 이후 중력의 영향을 주기 위해 map을 돌면서
    // 자신의 아래 행에 .이 있다면 아래로 이동시킵니다.

    // 구현해야할 메소드
    // 연결된 인덱스 개수를 확인하는 bfs
    // 4개이상 연결됐을 때 연결된 인덱스의 값을 .으로 바꿔주는 change
    // 중력의 영향으로 내리는 메소드

    public static char[][] map;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0 ,0};
    public static int[] dy = {0, 0, -1, 1};
    public static int result;


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        map = new char[12][6];

        for (int i = 0; i < 12; i++) {
            String str = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = str.charAt(j);
            }
        }







        while (true){
//            System.out.println("=================");
//            for (int i = 0; i < 12; i++) {
//                System.out.println(Arrays.toString(map[i]));
//            }

            int sum = 0;
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] != '.'){
                        visited = new boolean[12][6];
                        sum += bfs(i, j);
                    }
                }
            }

            if (sum == 0){
                break;
            } else {
                result ++;

                // 중력으로 내려가는 메소드
                gravity();
            }

//            System.out.println("=================");
//            for (int i = 0; i < 12; i++) {
//                System.out.println(Arrays.toString(map[i]));
//            }
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();


    }

    public static int bfs(int x, int y){
        ArrayList<int[]> arrayList = new ArrayList<>();
        arrayList.add(new int[] {x, y});

        int cnt = 1;

        visited[x][y] = true;

        char data = map[x][y];


        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});

        while (!queue.isEmpty()){
            int[] cur = queue.poll();

            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];


                if (nextX < 0 || nextY < 0 || nextX >= 12 || nextY >= 6){
                    continue;
                }


                if (visited[nextX][nextY]){
                    continue;
                }

                if (map[nextX][nextY] == data){
                    visited[nextX][nextY] = true;
                    queue.offer(new int[] {nextX, nextY});
                    cnt++;
                    arrayList.add(new int[] {nextX, nextY});
                }
            }
        }

        if (cnt >= 4){
            // 연결된 데이터 "."으로 변경
            change(arrayList);
            return 1;
        }

        return 0;

    }

    public static void change(ArrayList<int[]> arrayList){

        for (int i = 0; i < arrayList.size(); i++) {
            int[] cur = arrayList.get(i);

            map[cur[0]][cur[1]] = '.';
        }

    }

    public static void gravity(){

        for (int i = 11; i > 0; i--) {
            for (int j = 0; j < 6; j++) {
                if (map[i][j] == '.'){
                    // 해당 인덱스 윗 행에, 몇번째 행에 문자가 존재하는지 확인
                    int k = check(i,j);
                    if (k == -1){
                        continue;
                    } else {
                        // 현재 행까지 문자를 내림
                        down(i, j, k);
                    }
                }
            }
        }



    }

    public static int check(int i, int j){

        for (int k = i; k >= 0 ; k--) {
            if (map[k][j] != '.'){
                return k;
            }
        }

        return -1;

    }

    public static void down(int i, int j, int k){
        for (int l = k; l >= 0; l--) {
            map[i][j] = map[l][j];
            map[l][j] = '.';
            i--;
        }
    }


}
















