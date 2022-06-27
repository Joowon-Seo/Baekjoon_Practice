import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        int[] result = {0,0};
        int min = Integer.MAX_VALUE;
        int N = Integer.parseInt(br.readLine());

        int[] data = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(data);


        int p1 = 0;
        int p2 = N-1;

        while (p1 < p2){
            int sum = data[p1] + data[p2];

            int cur = Math.abs(sum);

            if (cur == 0){
                result[0] = data[p1];
                result[1] = data[p2];
                break;
            }

            if (cur < min){
                min = cur;
                result[0] = data[p1];
                result[1] = data[p2];
            }


            if (sum > 0){
                p2--;
            } else {
                p1 ++;
            }


        }


        bw.write(Integer.toString(result[0]) + " " + Integer.toString(result[1]));

        br.close();
        bw.close();
    }


}







