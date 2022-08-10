import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

    // 톱니바퀴 데이터를 입력 받습니다.
    // 회전 시킬 수를 입력 받습니다.

    // 특정 톱니바퀴를 회전 시킬 때
    // 좌우의 영향을 받는 톱니바퀴를 확인합니다.

    // 영향을 받는 톱니바퀴를 확인하고, 방향을 정합니다.
    // 톱니 바퀴를 회전하고, 이를 총 K번 반복합니다.

    public static ArrayList<Character>[] w;
    public static int[] di;
    public static int result;




    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        w = new ArrayList[4];

        for (int i = 0; i < 4; i++) {
            w[i] = new ArrayList<>();
        }

        for (int i = 0; i < 4; i++) {
            String str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                w[i].add(str.charAt(j));
            }
        }

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(str.nextToken()) - 1;
            int direction = Integer.parseInt(str.nextToken());
            di = new int[4];

            leftCheck(num, direction, di);
            rightCheck(num, direction, di);

            for (int j = 0; j < 4; j++) {
                turn(j, di[j]);
            }



        }

        result = 0;

        if (w[0].get(0) == '1'){
            result += 1;
        }
        if (w[1].get(0) == '1'){
            result += 2;
        }
        if (w[2].get(0) == '1'){
            result += 4;
        }
        if (w[3].get(0) == '1'){
            result += 8;
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();


    }

    // 해당 바퀴가 회전해야하는지, 어느방향으로 회전해야하는지 확인
    public static void leftCheck(int num, int direction, int[] di){
        di[num] = direction;

        if (num == 0){
            return;
        }

        if (w[num].get(6) == w[num - 1].get(2)){

            return;
        }

        leftCheck(num - 1, direction * -1, di);






    }

    public static void rightCheck(int num, int direction, int[] di){
        di[num] = direction;

        if (num == 3){
            return;
        }

        if (w[num].get(2) == w[num + 1].get(6)){
            return;
        }

        rightCheck(num + 1, direction * -1, di);
    }

    public static void turn(int num, int direction){
        if (direction == 0){
            return;
        }

        if (direction == 1){
            // 시계 방향 회전
            ArrayList<Character> wClone = new ArrayList<>();
            wClone.add(w[num].get(7));
            for (int i = 0; i < 7; i++) {
                wClone.add(w[num].get(i));
            }
            w[num] = wClone;

            return;
        }

        ArrayList<Character> wClone = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            wClone.add(w[num].get(i));
        }
        wClone.add(w[num].get(0));
        w[num] = wClone;
    }


}
















