import java.util.*;

class Solution {

    void fun(List<Integer> nums,
             List<Integer> temp,
             List<List<Integer>> ans) {

     
        if (nums.size() == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.size(); i++) {

      
            if (i > 0 && nums.get(i).equals(nums.get(i - 1))) {
                continue;
            }

            List<Integer> newNums = new ArrayList<>(nums);
            List<Integer> newTemp = new ArrayList<>(temp);

            newTemp.add(nums.get(i));

         
            newNums.remove(i);

            fun(newNums, newTemp, ans);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {

    
        List<Integer> list = new ArrayList<>();

        for (int x : nums) {
            list.add(x);
        }

      
        Collections.sort(list);

        List<List<Integer>> ans = new ArrayList<>();

        fun(list, new ArrayList<>(), ans);

        return ans;
    }
}