package az.unec.managerinfoservice.controller;

import az.unec.managerinfoservice.data.AllManagersDTO;
import az.unec.managerinfoservice.data.ManagersDTO;
import az.unec.managerinfoservice.service.ManagersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class MangersController {
    @Autowired
    private ManagersService service;

    @PostMapping("/manager")
    public ManagersDTO saveManager(@RequestBody ManagersDTO manager) {
        return service.saveManager(manager);
    }

    @GetMapping("/manager/{club}")
    public ManagersDTO getManager(@PathVariable String club) {
        return service.getManager(club);
    }

    @DeleteMapping("/manager/{club}")
    public String deleteManager(@PathVariable String club) {
        return service.deleteManager(club);
    }

    @GetMapping("/manager")
    public AllManagersDTO getAllManagers(){
        return service.getAllManagers();
    }
}
