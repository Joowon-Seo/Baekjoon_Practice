import javax.sound.midi.MidiFileFormat;
import java.io.*;
import java.util.*;


public class Main {

   


    public static int A, B;



   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//       StringTokenizer st = new StringTokenizer(br.readLine());

       A = Integer.parseInt(br.readLine());
       B = Integer.parseInt(br.readLine());

       int result = A + B;

       bw.write(String.valueOf(result));

       bw.close();
       br.close();

    }









}
















