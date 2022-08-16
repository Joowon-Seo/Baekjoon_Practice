import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 특정노드에서 시작하여 목표점까지의 거리(최소)를 구하고, 모든 노드를 거치지 않아도 되기 때문에
    // 다익스트라 알고리즘을 사용합니다.

    // 주어진 데이터를 입력받고 목표점에대해 모든 시작점을 비교합니다.
    // 그중 최대값을 가지는 것을 출력하고, 값이 같다면 갱신을 하지 않는 것으로
    // 인덱스 값중 최소 값이 출력되게 만듭니다.

    // 주어진 문제대로 풀이를 한다면 N 의 도시에서 면접장 K 개 만큼 N * K 번의  dijkstra 알고리즘을 해야하지만
    // 면접장에서 각 도시로 간선정보를 받아주고, 시작점을 면접장에서 각 도시로 수행한다면, 위의 반복보다 빠르게 정답을 구할 수 있습니다.

    public static long[] dist;
    public static int N, M, K;
    public static int[] interviewRooms;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static class Node implements Comparable<Node> {

        int to;
        long weight;

        public Node(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return (int)(this.weight - o.weight);
        }
    }

    public static long max = -1;
    public static int idx = -1;


    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        interviewRooms = new int[K];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(to).add(new Node(from, weight));

        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) {
            interviewRooms[i] = Integer.parseInt(st.nextToken());
        }

        dijkstra();

        for (int i = 1; i <= N; i++) {

            if (dist[i] > max){
                idx = i;
                max = dist[i];
            }
        }





        bw.write(idx + "\n" + max);


        br.close();
        bw.close();


    }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist = new long[N + 1];

        for (int i = 1; i < N + 1; i++) {
            dist[i] = Long.MAX_VALUE;
        }

        for (int i = 0; i < K; i++) {
            dist[interviewRooms[i]] = 0;
            pq.add(new Node(interviewRooms[i], 0));
        }

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

    }


}
















