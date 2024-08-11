for (int i = 0; i < n; i++) {
            // Process all elements that are greater than the current element
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                int idx = st.pop();
                int range;
                if (st.isEmpty()) {
                    range = i;
                } else {
                    range = i - st.peek() - 1;
                }
                ans[range - 1] = Math.max(ans[range - 1], arr[idx]);
            }
            // Push the current index onto the stack
            st.push(i);
        }

        // Process remaining elements in the stack
        while (!st.isEmpty()) {
            int idx = st.pop();
            int range;
            if (st.isEmpty()) {
                range = n;
            } else {
                range = n - st.peek() - 1;
            }
            ans[range - 1] = Math.max(ans[range - 1], arr[idx]);
        }

        // Fill the result array for smaller windows
        for (int i = n - 2; i >= 0; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }

        return ans;
