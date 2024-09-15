import Model.BlackCowModel;
import Model.BrownCowModel;
import Model.CowModel;
import Model.WhiteCowModel;
import java.util.Arrays;
import java.util.Comparator;

public class View {

     // แสดงคะแนนของวัวแต่ละตัวในรอบที่กำหนด
    public void displayScores(String round, CowModel[] whiteCows, CowModel[] blackCows, CowModel[] brownCows) {
        // แสดงหมายเลขรอบที่กำลังเล่นอยู่
        System.out.println("Round " + round);
        // สร้าง StringBuilder เพื่อเก็บข้อมูลคะแนนและข้อมูลการโยนในรอบนี้
        StringBuilder sb = new StringBuilder();
         // ลูปเพื่อดึงข้อมูลคะแนนของวัวในแต่ละทีม
        for (int i = 0; i < 3; i++) {
            sb.append("WriteCowNo.").append(i + 1).append(" Score: ").append(whiteCows[i].getScores()[whiteCows[i].getCurrentRound() - 1]).append(" -> ");
            sb.append("BlackCowNo.").append(i + 1).append(" Score: ").append(blackCows[i].getScores()[blackCows[i].getCurrentRound() - 1]).append(" -> ");
            sb.append("BrownCowNo.").append(i + 1).append(" Score: ").append(brownCows[i].getScores()[brownCows[i].getCurrentRound() - 1]).append(" -> ");
        }

        System.out.println(sb.toString());

        // แสดงประเภทการโยนของวัวแต่ละตัวและคะแนนของวัว
        for (int i = 0; i < 3; i++) {
            System.out.println("WriteCowNo." + (i + 1) + " got Cow " + (whiteCows[i].getScores()[whiteCows[i].getCurrentRound() - 1] == 10 ? "Strike" : "Open") + " with score: " + whiteCows[i].getScores()[whiteCows[i].getCurrentRound() - 1]);
            System.out.println("BlackCowNo." + (i + 1) + " got Cow " + (blackCows[i].getScores()[blackCows[i].getCurrentRound() - 1] == 10 ? "Strike" : "Open") + " with score: " + blackCows[i].getScores()[blackCows[i].getCurrentRound() - 1]);
            System.out.println("BrownCowNo." + (i + 1) + " got Cow " + (brownCows[i].getScores()[brownCows[i].getCurrentRound() - 1] == 10 ? "Strike" : "Open") + " with score: " + brownCows[i].getScores()[brownCows[i].getCurrentRound() - 1]);
        }
    }
    // แสดงการจัดอันดับของวัวทั้งหมดตามคะแนน
    public void displayRanking(CowModel[] allCows) {
        Arrays.sort(allCows, new Comparator<CowModel>() {
            @Override
            public int compare(CowModel c1, CowModel c2) {
                return Integer.compare(c2.getTotalScore(), c1.getTotalScore()); // Sort descending
            }
        });

        System.out.println("Ranking Score");
        // ลูปเพื่อแสดงอันดับของวัวแต่ละตัว
        for (int i = 0; i < allCows.length; i++) {
            System.out.print((i + 1) + ". ");
            if (allCows[i] instanceof WhiteCowModel) {
                System.out.print("WriteCowNo." + (i % 3 + 1));
            } else if (allCows[i] instanceof BlackCowModel) {
                System.out.print("BlackCowNo." + (i % 3 + 1));
            } else if (allCows[i] instanceof BrownCowModel) {
                System.out.print("BrownCowNo." + (i % 3 + 1));
            }
            System.out.println(" has a score: " + allCows[i].getTotalScore());
        }
    }
    // แสดงการจัดอันดับทีมตามคะแนนรวมของทีม
    public void displayTeamRanking(CowModel[][] teams) {
        int[] teamScores = new int[teams.length];
        String[] teamNames = {"WriteCow", "BlackCow", "BrownCow"};

        for (int i = 0; i < teams.length; i++) {
            for (CowModel cow : teams[i]) {
                teamScores[i] += cow.getTotalScore();
            }
        }

        
        String[][] teamRankings = new String[teams.length][2];
        // ลูปเพื่อคำนวณคะแนนรวมของแต่ละทีม
        for (int i = 0; i < teams.length; i++) {
            teamRankings[i][0] = teamNames[i];
            teamRankings[i][1] = String.valueOf(teamScores[i]);
        }

        Arrays.sort(teamRankings, new Comparator<String[]>() {
            @Override
            public int compare(String[] t1, String[] t2) {
                return Integer.compare(Integer.parseInt(t2[1]), Integer.parseInt(t1[1])); // Sort descending
            }
        });

        System.out.println("Ranking of Team total scores:");
        // ลูปเพื่อแสดงอันดับของแต่ละทีม
        for (int i = 0; i < teamRankings.length; i++) {
            System.out.println((i + 1) + "." + teamRankings[i][0] + " has a score: " + teamRankings[i][1]);
        }
    }
}
