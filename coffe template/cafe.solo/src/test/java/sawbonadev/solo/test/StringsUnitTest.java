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
import sawbonadev.solo.strings.StringNotNull;
import sawbonadev.solo.strings.StringRequired;
import sawbonadev.solo.strings.StringSecurePassword;

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
        StringsEquals stringsEquals = new StringsEquals();
        Assert.assertTrue(stringsEquals.isValid("1", "1"));

        stringsEquals = new StringsEquals();
        Assert.assertFalse(stringsEquals.isValid("2", "1"));

        stringsEquals = new StringsEquals();
        Assert.assertFalse(stringsEquals.isValid("2", null));

        stringsEquals = new StringsEquals();
        Assert.assertFalse(stringsEquals.isValid(null, "1"));

        stringsEquals = new StringsEquals();
        Assert.assertFalse(stringsEquals.isValid(null));
        Assert.assertFalse(stringsEquals.isValid((String) null));

        stringsEquals = new StringsEquals();
        Assert.assertFalse(stringsEquals.isValid(null, null));

        stringsEquals = new StringsEquals();
        Assert.assertFalse(stringsEquals.isValid());
    }

    @Test
    public void stringsNotNull() {
        StringNotNull stringsNotNull = new StringNotNull();
        
        // a null array is not valid
        Assert.assertFalse(stringsNotNull.isValid(null));
        
        // a null string value is not valid
        Assert.assertFalse(stringsNotNull.isValid((String) null));

        stringsNotNull = new StringNotNull();
        Assert.assertFalse(stringsNotNull.isValid(null));

        stringsNotNull = new StringNotNull();
        Assert.assertTrue(stringsNotNull.isValid(""));

        stringsNotNull = new StringNotNull();
        Assert.assertTrue(stringsNotNull.isValid(""));

        stringsNotNull = new StringNotNull();
        Assert.assertTrue(stringsNotNull.isValid(null) == false);

        stringsNotNull = new StringNotNull();
        Assert.assertTrue(stringsNotNull.isValid("asd"));
    }
    
    @Test
    public void stringsRequired() {
        StringRequired required = new StringRequired();
        Assert.assertFalse(required.isValid(null));
        
        required = new StringRequired();
        Assert.assertTrue(required.isValid("") == false);
        
        required = new StringRequired();
        Assert.assertTrue(required.isValid("   ") == false);
        
    }
    
    @Test
    public void stringSecurePassword(){
        StringSecurePassword val = new StringSecurePassword();
        Assert.assertFalse(val.isValid(null));
        
        val = new StringSecurePassword();
        Assert.assertTrue(val.isValid(null) == false);
        
        val = new StringSecurePassword();
        Assert.assertTrue(val.isValid(null) == false);
        
        val = new StringSecurePassword();
        Assert.assertTrue(val.isValid("") == false);
        
        val = new StringSecurePassword();
        Assert.assertTrue(val.isValid("aaa") == false);
        
        val = new StringSecurePassword();
        Assert.assertTrue(val.isValid("BBB") == false);
        
        val = new StringSecurePassword();
        Assert.assertTrue(val.isValid("1111222233344455") == false);
        
        val = new StringSecurePassword();
        Assert.assertTrue(val.isValid("   ") == false);
        
        val = new StringSecurePassword();
        Assert.assertTrue(val.isValid("   ") == false);
        
        val = new StringSecurePassword();
        Assert.assertTrue(val.isValid("   aaaaBBBBBB") == false);
        
        val = new StringSecurePassword();
        Assert.assertTrue(val.isValid("   aB#      ") == false);
        
        val = new StringSecurePassword();
        Assert.assertTrue(val.isValid("   aB#      ") == false);
        
        val = new StringSecurePassword();
        Assert.assertTrue(val.isValid("   aB#      ") == false);
        
        val = new StringSecurePassword();
        Assert.assertTrue(val.isValid("111111aB#") == true);
        
        val = new StringSecurePassword();
        Assert.assertTrue(val.isValid("111111aB#"));
        
        val = new StringSecurePassword();
        Assert.assertTrue(val.isValid(null) == false);
        
        val = new StringSecurePassword();
        Assert.assertTrue(val.isValid("12345678aB%") == true);
        
        val = new StringSecurePassword();
        Assert.assertTrue(val.isValid("El Universo!") == true);
    }
}
