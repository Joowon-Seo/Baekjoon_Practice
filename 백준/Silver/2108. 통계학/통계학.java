import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Map<Integer, Integer> map = new TreeMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        double sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int preNum = 4001;
        map.put(4001,0);
        int cntMax = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            map.put(num, map.getOrDefault(num, 0) + 1);
            cntMax = Math.max(cntMax,map.get(num));
            max = Math.max(max, num);
            min = Math.min(min, num);
            pq.offer(num);
        }

        //1.avg
        int avg = (int)Math.round(sum/N);

//        if (tmp < 0){
//            if (sum/N == tmp){
//                avg = tmp;
//            } else {
//                avg = tmp - 1;
//            }
//        } else{
//            avg = tmp;
//        }

        //2.
        for (int i = 0; i < N / 2; i++) {
            pq.poll();
        }
        int mid = pq.poll();

        //3.
        int cnt = 0;
        int many = 0;
        for (int i : map.keySet()){
            int cur = map.get(i);
            if (cur == cntMax){
                cnt++;
                many = i;
            }
            if (cnt == 2){
                break;
            }
        }

        //4.
        int range = max - min;


        System.out.println(avg);
        System.out.println(mid);
        System.out.println(many);
        System.out.println(range);


    }
}





