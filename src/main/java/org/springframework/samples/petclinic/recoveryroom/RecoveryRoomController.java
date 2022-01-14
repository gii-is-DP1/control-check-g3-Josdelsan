package org.springframework.samples.petclinic.recoveryroom;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("recoveryroom")
public class RecoveryRoomController {

    private final RecoveryRoomService recoveryRoomService;

    @Autowired
    public RecoveryRoomController(RecoveryRoomService recoveryRoomService) {
        this.recoveryRoomService = recoveryRoomService;
    }

    private final String CREATE_OR_UPDATE_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";

    @GetMapping(value = "/create")
    public String initCreationForm(ModelMap model) {
        RecoveryRoom rc = new RecoveryRoom();
        model.put("types", this.recoveryRoomService.getAllRecoveryRoomTypes());
        model.put("recoveryRoom", rc);
        return CREATE_OR_UPDATE_FORM;
    }

    @PostMapping(value = "/create")
    public String processCreationForm(@Valid RecoveryRoom recoveryRoom, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.put("recoveryRoom", recoveryRoom);
            return CREATE_OR_UPDATE_FORM;
        } else {
            this.recoveryRoomService.save(recoveryRoom);
            return "welcome";
        }
    }

}
