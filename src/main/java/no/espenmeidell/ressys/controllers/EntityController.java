package no.espenmeidell.ressys.controllers;

import no.espenmeidell.ressys.models.ReservableEntity;
import no.espenmeidell.ressys.services.ApplicationService;
import no.espenmeidell.ressys.services.ReservableEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/entity")
public class EntityController {

    private ReservableEntityService reservableEntityService;

    @Autowired
    public EntityController(ApplicationService service) {
        this.reservableEntityService = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<ReservableEntity> getAllEntities() {
        return reservableEntityService.getAllEntities();
    }

}
