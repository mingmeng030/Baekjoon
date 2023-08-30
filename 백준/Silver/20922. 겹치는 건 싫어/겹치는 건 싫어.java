import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        
        int[] arr = new int[n];
        line = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(line[i]);
        }
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0; i<n; i++){
            map.put(arr[i],0);
        }
        int left=0, right=0, result=0;
            
        while(left<n && right<n){
            if(map.get(arr[right])+1<=k){
                map.put(arr[right], map.get(arr[right])+1);
                result = Math.max(result, right-left+1);
                right++;
            }
            else{
                map.put(arr[left], map.get(arr[left])-1);
                left++;
            }
        }
        System.out.println(result);
    }
}