import java.util.*;

class SnakeGame2 {
    int width, height;
    List<int[]> food;
    List<int[]> snake;
    int[] dirc = {0, 1, 0, -1, 0};
    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame2(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        snake = new LinkedList<>();
        snake.add(new int[] {0, 0});
        this.food = new LinkedList<>(Arrays.asList(food));
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] pos = snake.get(0);
        int dir = 0;
        switch (direction) {
            case "U" : dir = 3; break;
            case "L" : dir = 2; break;
            case "D" : dir = 1; break;
            case "R" : dir = 0; break;
        }
        int[] next = new int[] {pos[0] + dirc[dir], pos[1] + dirc[dir + 1]};
        if (!food.isEmpty() && Arrays.equals(next,food.get(0))) {
            food.remove(0);
        } else {
            snake.remove(snake.size() - 1);
        }
        if (isValid(next)) {
            snake.add(0, next);
        } else {
            snake.clear();
        }
        return snake.size() - 1;
    }
    private boolean isValid(int[] next) {
        if (next[0] < 0 || next[1] < 0 || next[0] >= height || next[1] >= width) {
            return false;
        }
        for (int[] body : snake) {
            if (Arrays.equals(body,next)) {
                return false;
            }
        }
        return true;
    }
}