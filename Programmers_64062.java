class Programmers_64062 {
    public int solution(int[] stones, int k) {
        int ans = 0;
        int min = 1;
        int max = 200000000;
        
        while (min <= max) {
            int mid = (min + max) / 2;
            if (canCross(mid, stones, k)) {
                ans = Math.max(ans, mid);
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        
        return ans;
    }
    
    boolean canCross(int mid, int[] stones, int k) {
        int num = 0;
        
        for (int i : stones) {
            if (i - mid < 0) num++;
            else num = 0;
            
            if (k == num) return false;
        }
        return true;
    }
}