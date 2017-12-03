/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.cafe.web.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sawbonadev.cafe.model.person.User;
import sawbonadev.cafe.model.projects.Activity;
import sawbonadev.cafe.model.projects.Project;
import sawbonadev.cafe.model.utils.Constants;
import sawbonadev.cafe.repository.ActivitiesDao;
import sawbonadev.cafe.repository.ProjectsDao;
import sawbonadev.cafe.repository.UserDao;
import sawbonadev.cafe.web.api.converters.ProjectDtoConverter;
import sawbonadev.cafe.web.api.projects.model.ActivityDto;
import sawbonadev.cafe.web.api.projects.model.ProjectDto;
import sawbonadev.cafe.web.api.users.model.UserDto;
import sawbonadev.solo.GenericResponse;
import sawbonadev.solo.strings.ValidateUtils;

/**
 *
 * @author sawbona
 */
@Service
public class ProjectsLogic {

    private final ProjectDtoConverter projectDtoConverter = new ProjectDtoConverter();

    @Autowired
    private UserDao usersDao;

    @Autowired
    private ProjectsDao projectsDao;

    @Autowired
    private ActivitiesDao activitiesDao;

    public GenericResponse<Page<ProjectDto>> getProjectsFrom(UserDto user, int page, int pageSize) {
        Page<Project> findByOwnerEmail = projectsDao.findByOwnerEmail(user.getEmail(), new PageRequest(page, pageSize));
        Page<ProjectDto> map = findByOwnerEmail.map(projectDtoConverter);
        return new GenericResponse<>(map);
    }

    public GenericResponse<ProjectDto> createProject(UserDto user, ProjectDto projectDto) {
        GenericResponse<ProjectDto> createProject = new GenericResponse<>(projectDto);
        createProject.add("project.name", "Name is required", ValidateUtils.STRINGS_REQUIRED, projectDto.getName());
        if (createProject.isValid()) {
            User findByEmail = usersDao.findByEmail(user.getEmail());
            Project newProject = new Project();
            newProject.setOwner(findByEmail);
            newProject.setName(projectDto.getName());
            Project save = projectsDao.save(newProject);
            projectDto.setId(save.getProjectId());
        }
        return createProject;
    }

    public GenericResponse<ActivityDto> updateActivity(UserDto user, ActivityDto activityDto) {
        GenericResponse<ActivityDto> response = new GenericResponse<>(activityDto);
        response.add("activity.name", "Name is required",
                ValidateUtils.STRINGS_REQUIRED, activityDto.getName());
        if (response.isValid()) {
//            User findByEmail = usersDao.findByEmail(user.getEmail());
//            Project project = projectsDao.findOne(activityDto.getProjectId());
            Activity newActivity = activitiesDao.findOne(activityDto.getId());
            if (newActivity.getCreatedBy().getEmail().compareTo(user.getEmail()) != 0) {
                response.addValidationMessageForProperty("activity.createdBy", "Not the owner");
            } else {
                newActivity.setName(activityDto.getName());
                newActivity.setStatus(Constants.ACTIVITY_STATUS.getStatusById(activityDto.getStatus().getStatusId()));
//                newActivity.setCreatedBy(findByEmail);
                newActivity.setDescription(activityDto.getDescription());
                newActivity.setOwner(activityDto.getOwner());
                Activity save = activitiesDao.save(newActivity);
                activityDto.setId(save.getActivityId());
            }
        }
        return response;
    }

    public GenericResponse<ActivityDto> createActivity(UserDto user, ActivityDto activityDto) {
        GenericResponse<ActivityDto> response = new GenericResponse<>(activityDto);
        response.add("activity.name", "Name is required",
                ValidateUtils.STRINGS_REQUIRED, activityDto.getName());
        if (response.isValid()) {
            User findByEmail = usersDao.findByEmail(user.getEmail());
            Project project = projectsDao.findOne(activityDto.getProjectId());
            Activity newActivity = new Activity();
            newActivity.setName(activityDto.getName());
            newActivity.setProject(project);
            newActivity.getStatus().setIdActivityStatus(Constants.ACTIVITY_STATUS.NEW.getId());
            newActivity.setCreatedBy(findByEmail);
            newActivity.setDescription(activityDto.getDescription());
            newActivity.setOwner(activityDto.getOwner());
            Activity save = activitiesDao.save(newActivity);
            activityDto.setId(save.getActivityId());
        }
        return response;
    }

    public GenericResponse<Long> deleteActivity(UserDto user, long id) {
        long deleteOne = activitiesDao.deleteByIdAndUser(id, user.getEmail());
        GenericResponse<Long> response = new GenericResponse<>(deleteOne);
        return response;
    }

    public GenericResponse<ProjectDto> getProjectDetails(long projectId, UserDto principalToUserDto) {
        Project projectResult = projectsDao.findByProjectIdAndOwnerEmailFetch(projectId);
        GenericResponse<ProjectDto> response = new GenericResponse<>(projectDtoConverter.convertDetails(projectResult));
        return response;
    }

    private static class ActivityConverter implements Converter<Activity, ActivityDto> {

        @Override
        public ActivityDto convert(Activity s) {
            ActivityDto activityDto = new ActivityDto();
            activityDto.setDescription(s.getDescription());
            activityDto.setId(s.getActivityId());
            activityDto.setName(s.getName());
            activityDto.setOwner(s.getOwner());
            return activityDto;
        }

    }
}
