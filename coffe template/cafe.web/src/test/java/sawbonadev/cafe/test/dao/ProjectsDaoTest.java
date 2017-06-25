/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.cafe.test.dao;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sawbonadev.cafe.model.person.User;
import sawbonadev.cafe.model.projects.Project;
import sawbonadev.cafe.repository.ProjectsDao;
import sawbonadev.cafe.repository.UserDao;

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

    @Test
    public void testFindAllProjectDao() {
        Iterable<Project> findAll = projectsDao.findAll();
        for (Project project : findAll) {
            System.out.println("project = " + project);
        }
    }

    @Test
    public void crudTest() {
        final String email = "a@b.com";
        final User owner = new User(email);
        owner.setPassword("xxx");
        User save = userDao.save(owner);

        saveNewProject(save, "Kafé");
        saveNewProject(save, "Kafé2");

        Iterable<Project> findAll = projectsDao.findAll();
        for (Project projectTmp : findAll) {
            System.out.println("project = " + projectTmp);
        }
    }

    private void saveNewProject(User save, String name) {
        // required owner
        final Project project = new Project();
        project.setOwner(save);

        // project.setna
        project.setName(name);

        projectsDao.save(project);
    }

}
