import javax.sound.midi.MidiFileFormat;
import java.io.*;
import java.util.*;


public class Main {

    // 테스트 케이스 T를 입력 받는다.
    // dp[10] 까지의 값을 구해 놓는다
    // 주어진 값에 맞게 결과를 출력한다.


    public static int T;
    public static int[] dp;


   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
       T = Integer.parseInt(br.readLine());

       dp = new int[11];

       dp[1] = 1;
       dp[2] = 2;
       dp[3] = 4;

       for (int i = 4; i <= 10; i++) {

           dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
       }

       for (int i = 0; i < T; i++) {
           int n = Integer.parseInt(br.readLine());
           bw.write(dp[n]+"\n");
       }







       bw.close();
       br.close();

    }









}
















