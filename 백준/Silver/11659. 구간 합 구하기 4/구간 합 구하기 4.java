import javax.sound.midi.MidiFileFormat;
import java.io.*;
import java.util.*;


public class Main {

    // 자연수 N, M을 받는다
    // N개의 수를 받는다
    // 주어진 구간부터 시작해 인덱스를 찾아서 더한다

    public static int N, M;
    public static int[] num;

    public static StringBuilder sb = new StringBuilder();




   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N + 1];

        st = new StringTokenizer(br.readLine());
       for (int i = 1; i <= N; i++) {
           num[i] = num[i-1] + Integer.parseInt(st.nextToken());
       }

       for (int i = 0; i < M; i++) {
           st = new StringTokenizer(br.readLine());
           int start = Integer.parseInt(st.nextToken());
           int end = Integer.parseInt(st.nextToken());

           int result = num[end] - num[start - 1];
           bw.write(String.valueOf(result));
           bw.write("\n");

       }

       








        bw.close();
        br.close();

    }

    






}
















