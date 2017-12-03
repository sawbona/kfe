/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.cafe.web.controllers;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;
import sawbonadev.cafe.model.projects.Project;
import sawbonadev.cafe.web.api.projects.model.ActivityDto;
import sawbonadev.cafe.web.logic.UsersLogic;
import sawbonadev.cafe.web.api.users.model.UserDto;
import sawbonadev.cafe.web.logic.ProjectsLogic;
import sawbonadev.cafe.web.views.CreateAccountView;
import sawbonadev.solo.GenericResponse;

/**
 *
 * @author sawbona
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/test-datasource.xml"})
public class AccountControllerTest {
//    private jdbcDriver driver;
    public AccountControllerTest() {
//        com.mysql.jdbc.Driver driver;
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
//
//    /**
//     * Test of signin method, of class AccountController.
//     */
//    @Test
//    public void testLogin_0args() {
//        System.out.println("signin");
//        AccountController instance = new AccountController();
//        ModelAndView expResult = null;
//        ModelAndView result = instance.signin();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of signin method, of class AccountController.
//     */
//    @Test
//    public void testLogin_VistaInicioSesion() {
//        System.out.println("signin");
//        VistaInicioSesion vista = null;
//        AccountController instance = new AccountController();
//        ModelAndView expResult = null;
//        ModelAndView result = instance.signin(vista);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    /**
//     * Test of create method, of class AccountController.
//     */
//    @Test
//    public void testRegistrar_0args() {
//        System.out.println("create");
//        AccountController instance = new AccountController();
//        ModelAndView expResult = null;
//        ModelAndView result = instance.create();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    
    @Autowired
    private AccountController instance;
    
    @Autowired
    private UsersLogic usersLogic;
    
    
    /**
     * Test of create method, of class AccountController.
     */
    @Test
    public void testRegistrar_VistaRegistro() {
        System.out.println("registrar");
        CreateAccountView vista = new CreateAccountView();
        vista.setEmail("sawbona@gmail.com");
        vista.setPassword("Abc123##");
        vista.setPasswordConfirm("Abc123##");
//        AccountController instance = new AccountController();
//        ModelAndView expResult = null;
        ModelAndView result = instance.create(vista);
        assertTrue(result.getModel().get("basicResult") == null);
        
        Page<UserDto> list = usersLogic.list(0, 10).getPayload();
        
        System.out.println("list.getNumberOfElements() = " + list.getNumberOfElements());
        final int numberOfElements = list.getNumberOfElements();
        assertTrue(numberOfElements > 0);
        for (UserDto user : list) {
            System.out.println("" + user.getEmail());
        }
        
        usersLogic.delete("sawbona@gmail.com");
        list = usersLogic.list(0, 10).getPayload();
        
        System.out.println("list.getNumberOfElements() = " + list.getNumberOfElements());
        assertEquals(list.getNumberOfElements(), numberOfElements - 1);
        
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

//    /**
//     * Test of registroExitoso method, of class AccountController.
//     */
//    @Test
//    public void testRegistroExitoso() {
//        System.out.println("registroExitoso");
//        AccountController instance = new AccountController();
//        ModelAndView expResult = null;
//        ModelAndView result = instance.registroExitoso();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
