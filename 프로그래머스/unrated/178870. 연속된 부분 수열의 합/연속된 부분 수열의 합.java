class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int resultLen = sequence.length+1;

        int min = 0, max = 0, sum = 0;
        while(true){
            if(sum >= k){
                sum -= sequence[min++];
            }
            else if(max>=sequence.length){
                break;
            }
            else if(sum<k){
                sum+= sequence[max++];
            }
            if(sum == k){
                if(max-min<resultLen){
                    answer[0] = min;
                    answer[1] = max-1;
                    resultLen = max-min;
                }
            }
        }

//         for(int i = dp.length-1; i>=0; i--){
//             for(int j = i-1; j>=0; j--){
//                 if(dp[i]-dp[j]==k){
//                     if(i-j<=resultLen){
//                         answer[0] = j;
//                         answer[1] = i-1;
//                         resultLen = i-j;
//                     }
//                 }
//             }
            
//         }
        
        return answer;
    }
}