package project.android.com.model;

public class MaintenanceOfficer {
    private long officerID;
    private String name;
    private String username;
    private String password;
    private String contact;
    private String mail;
    private String profilePath;
    private long apartmentID;

    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

    public String getMail() {

        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContact() {

        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getOfficerID() {

        return officerID;
    }

    public void setOfficerID(long officerID) {
        this.officerID = officerID;
    }

    public long getApartmentID() {
        return apartmentID;
    }

    public void setApartmentID(long apartmentID) {
        this.apartmentID = apartmentID;
    }
}
