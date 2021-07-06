import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    static int[][] checked; //확인 여부
    static int[][] map;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static int n, count; //정점,간선개수,시작정점
    static ArrayList<Integer> list = new ArrayList<Integer>();

    public static int dfs(int row, int col) {
        checked[row][col] = 1; //확인한 정점을 1로 초기화

        for(int i=0;i<4;i++) {
            int nx = row+dx[i], ny = col+dy[i];

            if(nx>=0 && ny>=0 && nx<n && ny<n) {
                if(map[nx][ny] == 1 && checked[nx][ny] == 0){
                    dfs(nx,ny);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt(); //지도 크기
        checked=new int[n][n];
        map=new int[n][n];

        for(int i=0;i<n;i++) {
            String input = s.next();
            for(int j=0;j<n;j++)
                map[i][j] = input.charAt(j)-'0';
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++)
                if(map[i][j] == 1 && checked[i][j] == 0){
                    count = 1;
                    dfs(i,j);
                    list.add(count);
                }
        }

        Collections.sort(list);
        System.out.println(list.size());

        for(int i=0;i<list.size();i++)
            System.out.println(list.get(i));

    }
}