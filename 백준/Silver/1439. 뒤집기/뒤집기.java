import java.io.*;


public class Main {


    // 0과 1로 이루어진 데이터를 입력 받습니다.
    // str의 0번째 인덱스를 확인하고 zero 또는 one 의 count ++ 합니다.
    // 주어진 문자열을 한번 스캔하면서. 이전과 같으면 그냥 지나가고,
    // 다르다면 현재 인덱스의 값에 +1을 합니다.
    // zero 와 one 중 최소값을 출력합니다.

    public static int zero, one;


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = br.readLine();

        zero = 0;
        one = 0;

        if (str.charAt(0) == '0'){
            zero++;
        } else {
            one++;
        }

        for (int i = 1; i < str.length(); i++) {
            char cur = str.charAt(i);

            if (cur != str.charAt(i - 1)){
                if (cur == '0'){
                    zero++;
                } else {
                    one++;
                }
            }
        }

        int min = Math.min(zero, one);

        bw.write(String.valueOf(min));


        br.close();
        bw.close();


    }


}
















