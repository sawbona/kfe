/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.cafe.web.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author sawbona
 */
@Controller
@RequestMapping(value = "/app")
public class GenericViewController {
    
    
    
    @RequestMapping(value = { "/**"}, method = RequestMethod.GET)
    public ModelAndView create(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("/genericView");
        String restOfTheUrl = (String) request.getAttribute(
                HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        
        mv.addObject("ojViewName", restOfTheUrl.substring("/app/".length()));
        return mv;
    }
    
}
