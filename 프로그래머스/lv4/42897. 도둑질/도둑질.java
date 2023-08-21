class Solution {
    public int solution(int[] money) {
        // 첫 번째 집부터 시작
        int[] DP1 = new int[money.length]; 
        // 첫 번째 집을 넘기고 두 번째 집부터 시작
        int[] DP2 = new int[money.length]; 
        
        DP1[0] = money[0];
        DP1[1] = money[0];
        DP2[1] = money[1];
        
        for(int i=2; i<money.length; i++){
            DP1[i] = Math.max(DP1[i-1], DP1[i-2]+money[i]);
            DP2[i] = Math.max(DP2[i-1], DP2[i-2]+money[i]);
        }
        // for(int i=0; i<money.length; i++){
        //     System.out.print(DP1[i]+" ");
        // }        
        // System.out.println();
        // for(int i=0; i<money.length; i++){
        //     System.out.print(DP2[i]+" ");
        // }
        return Math.max(DP1[money.length-2],DP2[money.length-1]);
    }
}