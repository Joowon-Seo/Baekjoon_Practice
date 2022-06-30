import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 각 도시에 도착했을 때 기름 값이 더 낮다면 그 기름 값으로 갱신한다
        // 각 기름으로 간 거리 만큼 total 값에 더해준다.

        int N = Integer.parseInt(br.readLine());

        long[] distance = new long[N-1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        int[] gas = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            gas[i] = Integer.parseInt(st.nextToken());
        }


        //현재 이용하는 가스의 비용
        //처음에는 비싸도 선택권이 없기 때문에 써야함
        int curGas = gas[0];

        // 각 가스의 비용 * 가스로 간 거리의 총합
        long totalCost = 0;

        for (int i = 0; i < N-1; i++) {
            if (curGas > gas[i]){
                curGas = gas[i];
            }

            totalCost += curGas * distance[i];

        }

        bw.write(Long.toString(totalCost));
        bw.close();
        br.close();

    }



}








