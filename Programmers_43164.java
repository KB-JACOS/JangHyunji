import java.util.*;

class Programmers_43164 {
    List<String> ansRoute;
    boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        ansRoute = new ArrayList<>();
        visited = new boolean[tickets.length];
        
        dfs("ICN", "ICN", tickets, 0);
        
        Collections.sort(ansRoute);     // 가능한 루트 중 알파벳 순서 먼저 사용하기 위한 정렬
        String[] ans = ansRoute.get(0).split(" ");
        
        return ans;
    }
    
    void dfs(String dep, String route, String[][] tickets, int cnt) {
        // 탈출 조건: tickets을 다 씀
        if (cnt == tickets.length) {
            ansRoute.add(route);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && dep.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, cnt + 1);
                visited[i] = false;
            }
        }
    }
}