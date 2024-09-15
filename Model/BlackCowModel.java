package Model;
import java.util.Random;

public class BlackCowModel extends CowModel {
    private Random random = new Random();

    @Override
    public void bowl(int pins) {
        boolean falseReport = random.nextInt(5) < 1; // 20% chance
        if (falseReport) {
            pins = 10;
        }
        addScore(pins);
    }
}



