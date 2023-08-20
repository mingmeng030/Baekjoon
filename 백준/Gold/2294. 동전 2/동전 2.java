import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coin  = new int[n];
        int[] dp = new int[k + 1];
        Arrays.fill(dp, 100001);

        for(int i=0; i<n; i++)
            coin[i] = Integer.parseInt(br.readLine());

        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= k; j++)
                dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
        }
        if(dp[k]== 100001) System.out.println(-1);
        else System.out.println(dp[k]);
    }
}