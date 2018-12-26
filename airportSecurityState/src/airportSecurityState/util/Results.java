package airportSecurityState.util;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.File;
import airportSecurityState.util.MyLogger;
public class Results implements FileDisplayInterface {
    ArrayList<String> resultList;
    private static final MyLogger myLogger = new MyLogger();

    /**
     * Results constructor
     *
     * Creates a new results object
     *
     *@param
     *@return
     */
    public Results(){
        resultList = new ArrayList();
        myLogger.writeOutput("Results has been constructed", MyLogger.DEBUG_VALUE.CONSTRUCTOR);
    }

    public void addResult(String s){
        resultList.add(s);
    }

    /**
     * Print to file
     *
     *
     *
     *@param
     *@return
     */
    public void printFile(String filePath){
        File outFile = new File(filePath);
        PrintWriter p = null;
        try{
            p = new PrintWriter(outFile);
            for (int i = 0; i < resultList.size() ; i++) {
                p.println(resultList.get(i));
            }

        }catch(Exception e){

        }


        p.close();
    }




}