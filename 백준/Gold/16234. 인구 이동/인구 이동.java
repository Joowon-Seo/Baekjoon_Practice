import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;


public class Main {

	public static BufferedReader br = new BufferedReader(
		new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(
		new OutputStreamWriter(System.out));

	public static int N, L, R;
	public static int[][] map;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static boolean[][] visited;
	public static int result = 0;


	public static void main(String[] args) throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 인구 이동이 가능하려면 국경선을 공유하는 두 나라의 인구차이가 L이상, R명 이하 여야함

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {

				map[i][j] = Integer.parseInt(st.nextToken());

			}
		}


		while (true) {

			boolean flag = false;

			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						if (bfs(i, j)) {
							flag = true;
						}
					}
				}
			}

			if (!flag) {
				break;
			} else {
				result++;
			}
		}

		bw.write(result + "");

		br.close();
		bw.close();


	}

	public static boolean bfs(int x, int y) {

		int cnt = 1;
		int total = map[x][y];

		Deque<int[]> deque = new ArrayDeque<>();
		Deque<int[]> deque2 = new ArrayDeque<>();

		visited[x][y] = true;

		deque.add(new int[]{x, y});
		deque2.add(new int[]{x, y});

		while (!deque.isEmpty()) {

			int[] cur = deque.poll();

			int curX = cur[0];
			int curY = cur[1];

			for (int i = 0; i < 4; i++) {

				int nextX = curX + dx[i];
				int nextY = curY + dy[i];

				if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N
					&& !visited[nextX][nextY]) {

					if (Math.abs(map[curX][curY] - map[nextX][nextY]) >= L && Math.abs(map[curX][curY] - map[nextX][nextY]) <= R) {
						cnt++;
						total += map[nextX][nextY];
						deque.add(new int[]{nextX, nextY});
						deque2.add(new int[]{nextX, nextY});
						visited[nextX][nextY] = true;
					}
				}
			}

		}

		int nextPeople = (int) Math.floor(total / cnt);

		boolean same = true;

		while (!deque2.isEmpty()) {

			int[] cur = deque2.poll();

			if (map[cur[0]][cur[1]] != nextPeople) {
				same = false;
			}
			map[cur[0]][cur[1]] = nextPeople;

		}

		return cnt>=2 && !same;


	}


}
















