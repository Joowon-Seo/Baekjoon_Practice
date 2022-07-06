import java.io.*;
import java.util.StringTokenizer;


public class Main {

    public static int N, M;
    public static int[] out;
    public static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        out = new int[M];
        solution(0, 0);

        bw.write(String.valueOf(sb));
        bw.close();
        br.close();

    }

    public static void solution(int start, int depth){
        if (depth == M){
            for (int i : out){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
                out[depth] = i + 1;
                solution(i + 1, depth + 1);
        }

    }






}










