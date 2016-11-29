/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author aidan
 */
public class Participant implements Comparable<Participant> {
    private String name;
    private int length;
    private ArrayList<Integer> judgeScores;
    private int roundPoints;
    private int totalPoints;
    private ArrayList<Integer> jumpLengthList;
    
    public Participant(String name) {
        this.name = name;
        this.length = 0;
        this.judgeScores = new ArrayList<Integer>();
        this.roundPoints = 0;
        this.totalPoints = 0;
        this.jumpLengthList = new ArrayList<Integer>();
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public ArrayList<Integer> getJudgeScores() {
        return judgeScores;
    }

    public void setJudgeScores(ArrayList<Integer> judgeScores) {
        this.judgeScores = judgeScores;
    }

    public int getRoundPoints() {
        return roundPoints;
    }

    public void setRoundPoints(int roundPoints) {
        this.roundPoints = roundPoints;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void addToTotalPoints(int roundPoints) {
        this.totalPoints += roundPoints;
    }

    public void addJumpLengthToList(int length) {
        this.jumpLengthList.add(length);
    }

    public ArrayList<Integer> getJumpLengthList() {
        return jumpLengthList;
    }
    
    @Override
    // Compares Participant objects according to their totalScore object variables
    public int compareTo(Participant otherPaticipant) {
        return this.getTotalPoints()- otherPaticipant.getTotalPoints();
    }       
    
}
