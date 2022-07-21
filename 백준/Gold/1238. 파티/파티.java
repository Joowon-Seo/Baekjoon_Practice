import java.io.*;
import java.util.*;


public class Main {
    
    // 정점의 개수 인 N, 간선의 개수인 M의 데이터를 입력 받는다
    // 단 그래프의 방향성은 단방향 그래프이다.
    // 그리고 시작점은 주어진 모든 정점이 되고,
    // 도착점은 주어진 x가 된다.
    // 주어진 조건에 맞게 해결하려면
    // 각 정점에서 출발해서, x로, x에서 시작한 정점까지의 최소비용을 모두 구해서
    // 최소비용중 가장 큰 값을 출력한다
    // 따라서 데이크스트라 알고리즘을 이용한다.
    
    public static int N, M, X;
    public static int[] dist;
    public static ArrayList<ArrayList<Node>> graph;
    public static int result;
    public static boolean[] visited;
    
    public static class Node implements Comparable<Node>{
        
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            
            graph.add(new ArrayList<>());
            
        }
        
        
        // 단방향 그래프에 대한 간선정보 초기화
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            graph.get(from).add(new Node(to, weight));
        }

        result = 0;

        for (int i = 1; i <= N; i++) {

            int cur = dijkstra(i,X) + dijkstra(X, i);

            result = Math.max(cur, result);

        }


        bw.write(String.valueOf(result));

        br.close();
        bw.close();


    }

    public static int dijkstra(int start, int end){

        visited = new boolean[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();


        dist = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[start] = 0;

        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()){

            Node cur = pq.poll();

            if (dist[cur.to] < cur.weight && visited[cur.to]){
                continue;
            }

            visited[cur.to] = true;

            for (int i = 0; i < graph.get(cur.to).size(); i++) {

                Node adjNode = graph.get(cur.to).get(i);

                if (dist[adjNode.to] > adjNode.weight + cur.weight && !visited[adjNode.to]){
                    dist[adjNode.to] = adjNode.weight + cur.weight;
                    pq.offer(new Node(adjNode.to, dist[adjNode.to]));
                }

            }

        }

        return dist[end];


    }


}
















