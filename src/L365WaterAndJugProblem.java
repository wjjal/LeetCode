/**
 * Created by Administrator on 2016/6/25.
 */
public class L365WaterAndJugProblem {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z > x + y) {
            return false;
        }
        int gcd_x_y = gcd(x, y);
        if (z == 0 && gcd_x_y == 0) {
            return true;
        } else if (gcd_x_y != 0 && z % gcd_x_y == 0) {
            return true;
        }
        return false;
    }

    public int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
}
