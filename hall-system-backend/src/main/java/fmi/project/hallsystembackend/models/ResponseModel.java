package fmi.project.hallsystembackend.models;

import java.math.BigInteger;
import java.util.Date;

public class ResponseModel {
    private Long id;
    private int hallNumber;
    private String facultyName;
    private int capacity;
    private boolean hasProjector;
    private boolean isComputerHall;
    private Date reservedDate;
    private Integer reservedHour;

    public ResponseModel(Object[] obj) {
        this.id = ((BigInteger)obj[0]).longValue();
        this.hallNumber = (int) obj[1];
        this.facultyName = (String) obj[2];
        this.capacity = (int) obj[3];
        this.hasProjector = (boolean) obj[4];
        this.isComputerHall = (boolean) obj[5];
        this.reservedDate = (Date) obj[6];
        this.reservedHour = (int) obj[7];
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(int hallNumber) {
        this.hallNumber = hallNumber;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isHasProjector() {
        return hasProjector;
    }

    public void setHasProjector(boolean hasProjector) {
        this.hasProjector = hasProjector;
    }

    public boolean isComputerHall() {
        return isComputerHall;
    }

    public void setComputerHall(boolean computerHall) {
        isComputerHall = computerHall;
    }

    public Date getReservedDate() {
        return reservedDate;
    }

    public void setReservedDate(Date reservedDate) {
        this.reservedDate = reservedDate;
    }

    public Integer getReservedHour() {
        return reservedHour;
    }

    public void setReservedHour(Integer reservedHour) {
        this.reservedHour = reservedHour;
    }
}
