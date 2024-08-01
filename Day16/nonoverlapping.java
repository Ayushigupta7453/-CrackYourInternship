if (intervals.length == 0) return 0;

        // Sort intervals by their end time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int count = 0;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                // Overlapping interval, increment count
                count++;
            } else {
                // Non-overlapping interval, update end
                end = intervals[i][1];
            }
        }

        return count;
