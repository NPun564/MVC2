package Model;
public abstract class CowModel {
    protected int[] scores = new int[10];
    protected int currentScore = 0;
    protected int totalScore = 0;
    protected int currentRound = 0;
    
    public abstract void bowl(int pins);
    
    public void addScore(int score) {
        if (currentRound < scores.length) { // ตรวจสอบว่าอยู่ในช่วงของรอบที่มีคะแนนเก็บ
            scores[currentRound++] = score; // เก็บคะแนนและเพิ่มรอบปัจจุบัน
            totalScore += score; // เพิ่มคะแนนรวมทั้งหมด
        }
    }
    //ดึงคะแนนรวมทั้งหมด
    public int getTotalScore() {
        return totalScore;
    }
    // ดึงคะแนนของแต่ละรอบ
    public int[] getScores() {
        return scores;
    }
    //ดึงรอบปัจจุบัน
    public int getCurrentRound() {
        return currentRound;
    }
    // กำหนดรอบปัจจุบัน
    public void setCurrentRound(int round) {
        this.currentRound = round;
    }
}
