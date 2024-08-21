import java.util.Random;

public class Player {
    private int number;
    private float x;
    private float y;
    private float z = 0.0F;

    public Player(int number, float x, float y){
        this.number = number;
        this.x = x;
        this.y = y;
    }

    public void move(float x, float y){
        this.x += x;
        this.y += y;
    }

    public void jump(float z){
        this.z += z;
    }

    public boolean nearBall(Ball ball){
        if ((Math.abs(ball.getX() - x) < 8) && (Math.abs(ball.getY() - y) < 8) && (Math.abs(ball.getZ() - z) < 8)){
            return true;
        }
        else{
            return false;
        }
    }

    public void kick(Ball ball){
        Random rand = new Random();
        if (nearBall(ball)){
            ball.setXYZ(ball.getX() + (rand.nextFloat() * 10), ball.getY() + (rand.nextFloat() * 10), 0);
        }
    }

    public String toString() {
        return "Player{" +
                "number=" + number +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}