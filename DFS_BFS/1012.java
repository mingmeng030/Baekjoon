import java.io.IOException;
import java.util.Scanner;

public class baechu{
    static int[][] adjacent; //컴퓨터 연결상태
    static boolean[][] checked; //확인 여부
    static int n,m,k,T,temp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        T = s.nextInt(); //테스트 개수 2

        for(int j=0; j<T; j++){
            m = s.nextInt(); //가로 10
            n = s.nextInt(); //세로 8
            k = s.nextInt(); //배추가 심어져 있는 위치 개수 17

            adjacent = new int[n][m]; // 직접 연결되어 있는 컴퓨터의 번호 쌍
            checked = new boolean[n][m]; //초기값 False

            temp=0;

            for(int i = 0; i <k; i++) {
                int x = s.nextInt();
                int y = s.nextInt();
                adjacent[y][x] = 1;
            }
            for(int t = 0; t < n; t++){
                for(int l = 0 ; l < m; l++){
                    if(checkLocation(t, l) == true) {
                        temp++;
                        dfs(t, l);
                    }
                }
            }
            sb.append(temp + "\n");
        }
        System.out.println(sb);
    }
    public static boolean checkLocation(int row, int col){
        //좌표 값이 잘못된 경우
        if(row < 0 || row >= n || col < 0 || col >= m) return false;
        //이미 지나간 경로인 경우 || 칸이 0인 경우
        if(checked[row][col] == true || adjacent[row][col] == 0) return false;
        return true;
    }
    public static void dfs(int x, int y) { //초기 : [시작점][1~정점 개수]만큼 반복
        checked[x][y]=true;
        if(checkLocation(x - 1, y)) dfs(x - 1, y);// '상'의 좌표
        if(checkLocation(x, y + 1)) dfs(x, y + 1);// '우'의 좌표
        if(checkLocation(x + 1, y)) dfs(x + 1, y);// '하'의 좌표
        if(checkLocation(x, y - 1)) dfs(x, y - 1);// '좌'의 좌표
    }
}

