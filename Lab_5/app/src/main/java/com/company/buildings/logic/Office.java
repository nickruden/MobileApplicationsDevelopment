package com.company.buildings.logic;

/**
 * This is the office class file, it is a subclass of Building.
 */
public class Office extends Building {
       
    // TODO - Put your code here.
    private String mBusinessName;
    private int mParkingSpaces ;
    private static int sTotalOffices = 0;

    public Office(int length, int width, int lotLength, int lotWidth) {
        super(length, width, lotLength, lotWidth);
        this.mParkingSpaces = 0;
        this.mBusinessName = null;
        sTotalOffices++;
    }

    public Office(int length, int width, int lotLength, int lotWidth, String businessName) {
        // можно использовать this() для вызова конструктора этого класса
        super(length, width, lotLength, lotWidth);
        mBusinessName = businessName;
        sTotalOffices++;
    }

    public Office(int length, int width, int lotLength, int lotWidth, String businessName, int parkingSpaces) {
        super(length, width, lotLength, lotWidth);
        mBusinessName = businessName;
        mParkingSpaces = parkingSpaces;
        sTotalOffices++;
    }

    public String getBusinessName() {
        return mBusinessName;
    }

    public int getParkingSpaces() {
        return mParkingSpaces;
    }

    public void setBusinessName(String mBusinessName) {
        this.mBusinessName = mBusinessName;
    }

    public void setParkingSpaces(int mParkingSpaces) {
        this.mParkingSpaces = mParkingSpaces;
    }

    @Override
    public String toString() {
        String occupation = getBusinessName();
        String hasParking = "";
        if (occupation == null) {
            occupation = "unoccupied";
        }
        if (getParkingSpaces() > 0){
            hasParking = "; has "+ getParkingSpaces() +" parking spaces";
        }
        if (!"".equals(getBusinessName()) && getBusinessName() != null){
            occupation = getBusinessName();
        }
        return "Business: " + occupation + hasParking + " (total offices: "+ sTotalOffices + ")";
    }

    @Override
    public boolean equals(Object obj) {
        Office office = (Office) obj;
        if (this.calcBuildingArea() == office.calcBuildingArea() && this.getParkingSpaces() == office.getParkingSpaces()) {
            return true;
        } else {
            return false;
        }
    }
}
