package project.android.com.model;

public class Feedback {
    private long feedbackID;
    private String description;
    private long residentID;
    private long eventID;
    private long apartmentID;

    public long getResidentID() {
        return residentID;
    }

    public void setResidentID(long residentID) {
        this.residentID = residentID;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getFeedbackID() {

        return feedbackID;
    }

    public void setFeedbackID(long feedbackID) {
        this.feedbackID = feedbackID;
    }

    public long getEventID() {
        return eventID;
    }

    public void setEventID(long eventID) {
        this.eventID = eventID;
    }

    public long getApartmentID() {
        return apartmentID;
    }

    public void setApartmentID(long apartmentID) {
        this.apartmentID = apartmentID;
    }
}
