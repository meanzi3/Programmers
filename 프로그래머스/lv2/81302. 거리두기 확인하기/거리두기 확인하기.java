class Solution {
    
    private static final int dx[] = {0,-1,-1,0};
    private static final int dy[] = {-1,0,0,1}; // 상좌우하 dx, dy 값 => 반대방향 인덱스끼리 더했을 때 3이 되도록 설정.
    
    private boolean isDistanced(char[][] room, int x, int y){
        // room[y][x]가 거리두기를 지키는지 검사한다.
        for(int d = 0; d < 4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
            // room[ny][nx]가 다른 응시자에게 도달하는지 검사
            switch(room[ny][nx]){
                case 'P' : return false;
                case 'O' : // 빈 테이블과 붙어있는 곳 중 응시자가 있다만 거리두기를 지키지 않은 것. (원래 검사를 시작했던 응시자 제외, 상하좌우)
                    if(isNextToVolunteer(room, nx, ny, 3-d)) return false;
                    break;
            }
        }
        return true;
    }
    // 거리두기 검사 함수
    private boolean isDistanced(char[][] room){
        for(int i = 0; i < room.length; i++){
            for(int j = 0; j < room[i].length; j++){
                if(room[i][j] != 'P') continue; // 응시자가 앉아 있지 않은 위치들은 검사를 건너뛴다.
                // 거리두기 검사 - 지키지 않으면 false 반환
                if(!isDistanced(room, j, i)) return false;
            }
        }
        // 지키면 true 반환
        return true;
    }
    
    // 빈 테이블과 인접한 위치 중 응시자가 있는지 확인하는 함수
    private boolean isNextToVolunteer(char[][] room, int x, int y, int exclude){
        for(int d = 0; d < 4; d++){
            if(d == exclude) continue; // 원래 검사를 시작했던 방향 제외
            
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
            if(room[ny][nx] == 'P') return true;
        }
        return false;
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i = 0; i < answer.length; i++){
            String[] place = places[i]; // 대기실 하나 하나 검사
            char[][] room = new char[place.length][];
            for(int j = 0; j < room.length; j++){
                room[j] = place[j].toCharArray();
            }
            // 거리두기 검사 결과 답 작성
            if(isDistanced(room)){
                answer[i] = 1;
            }else{
                answer[i] = 0;
            }
        }
        return answer;
    }
}