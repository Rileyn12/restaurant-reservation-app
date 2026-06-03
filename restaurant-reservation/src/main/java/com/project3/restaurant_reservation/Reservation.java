package com.project3.restaurant_reservation;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")  // Explicitly map to the database column
    private Integer reservationId;

    @Column(name = "first_name")
    @NotBlank(message = "First name is required.")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "Last name is required.")
    private String lastName;

    @Column(name = "party_size")
    @Min(value = 1, message = "Party size must be at least 1.")
    @Max(value = 20, message = "Party size cannot exceed 20.")
    private int partySize;

    @Column(name = "contact_info")
    @Email(message = "Contact info must be a valid email address.")
    @NotBlank(message = "Contact info is required.")
    private String contactInfo;

    @NotBlank(message = "Time is required.")
    private String time;
    
    @NotBlank(message = "Date is required.")
    private String date;

    public Reservation() {}

    public Reservation(String firstName, String lastName, int partySize, String contactInfo, String time, String date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.partySize = partySize;
        this.contactInfo = contactInfo;
        this.time = time;
        this.date = date;
    }

    // Getters and setters
    public Integer getReservationId(){
        return reservationId;
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
        this.reservationId = reservationId;
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

