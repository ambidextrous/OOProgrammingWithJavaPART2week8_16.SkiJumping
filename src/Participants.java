/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author aidan
 */
public class Participants {
    private ArrayList<Participant> participants;
    private boolean firstRound;

    public Participants() {
        this.participants = new ArrayList();
        this.firstRound = true;
    }

    public ArrayList<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<Participant> participants) {
        this.participants = participants;
    }

    public void add(Participant participant) {
        this.participants.add(participant);
    }

    public void sort() {
        Collections.sort(participants);
    }

    public void reverse() {
        Collections.reverse(participants);
    }

    public ArrayList<Participant> getJumpingOrder() {
        if (!this.firstRound) {
            this.sort();
            //this.reverse();
        }
        this.firstRound = false;
        return participants;
    }
}
