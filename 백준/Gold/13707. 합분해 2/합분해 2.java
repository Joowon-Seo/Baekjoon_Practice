import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	public static BufferedReader br = new BufferedReader(
		new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(
		new OutputStreamWriter(System.out));

	public static int N, K;
	public static long[][] dp;


	public static void main(String[] args) throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new long[K + 1][N + 1];

		for (int i = 0; i <= N; i++) {
			dp[1][i] = 1;
		}

		for (int i = 2; i <= K; i++) {
			for (int j = 0; j <= N; j++) {

				if (j == 0){
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i - 1][j];
					dp[i][j] = (dp[i][j] + dp[i][j - 1]) % 1000000000;
				}

			}
		}

//		System.out.println(dp[K][N]);
//		System.out.println(Arrays.deepToString(dp));
		bw.write(String.valueOf(dp[K][N]));
		br.close();
		bw.close();


	}


}
















