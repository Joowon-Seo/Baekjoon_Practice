import java.io.*;
import java.util.*;


public class Main {

    // 수빈이의 위치 = 시작점, 동색의 위치 = 목표점
    // 시작점과, 목표점중 작은것 부터 반복문을 시작해 간선을 추가해준다
    // 큰 목표 점 까지
    // 각 반복문에서 간선 정보는 해당 위치에서 +- 1 할때는 가중치는 1로,
    // 해당 위치에서 *2 위치는 가중치를 0으로 간선정보를 초기화 해준다.
    // 그리고 시작점에서 목표점까지 최소 가중치로 가는 결과를 찾기 때문에
    // 데이크스트라 알고리즘을 이용한다.

    public static int N, K, INF;
    public static int[] dist;

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
        K = Integer.parseInt(st.nextToken());

        INF = Math.abs(N - K) * 100000;

        dist = new int[100001];

        for (int i = 0; i < 100001; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[N] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((x,y) -> x.weight - y.weight);

        pq.offer(new Node(N, 0));

        while (!pq.isEmpty()){

            Node cur = pq.poll();

            if (dist[cur.to] < cur.weight){
                continue;
            }

            int next1 = cur.to + 1;
            if (next1 <= 100000 && dist[next1] > dist[cur.to] + 1){
                dist[next1] = dist[cur.to] + 1;
                pq.offer(new Node(next1, 1));
            }

            int next2 = cur.to - 1;
            if (next2 >= 0 && next2 <= 100000
                    && dist[next2] > dist[cur.to] + 1){
                dist[next2] = dist[cur.to] + 1;
                pq.offer(new Node(next2, 1));
            }

            int next3 = cur.to * 2;
            if (next3 >= 0 && next3 <= 100000
                    && dist[next3] > dist[cur.to]){
                dist[next3] = dist[cur.to];
                pq.offer(new Node(next3, 0));
            }

        }

        if (N <= K){
            bw.write(String.valueOf(dist[K]));
        } else {
            bw.write(String.valueOf(N - K));
        }





        br.close();
        bw.close();


    }


}
















