import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        String[] line = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(line[i]);
        }
        int left=0, right=n-1;
        int resultLeft = 0, resultRight = n-1;
        int min = Integer.MAX_VALUE;
        
        while(left<right){
            int sum = arr[left]+arr[right];
			if(min > Math.abs(sum)) {
				min = Math.abs(sum);
				resultLeft = left; 
                resultRight = right;
			}
			if(sum>=0) right--;	
			else left++;
        }
        System.out.println(arr[resultLeft] + " " + arr[resultRight]);
    }
}