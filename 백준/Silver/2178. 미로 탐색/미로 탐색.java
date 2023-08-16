import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
    static int[][] map;
    static int n, m;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        visited[0][0] = true;

        for(int i=0; i<n; i++) {
            String s = br.readLine();
            for(int j=0; j<m; j++)
                map[i][j] = s.charAt(j)-'0';
        }

        bfs(0, 0);
        System.out.println(map[n-1][m-1]);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});

        while(!queue.isEmpty()) {
            int now[] = queue.poll();
            int nowX = now[0], nowY = now[1];

            for(int i=0; i<4; i++) { // 현 위치에서 상하좌우 갈 수 있는지 검사
                int nextX = nowX + dx[i], nextY = nowY + dy[i];

                if (nextX>=n || nextY>=m || nextX<0 || nextY<0) continue;
                if (map[nextX][nextY]==0 || visited[nextX][nextY]) continue;

                queue.add(new int[] {nextX, nextY});
                map[nextX][nextY] = map[nowX][nowY]+1; // 다음 갈 칸 = 현위치+1
                visited[nextX][nextY] = true;
            }
        }
    }
}