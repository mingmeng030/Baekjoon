import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 간선 정보 클래스
class Edge implements Comparable<Edge>{
	int v1;
	int v2;
	double weight;
	
	public Edge(int v1, int v2, double weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}
	
	// 가중치를 기준으로 내림차순 정렬
	@Override
	public int compareTo(Edge e) {
        return Double.compare(this.weight, e.weight);
    }
}
	
public class Main {
	static int n,m;
	static int[] root;
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    	
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
            
        
        int[][] position = new int[n + 1][2]; 
        // 우주신 좌표 저장
        for(int i = 1; i <= n; i++) {
            line = br.readLine().split(" ");
            position[i][0] = Integer.parseInt(line[0]);
            position[i][1] = Integer.parseInt(line[1]);
        }
        
        // 부모노드자기 자신으로 초기화
        root = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            root[i] = i;
        }
        // 이미 연결된 간선 union
        for (int i = 0; i < m; i++) {
            line = br.readLine().split(" ");
            int s = Integer.parseInt(line[0]);
            int e = Integer.parseInt(line[1]);
            union(s, e);
        }

        // 연결할 수 있는 모든 통로를 큐에 추가
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        for (int i = 1; i < n; i++) {			
            for (int j = i + 1; j < n + 1; j++) {
                int x1 = position[i][0];
                int y1 = position[i][1];
                int x2 = position[j][0];
                int y2 = position[j][1];
				
                double weight = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
				
                queue.add(new Edge(i, j, weight));
            }
        }

        double result = 0;
        while (!queue.isEmpty()) {
            Edge cur = queue.poll();
            // 통로의 시작점과 끝점의 그룹을 합침(최상위 노드가 다를 경우)
            if (union(cur.v1, cur.v2)) {
                result += cur.weight; // 가중치를 더함
            }
        }
        System.out.println(String.format("%.2f", result));
    }   
        
    // 합치기
    public static boolean union(int v1, int v2) {
        int x = find(v1);
        int y = find(v2);
        
        if(x==y) return false;
        
        if(x < y) root[y] = x;
        else if(x > y) root[x] = y;
        return true;
    }
    
    // 부모 노드 찾기
    public static int find(int x) {
        if(root[x] == x) return x;
        return root[x] = find(root[x]);
    }
}