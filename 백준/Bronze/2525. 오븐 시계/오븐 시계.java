import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] time = br.readLine().split(" ");
        int hour = Integer.parseInt(time[0]);
        int min = Integer.parseInt(time[1]);
        int plus = Integer.parseInt(br.readLine());

        hour = (hour + (min + plus)/60)%24;
        min = (min + plus)%60;

        System.out.println(hour + " " + min);


    }
}





