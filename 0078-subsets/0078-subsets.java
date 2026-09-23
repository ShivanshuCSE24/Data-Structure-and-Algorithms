class Solution {

    void func(int[] nums, int index,
              List<Integer> current,
              List<List<Integer>> ans) {

     
        if (index == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

       
        current.add(nums[index]);
        func(nums, index + 1, current, ans);

       
        current.remove(current.size() - 1);
        func(nums, index + 1, current, ans);
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        func(nums, 0, new ArrayList<>(), ans);

        return ans;
    }
}