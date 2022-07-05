import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static int N;
    public static boolean[] check1 = new boolean[15]; // 열에 대한 인덱스 최대 14
    public static boolean[] check2 = new boolean[30]; // '/' 대각선에 대한 인덱스 최대 (i,j) i+j 28;
    public static boolean[] check3 = new boolean[30]; // '\' 대각선에 대한 인덱스 최대 (i,j) i-j 음수가 나올 수 있음으로
                                                      // (1,14) i-j + 14 최대 : (14,1) 27;

    public static int cnt;




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());

        nQueen(1);

        bw.write(String.valueOf(cnt));
        bw.close();
        br.close();


    }

    public static void nQueen(int row){
        if (row == N+1){
            cnt++;
            return ;
        }

        for (int i = 1; i <= N; i++) {

            if (!check1[i] && !check2[row + i] && !check3[row-i+14]){

                check1[i] = true;
                check2[row + i] = true;
                check3[row - i + 14] = true;
                nQueen(row + 1);
                check1[i] = false;
                check2[row + i] = false;
                check3[row - i + 14] = false;

            }


        }

    }


}








