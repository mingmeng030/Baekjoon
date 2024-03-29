import java.io.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        while(T -- > 0){
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int d = Integer.parseInt(line[1]);

            if(d < 0) d += 360;
            d = (Math.abs(d)%360)/45;

            int[][] arr = new int[n][n];
            int[][] copiedArr = new int[n][n];
            
            for(int i = 0 ; i < n ; i++){
                String[] num = br.readLine().split(" ");
                for(int j = 0 ; j < n ; j++){
                    arr[i][j] = Integer.parseInt(num[j]);
                    copiedArr[i][j] = arr[i][j];
                }
            }

            while(d -- > 0){
                for(int i = 0; i < n ; i++){
                    copiedArr[i][n/2] = arr[i][i];
                    copiedArr[i][i] = arr[n/2][i];
                    copiedArr[n/2][i] = arr[n-i-1][i];
                    copiedArr[n-i-1][i] = arr[n-i-1][n/2];
                }

                for(int i = 0; i < n ; i++){
                    for(int j = 0 ; j < n ; j++){
                        arr[i][j] = copiedArr[i][j];
                    }
                }
            }
            for(int[] row : arr){
                for(int col : row)
                    sb.append(col + " ");
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}