/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.solo.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import sawbonadev.solo.strings.StringsEquals;
import sawbonadev.solo.strings.StringsNotNull;
import sawbonadev.solo.strings.StringsRequired;
import sawbonadev.solo.strings.StringsSecurePassword;

/**
 *
 * @author sawbona
 */
public class StringsUnitTest {

    public StringsUnitTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void stringEquals() {
        StringsEquals stringsEquals = new StringsEquals("1", "1");
        Assert.assertTrue(stringsEquals.isValid());

        stringsEquals = new StringsEquals("2", "1");
        Assert.assertFalse(stringsEquals.isValid());

        stringsEquals = new StringsEquals("2", null);
        Assert.assertFalse(stringsEquals.isValid());

        stringsEquals = new StringsEquals(null, "1");
        Assert.assertFalse(stringsEquals.isValid());

        stringsEquals = new StringsEquals(null);
        Assert.assertFalse(stringsEquals.isValid());

        stringsEquals = new StringsEquals(null, null);
        Assert.assertFalse(stringsEquals.isValid());

        stringsEquals = new StringsEquals();
        Assert.assertTrue(stringsEquals.isValid());
    }

    @Test
    public void stringsNotNull() {
        StringsNotNull stringsNotNull = new StringsNotNull(null);
        Assert.assertTrue(stringsNotNull.isValid() == false);

        stringsNotNull = new StringsNotNull();
        Assert.assertTrue(stringsNotNull.isValid());

        stringsNotNull = new StringsNotNull("");
        Assert.assertTrue(stringsNotNull.isValid());

        stringsNotNull = new StringsNotNull("", "asdasd");
        Assert.assertTrue(stringsNotNull.isValid());

        stringsNotNull = new StringsNotNull(null, "asdasd");
        Assert.assertTrue(stringsNotNull.isValid() == false);

        stringsNotNull = new StringsNotNull("asd", null);
        Assert.assertTrue(stringsNotNull.isValid() == false);
    }
    
    @Test
    public void stringsRequired() {
        StringsRequired required = new StringsRequired();
        Assert.assertTrue(required.isValid());
        
        required = new StringsRequired("");
        Assert.assertTrue(required.isValid() == false);
        
        required = new StringsRequired("   ");
        Assert.assertTrue(required.isValid() == false);
        
    }
    
    @Test
    public void stringSecurePassword(){
        StringsSecurePassword val = new StringsSecurePassword();
        Assert.assertTrue(val.isValid() == true);
        
        val = new StringsSecurePassword(null, "");
        Assert.assertTrue(val.isValid() == false);
        
        val = new StringsSecurePassword(null, null);
        Assert.assertTrue(val.isValid() == false);
        
        val = new StringsSecurePassword("", null);
        Assert.assertTrue(val.isValid() == false);
        
        val = new StringsSecurePassword("aaa", "BBBB");
        Assert.assertTrue(val.isValid() == false);
        
        val = new StringsSecurePassword("BBB");
        Assert.assertTrue(val.isValid() == false);
        
        val = new StringsSecurePassword("1111222233344455");
        Assert.assertTrue(val.isValid() == false);
        
        val = new StringsSecurePassword("   ");
        Assert.assertTrue(val.isValid() == false);
        
        val = new StringsSecurePassword("   ", "aaaaa", "BBB", null);
        Assert.assertTrue(val.isValid() == false);
        
        val = new StringsSecurePassword("   aaaaBBBBBB");
        Assert.assertTrue(val.isValid() == false);
        
        val = new StringsSecurePassword("   aB#      ");
        Assert.assertTrue(val.isValid() == false);
        
        val = new StringsSecurePassword("   aB#      ", null);
        Assert.assertTrue(val.isValid() == false);
        
        val = new StringsSecurePassword("   aB#      ", null);
        Assert.assertTrue(val.isValid() == false);
        
        val = new StringsSecurePassword("111111aB#");
        Assert.assertTrue(val.isValid() == true);
        
        val = new StringsSecurePassword("111111aB#", null);
        Assert.assertTrue(val.isValid() == false);
        
        val = new StringsSecurePassword(null, "111111aB#", null);
        Assert.assertTrue(val.isValid() == false);
        
        val = new StringsSecurePassword("12345678aB%", "111111aB#", "ASD12345678aB%");
        Assert.assertTrue(val.isValid() == true);
        
        val = new StringsSecurePassword("El Universo!", "111111aB#", "ASD12345678aB%");
        Assert.assertTrue(val.isValid() == true);
    }
}
