import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        long[][] dp = new long[n][n];

        for(int i=0; i<n; i++){
            String[] line= br.readLine().split(" ");
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }
        
        dp[0][0] = 1;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int now = arr[i][j];
                if(now == 0) break;
                if(j+now < n){
                    dp[i][j+now] += dp[i][j];
                }
                if(i+now < n){
                    dp[i+now][j] += dp[i][j];
                }
            }
        }
        System.out.print(dp[n-1][n-1]);
    }
}