import java.util.*;
public class Main {
	public static void main(String[] args)   {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
       		int dp[] = new int [n+1];
		dp[1]=1;
        		dp[0]=1;
   		if(n>=2){
            		for(int j=2;j<=n;j++) 
			dp[j] =  (dp[j-2] + dp[j-1])%10007;
		}
		System.out.println(dp[n]);
	}
}