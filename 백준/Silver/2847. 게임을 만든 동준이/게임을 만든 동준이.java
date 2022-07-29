import java.io.*;
import java.util.*;


public class Main {

    // 레벨의 수를 입력받고, 그 수 만큼 반복하여 각 레벨당 얻는 점수를 가져온다.
    // 그러면서 다음 레벨의 점수가 같거나 낮다면, 그 차이 + 1 만큼 전 레벨의 점수를 낮춘다.
    // 그리고 그 전의 모든 레벨을 확인해 봐야한다. 점수를 안 내려도 되는 레벨이 있을 수 도 있기 때문

    public static int N;
    public static int[] point;


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());

        point = new int[N];

        for (int i = 0; i < N; i++) {
            point[i] = Integer.parseInt(br.readLine());
        }



        int idx = 1;
        int cnt = 0;
        while (idx < N){
            if (point[idx] <= point[idx - 1]){
//                System.out.println(Arrays.toString(point));
                cnt += point[idx - 1] - point[idx] + 1;
                point[idx-1] -= point[idx - 1] - point[idx] + 1;
                idx = 1;
            } else {
                idx++;
            }
        }


        bw.write(String.valueOf(cnt));


        br.close();
        bw.close();


    }


}
















