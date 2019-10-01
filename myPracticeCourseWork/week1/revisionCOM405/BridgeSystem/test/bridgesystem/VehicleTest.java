/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridgesystem;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 4GILLK91 <4GILLK91@solent.ac.uk>
 */
public class VehicleTest
{
    /**
     * Test of getRegistrationNumber method, of class Vehicle.
     */
    @Test
    public void testGetRegistrationNumber() {
        System.out.println("getRegistrationNumber");
        Vehicle instance = new VehicleImpl("RE6 50AA", 1000d);
        String expResult = "";
        String result = instance.getRegistrationNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRegistrationNumber method, of class Vehicle.
     */
    @Test
    public void testSetRegistrationNumber() {
        System.out.println("setRegistrationNumber");
        String registrationNumber = "";
        Vehicle instance = new VehicleImpl("RE6 50AA", 1000d);
        instance.setRegistrationNumber(registrationNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Weight methods, of class Vehicle.
     */
    @Test
    public void testGetWeight() {
        System.out.println("getWeight / setWeight");
        Vehicle instance = new VehicleImpl("RE6 50AA", 1000d);
        double expResult = 1000d;
        double result = instance.getWeight();
        assertEquals(expResult, result, 0.0);

        result = 2000d;
        instance.setWeight(result);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calcFee method, of class Vehicle.
     */
    @Test
    public void testCalcFee()
    {
        System.out.println("calcFee");
        Vehicle instance = new VehicleImpl("RE6 50AA", 1000d);
        double expResult = 0.0;
        double result = instance.calcFee();
        assertEquals(expResult, result, 0.0);
    }

    public class VehicleImpl extends Vehicle
    {
        public VehicleImpl(String regNo, double weight)
        {
            super(regNo, weight);
        }

        public double calcFee()
        {
            return 0.0;
        }
    }
}
