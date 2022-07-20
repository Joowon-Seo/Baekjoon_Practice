import java.io.*;
import java.util.*;


public class Main {

    // 수빈이의 위치 = 시작점, 동색의 위치 = 목표점
    // dist 배열을 최대치인 100001으로 초기화 해준다
    // 메모리가 워낙 크기 때문에 40만바이트 주어진 조건에 충분하다
    // 참고로 1MB = 100만 바이트
    // 현재 인덱스 위치에서 + , -1, *2 한뒤 가중치과 비교해서
    // 시작점부터 현재위치까지의 총 가중치보다 현재가중치에서 +1, +1 , 0
    // 가중치보다 클 경우에 pq에 증가시킨 인덱스와 각 가중치를 offer한다.
    // 따라서 수민이가 동생보다 앞에 있는 경우는 dist[K]가 나올 것 이고
    // 동생이 수민이 보다 앞에 있는 경우는 N - K 가 그 결과 값일 것이다.

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

        if (N >= K){
            bw.write(String.valueOf(N - K));
        } else {

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

            bw.write(String.valueOf(dist[K]));
            
        }

        
        


        br.close();
        bw.close();


    }


}
















