import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] schedule = new int[n][2];
        int len = 1;
        
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            schedule[i][0] = Integer.parseInt(line[0]);
            schedule[i][1] = Integer.parseInt(line[1]);
            len = Math.max(schedule[i][1], len);
        }  
        
        int[] calendar = new int[len+1];
        for(int i = 0; i < n; i++) {
            for(int j = schedule[i][0]; j <= schedule[i][1]; j++){
                calendar[j]++;
            }
        }
        
        int area = 0, width=0, height=0;
        for (int i = 1; i <= len; i++) {
            if(calendar[i]!=0){
                width++;
                height = Math.max(height, calendar[i]);
            }
            else{
                area+=width*height;
                width=height=0;
            }
        }
        System.out.println(area+width*height);
    }
}