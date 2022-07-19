import java.io.*;
import java.util.*;


public class Main {


    // 방향그래프가 주어지고, 가중치가 10이하의 자연수 이기 때문에 데이크스트라 알고리즘을 사용한다.
    // 정점의 개수와 간선의 개수를 입력 받는다.
    // start부터 정점까지의 최단 경로의 데이터를 dist[]에 dp로 활용한다.
    // dist[] 의 크기는 v+1
    // dist[]의 각 인덱스에 Integer.MAXVALUE 로 초기화 한다.
    // 시작 점에서 자신의 정점 까지의 최소 값은 0이기 때문에 dist[시작점] = 0으로 초기화 한다
    // 우선순위 큐를 이용한다. 현재 위치와 이어진 간선의 정보둘 즁 가중치가 최소인 부분만 탐색하면 되기 때문이다.
    // 큐를 통해 poll된 Node는 현재 위치이다. 현재 위치에서 이어진 정점들 중 최소가 되는 부분이 있다면 초기화 하고,
    // 최소가 되는 부분은 시작점에서 목표 정점까지 가는 최소의 값 과 시작점에서 현재 위치를 거쳐 목표 정점으로 가는 값중
    // 최소를 찾는다. 이를 정점의 개수 만큼 반복한다.
    // 결과값은 시작점부터 각 정점의 위치에 가기위한 최소한의 가중치의 값이 dist[]에 저장돼 있다.
    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }


    static int V, E, start;
    static int[] dist;


   public static void main(String[] args) throws IOException {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       StringTokenizer st = new StringTokenizer(br.readLine());

       V = Integer.parseInt(st.nextToken());
       E = Integer.parseInt(st.nextToken());
       start = Integer.parseInt(br.readLine());

       ArrayList<ArrayList<Node>> graph = new ArrayList<>();

       for (int i = 0; i < V + 1; i++) {
           graph.add(new ArrayList<>());
       }

       for (int i = 0; i < E; i++) {
           st = new StringTokenizer(br.readLine());

           int from = Integer.parseInt(st.nextToken());
           int to = Integer.parseInt(st.nextToken());
           int weight = Integer.parseInt(st.nextToken());

           graph.get(from).add(new Node(to, weight));

       }

       dist = new int[V + 1];

       for (int i = 1; i < V + 1; i++) {
           dist[i] = Integer.MAX_VALUE;
       }

       dist[start] = 0;

       PriorityQueue<Node> pq = new PriorityQueue<>((x,y) -> x.weight - y.weight);

       pq.offer(new Node(start, 0)); //시작 점이 자신에 대한 가중치는 0이기 때문에

       while (!pq.isEmpty()){

           Node curNode = pq.poll();

           if (dist[curNode.to] < curNode.weight){
               continue;    //시작점부터 현재 정점까지의 값보다 가중치가 더 크다면 탐색할 이유가 없다
           }

           for (int i = 0; i < graph.get(curNode.to).size(); i++) {

               Node adjNode = graph.get(curNode.to).get(i);

               if (dist[adjNode.to] > curNode.weight + adjNode.weight){
                   dist[adjNode.to] = curNode.weight + adjNode.weight;
                   pq.offer(new Node(adjNode.to, dist[adjNode.to]));
               }

           }

       }

       for (int i = 1; i <= V; i++) {

           if (dist[i] == Integer.MAX_VALUE){
               bw.write("INF\n");
           } else {
               bw.write(dist[i] + "\n");
           }

       }


       br.close();
       bw.close();


    }


}
















