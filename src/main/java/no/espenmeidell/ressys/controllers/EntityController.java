package no.espenmeidell.ressys.controllers;

import no.espenmeidell.ressys.models.ReservableEntity;
import no.espenmeidell.ressys.services.ApplicationService;
import no.espenmeidell.ressys.services.ReservableEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<String, List<ReservableEntity>> getAllEntities() {
        HashMap<String, List<ReservableEntity>> result = new HashMap();
        result.put("entities", reservableEntityService.getAllEntities());
        return result;
    }

}
