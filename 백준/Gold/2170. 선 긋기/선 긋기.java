import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
 
        Queue<long[]> queue = new PriorityQueue<>(Comparator.comparingLong(o -> o[0]));
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            queue.offer(new long[]{Long.parseLong(line[0]), Long.parseLong(line[1])});
        }
 
        long[] top = queue.poll();
        long start = top[0];
        long end = top[1];
        long result = 0;
        
        while (!queue.isEmpty()) {
            long[] now = queue.poll();

            // 이전 선에 현재 선이 포함 되는 경우
            if (now[0] <= end) {
                if (now[1] > end) end = now[1];
                continue;
            }

            result += end - start;
            start = now[0];
            end = now[1];
        }
        System.out.println(result+end-start);
    }
}