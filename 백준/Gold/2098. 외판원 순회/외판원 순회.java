import java.io.*;
import java.util.*;

public class Main {
	static int n, INFINITY = 999999999;
	static int[][] map;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = Integer.parseInt(br.readLine());
        
		map = new int[n][n];
		dp = new int[n][(1<<n) -1];
        
		for(int i=0; i<n; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(tsp(0,1)); // 0번도시 부터 탐색 시작 (check: 0001)
	}
	
	static int tsp(int city, int visitedBit) {
        
		// 모든 도시 방문 완료
		if(visitedBit == (1<<n) -1) {
			if(map[city][0] == 0) return INFINITY; // 경로 없으면 INFINITY로 탐색 무효화 (Math.min)
			else return map[city][0]; // 경로가 존재하면 map[city][0]
		}
        
		// 이미 방문한 도시 
		if(dp[city][visitedBit] != -1) return dp[city][visitedBit];
        
		// 해당 도시에 출석 표시
		dp[city][visitedBit] = INFINITY;
        
		// 방문하지 않은 도시 탐색 
		for(int i=0; i<n; i++) {
			// next : i 도시 방문
			int next = visitedBit | (1<<i); 
            
			// 경로가 없거나 i 도시를 이미 방문했을 경우 continue 
			if(map[city][i] ==0 || (visitedBit & (1<<i)) != 0) continue;
			
			dp[city][visitedBit] = Math.min(dp[city][visitedBit], tsp(i, next) + map[city][i]);
		}
		
		return dp[city][visitedBit];
	}
}