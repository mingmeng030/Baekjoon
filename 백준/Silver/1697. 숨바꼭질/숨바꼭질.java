import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] distance = new int[100005];
        Arrays.fill(distance, -1);

        System.out.println(BFS(N, K, distance));
    }

    public static int BFS(int N, int K, int[] distance) {
        int nowN = N;
        int[] status = new int[3];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(nowN);
        distance[nowN] = 0;

        while (!queue.isEmpty() && nowN != K) {
            nowN = queue.poll();
            status[0] = nowN - 1; 
            status[1] = nowN + 1; 
            status[2] = nowN * 2; 

            for (int i = 0; i < 3; i++) {
                if (status[i] >= 0 && status[i] <= 100000) {
                    if (distance[status[i]] == -1) {
                        queue.add(status[i]);
                        distance[status[i]] = distance[nowN] + 1;
                    }
                }
            }
        }
        return distance[K];
    }
}