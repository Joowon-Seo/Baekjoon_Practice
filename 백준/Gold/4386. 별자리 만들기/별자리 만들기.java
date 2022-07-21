import java.io.*;
import java.util.*;


public class Main {

    // 문제는 주어진 정점에 대해 모두 이어져 있고 가중치를 최소를 찾는 문제이기 때문에
    // MST를 이용한다.
    // 별의 개수 = 정점의 개수를 입력받는다
    // 정점의 위치 정보를 입력 받는다  class Point
    // 주어진 정보들을 토대로 간선에 대한 정보를 입력받는다
    // 그리고 가중치에 대해서 정렬을 진행한후
    // 크루스칼 알고리즘을 이용한다.

    public static int n;
    public static ArrayList<Node> graph;
    public static int[] parent; // 크루스칼 알고리즘의 부모 노드모음;
    public static Point[] point;

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

    public static class Node implements Comparable<Node>{

        int from;
        int to;
        double weight;

        public Node(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            if (this.weight < o.weight){
                return -1;
            }

            return 1;
        }
    }



    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());


        n = Integer.parseInt(br.readLine());
        
        // 주어진 정점 초기화
        point = new Point[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            point[i] = new Point(i, x, y);
        }
        
        graph = new ArrayList<>();
        
        
        // 간선 정보 초기화
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                double weight = Math.sqrt(Math.pow(point[i].x - point[j].x, 2)
                        + Math.pow(point[i].y - point[j].y, 2));
                
                graph.add(new Node(point[i].idx, point[j].idx, weight));
                graph.add(new Node(point[j].idx, point[i].idx, weight));
            }
        }
        
        // 크루스칼 알고리즘 이용
        // 크루스칼 알로리즘 이용 전 weight 오름차순 정렬


        Collections.sort(graph);

        double result = kruskal(n, graph);

        result = Math.round(result*100)/100.0;

        bw.write(String.valueOf(result));



        br.close();
        bw.close();


    }

    public static Double kruskal(int n, ArrayList<Node> graph){

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        double weightSum = 0;

        for (int i = 0; i < graph.size(); i++) {

            Node cur = graph.get(i);

            if (find(cur.to) != find(cur.from)){
                union(cur.to, cur.from);
                weightSum += cur.weight;
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
















