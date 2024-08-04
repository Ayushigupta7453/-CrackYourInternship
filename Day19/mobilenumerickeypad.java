class Solution {
    private long getCountUtil(char[][] keypad, int n) {
        if (keypad == null || n <= 0) return 0;
        if (n == 1) return 10;

        int[] row = {0, 0, -1, 0, 1};
        int[] col = {0, -1, 0, 1, 0};

       
        long[][] count = new long[10][n + 1];
        int i = 0, j = 0, k = 0, move = 0, ro = 0, co = 0, num = 0;
        long nextNum = 0, totalCount = 0;

        // count numbers starting with digit i and of lengths 0 and 1
        for (i = 0; i <= 9; i++) {
            count[i][0] = 0;
            count[i][1] = 1;
        }

        // Bottom up - Get number count of length 2, 3, 4, ... , n
        for (k = 2; k <= n; k++) {
            for (i = 0; i < 4; i++) {     // Loop on keypad row
                for (j = 0; j < 3; j++) { // Loop on keypad column
                    // Process for 0 to 9 digits
                    if (keypad[i][j] != '*' && keypad[i][j] != '#') {
                        
                        num = keypad[i][j] - '0';
                        count[num][k] = 0;

                        for (move = 0; move < 5; move++) {
                            ro = i + row[move];
                            co = j + col[move];
                            if (ro >= 0 && ro <= 3 && co >= 0 && co <= 2 &&
                                keypad[ro][co] != '*' && keypad[ro][co] != '#') {
                                nextNum = keypad[ro][co] - '0';
                                count[num][k] += count[(int)nextNum][k - 1];
                            }
                        }
                    }
                }
            }
        }

        
     
        totalCount = 0;
        for (i = 0; i <= 9; i++) totalCount += count[i][n];
        return totalCount;
    }

    public long getCount(int n) {
        char[][] keypad = {
            {'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}, {'*', '0', '#'}};

        return getCountUtil(keypad, n);
    }
}
