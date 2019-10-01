/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridgesystem;

/**
 *
 * @author 4GILLK91 <4GILLK91@solent.ac.uk>
 */
public class Car extends Vehicle
{
    public Car(String regNo, double weight)
    {
        super(regNo, weight);
    }

    
    @Override
    public double calcFee()
    {
        return 5d;
    }
}