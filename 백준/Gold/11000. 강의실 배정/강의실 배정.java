import java.io.*;
import java.util.*;


public class Main {

    // N 개의 수업을 입력 받는다.
    // 그리고 우선순위 큐를 이용해서 끝나는 시간을 오름차순으로
    // 그 다음으로 수업이 연결 되는지 확인하는 부분은 시작 시간을 오름차순으로
    // pq의 peek에는 현재까지 순회한 강의중 가장 빨리 끝나는 수업이 들어있을 것이고
    // peek 보다 시작 시간이 더 빠르다면 나머지 강의들은 모두 안되는 것임을 알 수 있다.
    // 만약 peek보다 시작 시간이 뒤라면, 해당 peek를 poll하고 현재 순회 중이였던 (시작시간)의 끝나는 시간을 add 합다.

    // 최종적으로 남은 pq의 사이즈가 출력 값이 된다.
    public static int N;

    public static Lecture[] lectures;

    public static class Lecture {
        int S;
        int T;

        public Lecture(int s, int t) {
            S = s;
            T = t;
        }
    }



    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());

        lectures = new Lecture[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            lectures[i] = new Lecture(s,t);
        }

        Arrays.sort(lectures, (x, y) -> x.S - y.S);


        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lectures[0].T);

        for (int i = 1; i < N; i++) {
            if (lectures[i].S >= pq.peek()){
                pq.poll();
            }
            pq.add(lectures[i].T);
        }

        bw.write(String.valueOf(pq.size()));


        br.close();
        bw.close();


    }


}
















