class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        def back_trace(queue_list, row):
            if row == n: 
                res.append([''.join(q) for q in queue_list])
                return
            for col in range(n):
                if not check(queue_list, row, col): continue
                queue_list[row][col] = 'Q'
                back_trace(queue_list, row +1)
                queue_list[row][col] = '.'
        def check(queue_list, row, col):
            for i in range(row):
                if queue_list[i][col] == 'Q': return False
            for i,j in zip(range(row, -1, -1),range(col, -1, -1)):
                if queue_list[i][j] == 'Q': return False
            for i,j in zip(range(row, -1, -1),range(col, n)):
                if queue_list[i][j] == 'Q': return False
            return True
        res = []
        queue_list = [['.' for i in range(n)] for i in range(n)]
        back_trace(queue_list,0)
        return res