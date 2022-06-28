import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        int sum = 0;
        boolean flag = false;


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            sum+=nums[i];
            if (nums[i] >= S){
                flag = true;
            }
        }
        // 테스트 케이스가 불가능한 경우
        if (sum < S){
            bw.write("0");
            bw.close();
            br.close();

        } else if (sum == S){
            bw.write(Integer.toString(N));
            bw.close();
            br.close();
        } else if (flag){
            bw.write("1");
            bw.close();
            br.close();
        }

        else {

            // 투포인터 이용
            // 앞에 나가는 인덱스는 p1
            // 뒤에 따라가는 인덱스가 p2

            //p1 부터 p2 까지의 합이 s보다 작다면 p1++ 하면서 앞의 인덱스의 값을 더해줌
            //p1 부터 p2 까지의 합이 s보다 크다면 p2-- 하면서 기존의 인덱스의 값을 뺴줌

            int p1 = 0;
            int p2 = 0;
            sum = 0;

            // 최소 길이 찾기
            int result = N;


            while (p1 < N){
                
                if (sum<S){
                    sum+=nums[p1++];
                }

                while (sum >= S){
                    //길이
                    int len = p1 - p2;
                    result = Math.min(result, len);
                    sum-=nums[p2++];

                }


            }

            bw.write(Integer.toString(result));
            bw.close();
            br.close();

        }




    }
}








