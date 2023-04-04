class Solution {
    private static final int[] dx = {0,1,-1};
    private static final int[] dy = {1,0,-1}; // 아래쪽, 오른쪽, 왼쪽위
    
    public int[] solution(int n) {
        
        int[][] triangle = new int[n][n]; // 삼각형 만들 배열 선언
        int v = 1; // 채워넣을 숫자 -> 채워넣을 때마다 1씩 증가시킬 것.
        
        int x = 0;
        int y = 0; // 숫자를 채운 현재 위치
        int d = 0; // 인덱스의 방향 (0,1,2 => 아래쪽, 오른쪽, 왼쪽위)
        
        while(true){
            triangle[y][x] = v++;
            
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if(nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0){
                d = (d+1) % 3; // d = 0~2
                nx = x + dx[d];
                ny = y + dy[d];
                if(nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) break; // 모든 숫자가 다 채워졌을 때
            }
            x = nx;
            y = ny;
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