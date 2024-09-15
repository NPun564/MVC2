package Model;
public class BrownCowModel extends CowModel {

    @Override
    public void bowl(int pins) {
        addScore(pins);
    }
}
