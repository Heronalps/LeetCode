import java.util.Objects;

/**
 * Created by michaelzhang on 2/1/17.
 */
class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        Point point = (Point) obj;
        return this.x == point.x && this.y == point.y;
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

