import java.io.*;
import java.util.*;


public class Main {

    // 정점의 개수 N, 간선의 개수 M
    // 여기서 주어진 M은 이미 연결된 정정이기 때문에 가중치가 0이라고 할 수 있다
    // 그리고 우어진 정점의 데이터를 Point class 를 통해 초기화 하고
    // 반복문을 통해서 주어진 조건에 맞게 간선을 ArrayList<Edge>로 간선의 정보를 모아준다
    // 여기서 처음에 주어진 간선의 개수도 가중치를 0으로 정보를 추가해준다
    // 이렇게 모아진 가중치 간선 데이터를 가중치의 오름차순으로 정렬하고
    // 크루스칼 알고리즘을 이용한다.


    public static int N, M;
    public static int[] parent; // 크루스칼 때 이용할 부모노드
    public static ArrayList<Edge> edges;
    public static Point[] points;

    public static class Point {
        int idx;
        double x;
        double y;

        public Point(int idx, double x, double y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }
    }

    public static class Edge implements Comparable<Edge> {
        int from;
        int to;
        double weight;

        public Edge(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.weight < o.weight) {
                return -1;
            }
            return 1;
        }
    }


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        points = new Point[N + 1];

        for (int i = 1; i <= N; i++) {

            st = new StringTokenizer(br.readLine());

            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            points[i] = new Point(i, x, y);
        }

        edges = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = 0;

            edges.add(new Edge(from, to, weight));
//            edges.add(new Edge(to, from, weight));
        }

        for (int i = 1; i <= N - 1; i++) {
            for (int j = i + 1; j <= N; j++) {

                double weight = Math.sqrt(Math.pow(points[i].x - points[j].x, 2)
                    + Math.pow(points[i].y - points[j].y, 2));

                edges.add(new Edge(points[i].idx, points[j].idx, weight));
//                edges.add(new Edge(points[j].idx, points[i].idx, weight));
            }
        }

        Collections.sort(edges);

        // 간선 정보들을 가중치에 대한 오름차순으로 정렬 했음으로
        // 크루스칼 알로기즘을 통해서 가중치 합의 최소 값을 구해준다.

        double result = kruskal(N, edges);
//        result = Math.round(result * 100)/100.0;

        bw.write(String.format("%.2f", result));


        br.close();
        bw.close();


    }

    public static double kruskal(int N, ArrayList<Edge> edges){
        parent = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }

        double weightSum = 0;

        for (int i = 0; i < edges.size(); i++) {
            Edge cur = edges.get(i);
            if (find(cur.from) != find(cur.to)){
                weightSum += cur.weight;
                union(cur.from, cur.to);
            }
        }


        return weightSum;
    }

    public static void union(int a, int b){
        int aP = find(a);
        int bP = find(b);

        if (aP != bP){
            parent[bP] = aP;
        }
    }

    public static int find(int a){
        if (parent[a] == a){
            return a;
        }

        return parent[a] = find(parent[a]);
    }


}
















