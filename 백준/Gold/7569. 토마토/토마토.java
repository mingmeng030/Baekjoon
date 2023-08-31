import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] dx = { 0, 0, 0, 0, -1, 1 };
        int[] dy = { 0, 0, -1, 1, 0, 0 };
        int[] dz = { -1, 1, 0, 0, 0, 0 };

        int[][][] tomato = new int[H][N][M];
        int count = 0, days = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
                for (int m = 0; m < M; m++) {
                    tomato[h][n][m] = Integer.parseInt(st1.nextToken());
                    if (tomato[h][n][m] == 1)
                        queue.add(new int[]{h, n, m});
                    else if (tomato[h][n][m] == 0)
                        count++;
                }
            }
        }

        while (count > 0 && !queue.isEmpty()) {
            for (int s = queue.size(); s > 0; s--) {
                int[] check = queue.poll();

                for (int k = 0; k < 6; k++) {
                    int nz = check[0] + dz[k];
                    int ny = check[1] + dy[k];
                    int nx = check[2] + dx[k];

                    if (ny < 0 || nx < 0 || nz < 0 || ny >= N || nx >= M || nz >= H || tomato[nz][ny][nx] != 0)
                        continue;

                    count--;
                    tomato[nz][ny][nx] = 1;
                    queue.add(new int[]{nz, ny, nx});
                }
            }
            days++;
        }
        System.out.println(count == 0 ? days : -1);
    }
}
