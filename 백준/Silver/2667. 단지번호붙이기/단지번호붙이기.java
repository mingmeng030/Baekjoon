import java.io.*;
import java.util.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static int[][] map; 
    static boolean[][] visited; 
    static int n, count=0; 
    static List<Integer> apartmentComplex = new ArrayList<>(); 
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 }; 
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        map = new int[n][n]; 
        visited = new boolean[n][n]; 
        
        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j)-'0';
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j]==1&&visited[i][j]==false){
                    count++;
                    bfs(i,j);
                } 
            }
        }
        Collections.sort(apartmentComplex);
        System.out.println(count);
        for(int house : apartmentComplex) {
            System.out.println(house);
        }    
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x,y});
        visited[x][y] = true;
        int house = 1;
        while (!queue.isEmpty()) {
            int now[] = queue.poll(); 
            int nowX = now[0];
            int nowY = now[1];
            
            for(int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];  
                
                if (nextX < n && nextY < n && nextX >= 0 && nextY >= 0
                   && !visited[nextX][nextY] && map[nextX][nextY] == 1){
                    visited[nextX][nextY] = true;
                    queue.offer(new int[] {nextX, nextY});
                    house++;
                }
            }
        }
        apartmentComplex.add(house);
    }
}