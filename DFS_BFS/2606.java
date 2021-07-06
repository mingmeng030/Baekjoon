import java.io.IOException;
import java.util.Scanner;

public class virus{
    static int[][] adjacent; //컴퓨터 연결상태
    static boolean[] checked; //확인 여부
    static int n,m,num=0;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        n = s.nextInt(); //컴퓨터 수
        m = s.nextInt(); //직접 연결 되어 있는 컴퓨터 수

        adjacent = new int[n+1][n+1]; // 직접 연결되어 있는 컴퓨터의 번호 쌍
        checked = new boolean[n+1]; //초기값 False

        //연결된 컴퓨터 쌍 각각의 번호를 입력받아 인접 행렬에 저장
        for(int i = 0; i < m; i++) {
            int x = s.nextInt();
            int y = s.nextInt();
            //양방향 간선으로 (x,y)와 (y,x)는 같은 값을 갖는다
            adjacent[x][y] = adjacent[y][x] = 1;
        }
        dfs(1); //시작점 : 1
        System.out.println(num);
    }

    public static void dfs(int i) { //초기 : [시작점][1~정점 개수]만큼 반복
        checked[i]=true;
        for (int j = 1; j <= n; j++) {
            if (adjacent[i][j] == 1 && checked[j] == false) {
                num++;
                dfs(j);
            }
        }
    }
}

