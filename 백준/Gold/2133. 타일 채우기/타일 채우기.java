import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wall = new int[n+1];
        
        if(n%2==0){
            wall[0] = 1;
            wall[2] = 3;
            for(int i = 4; i<=n; i+=2){
                wall[i] += wall[i-2]*wall[2];
                for(int j = i-4; j>=0; j-=2){
                    wall[i] += wall[j]*2;
                }
            }
            System.out.print(wall[n]);
        }
        else System.out.print(0);
    }
}