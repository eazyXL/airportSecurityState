package airportSecurityState.airportStates;
import airportSecurityState.util.Results;
public interface AirportStateI{


    public void increaseOrDecreaseSecurity(AirportContextI airport, int itemType, int day);
    public void print(Results r);

}
