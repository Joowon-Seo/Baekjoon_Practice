import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

	public static BufferedReader br = new BufferedReader(
		new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(
		new OutputStreamWriter(System.out));

	public static int N;
	public static ArrayList<Integer> cards;
	public static ArrayList<Integer> candidate;
	public static int[] result = new int[2];
	public static int[] resultCard;
	public static int result1;
	public static int result2;
	public static int L;

	public static void main(String[] args) throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine());

//		k의 범위 : 1≤ K, 2K < N

		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");

		resultCard = new int[N];
		for (int i = 0; i < N; i++) {
			resultCard[i] = Integer.parseInt(st.nextToken());
		}

		candidate = new ArrayList<>();
		int k = 1;

		for (int i = 1; i <= N; i++) {
			k *= 2;
			if (k < N) {
				candidate.add(i);
			} else {
				break;
			}
		}

		permutation(0);
//		bw.write("candidate" + candidate);
		bw.write(result1 + " " + result2);

		br.close();
		bw.close();


	}

	private static void permutation(int cnt) {
		if (cnt == 2) {

//			System.out.println("result" + Arrays.toString(result));

			cards = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				cards.add(i + 1);
			}

			shuffle_1(result[0]);
			while (L >= 1) {
				shuffle_2();
			}

			shuffle_1(result[1]);
			while (L >= 1) {
				shuffle_2();
			}

			boolean same = true;
			for (int i = 0; i < N; i++) {
				if (cards.get(i) != resultCard[i]) {
					same = false;
					break;
				}
			}
			if (same) {
				result1 = result[0];
				result2 = result[1];
			}

//			System.out.println("결과" + cards);

			return;
		}
		for (Integer integer : candidate) {
			// 숫자를 담는다.
			result[cnt] = integer;
			permutation(cnt + 1);
		}
	}

	public static void shuffle_1(int k) {
		int idx = 1;
		for (int i = 0; i < k; i++) {
			idx *= 2;
		}

		for (int i = 0; i < idx; i++) {
			int num = cards.get(cards.size() - 1);
			cards.add(0, num);
			cards.remove(cards.size() - 1);
		}

		L = idx;

	}

	public static void shuffle_2() {
		int idx = L - 1;
		for (int i = 0; i < L / 2; i++) {
			int num = cards.get(idx);
			cards.remove(idx);
			cards.add(0, num);
		}

		L /= 2;
	}


}
















