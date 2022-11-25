import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {

	public static BufferedReader br = new BufferedReader(
		new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(
		new OutputStreamWriter(System.out));

	public static int N;
	public static int[][] map;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static Map<Integer, int[]> favorite;
	public static List<Integer> data;

	// 1. 2차배열을 순회하면서 각 칸에 인접하는 자리에서 좋아하는 학생이 몇 명이 있는지 확인
	// (1.에서 여러개가 나올 경우 2로) 
	// 2. 2차배열을 순회하면서 각 칸에 인접하는 빈 칸의 개수를 확인 
	// (2.에서 여러개가 나올 경우 3으로) 
	// 3. 행 번호가 가장 작은 칸
	// 4. 열 번호가 가장 작은 칸

	public static class Node {
		int x;
		int y;
		int emptyCnt;
		
		Node (int x, int y, int emptyCnt) {
			this.x = x;
			this.y = y;
			this.emptyCnt = emptyCnt;
		}
	}

	public static void main(String[] args) throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		data = new ArrayList<>();
		favorite = new HashMap<>();

		for (int i = 0; i < N * N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int student = Integer.parseInt(st.nextToken());

			int[] likeStudents = new int[4];
			likeStudents[0] = Integer.parseInt(st.nextToken());
			likeStudents[1] = Integer.parseInt(st.nextToken());
			likeStudents[2] = Integer.parseInt(st.nextToken());
			likeStudents[3] = Integer.parseInt(st.nextToken());

			favorite.put(student, likeStudents);

			data.add(student);
		}

		for (int cur : data) {

			// 1번 각 칸바다 좋아하는 학생이 몇명이 인접해 있는지 확인
			List<int[]> check_1 = check_1(cur);
			if (check_1.size() == 1) {
				map[check_1.get(0)[0]][check_1.get(0)[1]] = cur;
				continue;
			}

			// 2번 해당 하는 칸에서 빈칸이 가장 많은 부분
			List<Node> check_2 = check_2(check_1);
			if (check_2.size() == 1) {
				Node node = check_2.get(0);
				map[node.x][node.y] = cur;
				continue;
			}

			// 3. 행번호가 가장 작은 것
			List<Node> check_3 = check_3(check_2);
			if (check_3.size() == 1) {
				Node node = check_3.get(0);
				map[node.x][node.y] = cur;
				continue;
			}

			//4. 열번호가 가장 작은 것
			List<Node> check_4 = check_4(check_3);
			Node node = check_4.get(0);
			map[node.x][node.y] = cur;


		}

//		System.out.println(data);
//		System.out.println(Arrays.deepToString(map));

		bw.write(satisfaction() + "");



		br.close();
		bw.close();


	}

	public static List<int[]> check_1(int student) {

		int[] like = favorite.get(student);
		int max_adjLike = 0;

		int[][] likeMap = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				int cnt = 0;

				if (map[i][j] != 0) {
					continue;
				}

				for (int k = 0; k < 4; k++) {

					int adjX = i + dx[k];
					int adjY = j + dy[k];

					if (adjX >= 0 && adjY >= 0 && adjX < N && adjY < N) {
						if (like[0] == map[adjX][adjY]
							|| like[1] == map[adjX][adjY]
							|| like[2] == map[adjX][adjY]
							|| like[3] == map[adjX][adjY]) {
							cnt++;
						}
					}
				}

				likeMap[i][j] = cnt;
				max_adjLike = Math.max(cnt, max_adjLike);

			}
		}

		List<int[]> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (likeMap[i][j] == max_adjLike && map[i][j] == 0) {
					list.add(new int[]{i, j});
				}
			}
		}

		return list;

	}

	public static List<Node> check_2(List<int[]> list) {
		
		List<Node> list2 = new ArrayList<>();
		
		int max_cnt = 0;

		for (int i = 0; i < list.size(); i++) {

			int cnt = 0; // 인근 반칸 개수

			int[] cur = list.get(i);

			for (int j = 0; j < 4; j++) {
				int adjX = cur[0] + dx[j];
				int adjY = cur[1] + dy[j];

				if (adjX >= 0 && adjY >= 0 && adjX < N && adjY < N) {
					if (map[adjX][adjY] == 0) {
						cnt++;
					}
				}
			}
			
			max_cnt = Math.max(max_cnt, cnt);
			
			list2.add(new Node(cur[0], cur[1], cnt));
		}

		List<Node> resultList = new ArrayList<>();

		for (int i = 0; i < list2.size(); i++) {
			if (list2.get(i).emptyCnt == max_cnt) {
				resultList.add(list2.get(i));
			}
		}

		return resultList;
	}

	public static List<Node> check_3(List<Node> list) {

		int minRow = Integer.MAX_VALUE;

		for (int i = 0; i < list.size(); i++) {
			Node node = list.get(i);
			minRow = Math.min(node.x, minRow);
		}

		List<Node> resultList = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).x == minRow) {
				resultList.add(list.get(i));
			}
		}

		return resultList;

	}

	public static List<Node> check_4(List<Node> list) {

		int minCol = Integer.MAX_VALUE;

		for (int i = 0; i < list.size(); i++) {
			Node node = list.get(i);
			minCol = Math.min(node.y, minCol);
		}

		List<Node> resultList = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).y == minCol) {
				resultList.add(list.get(i));
			}
		}

		return resultList;

	}

	public static int satisfaction() {

		int sum = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				int student = map[i][j];
				int[] like = favorite.get(student);

				int cnt = 0;

				for (int k = 0; k < 4; k++) {

					int adjX = i + dx[k];
					int adjY = j + dy[k];

					if (adjX >= 0 && adjY >= 0 && adjX < N && adjY < N) {
						if (like[0] == map[adjX][adjY]
							|| like[1] == map[adjX][adjY]
							|| like[2] == map[adjX][adjY]
							|| like[3] == map[adjX][adjY]) {
							cnt++;
						}
					}
				}

				if (cnt == 1) {
					sum += 1;
				} else if (cnt == 2) {
					sum += 10;
				} else if (cnt == 3) {
					sum += 100;
				} else if (cnt == 4) {
					sum += 1000;
				}


			}
		}

		return sum;


	}


}
















