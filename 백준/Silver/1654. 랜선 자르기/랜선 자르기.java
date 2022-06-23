import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int max = 0;
        int[] arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(arr[i], max);
        }

        long left = 1;
        long right = max;


        while (left <= right){
            long mid = (left + right)/2;
            int cnt = 0;

            for (int i = 0; i < K; i++) {
                cnt += arr[i]/mid;
            }



            if (cnt < N){
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        bw.write(Long.toString(right));










        br.close();
        bw.close();



    }
}





