import java.io.*;
import java.util.*;


public class Main {

    // 수열을 입력 받는다
    // 연산자 데이터를 입력 받는다
    // 숫자 + 연산자
    // 연산자 부분은 반복문을 돌리면서 해당 인덱스의 남은 연산자의 개수가 0이 아니라면
    // 남은 연산자에서 -1을 하고, 그 연산자로 dfs 한다.
    // 끝까지 간 후 사용했던 연산자를 다시 ++ 하며 다른 연산자가 먼저 사용 됐을 때
    // 사용 될 수 있게 구현한다.

    public static int N;
    public static int[] nums;
    public static int[] operator = new int[4]; // 인덱스 순서대로  +, -, *, /
    public static int min = Integer.MAX_VALUE;
    public static int max = Integer.MIN_VALUE;





    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
       N = Integer.parseInt(br.readLine());
       nums = new int[N];

       StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());



        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }


        dfs(nums[0], 0);




        bw.write(max + "\n" + min);




        bw.close();
        br.close();

    }

    public static void dfs(int cur, int depth){

        if (depth == N-1){
            max = Math.max(cur, max);
            min = Math.min(cur, min);

            return;
        }

        for (int i = 0; i < 4; i++) {

            if (operator[i] >= 1){

                operator[i]--;

                if (i == 0){
                    dfs(cur + nums[depth + 1], depth + 1);
                } else if (i == 1){
                    dfs(cur - nums[depth + 1], depth + 1);
                } else if (i == 2){
                    dfs(cur * nums[depth + 1], depth + 1);
                } else {
                    dfs(cur / nums[depth + 1], depth + 1);
                }

                operator[i]++;

            }

        }


    }





}
















