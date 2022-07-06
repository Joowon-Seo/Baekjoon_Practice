import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static int N, M, K;
    public static int[][] A, B;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        st.nextToken(); //A의 열과 B의 행은 같음
        K = Integer.parseInt(st.nextToken());

        B = new int[M][K];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // A행의 원소와 B의 열의 원소를 곱해서 나감
        // 따라서 만들어 지는 C 는 [N][K]크기를 가짐

        // 결과 값 저장
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) { //고정된 A의 행
            for (int j = 0; j < K; j++) { // 고정된 B의 열

                int sum = 0;

                for (int k = 0; k < M; k++) {
                    sum += A[i][k] * B[k][j];
                }

                sb.append(sum).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);



//        bw.close();
        br.close();


    }


}








