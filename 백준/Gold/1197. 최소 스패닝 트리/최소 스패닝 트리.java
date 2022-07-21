import java.io.*;
import java.util.*;


public class Main {

    // 정점의 개수 V, 간선의 개수 E 를 입력 받는다
    // 간선에 대한 정보를 Node class 에 초기화한다.
    // 모든 정점을 연결하는 부분 그래프르에서 가중치가 최소인 값을 찾느 것 이기 때문에
    // 프림 알고리즘을 이용한다.

    public static int V, E;
    public static ArrayList<Node>[] graph;
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

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V + 1];

        for (int i = 0; i < V + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, weight));
            graph[to].add(new Node(from, weight));
        }

        visited = new boolean[V + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1,0));

        int weightSum = 0;

        while (!pq.isEmpty()){

            Node cur = pq.poll();

            if (visited[cur.to]){
                continue;
            }

            visited[cur.to] = true;

            weightSum += cur.weight;

            for (int i = 0; i < graph[cur.to].size(); i++) {

                Node adjNode = graph[cur.to].get(i);
                if (!visited[adjNode.to]){
                    pq.offer(adjNode);
                }

            }

        }

        bw.write(String.valueOf(weightSum));



        br.close();
        bw.close();


    }


}
















