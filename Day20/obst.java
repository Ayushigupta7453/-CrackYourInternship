static int optCost(int freq[], int i, int j)
    {
       // Base cases
       if (j < i)      // no elements in this subarray
         return 0;
       if (j == i)     // one element in this subarray
         return freq[i];
      
       // Get sum of freq[i], freq[i+1], ... freq[j]
       int fsum = sum(freq, i, j);
      
       // Initialize minimum value
       int min = Integer.MAX_VALUE;
      
       // One by one consider all elements as root and 
           // recursively find cost of the BST, compare the 
           // cost with min and update min if needed
       for (int r = i; r <= j; ++r)
       {
           int cost = optCost(freq, i, r-1) + 
                          optCost(freq, r+1, j);
           if (cost < min)
              min = cost;
       }
      
       // Return minimum value
       return min + fsum;
    }
