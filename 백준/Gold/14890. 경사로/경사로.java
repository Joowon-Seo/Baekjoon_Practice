import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// N을 입력받습니다.
	// 총 2N개의 경로를 확인합니다.
	// 다음 값이 현재 값과 같다면 pass
	// 값이 다르다면 : 증가 / 감소를 확인합니다.

	// 증가
	// 차이가 2이상 이라면 stop
	// 차이가 1이라면 현재값 이전의 L개의 값이 존재하고 같아하고, 해당 길에 경사로가 없어야 합니다.

	// 감소
	// 차이가 2이상 이아면 stop
	// 1이라면 현재 값을 포함하여 L개의 값이 존재하고, 값이 같아야합니다.

	// 경사로 부분은 일차배열에 true로 표시

	public static int N, L;
	public static int[][] map;
	public static boolean[] check;
	public static int cnt;


	public static void main(String[] args) throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		cnt = 0;

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			findWayRow(i);
			findWayCol(i);
		}

		bw.write(cnt + "");

		br.close();
		bw.close();


	}

	public static void findWayRow(int i) {

		check = new boolean[N];

		for (int j = 1; j < N; j++) {
			if (map[i][j] != map[i][j - 1]) {
				// 경사로를 놓을 수 있는지 확인
				if (!checkSlopeRow(i, j)) {
					return;
				}

				if (!checkIncreaseRow(i, j)){
					j += L - 1;
				}
			}
		}

		cnt++;
//		System.out.print("row" + i + " : ");
//		for (int j = 0; j < N; j++) {
//			System.out.print(map[i][j] + " ");
//		}
//		System.out.println();

	}

	public static boolean checkSlopeRow(int i, int j) {

		int cur = map[i][j];
		int pre = map[i][j - 1];

		if (Math.abs(cur - pre) >= 2) {
			return false;
		}

		//증가
		if (pre < cur) {
			if (j <= L - 1) {
				return false;
			}

			// L 크기만큼 같은지 확인
			for (int k = 1; k <= L; k++) {
				if (pre != map[i][j - k]) {
					return false;
				}
			}

			for (int k = 1; k <= L; k++) {
				if (check[j - k]) {
					return false;
				}
			}

			for (int k = 1; k <= L; k++) {
				check[j - k] = true;
			}

		} else {

			if (j >= N - L + 1) {
				return false;
			}

			for (int k = 1; k < L; k++) {
				if (cur != map[i][j + k]) {
					return false;
				}
			}

			for (int k = 0; k < L; k++) {
				check[j + k] = true;
			}
		}
		return true;
	}

	public static void findWayCol(int j) {

		check = new boolean[N];

		for (int i = 1; i < N; i++) {
			if (map[i][j] != map[i - 1][j]) {
				// 경사로 놓을 수 있는지 확인
				if (!checkSlopeCol(i, j)) {
					return;
				}

				if (!checkIncreaseCol(i, j)){
					i += L - 1;
				}
			}
		}

		cnt++;
//		System.out.print("col" + j + " : ");
//		for (int i = 0; i < N; i++) {
//			System.out.print(map[i][j] + " ");
//		}
//		System.out.println();

	}

	public static boolean checkSlopeCol(int i, int j) {

		int cur = map[i][j];
		int pre = map[i - 1][j];

		if (Math.abs(cur - pre) >= 2) {
			return false;
		}

		//증가
		if (pre < cur) {
			if (i <= L - 1) {
				return false;
			}

			// L 크기만큼 같은지 확인
			for (int k = 1; k <= L; k++) {
				if (pre != map[i - k][j]) {
					return false;
				}
			}

			for (int k = 1; k <= L; k++) {
				if (check[i - k]) {
					return false;
				}
			}

			for (int k = 1; k <= L; k++) {
				check[i - k] = true;
			}

		} else {

			if (i >= N - L + 1) {
				return false;
			}

			for (int k = 1; k < L; k++) {
				if (cur != map[i + k][j]) {
					return false;
				}
			}

			for (int k = 0; k < L; k++) {
				check[i + k] = true;
			}
		}
		return true;
	}

	public static boolean checkIncreaseRow(int i, int j){
		int cur = map[i][j];
		int pre = map[i][j - 1];

		return cur > pre;
	}

	public static boolean checkIncreaseCol(int i, int j){
		int cur = map[i][j];
		int pre = map[i - 1][j];

		return cur > pre;
	}




}
















