import java.io.*;
import java.util.*;

public class Main {
    static int V, E, K; // 정점, 간선, 탐색 시작 정점
    static ArrayList<ArrayList<Node>> graph;
    static int[] dist; 
    static final int MAX = 3000000; //300,000 * 10
    
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
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
 
        graph = new ArrayList<>();
        dist = new int[V + 1];
 
        Arrays.fill(dist, MAX);
 
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
 
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
 
            // 단방향 인접 리스트
            graph.get(start).add(new Node(end, cost));
        }
        
        dijkstra(K);
        
        for(int i = 1; i<=V; i++){
            if(dist[i]==MAX) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }
    public static void dijkstra(int start) {
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
            

                for (Node node : graph.get(cur)) {
                    if( dist[node.idx] > dist[cur] + node.value){
                        dist[node.idx] = dist[cur] + node.value;
                        queue.add(new Node(node.idx, dist[node.idx]));
                    }
                }
            
    	  }
    }
}