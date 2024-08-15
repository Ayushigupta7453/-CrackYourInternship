static int equalPartition(int N, int arr[]) {
    int sum = 0;
    for (int i = 0; i < N; i++) {
        sum += arr[i];
    }
    
    // If the sum is odd, partitioning into two equal subsets is impossible
    if (sum % 2 != 0) {
        return 0;
    }
    
    int target = sum / 2;
    boolean[][] dp = new boolean[N + 1][target + 1];
    
    // Initialize DP array
    for (int i = 0; i <= N; i++) {
        dp[i][0] = true; // Sum 0 can always be achieved with no elements
    }
    
    // Fill DP array
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= target; j++) {
            if (arr[i - 1] > j) {
                dp[i][j] = dp[i - 1][j]; // Exclude the current element
            } else {
                dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]]; // Include or exclude the current element
            }
        }
    }
    
    // The answer is whether we can form the sum `target` using all elements
    return dp[N][target] ? 1 : 0;
}
