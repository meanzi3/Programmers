import java.util.*;

class Solution { 
    // 좌표 객체 생성
    private static class Point{
        public final long x, y;
        private Point(long x, long y){
            this.x = x;
            this.y = y;
        }   
    }  
    
    // 교점 좌표 구하기
    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2){
        // 교점 좌표 구하기
        double x = (double) (b1*c2-b2*c1) / (a1*b2-a2*b1);
        double y = (double) (a2*c1-a1*c2) / (a1*b2-a2*b1);
        
        // 교점 좌표 값이 정수가 아니라면 null 반환
        if(x % 1 != 0 || y % 1 != 0) return null;
        
        return new Point((long)x, (long)y); // 교점 좌표 값이 정수하면 Point 객체를 반환
    }
    
    // 가장 작은 x,y 좌표 찾기
    private Point getMinimumPoint(List<Point> points){
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;
        
        for(Point p : points){
            if(p.x < x) x = p.x;
            if(p.y < y) y = p.y;
        }
        
        return new Point(x, y); // 가장 작은 x, y 값을 찾고, Point 객체로 만들어 반환
    }
    
    // 가장 큰 x,y 좌표 찾기
    private Point getMaximumPoint(List<Point> points){
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;
        
        for(Point p : points){
            if(p.x > x) x = p.x;
            if(p.y > y) y = p.y;
        }
        
        return new Point(x, y); // 가장 큰 x, y 값을 찾고, Point 객체로 만들어 반환
    }
    
    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        
        for(int i = 0; i <line.length; i++){
            for(int j = i + 1; j < line.length; j++){
                Point intersection = intersection(line [i][0], line[i][1], line[i][2], line[j][0], line[j][1],line[j][2]);
                if(intersection != null) points.add(intersection); // 객체가 반환 되었을 때 리스트에 저장
            }
        }
        
        Point minimum = getMinimumPoint(points);
        Point maximum = getMaximumPoint(points);
        
        // 2차원 배열의 크기 결정
        int width = (int) (maximum.x - minimum.x +1); // 배열 크기를 구하는 것이므로 +1
        int height = (int) (maximum.y - minimum.y +1);
        
        char[][] arr = new char[height][width];
        for(char[] row : arr){
            Arrays.fill(row,'.');
        }
        
        for(Point p : points){
            int x = (int) (p.x - minimum.x);
            int y = (int) (maximum.y - p.y);
            arr[y][x] = '*';
        }
        
        String[] result = new String[arr.length];
        for(int i = 0; i < result.length; i++){
            result[i] = new String(arr[i]);
        }
        
        return result;
    }
}
