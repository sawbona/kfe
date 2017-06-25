/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.cafe.web.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sawbonadev.cafe.model.person.User;
import sawbonadev.cafe.model.projects.Project;
import sawbonadev.cafe.repository.ProjectsDao;
import sawbonadev.cafe.repository.UserDao;
import sawbonadev.cafe.web.api.converters.ProjectDtoConverter;
import sawbonadev.cafe.web.api.projects.model.ProjectDto;
import sawbonadev.cafe.web.api.users.model.UserDto;
import sawbonadev.solo.GenericResponse;
import sawbonadev.solo.strings.ValidationsUtils;

/**
 *
 * @author sawbona
 */
@Service
public class ProjectsLogic {

    @Autowired
    private UserDao usersDao;

    private final ProjectDtoConverter projectDtoConverter = new ProjectDtoConverter();

    @Autowired
    private ProjectsDao projectsDao;

    public GenericResponse<Page<ProjectDto>> getProjectsFrom(UserDto user, int page, int pageSize) {
        Page<Project> findByOwnerEmail = projectsDao.findByOwnerEmail(user.getEmail(), new PageRequest(page, pageSize));
        Page<ProjectDto> map = findByOwnerEmail.map(projectDtoConverter);
        return new GenericResponse<>(map);
    }

    public GenericResponse<ProjectDto> createProject(UserDto user, ProjectDto projectDto) {
        GenericResponse<ProjectDto> createProject = new GenericResponse<>(projectDto);
        createProject.add("name", "Name is required", ValidationsUtils.STRINGS_REQUIRED, projectDto.getName());
        if (createProject.isValid()) {
            User findByEmail = usersDao.findByEmail(user.getEmail());
            Project newProject = new Project();
            newProject.setOwner(findByEmail);
            newProject.setName(projectDto.getName());
            projectsDao.save(newProject);
        }
        return createProject;
    }

}
