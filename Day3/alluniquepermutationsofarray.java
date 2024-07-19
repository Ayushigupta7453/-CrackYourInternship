import java.util.*;

class Solution {
    public List<List<Integer>> uniquePerms(int[] arr, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        boolean[] taken = new boolean[n];
        
        helper(arr, n, 0, cur, taken, ans);
        
        Collections.sort(ans, (a, b) -> {
            for (int i = 0; i < a.size(); i++) {
                if (!a.get(i).equals(b.get(i))) {
                    return a.get(i) - b.get(i);
                }
            }
            return 0;
        });
        
        return ans;
    }

    private void helper(int[] arr, int n, int p, List<Integer> cur, boolean[] taken, List<List<Integer>> ans) {
        if (p == n) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        
        boolean[] cur_taken = new boolean[11];
        
        for (int i = 0; i < n; i++) {
            if (!taken[i] && !cur_taken[arr[i]]) {
                cur_taken[arr[i]] = true;
                taken[i] = true;
                cur.add(arr[i]);
                helper(arr, n, p + 1, cur, taken, ans);
                cur.remove(cur.size() - 1);
                taken[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1, 1, 2};
        List<List<Integer>> result = sol.uniquePerms(arr, arr.length);
        for (List<Integer> perm : result) {
            System.out.println(perm);
        }
    }
}
