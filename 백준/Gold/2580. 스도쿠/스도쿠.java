import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    // 데이터를 입력 받는다.
    public static int[][] map = new int[9][9];

    // 칸을 9 칸으로 나누고 만약 빈칸이 하나라면 없는 숫자를 기입한 후 시작한다
    // 각 행을 기준으로 열을 하나씩 증가하면서 빈칸이 있다면 들어갈 수 있는 수를 탐색한다
    // 빈칸이 없다면 그 열에대해 건더 띈다
    // 열이 9까지 갔을 때 다음 행으로 넘어간다.
    // 행이 9까지 갔다면 모두 채워진 상태 이기 때문에 그 즉시 출력하고 시스템을 종료한다.




    public static StringBuilder sb = new StringBuilder();



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }




        sudoku(0,0);

        bw.close();
        br.close();

    }

    public static void sudoku(int row, int col){

        if (col == 9){
            sudoku(row + 1, 0);
            return;
        }

        if (row == 9){
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }

            System.out.println(sb);

            System.exit(0);
        }

        // 빈칸을 만난경우
        if (map[row][col] == 0){
            for (int i = 1; i <= 9 ; i++) {

                // 각 행과 열에 i가 들어 갈 수 있는 숫자인지 확인해주는 메소드
                if (possibility(row, col, i)){
                    map[row][col] = i;
                    sudoku(row, col + 1);
                }


            }
            // 조건문에 들어간 이후 잘못된 경우의 수 였다면 원래 상태토 복귀
            map[row][col] = 0;

            //기존의 숫자가 잘 못 기입 됐기 때문이므로 현재 메소드를 끝내줌
            return;

        }

        // 0이 아닌 경우 다음 열로 넘거가면 됨
        sudoku(row, col + 1);


    }


    public static boolean possibility(int row, int col, int value){

        for (int i = 0; i < 9; i++) {
            if (map[row][i] == value || map[i][col] == value){
                return false;
            }
        }

        int startRow = (row/3)*3;
        int startCol = (col/3)*3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (map[i][j] == value){
                    return false;
                }

            }

        }

        return true;

    }














}
















