import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[][] board = new int[n+1][n+1];
        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0; j<n; j++)
                board[i+1][j+1] = Integer.parseInt(line[j]);
        }

        long[][] dp = new long[n+1][n+1]; 
        dp[1][1]=1;
            
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                int now = board[i][j];
                if(now == 0) break;
                if(j+now<=n) dp[i][j+now] += dp[i][j];
                if(i+now<=n) dp[i+now][j] += dp[i][j];
            }
        }   
        System.out.println(dp[n][n]);
    }
}