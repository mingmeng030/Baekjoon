import java.io.*;
import java.util.*;

public class Main {
    static int N, E;
    static ArrayList<ArrayList<Node>> graph;
    static int[] dist; 
    static boolean[] check; // 방문 확인
    static final int MAX = 200000000; //200,000 * 1,000
    
    static class Node{
		int idx, value;
		public Node(int idx, int value) {
			this.idx = idx;
			this.value = value;
		}
	}
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
 
        graph = new ArrayList<>();
        dist = new int[N + 1];
        check = new boolean[N + 1];
 
        Arrays.fill(dist, MAX);
 
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
 
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
 
            // 양방향 인접 리스트
            graph.get(start).add(new Node(end, cost));
            graph.get(end).add(new Node(start, cost));
        }
 
        // 반드시 거쳐야 하는 정점.
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        
        // 1->v1->v2->N
        int route1 = 0;
        route1+=dijkstra(1,v1);
        route1+=dijkstra(v1,v2);
        route1+=dijkstra(v2,N);
        
        // 1->v2->v1->N
        int route2 = 0;
        route2+=dijkstra(1,v2);
        route2+=dijkstra(v2,v1);
        route2+=dijkstra(v1,N);
        
        System.out.println((route1 >= MAX && route2 >= MAX) ? -1 : Math.min(route1, route2));
    }
        public static int dijkstra(int start, int end) {
            Arrays.fill(dist, MAX);
            Arrays.fill(check, false);
            
    	    PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {	
	    		@Override
	    		public int compare(Node o1, Node o2) {
	    			return o1.value - o2.value;
	    		}
		    });
            
    	    queue.add(new Node(start,0));
    	    dist[start] = 0;	
                    
    	    while(!queue.isEmpty()) {
    		    Node now = queue.poll();
                int cur = now.idx;
            
                if(!check[cur]){
                    check[cur] = true;
                    for (Node node : graph.get(cur)) {
                    // 방문한적 없는 노드이고
                    // 저장된 node의 최소 경로보다 (cur의 최소경로+cur에서 node로 가는 거리)가 더 짧을 때
                    // node의 최소 경로를 (cur의 최소경로+cur에서 node로 가는 거리)로 갱신, queue에 삽입
                        if(!check[node.idx] && dist[node.idx] > dist[cur] + node.value){
                            dist[node.idx] = dist[cur] + node.value;
                            queue.add(new Node(node.idx, dist[node.idx]));
                        }
                    }
                }
    	    }
    	    return dist[end];
        }
}