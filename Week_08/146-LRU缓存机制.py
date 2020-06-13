from collections import OrderedDict
'''
解题思路：利用有序字典OrderedDict辅助完成，往字典添加元素时如果字典已有该key则将其移到字典末尾并更新值，
当字典长度超出maxsize时，则弹出字典首部元素
'''
class LRUCache:

    def __init__(self, capacity: int):
        self.maxsize = capacity
        self.lru_dict = OrderedDict()

    def get(self, key: int) -> int:
        if self.lru_dict.get(key):
            self.lru_dict.move_to_end(key)
        return self.lru_dict.get(key, -1)

    def put(self, key: int, value: int) -> None:
        if self.lru_dict.get(key):
            self.lru_dict.move_to_end(key)
        self.lru_dict[key] = value
        if len(self.lru_dict) > self.maxsize:
            #此处默认是弹出末位元素，设置last=False后弹出首位元素
            self.lru_dict.popitem(last=False)



# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)