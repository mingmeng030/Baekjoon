import java.io.*;
import java.util.*;

// 간선 정보 자료구조
class Edge implements Comparable<Edge>{
	int v1, v2, weight;
	
	public Edge(int v1, int v2, int weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}
	
	// 가중치를 기준으로 내림차순 정렬
	@Override
	public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}

public class Main {
	static int n,m, islandCnt;
	static int[][] map;
	static int[] root;
	static Queue<int[]> queue;
	static PriorityQueue<Edge> pq = new PriorityQueue<>(); ;
	static boolean[][] check;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
            line = br.readLine().split(" ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		islandCnt = 2;
		check = new boolean[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]==1 && !check[i][j]) {
					islandIndexing(j, i, islandCnt);
					islandCnt++;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]!=0) {
					makeBridge(j, i, map[i][j]);
				}
			}
		}
		
		islandCnt--;
		root = new int[islandCnt];
		for(int i=1; i<islandCnt; i++) {
			root[i] = i;
		} 
		int answer = shortestPath();
		System.out.println(answer == 0 ? -1 : answer);
		
	}
	
	// 1번 로직 (그래프 색칠) 
	static void islandIndexing(int x, int y, int idx) {
		queue = new LinkedList<>();
		
		queue.add(new int[] {x,y});
		map[y][x] = idx;
		check[y][x] = true;
		
		while(!queue.isEmpty()) {
			int[] p = queue.poll();
			int px = p[0];
			int py = p[1];
			
			for(int i=0; i<4; i++) {
				int nx = px + dx[i];
				int ny = py + dy[i];
				
				if(nx<0 || ny <0 || nx > m-1 || ny > n-1 || check[ny][nx]) continue;
				
				if(map[ny][nx]==1) {
					map[ny][nx] = idx;
					check[ny][nx] = true;
					queue.add(new int[] {nx,ny});
				}
			}
		}
	}
    
	// 2번 로직 (그래프 연결) 
	static void makeBridge(int x, int y, int idx) {
		queue = new LinkedList<>();	
		check = new boolean[n][m];
		for(int d=0; d<4; d++) {
			queue.add(new int[] {x,y,0});
			check[y][x] = true;
			
			while(!queue.isEmpty()) {
				int[] p = queue.poll();
				int px = p[0];
				int py = p[1];
				int move = p[2];
				
				int nx = px + dx[d];
				int ny = py + dy[d];
				
				if(nx<0 || ny <0 || nx > m-1 || ny > n-1 || check[ny][nx]) continue;
				
				if(map[ny][nx]!=idx) {
					if(map[ny][nx] !=0) {
						int v1 = idx-1;
						int v2 = map[ny][nx]-1;
						int bridgeLength = move;
						if(bridgeLength>1) {		
							pq.add(new Edge(v1, v2, bridgeLength));
							break;
						}
					}
                    else {
						check[ny][nx] = true;
						queue.add(new int[] {nx, ny, move+1});
					}
				}
			}
			queue.clear();
		}
	}

	// 3번 로직 (최소 신장트리 -크루스칼) 
	static int shortestPath() {
		int sum =0;
		int size = pq.size();
		for(int i=0; i< size; i++) {
			Edge cur = pq.poll();
			int x = cur.v1;
			int y = cur.v2;
			
			if(find(x) != find(y)) {
				sum += cur.weight;
				union(x,y);
			}
		}
		
		// int rx = root[1];
		for(int i=2; i<islandCnt; i++) {
			if(root[1] != find(root[i])) {
				return 0;
			}
		}
		return sum;
	}
	
	
	public static int find(int x) {
        if(root[x] == x) return x;
        return root[x] = find(root[x]);
    }
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x<y) root[y]=x;
		else root[x] =y;
	}
}