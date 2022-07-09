import javax.sound.midi.MidiFileFormat;
import java.io.*;
import java.util.*;


public class Main {

    public static int n, m; // 가로 세로
    public static int[][] paper;
    public static int[] dirX = {-1, 1, 0, 0}; // 상하
    public static int[] dirY = {0, 0, -1, 1}; //좌우

    public static int picture = 0;
    public static int cur = 0;
    public static int max = 0;

    // 데이터를 입력받고
    // 데이터를 순회 하면서, 값이 1이 나오면
    // 1. 그림 개수를 증가시킨다
    // 2. 현재 위치를 기준으로 상하좌우르 탐색한다.(방문 했을 때 1이 나오면 0으로 바꾸어서)
    // 반복 방문을 막는다
    // 탐색이 끝나면 최대값과 비교한다




   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        paper = new int[n][m];

       for (int i = 0; i < n; i++) {
           st = new StringTokenizer(br.readLine());
           for (int j = 0; j < m; j++) {
               paper[i][j] = Integer.parseInt(st.nextToken());
           }
       }

       for (int i = 0; i < n; i++) {
           for (int j = 0; j < m; j++) {
               if (paper[i][j] == 1){
                   picture++;
                   cur = 0;
                   bfs(i,j);
                   max = Math.max(max, cur);
               }
           }
       }



        bw.write(picture + "\n" + max);




        bw.close();
        br.close();

    }

    public static void bfs(int x, int y){


       paper[x][y] = 0;
       cur++;


        for (int i = 0; i < 4; i++) {
            int nextX = x + dirX[i];
            int nextY = y + dirY[i];

            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m){
                if (paper[nextX][nextY] == 1){

                    bfs(nextX, nextY);
                }
            }

        }


    }




}
















