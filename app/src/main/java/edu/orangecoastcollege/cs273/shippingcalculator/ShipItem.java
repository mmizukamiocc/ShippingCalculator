package edu.orangecoastcollege.cs273.shippingcalculator;

/**
 * Created by mmizukami on 9/13/2016.
 */
public class ShipItem {

    private double mWeight;
    private double BASE_COST = 3.00;
    private double mAddedCost;
    private double mTotalCost;

    public ShipItem() {
        mWeight = 0.00;
        mAddedCost = 0.00;
        mTotalCost = 0.00;
    }

    public double getWeight() {
        return mWeight;
    }

    public double getBASE_COST() {
        return BASE_COST;
    }

    public double getAddedCost() {
        return mAddedCost;
    }

    public double getTotalCost() {
        return mTotalCost;
    }

    public void setWeight(double mWeight) {
        this.mWeight = mWeight;
        recaluculateTotal();
    }

    private void recaluculateTotal()
    {
        if(mWeight >= 16.0)
        {mAddedCost = (((mWeight - 16.0) / 4.0) * 0.50 + 0.50);}
        else
        {mAddedCost = 0.0;}

        mTotalCost = BASE_COST + mAddedCost;
    }

}
