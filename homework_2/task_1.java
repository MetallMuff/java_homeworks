class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(n < k) return result;
        int[] arr = new int[n];
        for(int i = 1; i <= n; i++)
            arr[i - 1] = i;
        backtrace(k, 0, arr, new ArrayList<Integer>(), result);
        return result;
    }
    private static void backtrace(int k, int start, int[] arr, List<Integer> list, List<List<Integer>> result){
        if(k == 0) result.add(new ArrayList<Integer>(list));
        else{
            for(int i = start; i <= arr.length - k; i++){
                list.add(arr[i]);
                backtrace(k - 1, i + 1, arr, list, result);
                list.remove(list.size() - 1);
            }
        }
    }
}