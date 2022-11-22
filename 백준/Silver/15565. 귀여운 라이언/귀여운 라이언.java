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
	public static int[] dolls;
	public static int cnt;
	public static int result = Integer.MAX_VALUE;



	public static void main(String[] args) throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		dolls = new int[N];
		st = new StringTokenizer(br.readLine());

		int rightIdx = 0;
		int leftIdx = 0;



		for (int i = 0; i < N; i++) {
			dolls[i] = Integer.parseInt(st.nextToken());
		}

		if (dolls[0] == 1) {
			cnt = 1;
		}

		while (leftIdx <= rightIdx && rightIdx <= N - 1) {

			if (cnt < K) {
				if (rightIdx == N - 1) {
					break;
				}
				rightIdx++;
				if (dolls[rightIdx] == 1) {
					cnt++;
				}
			} else {
				result = Math.min(result, rightIdx - leftIdx + 1);
				if (dolls[leftIdx] == 1) {
					cnt--;
				}
				leftIdx++;
			}


		}

		if (result == Integer.MAX_VALUE) {
			bw.write(-1+"");
		} else {
			bw.write(result+"");
		}


		br.close();
		bw.close();


	}


}
















