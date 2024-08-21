public class Main {
    public static void main(String[] args) {

        Ball ball = new Ball(10,20,0);

        Player messi = new Player(30, 35, 25);

        System.out.println(ball.getX());
        System.out.println(ball.getY());
        System.out.println(ball.getZ());
        System.out.println(ball);
        System.out.println(messi);

        messi.move(-20,0);

        System.out.println(messi);
        System.out.println(messi.nearBall(ball));

        messi.kick(ball);

        System.out.println(ball);

        messi.jump(80);

        System.out.println(messi);
    }
}