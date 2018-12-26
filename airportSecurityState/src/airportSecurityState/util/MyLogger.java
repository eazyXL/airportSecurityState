package airportSecurityState.util;

public class MyLogger {
	public static enum DEBUG_VALUE {
		READLINE, NEWPROITEM, NEWDAY, CONSTRUCTOR
	};

	public static DEBUG_VALUE debugLevel;

	/**
	 * Sets debug level by DEBUG_VALUE
	 * @param int level - debug level from command line argument
	 * @return none
	 * DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
	 * DEBUG_VALUE=3 [Print to stdout everytime a New Day happens]
	 * DEBUG_VALUE=2 [Print to stdout everytime a Prohibited item is found]
	 * DEBUG_VALUE=1 [Print to stdout each time a line is read]
	 * DEBUG_VALUE=0 [No output should be printed from the application]
	 */
	public static void setDebugLevel(int level) {
		switch (level) {
			case 1: debugLevel = DEBUG_VALUE.READLINE; break;
			case 2: debugLevel = DEBUG_VALUE.NEWPROITEM; break;
			case 3: debugLevel = DEBUG_VALUE.NEWDAY; break;
			case 4: debugLevel = DEBUG_VALUE.CONSTRUCTOR; break;
		}
	}

	/**
	 * Setter for debug level
	 * @param DEBUG_VALUE level to set as debug level
	 */
	public static void setDebugLevel(DEBUG_VALUE level) {
		debugLevel = level;
	}

	/**
	 * Writes a message with System.out
	 * @param String message to be written out
	 * @param int level - debug value
	 * @return none
	 */
	public static void writeOutput(String message, DEBUG_VALUE level) {
		try {
			if (level.ordinal() <= debugLevel.ordinal()) {
				System.out.println(message);
			}
		}catch(Exception e){

		}
	}
}