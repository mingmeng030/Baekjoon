import java.io.*;
import java.util.*;
public class dfs_bfs{
    static int[][] adjacent; //간선 연결상태
    static boolean[] checked; //확인 여부
    static int n,m,start,num; //정점,간선개수,시작정점

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        n = s.nextInt(); //정점 개수 입력
        m = s.nextInt(); //간선 개수 입력
        start = s.nextInt(); //시작점 입력

        adjacent = new int[1001][1001]; //좌표를 그대로 받기 위해 +1한 크기로 선언
        checked = new boolean[1001]; //초기값 False

        //간선을 입력받아 인접 행렬에 저장
        for(int i = 0; i < m; i++) {
            int x = s.nextInt();
            int y = s.nextInt();
            //양방향 간선으로 (x,y)와 (y,x)는 같은 값을 갖는다
            adjacent[x][y] = adjacent[y][x] = 1;
        }
        dfs(start);

        checked = new boolean[1001];
        System.out.println();

        bfs();
    }

    //시작점을 변수로 받아 확인, 출력 후 다음 연결점을 찾아 시작점을 변경하여 재호출
    public static void dfs(int i) {
        checked[i] = true; //확인한 정점을 1로 초기화
        System.out.print(i + " "); //확인한 정점 출력

        //초기 : [시작점][1~정점 개수]만큼 반복
        for(int j = 1; j <= n; j++) {
            if(adjacent[i][j] == 1 && checked[j] == false) {
                dfs(j);
            }
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start); //add 대신 offer 사용(실패할 경우 false를 return)
        checked[start] = true;
        System.out.print(start + " ");

        //Queue가 빌 때까지 반복. 방문 정점은 확인, 출력 후 Queue에 넣어 순서대로 확인
        while (!queue.isEmpty()) {
            int temp = queue.poll(); //remove 대신 poll 사용(실패할 경우 false를 return)

            for (int j = 1; j <= n; j++) {
                if (adjacent[temp][j] == 1 && checked[j] == false) {
                    queue.offer(j);
                    checked[j] = true;
                    num++;
                    if(num==n) break;
                    System.out.print(j + " ");
                }
            }
            if(num==n) break;
        }
    }
}
