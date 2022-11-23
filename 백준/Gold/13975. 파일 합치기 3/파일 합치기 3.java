import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

	public static BufferedReader br = new BufferedReader(
		new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(
		new OutputStreamWriter(System.out));

	public static int T, K;
	public static long result;
	public static PriorityQueue<Long> deque;


	public static void main(String[] args) throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());

			deque = new PriorityQueue<>();
			result = 0;

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < K; j++) {
				deque.add(Long.parseLong(st.nextToken()));
			}

			while (deque.size() > 1) {
				long cur1 = deque.poll();
				long cur2 = deque.poll();

				long sum = cur1 + cur2;
				result += sum;

				deque.add(sum);

			}

			bw.write(result + "\n");
		}

		br.close();
		bw.close();


	}


}
















