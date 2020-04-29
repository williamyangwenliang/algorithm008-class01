class Solution {
    /**
     * 解题思路：先使用map记录各数字出现的频次，再利用优先队列进行排序，最后将队列前k个数返回即可
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> tkfMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            tkfMap.put(nums[i], tkfMap.getOrDefault(nums[i], 0) + 1);
        }
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> tkfMap.get(b) - tkfMap.get(a));
        tkfMap.keySet().forEach(key->queue.offer(key));
        int[] tkfa = new int[k];
        for (int i = 0; i < tkfa.length; i++) {
            tkfa[i] = queue.poll();
        }
        return tkfa;
    }
}