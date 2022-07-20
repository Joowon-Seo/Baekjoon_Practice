import java.io.*;
import java.util.*;


public class Main {

    // 각 정점들에대해서 간선이 존재한다.
    // 그리고 간선들을 통해 정점들을 연결하고, 가중치의 최소 값을 구하는 문제이기 때문에
    // 최소 신장 트리를 구현해서 문제를 푼다
    // 문제에서 간선에 대한 조건이 1000000 이하로 굉장히 많기 때문에 트림 알고리즘을 사용한다

    // 정점의 개수와, 간선의 개수를 입력 받는다
    // 노드 클래스를 만들어 간선에 대한 정보를 관리한다
    // priorituQueue 를 이용해서 가중치가 적은 것 부터 방문하지 않은 노드라면
    // 방문 처리를 하고, 간선에 대한 가중치를 모두 더한다. 그리고 인접한 노드에 대해서 
    // 방문하지 않았다면 pq에 offer하고, 모든 정점을 방문할 때 까지 반복한다
    // 그리고 마을을 두개의 마을로 나누기 때문에 각 가중치를 더할 때 최대 가중치를 가진 간선을 제거 함으로써
    // 두개의 마을로 나눈다
    // 따라서 결과 값은 모든 간선의 가중치 - 최대 가중치 값이 된다.

    public static int N, M;
    public static boolean[] visited;
    public static ArrayList<Node>[] graph;

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
        M = Integer.parseInt(st.nextToken());
        
        visited = new boolean[N + 1];
        
        graph = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 주어진 간선 정보에대한 값 초기화
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            graph[from].add(new Node(to, weight));
            graph[to].add(new Node(from, weight));
        }

        int result = prim();

        bw.write(String.valueOf(result));
        

        br.close();
        bw.close();


    }

    public static int prim(){

        PriorityQueue<Node> pq = new PriorityQueue<>((x,y) -> x.weight - y.weight);
        pq.offer(new Node(1, 0));

        int weightSum = 0;
        int maxWeight = 0;

        while (!pq.isEmpty()){
            Node cur = pq.poll();

            if (visited[cur.to]){
                continue;
            }

            visited[cur.to] = true;
            weightSum += cur.weight;
            maxWeight = Math.max(cur.weight, maxWeight);


            // 인접 노드에 대한 방문여부 확인 밑 pq offer 과정
            for (int i = 0; i < graph[cur.to].size(); i++) {
                Node adjNode = graph[cur.to].get(i);

                if (visited[adjNode.to]){
                    continue;
                }

                pq.offer(adjNode);

            }

        }

        return weightSum - maxWeight;

    }


}
















