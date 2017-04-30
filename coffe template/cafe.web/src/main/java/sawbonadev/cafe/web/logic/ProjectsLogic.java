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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import sawbonadev.cafe.web.api.projects.model.ProjectDto;
import sawbonadev.cafe.web.security.BasicUserDetails;
import sawbonadev.solo.GenericResponse;

/**
 *
 * @author sawbona
 */
@Service
public class ProjectsLogic {

    private Map<BasicUserDetails, List<ProjectDto>> db = new HashMap<>();

    public GenericResponse<Page<ProjectDto>> getProjectsFrom(BasicUserDetails user) {
        if (!db.containsKey(user)) {
            db.put(user, new ArrayList<ProjectDto>());
        }
        return new GenericResponse(new PageImpl(db.get(user)));
    }

}
