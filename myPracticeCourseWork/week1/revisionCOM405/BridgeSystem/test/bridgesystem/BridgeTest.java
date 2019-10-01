/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridgesystem;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 4GILLK91 <4GILLK91@solent.ac.uk>
 */
public class BridgeTest {
    
    public BridgeTest() {
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
     * Test of calcTotalWeight method, of class Bridge.
     */
    @Test
    public void testCalcTotalWeight() {
        System.out.println("calcTotalWeight");
        Bridge instance = new Bridge();
        double expResult = 0.0;
        double result = instance.calcTotalWeight();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of requestAddVehicle method, of class Bridge.
     */
    @Test
    public void testRequestAddVehicle() {
        System.out.println("requestAddVehicle");
        Vehicle vehicle = null;
        Bridge instance = new Bridge();
        boolean expResult = false;
        boolean result = instance.requestAddVehicle(vehicle);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeVehicle method, of class Bridge.
     */
    @Test
    public void testRemoveVehicle() {
        System.out.println("removeVehicle");
        String registration = "";
        Bridge instance = new Bridge();
        boolean expResult = false;
        boolean result = instance.removeVehicle(registration);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcTotalCost method, of class Bridge.
     */
    @Test
    public void testCalcTotalCost() {
        System.out.println("calcTotalCost");
        Bridge instance = new Bridge();
        double expResult = 0.0;
        double result = instance.calcTotalCost();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of numberOfVehicles method, of class Bridge.
     */
    @Test
    public void testNumberOfVehicles() {
        System.out.println("numberOfVehicles");
        Bridge instance = new Bridge();
        int expResult = 0;
        int result = instance.numberOfVehicles();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWeightLimit method, of class Bridge.
     */
    @Test
    public void testGetWeightLimit() {
        System.out.println("getWeightLimit");
        Bridge instance = new Bridge();
        double expResult = 0.0;
        double result = instance.getWeightLimit();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWeightLimit method, of class Bridge.
     */
    @Test
    public void testSetWeightLimit() {
        System.out.println("setWeightLimit");
        double weightLimit = 0.0;
        Bridge instance = new Bridge();
        instance.setWeightLimit(weightLimit);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
