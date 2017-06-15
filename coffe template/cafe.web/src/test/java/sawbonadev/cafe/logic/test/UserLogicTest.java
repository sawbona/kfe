package sawbonadev.cafe.logic.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import sawbonadev.cafe.web.logic.UsersLogic;
import sawbonadev.cafe.web.security.UsersAuthenticationProvider;
import sawbonadev.solo.GenericResponse;
import sawbonadev.cafe.web.views.CreateAccountView;

/**
 *
 * @author sawbona
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = {"classpath:/test-datasource.xml"})
public class UserLogicTest {
    
    @Autowired
    private UsersLogic logic;
    
    @Autowired
    private UsersAuthenticationProvider authenticationProvider;
    
    public UserLogicTest() {
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
    public void logicTest() {
        System.out.println("logicTest");
        final CreateAccountView createAccountView = new CreateAccountView();
        createAccountView.setEmail("");
        createAccountView.setPassword(null);
        createAccountView.setPasswordConfirm(null);
        GenericResponse<CreateAccountView> save = logic.save(createAccountView);
        Assert.isTrue(!save.isValid(), "valid view?");
        System.out.println("size validations = " + save.getValidations().keySet().size());
        Assert.isTrue(save.getValidations().keySet().size() == 3, "elements");
        authenticationProvider.loadUserByUsername("a@b.com");
    }
    
    
}
