package com.project3.restaurant_reservation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompletedReservationRepository extends JpaRepository<CompletedReservation, Integer> {}