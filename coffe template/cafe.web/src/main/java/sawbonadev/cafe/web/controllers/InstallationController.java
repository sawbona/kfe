package sawbonadev.cafe.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sawbonadev.cafe.model.projects.ActivityStatus;
import sawbonadev.cafe.model.utils.Constants;
import sawbonadev.cafe.repository.ActivityStatusDao;
import sawbonadev.cafe.repository.InstallationPropertiesDao;

/**
 *
 * @author sawbona
 */
@Controller
@RequestMapping(value = "/installation")
public class InstallationController {
    
    @Autowired
    private ActivityStatusDao activityStatusDao;
        
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public ModelAndView create() {
        ModelAndView mv = new ModelAndView("/genericView");
        mv.addObject("ojViewName", "installation");
        
        Constants.ACTIVITY_STATUS[] activityStatus = Constants.ACTIVITY_STATUS.values();
        for (Constants.ACTIVITY_STATUS status : activityStatus) {
            ActivityStatus findOne = activityStatusDao.findOne(status.getId());
            if(findOne == null){
                activityStatusDao.save(new ActivityStatus(status.getId(), status.getDescription()));
            }
        }
        
        return mv;
    }
    
}
