import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        int[] dp = new int[41];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++) 
			dp[i] = dp[i-1] + dp[i-2];
		
        int answer = 1, prevSeatNum=0;
        for(int i=0; i<m; i++) {
            int fixed = Integer.parseInt(br.readLine());
            answer*=dp[fixed-prevSeatNum-1];
            prevSeatNum = fixed;
        }
        System.out.println(answer*=dp[n-prevSeatNum]);
    }
}