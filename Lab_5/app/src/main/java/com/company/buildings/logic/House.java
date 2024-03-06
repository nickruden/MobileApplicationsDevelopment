package com.company.buildings.logic;

/**
 * This is the House class file that extends Building.
 */
public class House extends Building {
       
    // TODO - Put your code here.
    private String mOwner;
    private boolean mPool; // наличие бассейна в доме


    public House(int length, int width, int lotLength, int lotWidth) {
        super(length, width, lotLength, lotWidth);
    }

    public House(int length, int width, int lotLength, int lotWidth, String owner) {
        super(length, width, lotLength, lotWidth);
        mOwner = owner;
    }

    public House(int length, int width, int lotLength, int lotWidth, String owner, boolean pool) {
        super(length, width, lotLength, lotWidth);
        mOwner = owner;
        mPool = pool;
    }

    public String getOwner() {
        return mOwner;
    }

    public boolean hasPool() {
        return mPool;
    }

    public void setOwner(String mOwner) {
        this.mOwner = mOwner;
    }

    public void setPool (boolean mPool) {
        this.mPool = mPool;
    }

    @Override
    public String toString() {
        String bigArea = "";
        String pool = "";
        String owner = getOwner();
        if (calcLotArea() > calcBuildingArea()) {
            bigArea = "; has a big open space";
        }
        if (hasPool()) {
            pool = "; has a pool";
        }
        if (owner == "") {
            owner = "n/a";
        }

        return "Owner: " + owner + pool + bigArea;
    }

    @Override
    public boolean equals(Object obj) {
        House house = (House) obj;
        if (this.calcBuildingArea() == house.calcBuildingArea() && this.hasPool() == house.hasPool()) {
            return true;
        } else {
            return false;
        }
    }
}
