class Solution {
    public int[] solution(int n) {
        
        int[][] triangle = new int[n][n]; // 삼각형 만들 배열 선언
        int v = 1; // 채워넣을 숫자 -> 채워넣을 때마다 1씩 증가시킬 것.
        
        int x = 0;
        int y = 0; // 숫자를 채운 현재 위치
        
        while(true){
            // 아래로
            while(true){
                triangle[y][x] = v++;
                if(y+1 == n || triangle[y+1][x] != 0)  break; // 더 이상 아래로 이동할 수 없을 때 빠져나옴
                y += 1;    
            }
            // 아래쪽으로 진행하는 마지막 진행 방향일 경우
            if(x+1 == n || triangle[y][x+1] != 0) break; // 오른쪽으로도 진행할 수 없는 경우에 빠져나옴
            x += 1; 
            
            // 오른쪽으로
            while(true){
                triangle[y][x] = v++;
                if(x + 1 == n || triangle[y][x+1] != 0) break; // 더 이상 오른쪽으로 이동할 수 없을 때 빠져나옴
                x += 1;
            }
            // 오른쪽으로 진행하는 마지막 진행 방향일 경우
            if(triangle[y-1][x-1] != 0) break; // 왼쪽 위로도 진행할 수 없는 경우에 빠져나옴
            x -= 1;
            y -= 1;
            
            // 왼쪽위로
            while(true){
                triangle[y][x] = v++;
                if(triangle[y-1][x-1] != 0) break; // 더 이상 왼쪽 위로 이동할 수 없을 때 빠져나옴
                x -= 1;
                y -= 1;
            }
            if(y+1 == n || triangle[y+1][x] != 0) break; // 아래쪽으로도 진행할 수 없는 경우 빠져나옴
            y += 1;
        }
        
        int[] answer = new int[v-1];
        
        int index = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                answer[index++] = triangle[i][j];
            }
        }
        
        return answer;
    }
}