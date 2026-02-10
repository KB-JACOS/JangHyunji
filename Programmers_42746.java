import java.util.*;

class Programmers_42746 {
    public String solution(int[] numbers) {
        List<String> list = new ArrayList<>();
        for (int num : numbers) {
            list.add(String.valueOf(num));
        }
        
        Collections.sort(list, (a, b) -> (b + a).compareTo(a + b));     // 내림차순
        
        // 예외 처리: 전부 0인 경우
        if (list.get(0).equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
        }    

        return sb.toString();
    }
}