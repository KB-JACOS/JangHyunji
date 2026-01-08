class Programmers_42880 {
    public int[] solution(int[] answers) {
        int[] s1 = {1,2,3,4,5};           // len: 5
        int[] s2 = {2,1,2,3,2,4,2,5};     // len: 8
        int[] s3 = {3,3,1,1,2,2,4,4,5,5}; // len: 10
        
        int[] scores = new int[3];
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == s1[i % s1.length]) scores[0]++;
            if (answers[i] == s2[i % s2.length]) scores[1]++;
            if (answers[i] == s3[i % s3.length]) scores[2]++;
        }
        
        int max = Math.max(scores[0], Math.max(scores[1], scores[2]));
        
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (scores[i] == max) cnt++;
        }
        
        int[] answer = new int[cnt];
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            if (scores[i] == max) {
                answer[idx++] = i + 1;
            }
        }
        
        System.out.println(0 % 5);
        System.out.println(1 % 5);
        System.out.println(7 % 5);
        
        return answer;
    }
}