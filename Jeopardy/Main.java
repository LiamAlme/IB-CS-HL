import java.awt.*;

public class Main extends Easyapp {
    public static void main(String[] args) {
        new Main();
    }

    Label lJeopardy = addLabel("Jeopardy", 60, 30, 200, 60, this);

    Label lScore1 = addLabel("Player 1 Score", 300, 30, 50, 30, this);
    TextField tScore1 = addTextField("0", 350, 30, 80, 30, this);
    Label lScore2 = addLabel("Player 2 Score", 300, 60, 50, 30, this);
    TextField tScore2 = addTextField("0", 350, 60, 80, 30, this);
    TextField tTurn = addTextField("Player 1's Turn", 200, 100, 100, 50, this);
    Button bScience = addButton("Science 100", 50, 150, 100, 50, this);
    Button bScience2 = addButton("Science 200", 50, 200, 100, 50, this);
    Button bScience3 = addButton("Science 300", 50, 250, 100, 50, this);
    Button bSports = addButton("Sports 100", 150, 150, 100, 50, this);
    Button bSports2 = addButton("Sports 200", 150, 200, 100, 50, this);
    Button bSports3 = addButton("Sports 300", 150, 250, 100, 50, this);
    Button bHistory = addButton("History 100", 250, 150, 100, 50, this);
    Button bHistory2 = addButton("History 200", 250, 200, 100, 50, this);
    Button bHistory3 = addButton("History 300", 250, 250, 100, 50, this);
    Button bMath = addButton("Math 100", 350, 150, 100, 50, this);
    Button bMath2 = addButton("Math 200", 350, 200, 100, 50, this);
    Button bMath3 = addButton("Math 300", 350, 250, 100, 50, this);

    Button bPlayAgain = addButton("Play again", 50, 300, 400, 50, this);

    int score = 0;
    int score1 = 0;
    int score2 = 0;
    int turn = 1;

    public Main()   // Constructor - change window appearance
    {
        setSize(500, 500);
        setTitle("Jeopardy");
        lJeopardy.setFont(new Font("Arial", 1, 36));
        lJeopardy.setBackground(new Color(17, 0, 255));
        lJeopardy.setForeground(new Color(255, 255, 0));
        lScore1.setBackground(new Color(100, 100, 150));
        lScore2.setBackground(new Color(100, 100, 150));
        setBackground(new Color(17, 0, 255));
        bScience.setFont(new Font("Arial", 1, 16));
        bScience2.setFont(new Font("Arial", 1, 16));
        bScience3.setFont(new Font("Arial", 1, 16));
        bMath.setFont(new Font("Arial", 1, 16));
        bMath2.setFont(new Font("Arial", 1, 16));
        bMath3.setFont(new Font("Arial", 1, 16));
        bHistory.setFont(new Font("Arial", 1, 16));
        bHistory2.setFont(new Font("Arial", 1, 16));
        bHistory3.setFont(new Font("Arial", 1, 16));
        bSports.setFont(new Font("Arial", 1, 16));
        bSports2.setFont(new Font("Arial", 1, 16));
        bSports3.setFont(new Font("Arial", 1, 16));
        bPlayAgain.setFont(new Font("Arial", 1, 16));

    }

    public void actions(Object source, String command) {
        if (source == bScience) {
            science();
        }
        if (source == bScience2) {
            science2();
        }
        if (source == bScience3) {
            science3();
        }
        if (source == bSports) {
            sports();
        }
        if (source == bSports2) {
            sports2();
        }
        if (source == bSports3) {
            sports3();
        }
        if (source == bHistory) {
            history();
        }
        if (source == bHistory2) {
            history2();
        }
        if (source == bHistory3) {
            history3();
        }
        if (source == bMath) {
            math();
        }
        if (source == bMath2) {
            math2();
        }
        if (source == bMath3) {
            math3();
        }
        if (source == bPlayAgain) {
            bScience.setEnabled(true);
            bHistory.setEnabled(true);
            bSports.setEnabled(true);
            bMath.setEnabled(true);
            bScience2.setEnabled(true);
            bHistory2.setEnabled(true);
            bSports2.setEnabled(true);
            bMath2.setEnabled(true);
            bScience3.setEnabled(true);
            bHistory3.setEnabled(true);
            bSports3.setEnabled(true);
            bMath3.setEnabled(true);
            score = 0;
        }
        if(turn==-1 && score != 0){
            score1 += score;
            tTurn.setText("Player 2's Turn");
            score = 0;
        }
        if(turn==1 && score != 0){
            score2 += score;
            tTurn.setText("Player 1's Turn");
            score = 0;
        }
        tScore1.setText(score1 + "");
        tScore2.setText(score2 + "");
    }

