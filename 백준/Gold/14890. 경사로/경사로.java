import java.io.*;
import java.util.*;
 
class Main { 
    static int n, L;
    static int[][] map;
    static int count = 0;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[n][n];
 
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
							map[i][j] = Integer.parseInt(st.nextToken());
						}
        }
 
        for (int i=0; i<n; i++) {
					if (check(i, 0, 0)) count++; // 행
					if (check(0, i, 1)) count++; // 열
        }
 
        System.out.println(count);
    }
 
    static boolean check(int x, int y, int d) {
        int[] height = new int[n];
        boolean[] visited = new boolean[n];     // 경사로가 이미 놓여있는지 체크
 
        // 알아보기 쉽게 height 배열에 옮기기
        for (int i=0; i<n; i++) {
            height[i] = (d == 0) ? map[x][y+i] : map[x+i][y];
        }
 
        for (int i=0; i<n-1; i++) {
            // 높이가 같으면 패스
            if (height[i] == height[i+1]) continue;
            
						// 높이가 두 칸 이상 차이날 때
            if (Math.abs(height[i] - height[i+1]) > 1) return false;
 
            // 내려가는 경사
            if (height[i]-height[i+1]==1) {
                for (int j=i+1; j<=i+L; j++) {
                    // j가 범위를 벗어나거나 높이가 다르거나 이미 경사로가 있는 경우
                    if (j >= n || height[i+1] != height[j] || visited[j] == true) {
                        return false;
                    } 
                    visited[j] = true;
                }
            }
            // 올라가는 경사
            else if (height[i] - height[i+1]==-1) {
                for (int j=i; j>i-L; j--) {
                    if (j < 0 || height[i] != height[j] || visited[j] == true) {
                        return false;
                    }
                    visited[j] = true;
                }
            }            
        }
 
        return true;
    }
}
