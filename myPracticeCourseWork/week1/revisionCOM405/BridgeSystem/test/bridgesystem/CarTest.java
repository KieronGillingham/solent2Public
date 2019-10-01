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
public class CarTest
{
    /**
     * Test of calcFee method, of class Car.
     */
    @Test
    public void testCalcFee()
    {
        System.out.println("calcFee");
        Car instance = new Car("RE6 50AA", 1500);
        double expResult = 5d;
        double result = instance.calcFee();
        assertEquals(expResult, result, 0.0);
    }
    
}
