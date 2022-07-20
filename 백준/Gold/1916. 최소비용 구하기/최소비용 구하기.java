import java.io.*;
import java.util.*;


public class Main {

    // 시작점에서 목표 지점까지의 최소 비용을 구하는 문제임으로 데이크스트라 알고리즘을 이용한다
    // 도시의 개수 = 정점의 개수, 버스의 개수 = 간선의 개수
    // 그리고 주어진 간선만큼 반복하여 Node class 에 간선에대한 정보를 입력한다
    // 그리고 데이크스트라 알고리즘을 통해 마지막 정점에대한 값을 출력한다.
    // 문제에서 버스비용이 0보다 크거나 같이 때문에 한번 방문한 도시에 대해서는 다시 방문하지 않게
    // visited 배열을 통해 관리한다.

    public static int N, M, start, end;
    public static int[] dist;
    public static boolean[] visited;
    public static ArrayList<ArrayList<Node>> graph;
    public static int INF = 100000000;

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
//        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        dist = new int[N + 1];
        visited = new boolean[N + 1];

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

        for (int i = 0; i < N + 1; i++) {
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

                if (dist[adjNode.to] > adjNode.weight + cur.weight){
                    dist[adjNode.to] = adjNode.weight + cur.weight;
                    pq.offer(new Node(adjNode.to, dist[adjNode.to]));
                }
            }
        }


        bw.write(String.valueOf(dist[end]));




        br.close();
        bw.close();


    }


}
















