/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.cafe.logic.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import sawbonadev.cafe.model.person.User;
import sawbonadev.cafe.model.projects.Project;
import sawbonadev.cafe.repository.ProjectsDao;
import sawbonadev.cafe.repository.UserDao;
import sawbonadev.cafe.web.api.projects.model.ActivityDto;
import sawbonadev.cafe.web.api.users.model.UserDto;
import sawbonadev.cafe.web.logic.ProjectsLogic;
import sawbonadev.solo.GenericResponse;

/**
 *
 * @author sawbona
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = {"classpath:/test-datasource.xml"})
public class ActivityLogicTest {

    @Autowired
    private ProjectsDao projectsDao;

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private ProjectsLogic projectsLogic;

    @Test
    @Transactional
    public void testDeleteActivity() {
        System.out.println("\ntestCreateActivities");

        String email = "deleteuser@b.com";
        Project project = createProject(email);
        final UserDto userDto = new UserDto();
        userDto.setEmail(email);

        final ActivityDto activityDto = new ActivityDto();
        activityDto.setProjectId(project.getProjectId());
        activityDto.setName("activity test");

        GenericResponse<ActivityDto> result
                = projectsLogic.createActivity(userDto, activityDto);
        Assert.assertTrue(result.isValid());
        
        projectsLogic.deleteActivity(userDto, result.getPayload().getId());
    }
    
    @Test
    @Transactional
    public void testUpdateActivity() {
        System.out.println("\ntestCreateActivities");

        String email = "deleteuser@b.com";
        Project project = createProject(email);
        final UserDto userDto = new UserDto();
        userDto.setEmail(email);

        final ActivityDto activityDto = new ActivityDto();
        activityDto.setProjectId(project.getProjectId());
        activityDto.setName("activity test");

        GenericResponse<ActivityDto> result
                = projectsLogic.createActivity(userDto, activityDto);
        Assert.assertTrue(result.isValid());
        ActivityDto payload = result.getPayload();
        payload.getStatus().setStatusId(2);
        projectsLogic.updateActivity(userDto, payload);
    }


    private Project createProject(String email) {
        User save = createUser(email);
        return saveNewProject(save, "Kafé");
    }

    private User createUser(String email) {
        final User owner = new User(email);
        owner.setPassword("xxx");
        User save = userDao.save(owner);
        return save;
    }

    private Project saveNewProject(User save, String name) {
        // required owner
        final Project project = new Project();
        project.setOwner(save);
        // project.setna
        project.setName(name);
        return projectsDao.save(project);
    }
    
}
