class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int index = 0, now = 0;
        
         for(int i=0; i<number.length()-k; i++){
            now = 0;
            for(int j=index; j<=i+k; j++){ 
                if(now < number.charAt(j)-'0'){
                    now = number.charAt(j)-'0';
                    index = j+1;
                }    
            }
            sb.append(now);
        }
        return sb.toString();
    }
}