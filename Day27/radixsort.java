static void countingSortForRadix(int[] arr, int s) {
  int[] countingArray = {0,0,0,0,0,0,0,0,0,0};
  for (int i = 0; i < arr.length; i++)
    countingArray[(arr[i] / s) % 10]++;

  for (int i = 1; i < 10; i++)
    countingArray[i] += countingArray[i - 1];

  int[] outputArray = {0,0,0,0,0,0,0,0};
  for (int i = arr.length - 1; i >= 0; i--)
    outputArray[--countingArray[(arr[i] / s) % 10]] = arr[i];

  for (int i = 0; i < arr.length; i++)
    arr[i] = outputArray[i];
}
