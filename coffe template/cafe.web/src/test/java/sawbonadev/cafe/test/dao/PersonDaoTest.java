package sawbonadev.cafe.test.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;
import sawbonadev.cafe.repository.PersonDao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sawbonadev.cafe.model.person.PersonDetail;
import sawbonadev.cafe.model.person.User;
import sawbonadev.cafe.repository.UserDao;

/**
 *
 * @author sawbona
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = 
                {"classpath:/test-datasource.xml"})
public class PersonDaoTest {
    
    @Autowired
    private PersonDao personDao;
    
    @Autowired
    private UserDao userDao;
    
    public PersonDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of save method, of class PersonDao.
     */
    @Test
    public void testSave() {
        System.out.println("testSave");
        PersonDetail persona = new PersonDetail();
        persona.setName("jacob");
        personDao.save(persona);
    }
    
    @Test
    public void testUserDao(){
        System.out.println("testUserDao");
        saveUser("sawbona@gmail.com");
        saveUser("abc@gmail.com");
        Iterable<User> findAll = userDao.findAll();
        for (User user : findAll) {
            System.out.println("user" + user);
        }
    }

    private void saveUser(String email) {
        final User user = new User();
        user.setEmail(email);
        user.setPassword("abc");
        final PersonDetail person = new PersonDetail();
        person.setBirthday(new Date());
        person.setName("jacob");
        user.setPerson(person);
        userDao.save(user);
    }
    
}
