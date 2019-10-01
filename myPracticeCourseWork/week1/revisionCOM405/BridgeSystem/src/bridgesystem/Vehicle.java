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
public abstract class Vehicle
{
    private String registrationNumber;
    private double weight;

    public Vehicle(String regNo, double weight)
    {
        this.setRegistrationNumber(regNo);
        this.setWeight(weight);
    }
    
    public String getRegistrationNumber()
    {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber)
    {
        this.registrationNumber = registrationNumber;
    }

    public double getWeight()
    {
        return weight;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }
    
    public abstract double calcFee();
}
