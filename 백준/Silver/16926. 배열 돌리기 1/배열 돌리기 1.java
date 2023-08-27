import java.io.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] dx = {0, 1, 0, -1}; // 우 하 좌 상 (←↓→↑)
        int[] dy = {1, 0, -1, 0}; // 우 하 좌 상
        
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int r = Integer.parseInt(line[2]);
        
        int[][] arr = new int[n][m];
        int[][] copiedArr = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            String[] num = br.readLine().split(" ");
            for(int j = 0 ; j < m ; j++){
                arr[i][j] = Integer.parseInt(num[j]);
                copiedArr[i][j] = arr[i][j];
            }
        }
        
        int rotate = Math.min(n,m)/2;
        
        while(r -- > 0){
            for(int i = 0; i < rotate ; i++){
                int x = i, y = i, index = 0;
                int firstValue = arr[x][y];

                while(index<4){
                    int nx = x + dx[index];
                    int ny = y + dy[index];
                    if(nx>=i && ny>=i && nx<n-i && ny<m-i){
                        arr[x][y] = arr[nx][ny];
                        x = nx;
                        y = ny;
                    }
                    else index++;
                }
                arr[i+1][i] = firstValue;
            }
        }

        for(int i = 0; i < n ; i++){
            for(int j = 0 ; j < m; j++){
               sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}