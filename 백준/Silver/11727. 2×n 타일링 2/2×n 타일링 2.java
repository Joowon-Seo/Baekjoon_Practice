import javax.sound.midi.MidiFileFormat;
import java.io.*;
import java.util.*;


public class Main {

    // n을 입력 받는다
    // 점화식을 생각해 봤을 때
    // dp[n] = dp[n - 1] + 2 * dp[n - 1];
    // 를 유도해 낼 수 있다.


    public static int n;
    public static int[] dp;
    public static int mod = 10007;




   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//       StringTokenizer st = new StringTokenizer(br.readLine());

       n = Integer.parseInt(br.readLine());

       dp = new int[n + 1];

       if (n == 1){
           bw.write(String.valueOf(1));
       } else if (n == 2){
           bw.write(String.valueOf(3));
       } else {

           dp[1] = 1;
           dp[2] = 3;

           for (int i = 3; i <= n; i++) {

               dp[i] = (dp[i - 1] + 2 * dp[i - 2])%mod;

           }

           bw.write(String.valueOf(dp[n]));


       }









       bw.close();
       br.close();

    }









}
















