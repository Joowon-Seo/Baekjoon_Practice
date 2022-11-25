import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

	public static BufferedReader br = new BufferedReader(
		new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(
		new OutputStreamWriter(System.out));

	public static int N, M;
	public static int[][] map;
	public static boolean[][][] visited;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};

	// 브루트 포스 + bfs
	// 벽의 위치를 배열에 저장해놓고 하나씩 없을 때를 가정하여 최단거리를 계산해봅니다.
	// 시간 초과 : 벽의 개수가 최대 998개 나올 수 있기 때문에
	// 1000*1000*998 = 998,000,000 10초가량 나올 수 있기 때문

	// 3차 배열 + bfs 사용하여 현재 벽을 한번 제거한 상태인이 유지 및 파악

	public static class Node {
		int x;
		int y;
		int cnt;
		boolean breakWall;

		Node (int x, int y, int cnt, boolean breakWall) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.breakWall = breakWall;
		}
	}


	public static void main(String[] args) throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M][2];

		for (int i = 0; i < N; i++) {

			String str = br.readLine();

			for (int j = 0; j < M; j++) {
				map[i][j] = (str.charAt(j) - '0');
			}
		}

		bw.write(bfs(0, 0) + "");


		br.close();
		bw.close();


	}

	public static int bfs(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y, 1, false));

		while (!queue.isEmpty()) {

			Node cur = queue.poll();
			int curX = cur.x;
			int curY = cur.y;

			if (curX == N - 1 && curY == M - 1) {

				return cur.cnt;
			}

			for (int i = 0; i < 4; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
					continue;
				}


				// 벽을 만났을 때 한번도 벽 제거를 안한 것만 제거하고 통과 가능
				if (map[nextX][nextY] == 1) {
					if (!cur.breakWall) {
						visited[nextX][nextY][1] = true;
						queue.add(new Node(nextX, nextY, cur.cnt + 1, true));
					}
				// 벽을 만나지 않았을 때
				} else {

					// 이미 벽을 한번 부셨을 때
					if (cur.breakWall && !visited[nextX][nextY][1]) {

						visited[nextX][nextY][1] = true;
						queue.add(new Node(nextX, nextY, cur.cnt + 1, true));

					} else if (!cur.breakWall && !visited[nextX][nextY][0]) {

						visited[nextX][nextY][0] = true;
						queue.add(new Node(nextX, nextY, cur.cnt + 1, false));
					}

				}


			}

		}

		return -1;

	}


}
















