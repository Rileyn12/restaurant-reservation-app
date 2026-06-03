package com.project3.restaurant_reservation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "completedelete")
public class CompletedReservation {

    @Id
    private Integer id;

    private String firstName;
    private String lastName;
    private int partySize;
    private String contactInfo;
    private String time;
    private String date;

    public CompletedReservation() {}

    // Constructor to copy fields from Reservation
    public CompletedReservation(Reservation reservation) {
        this.id = reservation.getReservationId();
        this.firstName = reservation.getFirstName();
        this.lastName = reservation.getLastName();
        this.partySize = reservation.getPartySize();
        this.contactInfo = reservation.getContactInfo();
        this.time = reservation.getTime();
        this.date = reservation.getDate();
    }

    // Getters and setters
    public Integer getReservationId(){
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getPartySize() {
        return partySize;
    }
    public String getContactInfo() {
        return contactInfo;
    }
    public String getTime() {
        return time;
    }
    public String getDate() {
        return date;
    }

    public void setReservationId(Integer reservationId) {
        this.id = reservationId;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setPartySize(int partySize) {
        this.partySize = partySize;
    }
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public void setDate(String date) {
        this.date = date;
    }
}
