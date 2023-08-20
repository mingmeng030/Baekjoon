import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][N+1];
            int[][] DP = new int[2][N+1];
            String [][] testCase = {br.readLine().split(" "),br.readLine().split(" ")};
            for(int j = 1; j <= N; j++){
                sticker[0][j] = Integer.parseInt(testCase[0][j-1]);
                sticker[1][j] = Integer.parseInt(testCase[1][j-1]);
            }

            if(N==1) System.out.println(Math.max(sticker[0][1],sticker[1][1]));
            else{
                DP[0][1] = sticker[0][1];
                DP[1][1] = sticker[1][1];

                for(int j = 2; j <= N; j++){
                    DP[0][j] = sticker[0][j] + Math.max(Math.max(DP[0][j-2],DP[1][j-2]),DP[1][j-1]);
                    DP[1][j] = sticker[1][j] + Math.max(Math.max(DP[1][j-2],DP[0][j-2]),DP[0][j-1]);
                }
                System.out.println(Math.max(DP[0][N],DP[1][N]));
            }
        }
    }
}