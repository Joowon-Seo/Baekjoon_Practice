import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static int[][] A;
    public static int N, MOD;
    public static long B;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        MOD = 1000;

        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken())%MOD; // 하지 않으면 원소가 1000이고 지수가 1일 때
                                                            // MOD를 나누지 않고 결과가 출력됨
            }
        }

        // pow
        int[][] result = pow(A,B);


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(result[i][j] + " ");
            }
            bw.write("\n");
        }


        bw.close();
        br.close();


    }

    public static int[][] pow(int[][] a, long exp){
        if (exp == 1){
            return a;
        }

        int[][] res = pow(a, exp/2);

        res = multiply(res, res);

        if (exp % 2 == 1){
            res = multiply(res, A);
        }

        return res;



    }

    public static int[][] multiply(int[][] arr1, int[][] arr2){

        int[][] res = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                int tmp = 0;

                for (int k = 0; k < N; k++) {

                    tmp += (arr1[i][k] * arr2[k][j])%MOD;

                }

                res[i][j] = tmp%MOD;
            }
        }

        return res;

    }



}








