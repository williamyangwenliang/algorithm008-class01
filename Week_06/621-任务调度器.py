class Solution:
    '''
    解题思路：找出出现次数最多的任务，假设出现次数为 x
    计算至少需要的时间 (x - 1) * (n + 1)，记为 min_time
    计算出现次数为 x 的任务总数 count，计算最终结果为 res = min_time + count
    最终返回 max(res, len(tasks))
    '''
    def leastInterval(self, tasks: List[str], n: int) -> int:
        length = len(tasks)
        if length == 0: return length
        count_list = [0] * 26
        for task in tasks:
            # ord() 返回ASCII值
            count_list[ord(task) - ord('A')] += 1
        sorted_list = sorted(count_list, reverse=True)
        most_times = sorted_list[0]
        res = (most_times - 1) * (n + 1)
        for sl in sorted_list:
            if sl == most_times:
                res += 1
            else:
                break
        return max(res, length)