package airportSecurityState.util;
import java.util.Scanner;
import java.io.File;
import airportSecurityState.util.MyLogger;
public class FileProcessor {

    private static final MyLogger myLogger = new MyLogger();

    /**
     * Scanner to get lines
     */
    Scanner in;



    /**
     * FileProcessor constructor
     *
     * Creates scanner with an input file to read from
     *
     *@param String input: input file path
     *@return
     */
    public FileProcessor(String input){
        try{
            in = new Scanner(new File(input));
            myLogger.writeOutput("New FileProcessor has been constructed", MyLogger.DEBUG_VALUE.CONSTRUCTOR);

        }catch(Exception e){
            System.out.println("FileProcessor: input file not found **");
        }
    }


    /**
     * Gets next line
     *
     * Gets next line of file unless it is empty or reached EOF
     *
     *@param
     *@return String: line that was read or null if EOF
     */
    public String getLine(){
        if(this.in.hasNext()){
            return this.in.nextLine();
        }else{
            return null;
        }
    }
}