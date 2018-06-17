package it.fescacom.domain;

public class Match {
    private final String opponentA;
    private final String opponentB;
    private final String goalScoredA;
    private final String goalScoredB;

    public Match(String opponentA, String opponentB, String goalScoredA, String goalScoredB) {
        this.opponentA = opponentA;
        this.opponentB = opponentB;
        this.goalScoredA = goalScoredA;
        this.goalScoredB = goalScoredB;
    }

    @Override
    public String toString() {
        return "Match{" +
                "opponentA='" + opponentA + '\'' +
                ", goalScoredA='" + goalScoredA + '\'' +
                ", opponentB='" + opponentB + '\'' +
                ", goalScoredB='" + goalScoredB + '\'' +
                '}';
    }

    public String getOpponentA() {
        return opponentA;
    }


    public String getOpponentB() {
        return opponentB;
    }


    public String getGoalScoredA() {
        return goalScoredA;
    }


    public String getGoalScoredB() {
        return goalScoredB;
    }

}
