import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");  
        int n = Integer.parseInt(line[0]);
        int s = Integer.parseInt(line[1]);
        
        int[] numArr = new int[n+1];
        line = br.readLine().split(" ");
        for(int i = 0; i<n; i++){
            numArr[i] =  Integer.parseInt(line[i]);
        }
        
        int left = 0, right = 0, sum = 0 , resultLen = numArr.length+1;
        while(left <= n && right <= n){
            if(sum>=s && resultLen>right-left) resultLen = right-left;
            
            if(sum < s) sum += numArr[right++];
            else sum -= numArr[left++];
        }
        if(resultLen==numArr.length+1) System.out.println(0);
        else System.out.println(resultLen);
    }
}