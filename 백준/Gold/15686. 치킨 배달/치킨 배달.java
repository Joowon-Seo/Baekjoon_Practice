import java.io.*;
import java.util.*;


public class Main {

    // N 과 M의 데이터를 입력 받습니다.
    // N번 만큼 반복하여 2차배열의 데이터를 입력 받습니다.
    // 배열의 데이터가 1일 때 home이라는 배열에 따로 저장합니다.
    // 데이터가 2일 떄 chicken 이라는 배열에 따로 저장합니다.
    // 최고의 효울을 내는 치킨집의 개수 이기 때문에
    // 한 치킨집에 대해서 모든 집들까지의 거리의 총합을 배열에 저장한다음
    // 최소값을 갖는 M개의 도시의 치킨 거리의 합을 합니다.

    public static int N, M;
    public static ArrayList<int[]> home;
    public static ArrayList<int[]> chicken;
    public static ArrayList<Integer> dist;




    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        home = new ArrayList<>();
        chicken = new ArrayList<>();
        dist = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if (cur == 1){
                    home.add(new int[] {i, j});
                } else if (cur == 2){
                    chicken.add(new int[] {i, j});
                }
            }
        }

        int[] arr = new int[chicken.size()];
        boolean[] visited = new boolean[chicken.size()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        combination(arr, visited, 0, arr.length, M);

        Collections.sort(dist);

        bw.write(String.valueOf(dist.get(0)));


        br.close();
        bw.close();


    }

    public static void combination(int[] arr, boolean[] visited, int depth, int n, int r){
        if (r == 0){
            caculation(arr, visited);
        }

        if (depth == n){
            return;
        }

        visited[depth] = true;
        combination(arr, visited, depth + 1, n, r - 1);

        visited[depth] = false;
        combination(arr, visited, depth + 1, n, r);
    }

    public static void caculation(int[] arr, boolean[] visited){
        int sum = 0;
        for (int i = 0; i < home.size(); i++) {
            int[] curHome = home.get(i);
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < arr.length; j++) {
                if (!visited[j]){
                    continue;
                }
                int[] chickenCur = chicken.get(arr[j]);

                int weight = Math.abs(curHome[0] - chickenCur[0]) + Math.abs(curHome[1] - chickenCur[1]);

                min = Math.min(min, weight);
            }

            sum += min;
        }

        dist.add(sum);
    }



}
















