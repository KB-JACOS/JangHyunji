class Programmers_92344 {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int colSize = board[0].length;
        int rowSize = board.length;
        
        // 누적합 배열 생성
        int[][] sum = new int[board.length+1][board[0].length+1];
        
        // 2차원 누적합
        for (int[] s : skill) {
            int x1 = s[1];
            int y1 = s[2];
            int x2 = s[3];
            int y2 = s[4];
            int degree;
            if (s[0] == 1) {
                degree = -s[5];
            } else {
                degree = s[5];
            }
            
            sum[x1][y1] += degree;
            sum[x2+1][y1] -= degree;
            sum[x1][y2+1] -= degree;
            sum[x2+1][y2+1] += degree;
        }
        
        // 위->아래 누적합 갱신
        for (int i = 0; i < colSize; i++) {   // 열
            for (int j = 1; j < rowSize; j++) {  // 행
                sum[j][i] += sum[j-1][i];
            }
        }
        
        // 왼쪽->오른쪽 누적합 갱신
        for (int i = 0; i < rowSize; i++) {
            for (int j = 1; j < colSize; j++) {
                sum[i][j] += sum[i][j-1];
            }
        }
        
        // 누적합과 초기값 더해서 결과 도출
        
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                sum[i][j] += board[i][j];
                if (sum[i][j] > 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}