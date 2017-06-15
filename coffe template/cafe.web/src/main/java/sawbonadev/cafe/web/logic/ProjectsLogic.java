/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.cafe.web.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import sawbonadev.cafe.repository.UserDao;
import sawbonadev.cafe.web.api.projects.model.ProjectDto;
import sawbonadev.cafe.web.api.users.model.UserDto;
import sawbonadev.solo.GenericResponse;

/**
 *
 * @author sawbona
 */
@Service
public class ProjectsLogic {

    @Autowired
    private UserDao usersDao;
    
    private Map<UserDto, List<ProjectDto>> db = new HashMap<>();

    public GenericResponse<Page<ProjectDto>> getProjectsFrom(UserDto user) {
        if (!db.containsKey(user)) {
            db.put(user, new ArrayList<ProjectDto>());
        }
        return new GenericResponse(new PageImpl(db.get(user)));
    }

}
