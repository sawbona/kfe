/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.cafe.web.api.projects;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sawbonadev.cafe.web.api.projects.model.ProjectDto;
import sawbonadev.cafe.web.api.users.model.UserDto;
import sawbonadev.cafe.web.logic.ProjectsLogic;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getProjects(@RequestParam(value = "p", defaultValue = "0") int page,
            @RequestParam(value = "ps", defaultValue = "10") int pageSize, Principal principal) {
        GenericResponse<Page<ProjectDto>> projects = projectsLogic.getProjectsFrom(principalToUserDto(principal), page, pageSize);
        return ResponseEntity.ok(projects);
    }

    private static UserDto principalToUserDto(Principal principal) {
        return new UserDto(principal.getName());
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity createProjects(ProjectDto projectDto, Principal principal) {
        GenericResponse<ProjectDto> projects = projectsLogic.createProject(principalToUserDto(principal), projectDto);
        return ResponseEntity.ok(projects);
    }

}
