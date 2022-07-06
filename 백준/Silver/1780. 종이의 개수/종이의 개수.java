import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static int N;
    public static int minusOne = 0;
    public static int zero = 0;
    public static int one = 0;
    public static int[][] paper;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }




        partition(0,0,N);
        bw.write(String.valueOf(minusOne) + "\n");
        bw.write(String.valueOf(zero) + "\n");
        bw.write(String.valueOf(one) + "\n");
        bw.close();
        br.close();


    }

    public static void partition(int row, int col, int size){

        if (isEqual(row, col, size)){
            if (paper[row][col] == -1){
                minusOne++;
            } else if (paper[row][col] == 0){
                zero++;
            } else {
                one++;
            }

        } else {
            int newSize = size/3;

            partition(row, col, newSize);
            partition(row, col + newSize, newSize);
            partition(row, col + 2 * newSize, newSize);
            partition(row + newSize, col, newSize);
            partition(row + newSize, col + newSize, newSize);
            partition(row + newSize, col + 2 * newSize, newSize);
            partition(row + 2 * newSize, col, newSize);
            partition(row + 2 * newSize, col + newSize, newSize);
            partition(row + 2 * newSize, col + 2 * newSize, newSize);
        }

    }

    public static boolean isEqual(int row, int col, int size){

        int start = paper[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (paper[i][j] != start){
                    return false;
                }

            }
        }

        return true;

    }



}








