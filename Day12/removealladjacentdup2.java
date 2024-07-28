class Solution {
    public String removeDuplicates(String s, int k) {
        // Stack to store characters and their counts
        Stack<Pair> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().character == c) {
                // If the top of the stack has the same character, increase the count
                stack.peek().count++;
            } else {
                // Otherwise, push a new pair (character, count) onto the stack
                stack.push(new Pair(c, 1));
            }
            
            // If the count reaches k, pop the element from the stack
            if (stack.peek().count == k) {
                stack.pop();
            }
        }
        
        // Reconstruct the string from the stack
        StringBuilder sb = new StringBuilder();
        for (Pair pair : stack) {
            for (int i = 0; i < pair.count; i++) {
                sb.append(pair.character);
            }
        }
        
        return sb.toString();
    }
    
    // Helper class to store character and its count
    private static class Pair {
        char character;
        int count;
        
        Pair(char character, int count) {
            this.character = character;
            this.count = count;
        }
    }
}
