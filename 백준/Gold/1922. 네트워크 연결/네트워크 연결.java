import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 간선 정보 클래스
class Edge implements Comparable<Edge>{
	int v1;
	int v2;
	int weight;
	
	public Edge(int v1, int v2, int weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}
	
	// 가중치를 기준으로 오름차순 정렬
	@Override
	public int compareTo(Edge e) {
        return weight - e.weight;
    }
}
	
public class Main {
	static String[] line;
	static int n; // 정점의 개수
	static int m; // 간선의 개수
	static int[] root;
	static PriorityQueue<Edge> queue; // 간선 정보 저장
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    	
    	n = Integer.parseInt(br.readLine());
    	m = Integer.parseInt(br.readLine());
    	queue = new PriorityQueue<>();
    	root = new int[n + 1];
    	
    	// 부모노드 세팅
    	for(int i = 1; i <= n; i++) {
    		root[i] = i;
    	}
    	
    	// 간선 정보 입력
    	for(int i = 0; i < m; i++) {
    		line = br.readLine().split(" ");
    		int a = Integer.parseInt(line[0]);
    		int b = Integer.parseInt(line[1]);
    		int c = Integer.parseInt(line[2]);
    		queue.offer(new Edge(a,b,c));
    	}
    	
    	// 사이클 확인 (union-find)
    	int result = 0;
        while(!queue.isEmpty()) {
            // 가중치가 가장 작은 간선
            Edge cur = queue.poll(); 
            // 부모노드가 다르면 union으로 합집합에 추가 후 가중치 갱신
            if(find(cur.v1) != find(cur.v2)) {
                union(cur.v1, cur.v2);
                result += cur.weight;
            }
        }
        
        System.out.println(result);
    }   

    // 합치기
    public static void union(int v1, int v2) {
		int x = find(v1);
		int y = find(v2);
        
        if(x < y) root[y] = x;
        else root[x] = y;
    }
    
    // 부모 노드 찾기
    public static int find(int x) {
        if(root[x] == x) return x;
        return root[x] = find(root[x]);
    }
}