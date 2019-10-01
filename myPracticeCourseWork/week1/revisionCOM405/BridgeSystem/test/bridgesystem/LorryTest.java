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
public class LorryTest
{
    /**
     * Test of calcFee method, of class Lorry.
     */
    @Test
    public void testCalcFee()
    {
        System.out.println("calcFee");
        Lorry instance = new Lorry("RE6 50AA", 5000);
        double expResult = 10d;
        double result = instance.calcFee();
        assertEquals(expResult, result, 0.0);
    }
    
}
