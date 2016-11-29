/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author aidan
 */
public class Round {
    private int roundNumber;
    Random randomizer = new Random();

    public Round() {
        this.roundNumber = 0;
    }
    
    public void setRoundNumber(int number) {
        this.roundNumber = number;
    }

    public int getRoundNumber() {
        return roundNumber;
    }
    
    public void calculateRoundResults(Participants participants) {
        for (Participant participant : participants.getParticipants() ) {
            int length = randomizer.nextInt((120 - 60) + 1) + 60;
            participant.setLength(length);
            ArrayList<Integer> judgeVotesArrayList = new ArrayList<Integer>();
            for (int i = 1; i < 6; i++) {
                int vote = randomizer.nextInt((20 - 10) + 1) + 10;
                judgeVotesArrayList.add(vote); 
            }
            participant.setJudgeScores(judgeVotesArrayList);
        }
            
    }
        
}
