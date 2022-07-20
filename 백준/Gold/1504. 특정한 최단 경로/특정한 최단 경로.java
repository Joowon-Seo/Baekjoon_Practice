import java.io.*;
import java.util.*;


public class Main {

    // 1번 부터 N번 정점으로 최단 거리를 이동하려고 하니 데이크스트라 알고리즘을 사용한다.
    // 특정 정점 두개를 지나야 함으로 그리고 주어진 데이터는 무방향임으로 양방향으로 간선에 대한
    // 정보를 양방향으로 저장한다
    // 1 -> v1 -> v2 -> N
    // 1 -> v2 -> v1 -> N
    // 두 방법중 작은 값이 정답이 된다.
    // 그리고 INF 는 최대 간선의 개수 * 최대의 거리 = 200000000이 된다.

    public static int N, E;
    public static int v1, v2;
    public static int INF = 200000000;
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

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();


        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }


        //간선에 대한 정보 초기화
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to, weight));
            graph.get(to).add(new Node(from, weight));
        }

        st = new StringTokenizer(br.readLine());

        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int result1 = dijkstra(1,v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        int result2 = dijkstra(1,v2) + dijkstra(v2, v1) + dijkstra(v1, N);

        if (result1 >= INF && result2 >= INF){
            bw.write(String.valueOf(-1));
        } else {
            bw.write(String.valueOf(Math.min(result1, result2)));
        }



        br.close();
        bw.close();


    }

    public static int dijkstra(int start, int end){
        dist = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            dist[i] = INF;
        }

        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((x,y) -> x.weight - y.weight);
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()){

            Node cur = pq.poll();

            if (dist[cur.to] < cur.weight){
                continue;
            }

            for (int i = 0; i < graph.get(cur.to).size(); i++) {
                Node adjNode = graph.get(cur.to).get(i);

                if (dist[adjNode.to] > cur.weight + adjNode.weight){
                    dist[adjNode.to] = cur.weight + adjNode.weight;
                    pq.offer(new Node(adjNode.to, dist[adjNode.to]));
                }
            }

        }

        return dist[end];
    }


}
















