import java.io.*;
import java.util.*;


public class Main {

    // 주어진 데이터는 각 정점의 위치 정보가 들어온다
    // 그리고 각 주어진 정점의 위치 정보로 부터, 간선의 가중치를 찾는다
    // 이로서 모든 정점에 대한 가중치 데이터가 담긴 간선의 정보를 받을 수 있다
    // 각 정점의 정보를 담는 point 클래스와, point클래스에서 각 좌표에 대한
    // 가중치의 데이터를 통해 간선 class edge에 데이터를 담는다
    // 결국 간선과 가중치가 주어 진 것이고, 모든 행성이 서로 연결될 때 최소 비용이므로
    // 크루스칼 알고리즘을 사용한다.

    public static int n; // 정점의 개수
    public static int[] parent; // 크루스칼 알고리즘에서 이용할 부모들의 모듬

    public static class Point{
        int idx;
        int x;
        int y;
        int z;

        public Point(int idx, int x, int y, int z) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static class Edge implements Comparable<Edge>{

        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//       StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(br.readLine());

        Point[] points = new Point[n]; // 각 정점에대한 정보 초기화

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            points[i] = new Point(i,x,y,z);
        }

        ArrayList<Edge> edges = new ArrayList<>();

        // 주어진 조건에 맞게 간선의 정보를 추가하는 부분
        Arrays.sort(points, (p1,p2) -> p1.x - p2.x);
        for (int i = 0; i < n - 1; i++) {

            int weight = Math.abs(points[i].x - points[i + 1].x);

            edges.add(new Edge(points[i].idx, points[i + 1].idx, weight));
            edges.add(new Edge(points[i + 1].idx, points[i].idx, weight));
        }

        Arrays.sort(points, (p1,p2) -> p1.y - p2.y);
        for (int i = 0; i < n - 1; i++) {

            int weight = Math.abs(points[i].y - points[i + 1].y);

            edges.add(new Edge(points[i].idx, points[i + 1].idx, weight));
            edges.add(new Edge(points[i + 1].idx, points[i].idx, weight));
        }

        Arrays.sort(points, (p1,p2) -> p1.z - p2.z);
        for (int i = 0; i < n - 1; i++) {

            int weight = Math.abs(points[i].z - points[i + 1].z);

            edges.add(new Edge(points[i].idx, points[i + 1].idx, weight));
            edges.add(new Edge(points[i + 1].idx, points[i].idx, weight));
        }

        // 간선에 대한 정보를 모두 모았으니 크루스칼 알고리즘을 사용
        // 그리고 최소비용을 구해야 함으로 간선정보를 weight 에 맞게 정렬

        Collections.sort(edges);

        int result = kruskal(n, edges);

        bw.write(String.valueOf(result));



        br.close();
        bw.close();


    }

    public static int kruskal(int n, ArrayList<Edge> edges){


        parent = new int[n];
        int weightSum = 0;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < edges.size(); i++) {
            
            Edge edge = edges.get(i);

            if (find(edge.to) != find(edge.from)){
                union(edge.to, edge.from);

                weightSum += edge.weight;
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
















