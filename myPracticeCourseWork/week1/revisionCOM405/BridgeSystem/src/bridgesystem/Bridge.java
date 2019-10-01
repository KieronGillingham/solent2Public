/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridgesystem;
import java.util.LinkedList;

/**
 *
 * @author 4GILLK91 <4GILLK91@solent.ac.uk>
 */
public class Bridge
{
    private LinkedList<Vehicle> vehiclesOnBridge;
    private double weightLimit;
    
    public Bridge()
    {
        vehiclesOnBridge = new LinkedList<>();
    }
    
    public double calcTotalWeight()
    {
        double weight = 0d;
        for (Vehicle v : vehiclesOnBridge)
        {
            weight += v.getWeight();
        }
        return weight;
    }
    
    public boolean requestAddVehicle(Vehicle vehicle)
    {
        if (calcTotalWeight() + vehicle.getWeight() > getWeightLimit())
        {
            // Bridge overweight
            return false;
        }
        else
        {
            // Bridge able to hold vehicle
            vehiclesOnBridge.add(vehicle);
            return true;
        }
    }
        
    public boolean removeVehicle(String registration)
    {
        for (Vehicle v : vehiclesOnBridge)
        {
            if (v.getRegistrationNumber().equals(registration))
            {
                vehiclesOnBridge.remove(v);
                break;
            }
        }
        return false;
    }
            
    public double calcTotalCost()
    {
        double cost = 0d;
        for (Vehicle v : vehiclesOnBridge)
        {
            cost += v.calcFee();
        }
        return cost;
    }
    
    public int numberOfVehicles()
    {
        return vehiclesOnBridge.size();
    }

    public double getWeightLimit()
    {
        return weightLimit;
    }

    public void setWeightLimit(double weightLimit)
    {
        this.weightLimit = weightLimit;
    }
}
