import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int result = 0;

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(nums);



        for (int i = 0; i < n; i++) {
            int p1 = i;
            int p2 = i+1;

            while (p2 < n){
                int sum = nums[p1] + nums[p2];

                if (sum == x){
                    result++;
                    break;
                } else if (sum < x){
                    p2++;
                } else {
                    break;
                }
            }

        }









        bw.write(Integer.toString(result));

        br.close();
        bw.close();

    }




}







