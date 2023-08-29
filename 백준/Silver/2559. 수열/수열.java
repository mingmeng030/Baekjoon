import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        
        int[] numArr = new int[n];
        line = br.readLine().split(" ");
        for(int i = 0; i<n; i++){
            numArr[i] =  Integer.parseInt(line[i]);
        }
        
        int sum = 0;
        for (int i = 0; i < k; i++) sum+=numArr[i];
        int max = sum;
        
        for (int i = k, j=0; i < n; i++, j++) {
            sum+=numArr[i]-numArr[j];
            if (max < sum) max = sum;
        }
        System.out.println(max);
    }
}