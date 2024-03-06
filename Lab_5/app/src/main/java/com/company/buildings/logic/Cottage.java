package com.company.buildings.logic;

/**
 * This is the cottage class file.  It is a subclass of House.
 */
public class Cottage extends House {
       
    // TODO - Put your code here.
    private boolean mSecondFloor;

    public Cottage(int dimension, int lotLength, int lotWidth) {
        super(dimension, dimension, lotLength, lotWidth);
    }

    public Cottage(int dimension, int lotLength, int lotWidth, String owner, boolean secondFloor) {
        super(dimension, dimension, lotLength, lotWidth, owner);
        mSecondFloor = secondFloor;
    }

    public boolean hasSecondFloor() {
        return mSecondFloor;
    }

    @Override
    public String toString() {
        String bigArea = "";
        String pool = "";
        String owner = getOwner();
        String hasCottage = "";
        if (calcLotArea() > calcBuildingArea()) {
            bigArea = "; has big open space";
        }
        if (hasPool()) {
            pool = "; has a pool";
        }
        if (owner == "") {
            owner = "n/a";
        }
        if (hasSecondFloor()) {
            hasCottage = "; is a two stowy cottage";
        }

        return "Owner:" + owner + pool + bigArea + hasCottage;
    }
}

