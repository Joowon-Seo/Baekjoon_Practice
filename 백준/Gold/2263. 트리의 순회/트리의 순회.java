import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // preOder = 가운데, 왼쪽, 오른쪽 순으로 노드 방문
    // inOrder = 왼쪽, 가운데, 오른쪽 순으로 노드 방문
    // postOrder = 왼쪽, 오른쪽, 가운데 순으로 노드 방문문

    // postOrder 의 마지막은 가운데 노드를 알려준다

    // 가운데노드를 통해서, inOrder에서 그 가운데 노드의 좌우는 왼쪽, 오른쪽 노드이다.
    // 가운데 노드를 중심으로 좌우의 노드의 중을 찾습니다.

    public static int N;
    public static int[] inOrder;
    public static int[] postOrder;
    public static int[] preOrder;
//    public static ArrayList<Integer> result = new ArrayList<>();


    public static void main(String[] args) throws IOException {




        N = Integer.parseInt(br.readLine());

        inOrder = new int[N];
        postOrder = new int[N];
        preOrder = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }

        int num = 0;
        for (int i = 1; i <=1 ; i++) {
            num = i;
        }

//        System.out.println(num);


        search(0, N - 1, 0, N - 1);


        br.close();
        bw.close();


    }

    public static void search(int is, int ie, int ps, int pe) throws IOException {

        if (ie - is < 0 || pe - ps < 0){
            return;
        }

        int rootIdx = is;


        for (int i = is; i <= ie; i++) {

            if (inOrder[i] == postOrder[pe]){
                rootIdx = i;
                break;
            }
        }


        bw.write(inOrder[rootIdx] + " ");
        search(is, rootIdx - 1, ps, ps + rootIdx - is - 1);
        search(rootIdx + 1, ie, ps + rootIdx - is, pe - 1);






    }


}
