    public void science() {
        String guess = inputString("f = ma is a ________ law");
        if (guess.equalsIgnoreCase("physics")) {
            score = score + 100;
            output("Right!");
        } else {
            score = score - 100;
            output("Wrong...");
        }
        turn *= -1;

        bScience.setEnabled(false);
    }
    public void science2() {
        String guess = inputString("Who created the first nuclear bomb?");
        if (guess.equalsIgnoreCase("Oppenheimer")||guess.equalsIgnoreCase("Robert Oppenheimer")) {
            score = score + 200;
            output("Right!");
        } else {
            score = score - 200;
            output("Wrong...");
        }
        turn *= -1;

        bScience2.setEnabled(false);
    }
    public void science3() {
        String guess = inputString("What does DNA stand for?");
        if (guess.equalsIgnoreCase("Deoxyribonucleic acid")) {
            score = score + 300;
            output("Right!");
        } else {
            score = score - 300;
            output("Wrong...");
        }
        turn *= -1;

        bScience3.setEnabled(false);
    }

    public void sports() {
        String guess = inputString("What sport did Pele play?");
        if (guess.equalsIgnoreCase("soccer") || guess.equalsIgnoreCase("football")) {
            score = score + 100;
            output("Right!");
        } else {
            score = score - 100;
            output("Wrong...");
        }
        turn *= -1;
        bSports.setEnabled(false);
    }
    public void sports2()
    {
        int guess = inputInt("What is a perfect score in bowling?");
        if ( guess == 300 )
        {
            score = score + 200;
            output("Right!");
        }
        else
        {
            score = score - 200;
            output("Wrong... " );
        }
        turn *= -1;
        bSports2.setEnabled(false);
    }
    public void sports3()
    {
        int bet = inputInt("DAILY DOUBLE, How many points do you bet?");
        if(turn == 1){
            if(bet>score1){
                bet = score1;
            }
        }
        if(turn == -1){
            if(bet>score2){
                bet = score2;
            }
        }
        String guess = inputString("Who is the GOAT?");
        if (guess.equalsIgnoreCase("Lebron") || guess.equalsIgnoreCase("Lebron James"))
        {
            score = score + bet;
            output("Right!");
        }
        else
        {
            score = score - bet;
            output("Wrong... " );
        }
        turn *= -1;
        bSports3.setEnabled(false);
    }
    public void history() {
        int guess = inputInt("What year did WWII end?");
        if (guess == 1945) {
            score = score + 100;
            output("Right!");
        } else {
            score = score - 100;
            output("Wrong... ");
        }
        turn *= -1;
        bHistory.setEnabled(false);
    }
    public void history2() {
        String guess = inputString("Which Roman Emperor was betrayed and assassinated?");
        if (guess.equalsIgnoreCase("Caesar") || guess.equalsIgnoreCase("Julius Caesar")) {
            score = score + 200;
            output("Right!");
        } else {
            score = score - 200;
            output("Wrong... ");
        }
        turn *= -1;
        bHistory2.setEnabled(false);
    }
    public void history3() {
        String guess = inputString("Who wrote The Guns of August?");
        if (guess.equalsIgnoreCase("Barbara Tuchman") || guess.equalsIgnoreCase("Tuchman")) {
            score = score + 300;
            output("Right!");
        } else {
            score = score - 300;
            output("Wrong... ");
        }
        turn *= -1;
        bHistory3.setEnabled(false);
    }

    public void math() {
        int guess = inputInt("What is 5! ?");
        if (guess == 120) {
            score = score + 100;
            output("Right!");
        } else {
            score = score - 100;
            output("Wrong...");
        }
        turn *= -1;
        bMath.setEnabled(false);
    }

    public void math2() {
        String guess = inputString("What are the first five digits of Pi?");
        if (guess.equals("3.1415")) {
            score = score + 200;
            output("Right!");
        } else {
            score = score - 200;
            output("Wrong...");
        }
        turn *= -1;
        bMath2.setEnabled(false);
    }

    public void math3() {
        String guess = inputString("What is the derivative of 3x^5?");
        if (guess.equalsIgnoreCase("15x^4")) {
            score = score + 300;
            output("Right!");
        } else {
            score = score - 300;
            output("Wrong...");
        }
        turn *= -1;
        bMath3.setEnabled(false);
    }
}
