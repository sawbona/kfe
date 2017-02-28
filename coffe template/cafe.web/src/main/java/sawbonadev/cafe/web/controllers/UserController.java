/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.cafe.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author clobaco
 */
@Controller()
@RequestMapping(value = "/users")
public class UserController {
    
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView admin()
    {
        ModelAndView modelAndView = new ModelAndView("/users/admin");
        return modelAndView;
    }
    
}
