import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char [][] bomb = new char[n][n];
        char [][] map = new char[n][n];
        int [] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int [] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        boolean flag = false;
		
        for(int i = 0; i < n ; i++){
            String line = br.readLine();
            for(int j = 0; j < n; j++) {
                bomb[i][j] = line.charAt(j);
            }
        }

        for(int i = 0; i < n ; i++){
            String now = br.readLine();
            for(int j = 0; j < n; j++) {
                if(now.charAt(j) == '.') map[i][j] = '.';
                else if(now.charAt(j) == 'x') { 
                    if(bomb[i][j] == '*') flag = true;
                    else { 
                        int count = 0; 
                        for (int k = 0; k < 8; k++) { 
                            int newx = i + dx[k];
                            int newy = j + dy[k];
                            if (newx >= 0 && newx < n && newy >= 0 && newy < n && bomb[newx][newy] == '*') 
                                count++;
                        }
                        map[i][j] = (char) (count + '0');
                    }
                }
            }
        }

        if(flag) { 
            for(int i = 0; i < n ; i++){
                for(int j = 0; j < n; j++) {
                    if(bomb[i][j] == '*') map[i][j] = '*';
                }
            }
        }

        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}