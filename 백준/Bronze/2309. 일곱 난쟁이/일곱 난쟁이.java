import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        List<Integer> list = new ArrayList<>();
        int sum = 0;
        int idx_1;
        int idx_2;

        for (int i = 0; i < 9; i++) {
            int num = Integer.parseInt(br.readLine());
            list.add(num);
            sum += num;
        }

        for (int i = 0; i < 8; i++) {
            int num1 = list.get(i);
            if (sum - num1<= 100){
                continue;
            }
            for (int j = i + 1; j < 9; j++) {
                int num2 = list.get(j);
                if (sum - num1 - num2 == 100){
                    idx_1 = i;
                    idx_2 = j-1;
                    list.remove(idx_1);
                    list.remove(idx_2);

                    Collections.sort(list);
                    for (int k: list){
                        System.out.println(k);
                    }

                    return;
                }
            }
        }





    }




}







