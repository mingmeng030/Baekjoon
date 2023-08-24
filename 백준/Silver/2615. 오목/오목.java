import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int winner = 0, x = 0, y = 0;
         int[][] board = new int[19][19];

         for(int i=0; i<19; i++){
             String[] line = br.readLine().split(" ");
             for(int j=0; j<19; j++){
                board[i][j] = Integer.parseInt(line[j]);
             }
          }

        // 위에서 아래로 내려오므로 오른쪽, 오른쪽 대각선, 아래 check
        for(int i=0; i<19; i++){
            if(winner==1||winner==2) break;
            for(int j=0; j<19; j++){
                if(board[i][j]==0) continue;
                else if(board[i][j]==1){
                    if(isWon(i,j,1,board)==true) {
                        winner = 1;
                        x = i+1;
                        y = j+1;
                        break;
                    }
                }
                else if(board[i][j]==2){
                    if(isWon(i,j,2,board)==true) {
                        winner = 2;
                        x = i+1;
                        y = j+1;
                        break;
                    }
                }
            }
        }
		System.out.println(winner);
		if(winner!=0) System.out.println(x+" "+y);
    }
    public static boolean isWon(int i, int j, int now, int[][] board){
        int count = 1;
        
        // 가로로 5개인지 확인
        if(j<18){
            for(int k=j+1; k<19; k++){ // now의 오른쪽
                if(board[i][k]==now) count++;
                else break;
            }
        } 
        if(count==5) {
            if(j>0){
                if(board[i][j-1]==now) return false;
            }
            return true;
        }
        
        count = 1;
        // 세로로 5개인지 확인
        if(i<18){
            for(int k=i+1; k<19; k++){ // now의 아래쪽
                if(board[k][j]==now) count++;
                else break;
            }
        }
        if(count==5) {
            if(i>0){
                if(board[i-1][j]==now) return false;
            }
            return true;
        }

        count = 1;
        int m = i+1, n = j+1;
        while(m<19&&n<19){ // now의 오른쪽 아래 대각선
            if(board[m++][n++]==now) count++;
            else break;
        }
        if(count==5) {
            if(i>0&&j>0){
                if(board[i-1][j-1]==now) return false;
            }
            return true;
        }

        count = 1;
        m = i-1; 
        n = j+1;
        while(m>=0&&n<19){ // now의 오른쪽 위 대각선
            if(board[m--][n++]==now) count++;
            else break;
        }
        if(count==5) {
            if(i<18&&j>0){
                if(board[i+1][j-1]==now) return false;
            }
            return true;
        }
        return false;
    }
}