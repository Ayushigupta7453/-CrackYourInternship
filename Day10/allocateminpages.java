class Solution {
    // Function to find minimum number of pages.
    public static long findPages(int n, int[] arr, int m) {
        // Handle edge cases
        if (m > n) return -1; // More students than books
        
        // Initialize binary search boundaries
        int min = maxof(arr);
        int max = sumof(arr);
        long res = max;
        
        // Binary search to find the minimum possible maximum pages
        while (min <= max) {
            long mid = (min + max) / 2;
            if (feasible(arr, m, mid, n)) {
                res = mid;
                max = (int)mid - 1; // Try for a smaller maximum
            } else {
                min = (int)mid + 1; // Increase the minimum number of pages
            }
        }
        return res;
    }

    // Function to get maximum element from array
    public static int maxof(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    // Function to get sum of array elements
    public static int sumof(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    // Function to check if the current max pages assignment is feasible
    public static boolean feasible(int[] arr, int m, long res, int n) {
        int student = 1;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum + arr[i] > res) {
                student++;
                sum = arr[i];
                if (student > m) return false; // Exceeds the number of students
            } else {
                sum += arr[i];
            }
        }
        return true;
    }
}
