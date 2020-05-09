class Solution {
    /**
     * 解题思路：把障碍点放到集合中，如果机器人下一步是障碍点，则停止前进 等待下一步指令；
     * 确定机器人移动的4个方向每前进一步x与y值的变化，根据command的值一步步移动即可
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        //上下左右四个方向分别移动一步x与y值的增量
        //int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[] xm = {0, 1, 0, -1};
        int[] ym = {1, 0, -1, 0};
        //x，y：机器人位置；max：记录与原点的最远距离；index：对应上面数组的下标
        int x = 0, y = 0, max = 0, index = 0;
        //这里因为x和y的值不超过30000，又因为数字类型计算hashcode比字符串更快，所以这里value用数字类型，用Long防止溢出
        Set<Long> obsSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obsSet.add((long) obstacle[0] * 100000 + obstacle[1]);
        }
        for (int command : commands) {
            if (command == -1) {
                index = (index + 1) % 4;
            } else if (command == -2) {
                index = (index + 3) % 4;
            } else if (command > 0) {
                for (int i = 0; i < command; i++) {
                    int nextx = x + xm[index];
                    int nexty = y + ym[index];
                    if (obsSet.contains((long) nextx * 100000 + nexty)) break;
                    x = nextx;
                    y = nexty;
                    //因为是返回与原点的最远距离而不是终点与原点的距离，这里每走一步都比较一下
                    max = Math.max(max, x * x + y * y);
                }
            }
        }
        return max;
    }
}