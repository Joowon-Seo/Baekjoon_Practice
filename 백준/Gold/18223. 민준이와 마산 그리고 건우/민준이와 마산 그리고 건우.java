import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

	public static BufferedReader br = new BufferedReader(
		new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(
		new OutputStreamWriter(System.out));

	public static int V, E, P;
	public static int[] dist;
	public static ArrayList<ArrayList<Node>> graph;

	public static class Node {

		int to;
		int weight;

		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}


	public static void main(String[] args) throws IOException {
		
		// 정점과 간선의 정보가 주어졌고, 모든 정점을 지나갈 필요가 없으며,
		// 시작점과, 끝점을 정할 수 있고, 최간경로를 물어봤기 때문에 다익스트라 알고리즘을 사용합니다.
		// 민준이가 목표지점까지 갈 때 지나간 경로에 건우가 있는지를 파악하는 문제
		// 시작점부터 도착점까지의 최단경로와
		// 시작점 -> 건우 -> 도착점까지의 최단경로가 같다면 해당 조건을 만족합니다.

		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();

		for (int i = 0; i < V + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			graph.get(from).add(new Node(to, weight));
			graph.get(to).add(new Node(from, weight));

		}

		int result = dijkstra(1, V);
		int result2 = dijkstra(1, P) + dijkstra(P, V);

		if (result == result2) {
			bw.write("SAVE HIM");
		} else {
			bw.write("GOOD BYE");
		}

		br.close();
		bw.close();


	}

	public static int dijkstra(int start, int end) {

		dist = new int[V + 1];

		for (int i = 1; i < V + 1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		dist[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>(
			(x, y) -> x.weight - y.weight);
		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {

			Node cur = pq.poll();

			if (dist[cur.to] < cur.weight) {
				continue;
			}

			for (int i = 0; i < graph.get(cur.to).size(); i++) {

				Node adjNode = graph.get(cur.to).get(i);

				if (dist[adjNode.to] > cur.weight + adjNode.weight) {
					dist[adjNode.to] = cur.weight + adjNode.weight;
					pq.offer(new Node(adjNode.to, dist[adjNode.to]));
				}

			}
		}

		return dist[end];

	}

}
















