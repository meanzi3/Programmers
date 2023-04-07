class Solution {
    public String solution(String s) {
        
        StringBuilder builder = new StringBuilder();
        boolean toUpper = true;
        
        for(char c : s.toCharArray()){
            if(!Character.isAlphabetic(c)){
                builder.append(c);
                toUpper = true; // 공백 다음 문자는 무조건 대문자
            }else{
                if(toUpper){
                    builder.append(Character.toUpperCase(c));
                }else{
                    builder.append(Character.toLowerCase(c));
                }
                toUpper = !toUpper; // 다음 등장하는 문자의 대소문자는 현재 변환하는 문자와 반대
            }
        }
        return builder.toString();
    }
}