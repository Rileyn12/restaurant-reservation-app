package com.project3.restaurant_reservation;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private CompletedReservationRepository completedReservationRepository;

    @GetMapping("/makeReservation")
    public String makeReservation(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "makeReservation";
    }

    @PostMapping("/add-reservation")
    public String addReservation(@Valid @ModelAttribute Reservation reservation, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("reservation", reservation);
            return "makeReservation";
        }
        model.addAttribute("reservation", reservation);
        return "confirmReservation";
    }

    @PostMapping("/confirm-reservation")
    public String confirmReservation(@ModelAttribute Reservation reservation, Model model) {
        // Save the reservation to the database
        reservationRepository.save(reservation);
        return "index"; // Redirect to home or success page
    }

    @GetMapping("/employeeUI")
    public String employeeUI(Model model) {
        List<Reservation> reservations = reservationRepository.findAll();
        reservations.sort(Comparator.comparing(Reservation::getDate).thenComparing(Reservation::getTime));
        model.addAttribute("reservations", reservations);
        return "employeeUI";
    }

    @GetMapping("/editReservation")
    public String editReservation(@RequestParam(name = "id", required = true) Integer id, Model model) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow();
        model.addAttribute("reservation", reservation);
        return "editReservation";
    }

    @PostMapping("/editReservation")
    public String updateReservation(@Valid @ModelAttribute Reservation reservation, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            // If there are validation errors, return to the form with error messages
            model.addAttribute("reservation", reservation);
            return "editReservation";
        }
        Reservation existingReservation = reservationRepository.findById(reservation.getReservationId()).orElseThrow();
        existingReservation.setFirstName(reservation.getFirstName());
        existingReservation.setLastName(reservation.getLastName());
        existingReservation.setPartySize(reservation.getPartySize());
        existingReservation.setContactInfo(reservation.getContactInfo());
        existingReservation.setTime(reservation.getTime());
        existingReservation.setDate(reservation.getDate());
        // Pass the updated data to the confirmation page
        model.addAttribute("reservation", existingReservation);
        return "confirmEditReservation"; // View for confirmation
    }

    @PostMapping("/confirmEditReservation")
    public String confirmEditReservation(@ModelAttribute Reservation reservation) {

        // Retrieve the original reservation and update its values
        Reservation existingReservation = reservationRepository.findById(reservation.getReservationId()).orElseThrow();
        existingReservation.setFirstName(reservation.getFirstName());
        existingReservation.setLastName(reservation.getLastName());
        existingReservation.setPartySize(reservation.getPartySize());
        existingReservation.setContactInfo(reservation.getContactInfo());
        existingReservation.setTime(reservation.getTime());
        existingReservation.setDate(reservation.getDate());

        reservationRepository.save(existingReservation); // Persist the updates
        return "redirect:/employeeUI"; // Redirect to the main UI
    }

    @GetMapping("/completeReservation")
    public String completeReservation(@RequestParam Integer id) {
        // Fetch the reservation to be completed
        Reservation reservation = reservationRepository.findById(id).orElseThrow();
        CompletedReservation completedReservation = new CompletedReservation(reservation);
        completedReservationRepository.save(completedReservation);
        reservationRepository.delete(reservation);
        return "redirect:/employeeUI"; // Redirect back to the main UI
    }


}

