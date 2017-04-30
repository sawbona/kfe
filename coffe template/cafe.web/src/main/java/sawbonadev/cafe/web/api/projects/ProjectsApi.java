/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.cafe.web.api.projects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sawbonadev.cafe.web.api.projects.model.ProjectDto;
import sawbonadev.cafe.web.logic.ProjectsLogic;
import sawbonadev.cafe.web.security.BasicUserDetails;
import sawbonadev.solo.GenericResponse;

/**
 *
 * @author sawbona
 */
@RestController
@RequestMapping(value = "/api/projects")
public class ProjectsApi {
    
    @Autowired
    private ProjectsLogic projectsLogic;
    
    public ResponseEntity getProjects(){
        BasicUserDetails user = (BasicUserDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
        GenericResponse<Page<ProjectDto>> projects = projectsLogic.getProjectsFrom(user);
        return ResponseEntity.ok(projects);
    }
    
}
