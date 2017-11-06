package no.espenmeidell.ressys.controllers;

import no.espenmeidell.ressys.models.Reservation;
import no.espenmeidell.ressys.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    Map<String, List<Reservation>> getAllReservations() {
        HashMap<String, List<Reservation>> result = new HashMap<>();
        result.put("reservations", reservationService.getAllReservations());
        return result;
    }
}
