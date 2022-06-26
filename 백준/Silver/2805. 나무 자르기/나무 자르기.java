import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long left = 0;
        long right = Arrays.stream(arr).max().getAsInt();
        long best = 0;
        


        while (left <= right){

            long mid = left + (right - left)/2;
            long rest = 0;

            for (int i = N-1; i >= 0; i--) {
                if (rest >= M){
                    break;
                }
                
                if (mid < arr[i]){
                    rest += arr[i] - mid;
                    
                }
            }

            if (rest >= M){
                best = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }


        }


        bw.write(Long.toString(best));



        br.close();
        bw.close();





    }



}







