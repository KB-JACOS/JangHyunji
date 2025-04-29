class Programmers_92344 {
    public int solution(int[][] board, int[][] skill) {
        // 누적합 배열 생성
        int[][] sum = new int[board.length+1][board[0].length+1];
        
        // 2차원 누적합
        for (int i = 0; i < skill.length; i++) {
            int type = skill[i][0];
            int x1 = skill[i][1];
            int y1 = skill[i][2];
            int x2 = skill[i][3];
            int y2 = skill[i][4];
            int degree = skill[i][5];
            
            if (type == 1) {
                sum[x1][y1] -= degree;
                sum[x2+1][y1] += degree;
                sum[x1][y2+1] += degree;
                sum[x2+1][y2+1] -= degree;
            } else {
                sum[x1][y1] += degree;
                sum[x2+1][y1] -= degree;
                sum[x1][y2+1] -= degree;
                sum[x2+1][y2+1] += degree;
            }
        }
        
        // 위->아래 누적합 갱신
        for (int i = 0; i < sum[0].length; i++) {   // 열
            for (int j = 1; j < sum.length; j++) {  // 행
                sum[j][i] += sum[j-1][i];
            }
        }
        
        // 왼쪽->오른쪽 누적합 갱신
        for (int i = 0; i < sum.length; i++) {
            for (int j = 1; j < sum[0].length; j++) {
                sum[i][j] += sum[i][j-1];
            }
        }
        
        // 누적합과 초기값 더해서 결과 도출
        int answer = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sum[i][j] += board[i][j];
                if (sum[i][j] > 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}