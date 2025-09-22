import java.util.*;
import java.io.*;

class Programmers_42884 {
    public int solution(int[][] routes) {
        int cnt = 1;
        
        // 시작점으로 정렬
        // Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        Arrays.sort(routes, (o1, o2) -> o1[0] - o2[0]);
        
        int end = routes[0][1];
        
        for (int i = 1; i < routes.length; i++) {
            if (routes[i][0] <= end) {
                end = Math.min(routes[i][1], end);
            } else {
                cnt++;
                end = routes[i][1];
            }
        }
        
        return cnt;
    }
}