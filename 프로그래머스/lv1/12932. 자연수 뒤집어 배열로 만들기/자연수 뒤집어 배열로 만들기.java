class Solution {
    public int[] solution(long n) {
    
        String str = Long.toString(n);
        
        String revStr = new StringBuilder(str).reverse().toString();
        
        char[] arr = revStr.toCharArray();
        
        int[] answer = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            answer[i] = arr[i] - '0';
        }
        
        return answer;
    }
}