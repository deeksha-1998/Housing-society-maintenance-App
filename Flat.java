package project.android.com.model;

public class Flat {
    private long flatID;
    private String flatNumber;
    private int floorNumber;
    private String furnishedType;
    private String flatType;
    private String occupancyType;
    private int numberOfBedrooms;
    private long apartmentID;

    public String getFurnishedType() {
        return furnishedType;
    }

    public void setFurnishedType(String furnishedType) {
        this.furnishedType = furnishedType;
    }

    public String getFlatNumber() {

        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public long getFlatID() {

        return flatID;
    }

    public void setFlatID(long flatID) {
        this.flatID = flatID;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public long getApartmentID() {
        return apartmentID;
    }

    public void setApartmentID(long apartmentID) {
        this.apartmentID = apartmentID;
    }

    public String getFlatType() {
        return flatType;
    }

    public void setFlatType(String flatType) {
        this.flatType = flatType;
    }

    public String getOccupancyType() {
        return occupancyType;
    }

    public void setOccupancyType(String occupancyType) {
        this.occupancyType = occupancyType;
    }
}
