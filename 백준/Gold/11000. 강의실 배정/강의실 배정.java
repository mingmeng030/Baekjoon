import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] classes = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            classes[i][0] = Integer.parseInt(line[0]);
            classes[i][1] = Integer.parseInt(line[1]);
        }        

        Arrays.sort(classes, (o1, o2) -> {
            return o1[0]-o2[0]; 
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        pq.offer(classes[0][1]);

        for (int i = 1; i < n; i++) {
            if (pq.peek() <= classes[i][0]) pq.poll();
            pq.offer(classes[i][1]);
        }
        System.out.println(pq.size());
    }
}