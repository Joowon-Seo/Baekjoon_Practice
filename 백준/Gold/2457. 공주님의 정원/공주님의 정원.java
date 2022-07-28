import java.io.*;
import java.util.*;


public class Main {
    // 3월 1일 부터 12월 1일 까지  꽃이 핀상태로 유지 되는 것을 찾아야 하기 때문에
    // 받은 데이터를 시작일을 오름차순으로 정렬하고
    // 조금 더 빠르게 결과 값을 찾기위해 시작일이 같다면 끝나는 날을 내림차순으로 찾아야한다
    // 왜냐하면 최대한 넒은 범위에서 꽃을 피우는 최소 값을 찾아아야 하기 때문이다.

    // while 현재 쓸 꽃들의 end 값의 최대가 12월 1일을 넘어가면 종료한다
    // 위의 while 문이 반복 할 때마다 현재 상황에서 최대의 효율을 내는 것을 찾는다
    // 현재 노드의 start가 지정된 시작점 보다 크다면 break
    //

    public static int N;
    public static Flower[] flowers;

    public static class Flower implements Comparable<Flower>{
        int start;
        int end;

        public Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Flower o) {
            if (this.start == o.start){
                return o.end - this.end;
            }

            return this.start - o.start;
        }
    }





    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());
        flowers = new Flower[N];


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int startMonth = Integer.parseInt(st.nextToken()) * 100;
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken()) * 100;
            int endDay = Integer.parseInt(st.nextToken());

            flowers[i] = new Flower(startMonth + startDay, endMonth + endDay);

        }

        Arrays.sort(flowers);

        int start = 301;
        int end = 1201;
        int max = 0;
        int idx = 0;
        int cnt = 0;

        while (start < end){

            boolean check = false;

            for (int i = idx; i < N; i++) {

                Flower cur = flowers[i];

                if (cur.start > start){
                    break;
                }

                if (cur.end > max){
                    check = true;
                    max = cur.end;
                    idx ++;
                }
            }

            if (check){
                start = max;
                cnt++;
            } else {
                break;
            }


        }


        if (max < end){
            bw.write("0");
        } else {
            bw.write(String.valueOf(cnt));
        }






        br.close();
        bw.close();


    }


}
















