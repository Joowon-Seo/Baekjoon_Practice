import java.io.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;


public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // C개의 문자중 L개를 뽑습니다. 근데 여기서 암호의 순서는 이미 정해져 있음으로
    // 문자 정보를 받고 정렬을 한 후
    // Combination 을 사용하면 됩니다.
    // 출력하기전 자음 모음의 최소 개수를 충족하는지 확인합니다.

    public static int L, C;
    public static String[] alphabet;


    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphabet = br.readLine().split(" ");

        Arrays.sort(alphabet);

        boolean[] visited = new boolean[C];
        combination(alphabet, visited, C, L, 0);


        br.close();
        bw.close();


    }

    public static void combination(String[] arr, boolean[] visited, int n, int r, int depth) throws IOException {

        if (r == 0) {

            String result = "";
            int c = 0; //자음
            int v = 0; //모음
            for (int i = 0; i < n; i++) {
                if (visited[i]){
                    if (Objects.equals(arr[i], "a") || Objects.equals(arr[i], "e") || Objects.equals(arr[i], "i")
                            || Objects.equals(arr[i], "o") || Objects.equals(arr[i], "u")){
                        v++;
                    } else {
                        c++;
                    }
                }
            }

            if (v >= 1 && c >= 2){
                for (int i = 0; i < n; i++) {
                    if (visited[i]) {
                        bw.write(arr[i] + "");
                    }
                }
                bw.write("\n");
            }

            return;
        }

        for (int i = depth; i < n; i++) {

            visited[i] = true;
            combination(arr, visited, n, r - 1, i + 1);
            visited[i] = false;
        }


    }

}
















