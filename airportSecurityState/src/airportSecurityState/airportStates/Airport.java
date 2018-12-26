package airportSecurityState.airportStates;
import airportSecurityState.util.Results;
import airportSecurityState.util.MyLogger;
public class Airport implements AirportContextI{

    private double avgTrafficPerDay;
    private double avgProhibitedItemsPerDay;
    private double travelers;
    private double proItems;
    private double curDay;
    AirportStateI LowRisk, ModRisk, HighRisk, curState;
    public Results r;
    private static final MyLogger myLogger = new MyLogger();

    /**
     * Creates a new Airport
     * @param none
     * @return none
     */
    public Airport(){
        LowRisk = new LowRiskState();
        ModRisk = new ModRiskState();
        HighRisk = new HighRiskState();
        curState = LowRisk;
        travelers = 0;
        proItems = 0;
        avgTrafficPerDay = 0;
        avgProhibitedItemsPerDay = 0;
        curDay = 0;
        r = new Results();
        myLogger.writeOutput("New Airport has been constructed", MyLogger.DEBUG_VALUE.CONSTRUCTOR);
    }
    /**
     * increases or decreases security on the current state
     * @param Name of item
     * @Param Current day
     * @return none
     */
    public void increaseOrDecreaseSecurity(String itemName, String day){
            int itemType = 0;
            if(itemName.equals("Grains") || itemName.equals("NailCutters") || itemName.equals("Plants") || itemName.equals("EndangeredAnimals")){
                itemType = 1;
            }
            int dday = Integer.parseInt(day);


                curState.increaseOrDecreaseSecurity(this, itemType, dday);
                curState.print(r);

    }
    public void printResults(String path){
            r.printFile(path);
    }

    public void setCurState(int i){
        if(i == 0){
            curState = LowRisk;
        }else if(i == 1){
            curState = ModRisk;
        }else if(i == 2){
            curState = HighRisk;
        }

    }
    public double getCurDay() {
        return curDay;
    }

    public void setCurDay(double curDay) {
        this.curDay = curDay;
    }

    public void setTravelers(double travelers) {
        this.travelers = travelers;
    }

    public void setProItems(double proItems) {
        this.proItems = proItems;
    }


    public double getTravelers() {
        return travelers;
    }

    public double getProItems() {
        return proItems;
    }

    public void setAvgTrafficPerDay(double avgTrafficPerDay) {
        this.avgTrafficPerDay = avgTrafficPerDay;
    }

    public void setAvgProhibitedItemsPerDay(double avgProhibitedItemsPerDay) {
        this.avgProhibitedItemsPerDay = avgProhibitedItemsPerDay;
    }

    public double getAvgTrafficPerDay() {
        return avgTrafficPerDay;
    }

    public double getAvgProhibitedItemsPerDay() {
        return avgProhibitedItemsPerDay;
    }

}