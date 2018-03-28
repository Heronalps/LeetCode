import java.util.*;

class SnakeGame2 {
    int width, height;
    List<int[]> food; // 预设的food位置，list中用一维2元素数组表示坐标点
    List<int[]> snake; // snake body所有的坐标点
    int[] dirc = {0, 1, 0, -1, 0};

    public SnakeGame2(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        snake = new LinkedList<>();
        snake.add(new int[] {0, 0}); // 起点
        this.food = new LinkedList<>(Arrays.asList(food));
        // asList把二维数组的第一维，转换成List
    }
    public int move(String direction) {
        int[] pos = snake.get(0); // 蛇头位置
        int dir = 0;
        switch (direction) {
            case "U" : dir = 3; break;
            case "L" : dir = 2; break;
            case "D" : dir = 1; break;
            case "R" : dir = 0; break;
        }
        int[] next = new int[] {pos[0] + dirc[dir], pos[1] + dirc[dir + 1]};
        if (!food.isEmpty() && Arrays.equals(next,food.get(0))) {
            // 注意，两个数组比较，要用Arrays.equals

            food.remove(0); // 吃food的情况
        } else {
            snake.remove(snake.size() - 1);
            // 如果没有food，正常行进，就缩进蛇尾
        }
        if (isValid(next)) {
            snake.add(0, next); // 只要合法就加入
        } else {
            snake.clear();
        }
        return snake.size() - 1;
        // 巧妙，因为snake长度记录了food数量，而且包含了Gameover -1的情况。
    }
    private boolean isValid(int[] next) {
        if (next[0] < 0 || next[1] < 0 || next[0] >= height || next[1] >= width) {
            return false; // 越界
        }
        for (int[] body : snake) {
            if (Arrays.equals(body,next)) {
                return false; // 因为已经缩进了蛇尾，所以遍历整个List
            }
        }
        return true;
    }
}