/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.cafe.web.api.converters;

import org.springframework.core.convert.converter.Converter;
import sawbonadev.cafe.model.projects.Activity;
import sawbonadev.cafe.model.projects.ActivityStatus;
import sawbonadev.cafe.model.projects.Project;
import sawbonadev.cafe.web.api.projects.model.ActivityDto;
import sawbonadev.cafe.web.api.projects.model.ProjectDto;

/**
 *
 * @author sawbona
 */
public class ProjectDtoConverter implements Converter<Project, ProjectDto>{

    @Override
    public ProjectDto convert(Project s) {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setId(s.getProjectId());
        projectDto.setName(s.getName());
        return projectDto;
    }
    
    public ProjectDto convertDetails(Project s) {
        ProjectDto projectDto = convert(s);
        for (Activity activity : s.getActivities()) {
            final ActivityDto activityDto = new ActivityDto();
            activityDto.setId(activity.getActivityId());
            activityDto.setName(activity.getName());
            activityDto.setDescription(activity.getDescription());
            activityDto.setOwner(activity.getOwner());
            final ActivityStatus status = activity.getStatus();
            activityDto.getStatus().setStatusId(status.getIdActivityStatus());
            
            // todo add i18n support for display name.
            activityDto.getStatus().setDisplayName(status.getDescription());
            projectDto.getActivities().add(activityDto);
        }
        return projectDto;
    }
    
}
