import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int h = Integer.parseInt(line[0]);
        int w = Integer.parseInt(line[1]);
 
        int[] blocks = new int[w];
        line = br.readLine().split(" ");
        for (int i = 0; i < w; i++) {
            blocks[i] = Integer.parseInt(line[i]);
        }
        
        int totalRain = 0;
        for (int i = 1; i < w-1; i++) {
            int left = 0, right = 0;
            
            for (int j = 0; j <i; j++) {
                left = Math.max(left, blocks[j]);
            }
            for (int j = i+1; j < w; j++) {
                right = Math.max(right, blocks[j]);
            }
            if(blocks[i]<left && blocks[i]<right){
                totalRain += Math.min(right, left) - blocks[i];
            }
        }
        System.out.println(totalRain);
    }
}