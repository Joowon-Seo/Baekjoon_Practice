import java.io.*;
import java.util.*;


public class Main {
    // 수열의 크기를 입력받고, 수열의 크기만큼 데이터를 받는다
    // 이 때 데이터를 양수부분과, 0이하의 숫자로 나눈다.
    // 양수는 내림차순으로 , 0이하는 오름차순으로 정렬한다.
    // 데이터의 길이가 짝수라면, 짝수/2 만큼 반복문을 설정하고
    // 홀수라면 홀수 /2 만큼 반복문을 시행한다.
    // 출력값은 항상 2의 31승 보다 작기 때문에 int로 출력한다.

    public static int N;
    public static int S;
    public static ArrayList<Integer> positiveNum = new ArrayList<>();
    public static ArrayList<Integer> negativeNum = new ArrayList<>();


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) {
                positiveNum.add(num);
            } else {
                negativeNum.add(num);
            }
        }


        Collections.sort(positiveNum, Collections.reverseOrder());
        Collections.sort(negativeNum);

        S = 0;

        if (positiveNum.size() % 2 == 0) {
            for (int i = 0; i < positiveNum.size() / 2; i++) {
                if (positiveNum.get(2 * i) == 1 || positiveNum.get(2 * i + 1) == 1){
                    S+= positiveNum.get(2 * i) + positiveNum.get(2 * i + 1);
                } else{
                    S += positiveNum.get(2 * i) * positiveNum.get(2 * i + 1);
                }
            }
        } else {
            for (int i = 0; i < positiveNum.size() / 2; i++) {
                if (positiveNum.get(2 * i) == 1 || positiveNum.get(2 * i + 1) == 1){
                    S+= positiveNum.get(2 * i) + positiveNum.get(2 * i + 1);
                } else{
                    S += positiveNum.get(2 * i) * positiveNum.get(2 * i + 1);
                }
            }

            S += positiveNum.get(positiveNum.size() - 1);
        }

        if (negativeNum.size() % 2 == 0) {
            for (int i = 0; i < negativeNum.size() / 2; i++) {
                S += negativeNum.get(2 * i) * negativeNum.get(2 * i + 1);
            }
        } else {
            for (int i = 0; i < negativeNum.size() / 2; i++) {
                S += negativeNum.get(2 * i) * negativeNum.get(2 * i + 1);
            }

            S += negativeNum.get(negativeNum.size() - 1);
        }

        bw.write(String.valueOf(S));


        br.close();
        bw.close();


    }


}
















