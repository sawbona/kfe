/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.cafe.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sawbonadev.cafe.model.installation.InstallationProperty;
import sawbonadev.cafe.repository.InstallationPropertiesDao;
import sawbonadev.cafe.web.logic.UsersLogic;
import sawbonadev.solo.GenericResponse;
import sawbonadev.cafe.web.views.CreateAccountView;

/**
 *
 * @author sawbona
 */
@Controller
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private UsersLogic usuariosNegocio;
    
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() {
        ModelAndView mv = new ModelAndView("/account/create");
        return mv;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(CreateAccountView createView) {
        GenericResponse<CreateAccountView> basicResult = usuariosNegocio.save(createView);
        ModelAndView view = new ModelAndView("/account/create");
        if (basicResult.isValid()) {
            view = new ModelAndView("redirect:/account/create/success");
        } else {
            view.addObject("genericResponse", basicResult);
        }
        return view;
    }

    @RequestMapping(value = "/create/success", method = RequestMethod.GET)
    public ModelAndView success() {
        ModelAndView mv = new ModelAndView("/account/create/success");
        return mv;
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("/account/login");
        return mv;
    }
}
