class Solution {
    public int[] solution(int brown, int yellow) {
        int height = 0, width = 0;
        for(int i =1; i<(brown+4)/2; i++){
            int min = i;
            int max = (brown+4)/2-i;
            // System.out.println("min : "+min+" max : "+max);
            if(min*max==brown+yellow){
                height = max;
                width = min;
                break;
            }
        }
        int[] answer = {height, width};
        return answer;
    }
}