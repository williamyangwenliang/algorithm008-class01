class Solution {
    /**
     * 解题思路：将字符串数组里的字符串转成字节数组再排序，排序后相同的即为异位词，
     * 将排好序的字节数组组成字符串作为key，原字符串依次存到key对应的list集合中即可完成分类
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resultList = new ArrayList<>();
        Map<String, List<String>> gaMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (gaMap.get(key) == null) {
                List<String> gaList = new ArrayList<>();
                gaList.add(strs[i]);
                gaMap.put(key, gaList);
            } else {
                gaMap.get(key).add(strs[i]);
            }
        }
        resultList.addAll(gaMap.values());
        return resultList;
    }
}