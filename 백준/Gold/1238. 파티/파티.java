import java.io.*;
import java.util.*;

public class Main {
    static int N, M, X;
    static ArrayList<ArrayList<Node>> graph;
    static int[] dist; 
    static boolean[] check;
    static final int MAX = Integer.MAX_VALUE;
    
    static class Node implements Comparable<Node>{
		int idx, value;
		public Node(int idx, int value) {
			this.idx = idx;
			this.value = value;
        }
        public int compareTo(Node o) {
			return this.value - o.value; // 오름차순 정렬
		}
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
 
        graph = new ArrayList<>();
        dist = new int[N + 1];
        check = new boolean[N + 1];
 
        Arrays.fill(dist, MAX);
 
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
 
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, cost));
        } 
        
        int maxRoute = 0;
        for(int i = 1; i<=N; i++){
            int result = 0;
            result+=dijkstra(i,X);
            result+=dijkstra(X,i);
            
            maxRoute = Math.max(maxRoute, result);
        }
        System.out.println(maxRoute);
    }
    public static int dijkstra(int start, int end) {
        Arrays.fill(dist, MAX);
        Arrays.fill(check, false);
            
        PriorityQueue<Node> queue = new PriorityQueue<Node>();
            
        queue.add(new Node(start,0));
        dist[start] = 0;	
        
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            int cur = now.idx;
            
            if(!check[cur]){
	          check[cur] = true;
                for (Node node : graph.get(cur)) {
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