package airportSecurityState.airportStates;
import airportSecurityState.util.Results;
import airportSecurityState.util.MyLogger;
public class HighRiskState implements AirportStateI{
    private static final MyLogger myLogger = new MyLogger();

    /**
     * Creates a new HighRiskState
     * @param none
     * @return none
     */
    public HighRiskState(){
        myLogger.writeOutput("New HighRiskState has been constructed", MyLogger.DEBUG_VALUE.CONSTRUCTOR);
    }

    /**
     * Updates the counters and averages in Airport instance
     * checks if it is a new day
     * then checks to see where the AVGs are at and update the current state
     * @param Current Airport
     * @param item passenger is bringing
     * @param current day
     * @return none
     */
    public void increaseOrDecreaseSecurity(AirportContextI airport, int itemType, int day){
        double avgT, avgP, days, travs, pItems, curDay;

        avgT = airport.getAvgTrafficPerDay();
        avgP = airport.getAvgProhibitedItemsPerDay();
        travs = airport.getTravelers();
        pItems = airport.getProItems();
        curDay = airport.getCurDay();


        if(day > curDay){
            curDay = day;
            airport.setCurDay(curDay);
            myLogger.writeOutput("New Day", MyLogger.DEBUG_VALUE.NEWDAY);
        }


        if(itemType == 1){
            pItems +=1;
            airport.setProItems(pItems);
            myLogger.writeOutput("Prohibited Item Found", MyLogger.DEBUG_VALUE.NEWPROITEM);
        }


        travs++;
        airport.setTravelers(travs);

        avgT = travs/curDay;
        airport.setAvgTrafficPerDay(avgT);

        avgP = pItems/curDay;
        airport.setAvgProhibitedItemsPerDay(avgP);

        if((avgT >= 0  && avgT < 4) || (avgP < 2 && avgP >= 0)){
            airport.setCurState(0);
        }
        if((avgT >= 4  && avgT < 8) || (avgP < 4 && avgP >= 2)){
            airport.setCurState(1);
        }
        if((avgT >= 8) || (avgP >= 4)){
            airport.setCurState(2);
        }

    }

    /**
     * adds the operations for current state to the results
     * @param Results object from Airport instance
     * @return none
     */
    public void print(Results r){
        r.addResult("2 4 6 8 10");

    }

}