class Solution {
    public int solution(int n) {
        int answer = 0;
        // n을 3진법으로 바꾼다.
        String str = Integer.toString(n, 3);
        
        // 변환된 문자열을 뒤집는다.
        String rev = new StringBuilder(str).reverse().toString();
        
        // 뒤집은 수를 정수로 변환한다.
        answer = Integer.valueOf(rev, 3);
        return answer;
    }
}