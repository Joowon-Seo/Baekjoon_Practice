import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	public static BufferedReader br = new BufferedReader(
		new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(
		new OutputStreamWriter(System.out));

	public static int N, S, D;

	public static ArrayList<Node>[] graph;
	public static boolean[] visited;
	public static int[] depths;
	public static int result;

	public static class Node {

		int to;

		public Node(int to) {
			this.to = to;
		}
	}

	// 현재 위치에서 얼마만큼의 depth가 존재하는지 알아야합니다.
	// D만큼 현재 위치에서 이동하지 않고 전단지를 전달할 수 있기 때문입니다.
	// 따라서 각 노드마다 depth를 측정하고, 현재 노드에서 D이상의 깊이를 가진 노드에는
	// 직접 이동하여 전달하여야 하기 때문에 해당 부분만 count 처리 합니다.

	// D가 0일 때 모든 노드에 전단지를 직접 전달해야하기 때문에
	// 모든 간선의 개수인 N - 1 개수만큼을 출력합니다.


	public static void main(String[] args) throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		if (D == 0) {
			bw.write((N - 1) * 2 + "");
		} else {
			graph = new ArrayList[N + 1];

			for (int i = 0; i < N + 1; i++) {
				graph[i] = new ArrayList<>();
			}

			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());

				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				graph[to].add(new Node(from));
				graph[from].add(new Node(to));

			}

			visited = new boolean[N + 1];
			depths = new int[N + 1];

			bfs(S);

			for (int i = 1; i < depths.length; i++) {
				if (depths[i] >= D && i != S) {
					// 현재 노드의 깊이가 2이고, D = 0 이라면
					// 현재 노드까지는 와야지 2개의 깊이에 이동하지 않고 전달 할 수 있다.
					// 케니소프트의 위치에는 시작점이라 이동 없이 전달 할 수 있다..
					result++;
				}
			}

			bw.write(result * 2 + "");
		}


		br.close();
		bw.close();


	}

	public static int bfs(int cur) {
		int depth = 0;
		visited[cur] = true;
		for (int i = 0; i < graph[cur].size(); i++) {

			Node adjNode = graph[cur].get(i);

			if (!visited[adjNode.to]) {
				depth = Math.max(depth, bfs(adjNode.to));
			}
		}

		depths[cur] = depth;
		return depths[cur] + 1;
	}


}
















