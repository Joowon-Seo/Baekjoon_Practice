import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {

	public static BufferedReader br = new BufferedReader(
		new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(
		new OutputStreamWriter(System.out));

	public static int N;
	public static int[] T;
	public static int[] P;

	public static int[] dp;
	public static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine());

		// N의 범위 괎이 1,500,000 임으로 2중 반복 x
		// 따라서 한번 순회를 하면서 문제를 해결해야함 -> 데이터를 보관(dp)활용

		N = Integer.parseInt(st.nextToken());

		T = new int[N + 2];
		P = new int[N + 2];
		dp = new int[N + 2];

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());

			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < N + 2; i++) {

			// 현재 최고 값 찾기
			// i를 날짜로 활용
			max = Math.max(max, dp[i]);

			// 일정이 N + 2를 넘어갈 수 있음(에러방지)
			if (i + T[i] < N + 2) {

				//현재 일정을 소화할지말지에 대한 판단
				dp[i + T[i]] = Math.max(dp[i + T[i]], max + P[i]);

			}

		}

		bw.write(max + "");

		br.close();
		bw.close();


	}


}
















