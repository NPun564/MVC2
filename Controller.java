import Model.WhiteCowModel;
import java.util.Random;
import Model.BlackCowModel ;
import Model.BrownCowModel ;
import Model.CowModel;
import java.util.ArrayList;
import java.util.List;


public class Controller {
    private View view;
    private CowModel[] whiteCows;
    private CowModel[] blackCows;
    private CowModel[] brownCows;

    public Controller(View view) {
        this.view = view;
        this.whiteCows = new WhiteCowModel[3];
        this.blackCows = new BlackCowModel[3];
        this.brownCows = new BrownCowModel[3];

        for (int i = 0; i < 3; i++) {
            whiteCows[i] = new WhiteCowModel();
            blackCows[i] = new BlackCowModel();
            brownCows[i] = new BrownCowModel();
        }
    }

    public void playGame() {
        Random random = new Random();
        // ลูป 10 รอบ
        for (int round = 1; round <= 10; round++) {
            // ลูปสำหรับการโยน 2 ครั้งในแต่ละรอบ
            for (int throwNumber = 0; throwNumber < 2; throwNumber++) {
                for (int i = 0; i < 3; i++) {
                    int pins = random.nextInt(11);
                    whiteCows[i].bowl(pins);
                    blackCows[i].bowl(pins);
                    brownCows[i].bowl(pins);
                }
            }

            view.displayScores(String.valueOf(round), whiteCows, blackCows, brownCows);
        }

        // แสดงการจัดอันดับหลังจากจบเกม
        List<CowModel> allCows = mergeAllCows(whiteCows, blackCows, brownCows);
        view.displayRanking(allCows.toArray(new CowModel[0]));
        view.displayTeamRanking(new CowModel[][]{whiteCows, blackCows, brownCows});
    }
    // รวมวัวทั้งหมดจากหลายทีม
    private List<CowModel> mergeAllCows(CowModel[]... teams) {
        List<CowModel> allCows = new ArrayList<>();
        for (CowModel[] team : teams) {
            for (CowModel cow : team) {
                allCows.add(cow);
            }
        }
        return allCows;
    }
}
