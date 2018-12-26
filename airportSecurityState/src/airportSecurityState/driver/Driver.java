package airportSecurityState.driver;
import airportSecurityState.util.FileProcessor;
import airportSecurityState.airportStates.Airport;
import airportSecurityState.airportStates.AirportContextI;
import airportSecurityState.util.MyLogger;


public class Driver{
    private static final MyLogger myLogger = new MyLogger();

    /**
     * Makes a new airport
     * for each line from file pass the item and day along to the airport to determine security
     * when no more lines of file print the results
     * @param args array
     * @return none
     */
    public static void main(String[] args) {

        if (args.length != 3 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")) {

            System.err.println("Error: Incorrect number of arguments. Program accepts 3 arguments.");
            throw new IllegalArgumentException("Need: input.txt, output.txt, DEBUG_VALUE");
            // System.exit(0);
        }
        else {

           int debugValue = 0;
            try {
                debugValue = Integer.parseInt(args[2]);
            }catch(Exception e){
                System.err.println("ERROR: DEBUG_VALUE must be an integer");
                System.exit(0);
            }


            if (debugValue < 0 || debugValue > 4) {
                System.err.println("ERROR: DEBUG_VALUE must be between 0 and 4");
                System.exit(0);
            }
            myLogger.setDebugLevel(debugValue);
            FileProcessor fp = new FileProcessor(args[0]);
            AirportContextI myAirport = new Airport();

            while (true) {
                String line = fp.getLine();
                myLogger.writeOutput("New Line Read", MyLogger.DEBUG_VALUE.READLINE);
                if (line == null) {
                    break;
                }
                int start = line.indexOf("y:");
                int end = line.indexOf(";");
                String day = line.substring(start + 2, end);
                start = end + 6;
                String item = line.substring(start);
                // System.out.println(day + " " + item);
                myAirport.increaseOrDecreaseSecurity(item, day);


            }//while
            myAirport.printResults(args[1]);
        }//else
    }//main

}