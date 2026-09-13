class Solution {
    public int thirdMax(int[] arr) {
        int first = max(arr);

       
        if (distinctCount(arr) < 3) {
            return first;
        }

    
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == first) arr[i] = Integer.MIN_VALUE;
        }

        int second = max(arr);


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == second) arr[i] = Integer.MIN_VALUE;
        }

 
        return max(arr);
    }


    public int max(int[] arr) {
        int m = Integer.MIN_VALUE;
        for (int a : arr) {
            if (a > m) m = a;
        }
        return m;
    }


    private int distinctCount(int[] arr) {
        int count = 0;
        outer:
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] == arr[i]) continue outer;
            }
            count++;
        }
        return count;
    }
}