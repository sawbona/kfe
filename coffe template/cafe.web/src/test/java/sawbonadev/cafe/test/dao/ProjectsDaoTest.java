/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.cafe.test.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sawbonadev.cafe.model.person.User;
import sawbonadev.cafe.model.projects.ActivityStatus;
import sawbonadev.cafe.model.projects.Project;
import sawbonadev.cafe.model.utils.Constants;
import sawbonadev.cafe.repository.ActivityStatusDao;
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
        locations
        = {"classpath:/test-datasource.xml"})
public class ProjectsDaoTest {

    @Autowired
    private ProjectsDao projectsDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ProjectsLogic projectsLogic;

    @Autowired
    private ActivityStatusDao activityStatusDao;

    @Before
    public void before() {
        for (Constants.ACTIVITY_STATUS value : Constants.ACTIVITY_STATUS.values()) {
            activityStatusDao.save(
                    new ActivityStatus(value.getId(), value.getDescription()));
        }
    }

    @Test
    public void testFindAllProjectDao() {
        Iterable<Project> findAll = projectsDao.findAll();
        for (Project project : findAll) {
            System.out.println("project = " + project);
        }
    }

    @Test
    public void testGetProjectDetails() {
        System.out.println("testGetProjectDetails");
        Project result = projectsDao.findByProjectIdAndOwnerEmail(1);
        System.out.println("result = " + result);
    }

    @Test
    public void testCreateActivities() {
        System.out.println("\ntestCreateActivities");

        String email = "b@b.com";
        Project project = createProject(email);
        final UserDto userDto = new UserDto();
        userDto.setEmail(email);

        final ActivityDto activityDto = new ActivityDto();
        activityDto.setProjectId(project.getProjectId());
        activityDto.setName("activity test");

        GenericResponse<ActivityDto> result
                = projectsLogic.createActivity(userDto, activityDto);
        Assert.assertTrue(result.isValid());

    }

    @Test
    public void crudTest() {
        User save = createUser("a@b.com");
        saveNewProject(save, "Kafé2");

        Iterable<Project> findAll = projectsDao.findAll();
        long idToFind = 0;
        for (Project projectTmp : findAll) {
            System.out.println("project = " + projectTmp);
            idToFind = projectTmp.getProjectId();
        }

        System.out.println("idToFind = " + idToFind);
        Project result = projectsDao.findByProjectIdAndOwnerEmail(idToFind);
        System.out.println("result = " + result);

        result = projectsDao.findByProjectIdAndOwnerEmailFetch(idToFind);
        System.out.println("result fetched = " + result);
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
