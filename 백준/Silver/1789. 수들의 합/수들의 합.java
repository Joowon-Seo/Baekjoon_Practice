import javax.sound.midi.MidiFileFormat;
import java.io.*;
import java.util.*;


public class Main {

    public static long S;

   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//       StringBuilder sb = new StringBuilder();


        S = Long.parseLong(br.readLine());
        long cnt = 0;
        long n = 1;

        while (S>0){
            S -= n++;
            cnt++;
        }

        if (S==0){
            bw.write(String.valueOf(cnt));
        } else {
            if (Math.abs(S)<n){
                bw.write(String.valueOf(cnt-1));
            }
        }


        bw.close();
        br.close();

    }




}
















