import java.util.*;

class Programmers_72416 {
    List<Integer>[] child;
    int[][] cost;
    
    public int solution(int[] sales, int[][] links) {
        int size = sales.length;
        child = new ArrayList[size + 1];
        for (int i = 1; i <= size; i++) {
            child[i] = new ArrayList<>();
        }
        
        for (int[] link : links) {
            child[link[0]].add(link[1]);
        }
        
        // dp 테이블 초기화 -> 참석
        cost = new int[size + 1][2];
        dfs(1, sales);
        
        return Math.min(cost[1][0], cost[1][1]);
    }
    
    void dfs(int cur, int[] sales) {
        cost[cur][1] = sales[cur - 1];  // 참석 비용
        
        if (child[cur].isEmpty()) return;
        
        int extra = Integer.MAX_VALUE;
        
        for (int c : child[cur]) {
            dfs(c, sales);  // 자식 재귀 호출
            
            if (cost[c][0] < cost[c][1]) {  // 해당 팀원 X
                cost[cur][1] += cost[c][0];     // O - X
                cost[cur][0] += cost[c][0];     // X - X
                
                extra = Math.min(extra, cost[c][1] - cost[c][0]);   // 증가분 계산
            } else {                        // 해당 팀원 O
                cost[cur][1] += cost[c][1];     // O - O
                cost[cur][0] += cost[c][1];     // X - O
                
                extra = 0;  // 자식 중 이미 참석이 이득인 사람이 있어, 부모 불참 비용에 불필요하게 추가되지 않도록
            }
        }
        
        cost[cur][0] += extra;  // X - X인 경우 한 명이라도 참석하도록 변경
        return;
    }
}