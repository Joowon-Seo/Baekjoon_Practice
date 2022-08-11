import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    // 도시의 개수와, 버스의 간선 정보를 입력 받습니다.
    // 모든 노드가 연결 될 필요가 없고, 최소의 가중치를 구하는 문제이기 때문에 다익스트라 알고리즘을 이용합니다.
    // 다익스트라 알고리즘에서 거치는 노드의 경로를 저장합니다.
    // 노드 경로를 역으로 stack에 넣어주고
    // stack을 출력하면 이동 경로가 됩니다.

    public static int N, M; // 도시, 버스(간선정보의 개수)
    public static int start, end;
    public static int[] dist;
    public static int[] parent;
    public static boolean[] visited;

    public static ArrayList<ArrayList<Node>> graph;
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

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to, weight));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dijkstra();
        
        bw.write(dist[end] + "\n");
        
        Stack<Integer> result = searchPath(end);
        
        bw.write(result.size() + "\n");

        while (!result.isEmpty()){
            bw.write(result.pop() + " ");
        }







        br.close();
        bw.close();


    }

    public static void dijkstra(){

        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()){

            Node cur = pq.poll();

            if (dist[cur.to] < cur.weight){
                continue;
            }

            if (visited[cur.to]){
                continue;
            }

            visited[cur.to] = true;

            for (int i = 0; i < graph.get(cur.to).size(); i++) {
                Node adjNode = graph.get(cur.to).get(i);

                if (dist[adjNode.to] > cur.weight + adjNode.weight){
                    dist[adjNode.to] = cur.weight + adjNode.weight;
                    pq.offer(new Node(adjNode.to, dist[adjNode.to]));

                    parent[adjNode.to] = cur.to;
                }
            }

        }
        
    }
    
    public static Stack<Integer> searchPath(int end){
        Stack<Integer> stack = new Stack<>();
        int cur = end;
        
        while (cur != start){
            stack.push(cur);
            cur = parent[cur];
        }
        stack.push(start);
        
        return stack;
        
    }


}
















