import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];
        String[] line = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(line[i]);
        }
        
        Arrays.sort(arr);
        long min = Long.MAX_VALUE;
        long[] result = new long[3];
        
        out : for(int i = 0; i<n-2; i++){
            int left=i+1, right=n-1;
            
            while(left<right){
                long sum = arr[left]+arr[right]+arr[i];
                if(Math.abs(min) > Math.abs(sum)) {
                    min = sum;
                    result[0] = arr[i]; 
                    result[1] = arr[left];
                    result[2] = arr[right];
                }
                if(sum==0) {
                    result[0] = arr[i]; 
                    result[1] = arr[left];
                    result[2] = arr[right];
                    break out;
                }
                else if(sum>0) right--;	
                else left++;
            }
        }
        System.out.println(result[0]+" "+result[1]+" "+result[2]);
    }
}