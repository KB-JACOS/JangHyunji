import java.util.*;

class Programmers_42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        
        int maxDay = 0;     // 현재 배포 기준일
        int cnt = 0;
        
        for (int i = 0; i < progresses.length; i++) {
            int remains = 100 - progresses[i];
            int days = (int) Math.ceil((double) remains / speeds[i]);
            
            if (i == 0) {
                maxDay = days;
            }
            
            if (days <= maxDay) {
                cnt++;
            } else {
                result.add(cnt);
                cnt = 1;
                maxDay = days;
            }
        }
        
        result.add(cnt);    // loop 내에서는 maxDay이 갱신될 때만 추가하므로 마지막 배포 추가 필요
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}