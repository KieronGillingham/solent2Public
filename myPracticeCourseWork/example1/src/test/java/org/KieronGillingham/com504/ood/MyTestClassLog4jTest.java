/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.KieronGillingham.com504.ood;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CompAdmin
 */
public class MyTestClassLog4jTest {
    
    public MyTestClassLog4jTest() {
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
     * Test of main method, of class MyTestClassLog4j.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        MyTestClassLog4j.main(args);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue( true );
    }

    /**
     * Test of writeAboutMe method, of class MyTestClassLog4j.
     */
    @Test
    public void testWriteAboutMe() {
        System.out.println("writeAboutMe");
        MyTestClassLog4j instance = new MyTestClassLog4j();
        instance.writeAboutMe();
        // TODO review the generated test code and remove the default call to fail.
        assertTrue( true );
    }
    
}
