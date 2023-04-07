class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        int arr[]=new int [k];
        HashMap<Integer,Integer>set=new HashMap<>();
        for(int i=0;i<n;i++){
            set.put(nums[i],set.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer>heap=new PriorityQueue<>(new Comparator<Integer>(){
            public  int compare(Integer a,Integer b){
                return set.get(a)-set.get(b);
            }

        });
        for(int x:set.keySet()){
            heap.add(x);
            if(heap.size()>k){
                heap.poll();
            }
        }
        for(int i=0;i<k;i++){
            arr[i]=heap.poll();
        }
return arr;
    }
}
