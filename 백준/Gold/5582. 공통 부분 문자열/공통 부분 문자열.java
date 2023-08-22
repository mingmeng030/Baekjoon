import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();
        int[][] dp = new int[first.length()+1][second.length()+1];        
        int answer = 0;
        
        for(int i=1; i<=first.length(); i++) {
            for(int j=1; j<=second.length(); j++) {
                if(first.charAt(i-1) == second.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1; 
                }
                answer = Math.max(answer, dp[i][j]);
            }
        }
        System.out.println(answer);
    }
}