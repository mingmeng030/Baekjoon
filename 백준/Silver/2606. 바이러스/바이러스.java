import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static int[][] network; 
    static boolean[] visited; 
    static int totalComputer,node,infectedComputer; 
	static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        totalComputer = Integer.parseInt(br.readLine());
        node = Integer.parseInt(br.readLine());
        
        network = new int[totalComputer+1][totalComputer+1]; 
        visited = new boolean[totalComputer+1]; 

        for(int i = 0; i < node; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            network[x][y] = network[y][x] = 1;
        }
		infectedComputer = 0;	
        bfs(1);
        System.out.println(infectedComputer);
    }

    public static void bfs(int now) {
        queue.offer(now);
        visited[now] = true;
        
        while (!queue.isEmpty()) {
            now = queue.poll(); 

            for(int i = 1; i <= totalComputer; i++) {
                if (network[now][i] == 1 && visited[i] == false) {
                    queue.offer(i);
                    visited[i] = true;
                    infectedComputer++;
                }
            }
        }
    }
}