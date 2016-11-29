/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author aidan
 */
public class Interface {
    private Scanner reader;
    private Participants participants;
    private Tournament tournament;

    public Interface() {
        // Creates a Scanner object for user input,
        // a Participants object to contain the Participant objects
        // a Tournament object to keep count of rounds
        // and launches the programme
        this.reader = new Scanner(System.in);
        this.participants = new Participants();
        this.tournament = new Tournament();
        this.runProgramme();
    }
    
    public void runProgramme() {
        printTitle();
        enterParticipantNames();
        beginTournament();
    }
     
    public void printTitle() {
        System.out.println("Kumpula ski jumping week");
        System.out.println("");
    }
    
    public void enterParticipantNames() {
        // Allows user to enter participant names
        // creates a new Participant object for each one and adds it to the 
        // Participants object
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
        while (true) {
            System.out.print("  Participant name: ");
            String name = reader.nextLine();
            if (name.equals("")) {
                return;               
            }
            Participant newParticipant = new Participant(name);
            this.participants.add(newParticipant);
        }
    }
    
    public void beginTournament() {
        System.out.println("");
        System.out.println("The tournament begins!");
        System.out.println("");
        while (true) {
            System.out.print("Write \"jump\" to jump; otherwise you quit: ");
            String playOrQuit = reader.nextLine();
            if (playOrQuit.equals("jump")){
                playRound();
            } else {
                showFinalResults();
                return;
            }
        }    
    }
    
    public void playRound() {
        // Runs a round of the game and then calls a method to calculate scores
        Round round = new Round();
        int currentRound = tournament.getCurrentRound();
        tournament.setCurrentRound(currentRound+1);
        round.setRoundNumber(currentRound);
        printRoundNumber(round);
        ArrayList<Participant> jumperArrayList = participants.getJumpingOrder();
        printJumpingOrder(jumperArrayList);
        round.calculateRoundResults(participants);
        System.out.println("");
        System.out.println("Results of round "+round.getRoundNumber());
        System.out.println("");
        for (Participant participant : participants.getParticipants() ) {
            System.out.println("  "+participant.getName());
            System.out.println("    length: "+participant.getLength());
            System.out.println("    judge votes: "+participant.getJudgeScores());
            System.out.println("");
        }
        calculateTotalScores(round,participants);
    }
    
    public void printRoundNumber(Round round) {
        System.out.println("");
        System.out.println("Round "+round.getRoundNumber());
        System.out.println("");
    }
    
    public void printJumpingOrder(ArrayList<Participant> jumperArrayList) {
        System.out.println("Jumping order:");
        int counter = 1;
        for (Participant participant : jumperArrayList) {
            System.out.println("  "+counter+". "+participant.getName()+" ("+participant.getTotalPoints()+" points)");            
        }
    }
    
    public void calculateTotalScores(Round round,Participants participants) { 
        // Calculates round scores and the total score for each Participant object
        for (Participant participant : participants.getParticipants() ) {
            String participantName = participant.getName();
            ArrayList<Integer> particpantJudgeScores = participant.getJudgeScores();
            Collections.sort(particpantJudgeScores);
            int participantRoundJudgeVotesTotal = 0;
            participantRoundJudgeVotesTotal += particpantJudgeScores.get(1);
            participantRoundJudgeVotesTotal += particpantJudgeScores.get(2);
            participantRoundJudgeVotesTotal += particpantJudgeScores.get(3);
            int participantTotalRoundScore = participantRoundJudgeVotesTotal + participant.getLength();
            participant.setRoundPoints(participantTotalRoundScore);
            participant.addJumpLengthToList(participant.getLength());
            participant.addToTotalPoints(participantTotalRoundScore);
        }
    }
    
    public void showFinalResults() {
        // Prints final results
        System.out.println("");
        System.out.println("Thanks!");
        System.out.println("");
        System.out.println("Tournament results:");
        System.out.println("Position    Name");    
        participants.sort();
        participants.reverse();
        int participantCounter = 1;
        for (Participant participant : participants.getParticipants()) {
            System.out.println(participantCounter+"           "+participant.getName()+" ("+participant.getTotalPoints()+" points)");
            System.out.print("            jump lengths:");
            int i = 1;
            for (int length : participant.getJumpLengthList()){
                System.out.print(" "+length+" m");
                if (i < participant.getJumpLengthList().size()){
                    System.out.print(",");
                } else {
                    System.out.println("");
                }
                i++;
            }
            participantCounter++;
        }

    }
        
}
