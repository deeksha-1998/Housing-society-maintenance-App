package project.android.com.model;

import java.util.Calendar;

public class Event {

    private long officerID;
    private long eventID;
    private String title;
    private String description;
    private String venue;
    private Calendar date;
    private String time;

    public long getOfficerID() {
        return officerID;
    }

    public void setOfficerID(long officerID) {
        this.officerID = officerID;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Calendar getDate() {

        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getVenue() {

        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getEventID() {

        return eventID;
    }

    public void setEventID(long eventID) {
        this.eventID = eventID;
    }

}
