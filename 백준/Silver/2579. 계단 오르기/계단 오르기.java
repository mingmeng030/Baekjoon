import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] stair = new int[N+1];
        int[] dp = new int[N+1];

        for(int i = 1; i <=N; i++)
            stair[i] = Integer.parseInt(br.readLine());

        dp[1]=stair[1];

        if(N<=3){
            if(N==1) System.out.println(dp[1]);
            else if(N==2) System.out.println(stair[1]+stair[2]);
            else System.out.println(Math.max(stair[1]+stair[3],stair[2]+stair[3]));
        }
        else{
            dp[2]=stair[1]+stair[2];
            dp[3]=Math.max(stair[1]+stair[3],stair[2]+stair[3]);

            for(int i=4; i<=N; i++)
                dp[i]=Math.max( (dp[i-3]+stair[i]+stair[i-1]), (dp[i-2]+stair[i]));

            System.out.println(dp[N]);
        }
    }
}