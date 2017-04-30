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
 * @author sawbona
 */
@Controller()
@RequestMapping(value = "/projects")
public class ProjectsController {
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView root(){
        ModelAndView modelAndView = new ModelAndView("/projects/mainProjects");
        return modelAndView;
    }
    
}
