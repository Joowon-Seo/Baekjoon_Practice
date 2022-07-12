import javax.sound.midi.MidiFileFormat;
import java.io.*;
import java.util.*;


public class Main {

    // 구하려는 수 N을 입력 받는다
    // dp[1] = 0, dp[2] = 1 은 고정이다.
    // dp[3] 부터 N까지의 경우의 수를 구하는데
    //
    // 1. dp[현재값] = dp[현재값 - 1] + 1; 을 해준다. 2와 3으로 안 나누어 떨어질 수 있기 때문
    // 2. 2 또는 3을 나누어 진다면 dp[현재값 / 2 또는 3] + 1 과 1.번의 수중 작은 값이 dp[현재 값]이 된다.
    //
    // 값을 찾는 도중 현재값에서 그전은 어떤 수 인지 저장한다.


    public static int N;
    public static int[] dp;
    public static int[] preDp;




   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//       StringTokenizer st = new StringTokenizer(br.readLine());

       N = Integer.parseInt(br.readLine());
       if (N == 1){
           bw.write(0 + "\n" + 1);
       } else {

           dp = new int[N + 1];
           preDp = new int[N + 1];

           dp[1] = 0;
           dp[2] = 1;
           preDp[2] = 1;

           for (int i = 3; i <= N; i++) {
               dp[i] = dp[i - 1] + 1;
               preDp[i] = i - 1;

               if (i%2 == 0 && dp[i] > dp[i/2] + 1){
                   dp[i] = dp[i/2] + 1;
                   preDp[i] = i/2;
               }

               if (i%3 == 0 && dp[i] > dp[i/3] + 1){
                   dp[i] = dp[i/3] + 1;
                   preDp[i] = i/3;
               }


           }

           bw.write(dp[N] + "\n");

           int idx = N;
           for (int i = 0; i <= dp[N]; i++) {
               bw.write(idx + " ");
               idx = preDp[idx];
           }

       }



       bw.close();
       br.close();

    }









}
















