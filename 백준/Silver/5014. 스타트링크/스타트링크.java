import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int f = Integer.parseInt(line[0]);
        int s = Integer.parseInt(line[1]);
        int g = Integer.parseInt(line[2]);
        int u = Integer.parseInt(line[3]);
        int d = Integer.parseInt(line[4]);
        
        int[] building = new int[10000001];
        Arrays.fill(building, -1);
        building[s] = 0;
        
		Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        building[s]=0;
        int now = s;
        
        while (!queue.isEmpty() && now!=g) {  
            now = queue.poll();
            int up = now + u;
            int down = now - d;

            if (up<=f){
                if(building[up] == -1){
                    queue.add(up);
                    building[up] = building[now]+1;
                }
            }  
            if (down>0){
                if(building[down] == -1){
                    queue.add(down);
                    building[down] = building[now]+1;
                }
            } 
        }
		System.out.println(building[g]!=-1? building[g]: "use the stairs");
    }

}