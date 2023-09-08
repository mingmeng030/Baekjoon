import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line= br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);

        long dp[][] = new long[201][201];
        
        for(int i=0; i<=200; i++){
            dp[i][0] = 1;
            dp[1][i] = 1;
        }    
        for(int i=1; i<=200; i++){
            dp[2][i] = i+1;
        }  

        for(int i=3; i<=200; i++){
            for(int j=1; j<=200; j++){
                for(int m=0; m<=j; m++){
                    dp[i][j] += dp[i-1][j-m]%1000000000;
                }
            }
        }

        System.out.print(dp[k][n]%1000000000);
    }
}