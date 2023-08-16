import java.io.*;
import java.util.*;
public class Main{
    static int[][] adjacent; 
    static boolean[] checked; 
    static int n,m,start,num; 

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        n = s.nextInt(); 
        m = s.nextInt(); 
        start = s.nextInt(); 

        adjacent = new int[1001][1001]; 
        checked = new boolean[1001]; 

        for(int i = 0; i < m; i++) {
            int x = s.nextInt();
            int y = s.nextInt();
            adjacent[x][y] = adjacent[y][x] = 1;
        }
        dfs(start);
        checked = new boolean[1001];
        System.out.println();
        bfs();
    }
    public static void dfs(int i) {
        checked[i] = true; 
        System.out.print(i + " "); 
        for(int j = 1; j <= n; j++) {
            if(adjacent[i][j] == 1 && checked[j] == false)
                dfs(j);
        }
    }
    public static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        checked[start] = true;
        System.out.print(start + " ");
        while (!queue.isEmpty()) {
            int temp = queue.poll(); 
            for (int j = 1; j <= n; j++) {
                if (adjacent[temp][j] == 1 && checked[j] == false) {
                    queue.offer(j);
                    checked[j] = true;
                    System.out.print(j + " ");
                }
            }
        }
    }
}