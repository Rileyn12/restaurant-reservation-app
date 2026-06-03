package com.project3.restaurant_reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class RestaurantReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantReservationApplication.class, args);
	}

	@GetMapping("/employeeLogin")
  public String employeeLogin() {
    return "employeeLogin";
  }

  @GetMapping("/index")
  public String index() {
      return "index";
  }
}
