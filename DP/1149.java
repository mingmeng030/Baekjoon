import java.util.Scanner;

public class RGB{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int n=s.nextInt();

        int cost[][]=new int[n][3];
        int color[][]=new int[n][3];

        for(int i=0; i<n; i++){
            for(int j=0; j<3; j++){
                color[i][j]=s.nextInt();
            }
        }

        cost[0][0] = color[0][0];
        cost[0][1] = color[0][1];
        cost[0][2] = color[0][2];

        for(int i=1; i<n; i++) {
            cost[i][0]=Math.min(cost[i-1][1],cost[i-1][2]) + color[i][0];
            cost[i][1]=Math.min(cost[i-1][0],cost[i-1][2]) + color[i][1];
            cost[i][2]=Math.min(cost[i-1][0],cost[i-1][1]) + color[i][2];
        }

        System.out.println(Math.min(cost[n-1][0],Math.min(cost[n-1][1],cost[n-1][2])));
    }
}