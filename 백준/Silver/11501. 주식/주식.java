import java.io.*;
import java.util.*;


public class Main {

    public static int T;
    public static int N;
    public static int[] price;
    public static long gain;  // 총 이득
    public static int max; // 현재까지 가장 비싼 가격




   public static void main(String[] args) throws IOException {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//       StringTokenizer st = new StringTokenizer(br.readLine());

       T = Integer.parseInt(br.readLine());

       for (int i = 0; i < T; i++) {

           N = Integer.parseInt(br.readLine());
           price = new int[N];
           gain = 0;
           max = 0;
           StringTokenizer st = new StringTokenizer(br.readLine());
           for (int j = 0; j < N; j++) {
               price[j] = Integer.parseInt(st.nextToken());
           }



           for (int j = N - 1; j >= 0; j--) {
               if (price[j] > max){
                   max = price[j];
               } else {
                   gain += max - price[j];
               }
           }

            bw.write(gain + "\n");

       }

       br.close();
       bw.close();


    }


}
















