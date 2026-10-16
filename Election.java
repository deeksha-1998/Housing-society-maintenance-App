package project.android.com.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Election {
    private long electionID;
    private String title;
    private String description;
    private Calendar date;
    private String type;
    private List<Long> candidateIDs;

    private String opinionPollQuestion;
    private String opinionPollOption1;
    private String opinionPollOption2;
    private int opinionPollOption1Count;
    private int opinionPollOption2Count;

    public long getElectionID() {
        return electionID;
    }

    public void setElectionID(long electionID) {
        this.electionID = electionID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Long> getCandidateIDs() {
        return candidateIDs;
    }

    public void setCandidateIDs(List<Long> candidateIDs) {
        this.candidateIDs = candidateIDs;
    }

    public String getOpinionPollQuestion() {
        return opinionPollQuestion;
    }

    public void setOpinionPollQuestion(String opinionPollQuestion) {
        this.opinionPollQuestion = opinionPollQuestion;
    }

    public String getOpinionPollOption1() {
        return opinionPollOption1;
    }

    public void setOpinionPollOption1(String opinionPollOption1) {
        this.opinionPollOption1 = opinionPollOption1;
    }

    public String getOpinionPollOption2() {
        return opinionPollOption2;
    }

    public void setOpinionPollOption2(String opinionPollOption2) {
        this.opinionPollOption2 = opinionPollOption2;
    }

    public int getOpinionPollOption1Count() {
        return opinionPollOption1Count;
    }

    public void setOpinionPollOption1Count(int opinionPollOption1Count) {
        this.opinionPollOption1Count = opinionPollOption1Count;
    }

    public int getOpinionPollOption2Count() {
        return opinionPollOption2Count;
    }

    public void setOpinionPollOption2Count(int opinionPollOption2Count) {
        this.opinionPollOption2Count = opinionPollOption2Count;
    }
}
