import java.io.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    static String word;
    static boolean[] visited;
    static int len;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        word = br.readLine();
        len = word.length();
        visited = new boolean[len];

        zoac(0, len-1);

        System.out.println(sb.toString());
    }

    private static void zoac(int left, int right) throws IOException {
        if (left > right) return;

        int nextFastWordIndex = left;
        // left와 right 사이에서 가장 빠른 글자 탐색
        for (int i = left; i <= right; i++) {
            if (word.charAt(nextFastWordIndex) > word.charAt(i)) {
                nextFastWordIndex = i;
            }
        }
        
        visited[nextFastWordIndex] = true;
        
        // 탐색 완료한 알파벳 차례로 StringBuilder에 append
        // for문 종료 후에 줄바꿈 append
        for (int i = 0; i < len; i++) {
            if (visited[i]) sb.append(word.charAt(i));
        }
        sb.append("\n");

        // 가장 빠른 문자의 오른쪽칸부터 right까지 탐색
        zoac(nextFastWordIndex + 1, right);
        // left부터 가장 빠른 문자의 왼쪽칸까지 탐색
        zoac(left, nextFastWordIndex  - 1);
    }
}