import java.io.*;
import java.util.*;

class Main {
		// dirN : N번 CCTV가 한 번에 감시할 수 있는 방향 
    private static final int[][] dir1 = {{0}, {1}, {2}, {3}}; 
    private static final int[][] dir2 = {{0, 2}, {1, 3}}; 
    private static final int[][] dir3 = {{3, 0}, {0, 1}, {1, 2}, {2, 3}};
    private static final int[][] dir4 = {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}}; 
    private static final int[] dir5 = {0, 1, 2, 3}; 

    private static int[][] arr;
    private static int N, M, answer;

    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      arr = new int[N][M];
			answer= Integer.MAX_VALUE;
      boolean[][] visit = new boolean[N][M];
      int total = 0;

      for (int i = 0; i < N; i++) {
          st = new StringTokenizer(br.readLine(), " ");
          for (int j = 0; j < M; j++) {
              arr[i][j] = Integer.parseInt(st.nextToken());
              if (arr[i][j] != 0) {
                  visit[i][j] = true; // 이미 CCTV나 벽인 칸은 사각지대가 될 수 없으므로 방문 처리해준다.
                  if (arr[i][j] != 6) { // CCTV의 개수를 기록해준다.
                      total ++;
                  }
              }
          }
      }

      findCctv(0, visit, total);

      System.out.println(answer);
  }

    // 조합을 이용하여 가능한 모든 경우를 계산한다.
	private static void findCctv(int idx, boolean[][] visit, int remain) {
		if (remain == 0) { // 모든 CCTV를 찾으면 탐색 종료
			answer = Math.min(answer, getBlindSpot(visit));
			return;
		}

    for (int i = idx; i < N * M; i++) {
			int x = i / M;
			int y = i % M;

			int cctv = arr[x][y];

			// search 함수는 방향에 따라 볼 수 있는 모든 방향을 탐색하고, visit 배열을 리턴한다.
			// 다음 칸(idx + 1)부터 아직 발견하지 않은 CCTV를 찾는다. (남아있는 CCTV 개수 - 1)을 인자로 넘긴다.
			if (cctv != 0 && cctv != 6) {
				if (cctv == 1) {
					for (int[] arr : dir1) {
						findCctv(i + 1, search(x, y, arr, visit), remain - 1);
					}
				} 
				else if (cctv == 2) {
					for (int[] arr : dir2) {
						findCctv(i + 1, search(x, y, arr, visit), remain - 1);
					}
				} 
				else if (cctv == 3) {
					for (int[] arr : dir3) {
						findCctv(i + 1, search(x, y, arr, visit), remain - 1);
					}
				} 
				else if (cctv == 4) {
					for (int[] arr : dir4) {
						findCctv(i + 1, search(x, y, arr, visit), remain - 1);
					}
				} 
				else if (cctv == 5) {
					findCctv(i + 1, search(x, y, dir5, visit), remain - 1);
				}
			}
		}
	}

	// CCTV로 볼 수 있는 칸을 기록 함수
	private static boolean[][] search(int x, int y, int[] dir, boolean[][] visit) {
		boolean[][] copy = new boolean[N][M];

		// 원래 visit 배열이 함께 업데이트되지 않도록 배열 복사
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = visit[i][j];
			}
		}

		// 갈 수 있는 모든 방향을 탐색한다.
		for (int d : dir) {
			if (d == 0) { // 북
				for (int i = x; i >= 0; i--) {
					if (arr[i][y] == 6) break;
					copy[i][y] = true;
				}
			} 
			else if (d == 1) { // 동
				for (int i = y; i >= 0; i--) {
					if (arr[x][i] == 6) break;
					copy[x][i] = true;
				}
			} 
			else if (d == 2) { // 남
				for (int i = x; i < N; i++) {
					if (arr[i][y] == 6) break;
					copy[i][y] = true;
				}
			} 
			else if (d == 3) { // 서
				for (int i = y; i < M; i++) {
					if (arr[x][i] == 6) break;
					copy[x][i] = true;
				}
			}
		}
		return copy;
	}

    // 사각지대 계산 함수
    public static int getBlindSpot(boolean[][] visit) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visit[i][j]) count ++;
            }
        }
        return count;
    }
}