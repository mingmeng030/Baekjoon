import java.io.*;
import java.util.*;
public class Main{
    static int[][] adjacent= new int[1001][1001]; //간선 연결상태
    static boolean[] checked= new boolean[1001]; //확인 여부
    static int n,m; //정점,간선개수,시작정점

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        n = s.nextInt(); //정점 개수 입력
        m = s.nextInt(); //간선 개수 입력

        //간선을 입력받아 인접 행렬에 저장
        for(int i = 0; i < m; i++) {
            int x = s.nextInt();
            int y = s.nextInt();
            //양방향 간선으로 (x,y)와 (y,x)는 같은 값을 갖는다
            adjacent[x][y] = adjacent[y][x] = 1;
        }

        int result=0;
        for(int i = 1; i <=n; i++) {
            if(checked[i]==false){
                dfs(i);
                result++;
            }
        }
        System.out.println(result);
    }

    public static void dfs(int idx) {
        if(checked[idx] == true) return; //확인한 정점을 1로 초기화
        else{
            checked[idx] = true;
            for(int i = 1; i <=n; i++)
                if(adjacent[idx][i] == 1) dfs(i);
        }
    }
}