package Model;
import java.util.Random;

public class WhiteCowModel extends CowModel {
    private Random random = new Random();

    @Override
    public void bowl(int pins) {
        boolean falseReport = random.nextInt(10) < 1; // 10% chance
        if (falseReport && pins > 0) {
            pins = 10;
        }
        addScore(pins);// เพิ่มคะแนนที่ได้จากการโยน
    }
}
