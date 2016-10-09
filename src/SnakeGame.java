import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by michaelzhang on 10/8/16.
 */
public class SnakeGame {
    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    private boolean gameOver;
    private int[][] food;
    private int foodGet;
    private int width, height;
    private HashSet<Integer> usedMap;//判断是否撞上身体，用HashSet保存
    private Deque<Position> queue; //Snake头尾同时变化，所以用双端队列保存位置

    private class Position {
        public int x, y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        gameOver = false;
        foodGet = 0;
        usedMap = new HashSet<Integer>();
        this.food = food;
        queue = new LinkedList<Position>();//Deque是接口，要用LinkedList实现
        usedMap.add(0);//
        queue.offer(new Position(0, 0));

        //如果（0，0）处有food，则snake吃到的Food数加一
        if (food.length > 0 && food[foodGet][0] == 0 && food[foodGet][1] == 0) {
            foodGet++;
        }
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        if (gameOver) {
            return -1;
        }
        int incx = 0, incy = 0;
        switch (direction) {
            case "U": incx = -1; incy = 0; break;//每一个按键操作，其实都是在对变量负值
            case "L": incx = 0; incy = -1; break;
            case "R": incx = 0; incy = 1; break;
            case "D": incx = 1; incy = 0; break;
            default: break;
        }
        int x = queue.peekLast().x + incx, y = queue.peekLast().y + incy;
        if (x >= 0 && x < height && y >= 0 && y < width) {//判断是否在界内
            queue.offerLast(new Position(x, y)); //队尾加入新Position
            if (foodGet < food.length && x == food[foodGet][0] && y == food[foodGet][1]) {//如果（X, Y）处有food
                foodGet++;
            } else {
                usedMap.remove(queue.peekFirst().x * width + queue.peekFirst().y);//先把snake尾部的坐标去除，然后再判断新（X，Y）是否已存在。
                // 即使在首尾相接的Corner Case中，也不会有错误。
                queue.pollFirst();//队首去除，直观体现就是，snake在向前移动
            }
            if (usedMap.contains(x * width + y)) { //x * width是从（0，0）开始，一行一行数下来，x的总个数。加上y之后，可以保证唯一性。
                return -1;
            } else {
                usedMap.add(x * width + y);
            }
            return foodGet;//返回已经吃到的food数
        } else {
            gameOver = true;//如果超出边界，gameOver变成true
            return -1;
        }
    }
}
