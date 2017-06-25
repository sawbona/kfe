/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.cafe.web.api.converters;

import org.springframework.core.convert.converter.Converter;
import sawbonadev.cafe.model.projects.Project;
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
    
}
