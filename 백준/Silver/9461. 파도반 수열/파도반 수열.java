import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        long[] P= new long[101];

        P[1]=1;
        P[2]=1;
        P[3]=1;

        for(int i=4; i<101; i++) P[i] = P[i-2] + P[i-3];

        for(int i = 0; i<T; i++) {
            int temp=Integer.parseInt(br.readLine());
            sb.append(P[temp]).append('\n');
        }
        System.out.println(sb);
    }
}