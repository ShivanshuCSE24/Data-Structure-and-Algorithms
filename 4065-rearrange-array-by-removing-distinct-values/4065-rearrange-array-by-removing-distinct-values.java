
class Solution {
    public int[] rearrangeArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        int[] temp = new int[map.size()];
        int p = 0;
        for(int i:map.keySet()){
            temp[p++] = i;
        }
        Arrays.sort (temp);

        int ans[] = new int[nums.length];

        int k = 0;

        while(!map.isEmpty()){
            for(int i: temp){
                if(!map.containsKey(i)){
                    continue;
                }
                ans[k++] = i;
                int freq = map.get(i);
                if (freq == 1){
                    map.remove(i);
                }else{
                    map.put(i,freq - 1);
                }
            }
        }
        return ans;
    }
}