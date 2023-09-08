import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] tile = new int[N + 1];
        
        if (N % 2 == 0) {
            tile[0] = 1;
            tile[2] = 3;
            for (int i=4; i<=N; i += 2) {
                tile[i] = tile[i-2]*tile[2];
                for (int j = i-4; j >= 0; j -= 2) 
                    tile[i] += tile[j]*2;
            }
        }
        System.out.println(N%2==0 ? tile[N] : 0);
    }
}