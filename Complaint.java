package project.android.com.model;

import java.util.Calendar;

public class Complaint {
    private long complaintID;
    private String description;
    private int status;
    private long residentID;
    private long apartmentID;

    private Calendar complaintDate;

    public long getResidentID() {
        return residentID;
    }

    public void setResidentID(long residentID) {
        this.residentID = residentID;
    }

    public int getStatus() {

        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getComplaintID() {

        return complaintID;
    }

    public void setComplaintID(long complaintID) {
        this.complaintID = complaintID;
    }

    public Calendar getComplaintDate() {
        return complaintDate;
    }

    public void setComplaintDate(Calendar complaintDate) {
        this.complaintDate = complaintDate;
    }

    public long getApartmentID() {
        return apartmentID;
    }

    public void setApartmentID(long apartmentID) {
        this.apartmentID = apartmentID;
    }
}
