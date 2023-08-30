import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

         int[] arr = new int[n];
         String[] line = br.readLine().split(" ");
         for(int i=0; i<n; i++){
             arr[i] = Integer.parseInt(line[i]);
         }
        
        Arrays.sort(arr);
        int result = 0;
        
        for(int i = n-1; i>=0; i--){
            int left=0, right=n-1;
            
            while(left<right){
                if(left==i){
                    left++;
                    continue;
                }
                else if(right==i){
                    right--;
                    continue;
                }
                int sum = arr[left]+arr[right];
                if(sum==arr[i]){
                    result++;
                    break;
                }
                else if(sum>arr[i]) right--;	
                else left++;
            }
        }
        System.out.println(result);
    }
}