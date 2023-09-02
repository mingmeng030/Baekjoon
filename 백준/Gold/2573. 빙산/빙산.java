import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[][] iceberg;
	static boolean[][] check;
	static int n,m;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		iceberg = new int[n][m]; 
        
		for(int i = 0; i<n; i++){
            line = br.readLine().split(" ");
            for(int j = 0; j<m; j++){
                iceberg[i][j] = Integer.parseInt(line[j]);
            }
		}
		
        // 빙산이 다 녹았다면 false
        // 하나라도 빙산이 있다면 true
		boolean flag = true; 
        int year = 0;
        
		while(flag) {
			int count = 0;
			check = new boolean[n][m];
			flag = false; 
			for (int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(iceberg[i][j] > 0 && !check[i][j]) {
						flag=true;
						bfs(i, j);
						count++;
					}
				}
			}
			
			if(count >= 2) {
				System.out.println(year);
				break;
			}
			
			int[][] nextIceberg = new int[n][m];
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(iceberg[i][j] > 0) {
						int seaCount = 0;
						for(int k=0; k<4; k++) {
							int nowX = dx[k] + i;
							int nowY = dy[k] + j;
							if(iceberg[nowX][nowY] == 0) seaCount++;
						}
						int update = iceberg[i][j]-seaCount;
						if(update <= 0) update = 0;
						nextIceberg[i][j] = update;
					}
				}
			}
			year++;
			iceberg = nextIceberg.clone(); 
		}
		if(!flag) System.out.println(0);	
	}
    
    static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x,y});
        check[x][y] = true;
        
		while(!queue.isEmpty()) {
            int[] now = queue.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			for(int k=0; k<4; k++) {
				int nextY = nowY + dy[k];
				int nextX = nowX + dx[k];
				if(nextY>=0 && nextY<m && nextX >=0 && nextX<n) {
					if(iceberg[nextX][nextY] > 0 && !check[nextX][nextY]){
						queue.offer(new int[] {nextX,nextY});
						check[nextX][nextY] = true;
					}
				}
			}
		}
	}
}