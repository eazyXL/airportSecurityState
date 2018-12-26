package airportSecurityState.airportStates;

public interface AirportContextI{





    public void increaseOrDecreaseSecurity(String itemName, String day);

    public void printResults(String path);
    public void setCurState(int i);
    public double getCurDay();

    public void setCurDay(double curDay);

    public void setTravelers(double travelers);

    public void setProItems(double proItems);


    public double getTravelers();

    public double getProItems();

    public void setAvgTrafficPerDay(double avgTrafficPerDay);

    public void setAvgProhibitedItemsPerDay(double avgProhibitedItemsPerDay);

    public double getAvgTrafficPerDay();

    public double getAvgProhibitedItemsPerDay();

}