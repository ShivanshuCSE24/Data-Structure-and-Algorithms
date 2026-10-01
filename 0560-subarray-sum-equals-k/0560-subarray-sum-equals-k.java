class Solution {
    public int subarraySum(int[] nums, int k) {
       int p=0; 
        int count=0;
        HashMap <Integer,Integer> map=new HashMap<>();
        map.put(0,1); 
        for(int i=1;i<=nums.length;i++){ 
            p+=nums[i-1]; 
            int reqPre=p-k; 
            if(map.containsKey(reqPre)){
                count+=map.get(reqPre);
            }
            map.put(p,map.getOrDefault(p,0)+1);
        
        }
        return count;
    }
}