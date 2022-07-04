import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static int[][] map;
    public static int num = 0;
    public static int r,c;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int n = 2;

        for (int i = 0; i < N; i++) {
            n *= 2;
        }

//        for (int i = 0; i < n; i++) {
//            Arrays.fill(map[i], 1);
//        }
//        partition(0,0,n);
        find(r,c,n);
        bw.write(Integer.toString(num));
        bw.close();
        br.close();

    }

    // 시간 초과
//    public static void partition(int row, int col , int size){
//        if (size > 2){
//            int newSize = size/2;
//            partition(row, col, newSize);
//            partition(row, col  + newSize, newSize);
//            partition(row  + newSize, col, newSize);
//            partition(row + newSize, col + newSize, newSize);
//        } else if (size == 2){
//            for (int i = row; i < row + size; i++) {
//                for (int j = col; j < col + size; j++) {
//                    num++;
//                    if (i == r && j == c){
//                        System.out.println(num);
//                        return;
//                    }
//                }
//            }
//        }
//
//
//    }

    public static void find(int row, int col, int size){
        if (size == 1){
            return;
        } else if (row < size/2 && col < size/2){
            find(row, col, size/2);
        } else if (row < size/2 && col >= size/2){
            num += size/2 * size/2;
            find(row, col - size/2, size/2);
        } else if (row >= size/2 && col < size/2){
            num += 2 * size/2 * size/2;
            find(row - size/2, col, size/2);
        } else {
            num += 3 * size/2 * size/2;
            find(row - size/2, col - size/2, size/2);
        }
    }



}








