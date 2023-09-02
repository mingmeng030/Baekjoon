import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] region = new int[n][n];

        int maxHeight=0; 
        for(int i = 0; i<n; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j<n; j++){
                region[i][j] = Integer.parseInt(line[j]);
                maxHeight = Math.max(maxHeight,region[i][j]);			
            }
        }
        
        int safeZone = 0;
        for(int height = 0; height<=maxHeight; height++){
            boolean[][] check = new boolean[n][n];
            int count = 0;
            for(int j = 0; j<n; j++){
                for(int k = 0; k<n; k++){
                    if(!check[j][k]&&region[j][k]>height){
                        bfs(region, check, height, j, k, n);
                        count++;
                    }
                }
            }
            safeZone = Math.max(safeZone,count);
        }     
        System.out.println(safeZone);
    }
    
    public static void bfs(int[][] region, boolean[][] check, int height, int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        check[x][y]=true;
        
        while (!queue.isEmpty()) {  
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i = 0; i<4 ; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if (nextX>=0 && nextY>=0 && nextX<n && nextY<n) {
                    if(!check[nextX][nextY]&&region[nextX][nextY]>height){
                        check[nextX][nextY] = true;
                        queue.offer(new int[] {nextX, nextY});
                    }
                }
            }
        }
    }  
}