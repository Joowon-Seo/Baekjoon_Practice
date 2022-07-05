import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static int N;
    public static int[] board;
    public static int cnt;




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());


        // 보드판에 행을 1씩 더해 넣을 것 임으로 행이 같은 경우는 나올 수 없을
        // 따라서 메모리를 줄일 수 있음
        board = new int[N];



        bw.write(Integer.toString(nQueen(0)));
        bw.close();
        br.close();


    }

    public static int nQueen(int row){
        if (row == N){
            cnt++;
            return cnt;
        }

        for (int i = 0; i < N; i++) {
            board[row] = i;

            if (isPromising(row)){
                nQueen(row + 1);
            }


        }
        return cnt;
    }


    // 유망한지 확인 하는 메소드
    public static boolean isPromising(int row){
        // 여기서 열이 같은지, 대각선인지 확인
        for (int i = 0; i < row; i++) {

            if (board[row] == board[i] || row - i == Math.abs(board[row] - board[i])){
                return false;
            }
        }

        return true;
    }




}








