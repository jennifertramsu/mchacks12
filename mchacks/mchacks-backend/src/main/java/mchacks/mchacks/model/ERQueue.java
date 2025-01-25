/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/



// line 2 "model.ump"
// line 53 "model.ump"
public class ERQueue
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ERQueue Attributes
  private int waitingCount;
  private int longestWaitTime;
  private int averageWaitTimeOne;
  private int averageWaitTimeTwo;
  private int averageWaitTimeThree;
  private int averageWaitTimeFour;
  private int averageWaitTimeFive;
  private int numPatientsOne;
  private int numPatientsTwo;
  private int numPatientsThree;
  private int numPatientsFour;
  private int numPatientsFive;

  //ERQueue Associations
  private Position position;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ERQueue(int aWaitingCount, int aLongestWaitTime, int aAverageWaitTimeOne, int aAverageWaitTimeTwo, int aAverageWaitTimeThree, int aAverageWaitTimeFour, int aAverageWaitTimeFive, int aNumPatientsOne, int aNumPatientsTwo, int aNumPatientsThree, int aNumPatientsFour, int aNumPatientsFive, Position aPosition)
  {
    waitingCount = aWaitingCount;
    longestWaitTime = aLongestWaitTime;
    averageWaitTimeOne = aAverageWaitTimeOne;
    averageWaitTimeTwo = aAverageWaitTimeTwo;
    averageWaitTimeThree = aAverageWaitTimeThree;
    averageWaitTimeFour = aAverageWaitTimeFour;
    averageWaitTimeFive = aAverageWaitTimeFive;
    numPatientsOne = aNumPatientsOne;
    numPatientsTwo = aNumPatientsTwo;
    numPatientsThree = aNumPatientsThree;
    numPatientsFour = aNumPatientsFour;
    numPatientsFive = aNumPatientsFive;
    if (aPosition == null || aPosition.getERQueue() != null)
    {
      throw new RuntimeException("Unable to create ERQueue due to aPosition. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    position = aPosition;
  }

  public ERQueue(int aWaitingCount, int aLongestWaitTime, int aAverageWaitTimeOne, int aAverageWaitTimeTwo, int aAverageWaitTimeThree, int aAverageWaitTimeFour, int aAverageWaitTimeFive, int aNumPatientsOne, int aNumPatientsTwo, int aNumPatientsThree, int aNumPatientsFour, int aNumPatientsFive, int aGlobalForPosition, int aCategoryForPosition, Patient aPatientForPosition)
  {
    waitingCount = aWaitingCount;
    longestWaitTime = aLongestWaitTime;
    averageWaitTimeOne = aAverageWaitTimeOne;
    averageWaitTimeTwo = aAverageWaitTimeTwo;
    averageWaitTimeThree = aAverageWaitTimeThree;
    averageWaitTimeFour = aAverageWaitTimeFour;
    averageWaitTimeFive = aAverageWaitTimeFive;
    numPatientsOne = aNumPatientsOne;
    numPatientsTwo = aNumPatientsTwo;
    numPatientsThree = aNumPatientsThree;
    numPatientsFour = aNumPatientsFour;
    numPatientsFive = aNumPatientsFive;
    position = new Position(aGlobalForPosition, aCategoryForPosition, this, aPatientForPosition);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setWaitingCount(int aWaitingCount)
  {
    boolean wasSet = false;
    waitingCount = aWaitingCount;
    wasSet = true;
    return wasSet;
  }

  public boolean setLongestWaitTime(int aLongestWaitTime)
  {
    boolean wasSet = false;
    longestWaitTime = aLongestWaitTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setAverageWaitTimeOne(int aAverageWaitTimeOne)
  {
    boolean wasSet = false;
    averageWaitTimeOne = aAverageWaitTimeOne;
    wasSet = true;
    return wasSet;
  }

  public boolean setAverageWaitTimeTwo(int aAverageWaitTimeTwo)
  {
    boolean wasSet = false;
    averageWaitTimeTwo = aAverageWaitTimeTwo;
    wasSet = true;
    return wasSet;
  }

  public boolean setAverageWaitTimeThree(int aAverageWaitTimeThree)
  {
    boolean wasSet = false;
    averageWaitTimeThree = aAverageWaitTimeThree;
    wasSet = true;
    return wasSet;
  }

  public boolean setAverageWaitTimeFour(int aAverageWaitTimeFour)
  {
    boolean wasSet = false;
    averageWaitTimeFour = aAverageWaitTimeFour;
    wasSet = true;
    return wasSet;
  }

  public boolean setAverageWaitTimeFive(int aAverageWaitTimeFive)
  {
    boolean wasSet = false;
    averageWaitTimeFive = aAverageWaitTimeFive;
    wasSet = true;
    return wasSet;
  }

  public boolean setNumPatientsOne(int aNumPatientsOne)
  {
    boolean wasSet = false;
    numPatientsOne = aNumPatientsOne;
    wasSet = true;
    return wasSet;
  }

  public boolean setNumPatientsTwo(int aNumPatientsTwo)
  {
    boolean wasSet = false;
    numPatientsTwo = aNumPatientsTwo;
    wasSet = true;
    return wasSet;
  }

  public boolean setNumPatientsThree(int aNumPatientsThree)
  {
    boolean wasSet = false;
    numPatientsThree = aNumPatientsThree;
    wasSet = true;
    return wasSet;
  }

  public boolean setNumPatientsFour(int aNumPatientsFour)
  {
    boolean wasSet = false;
    numPatientsFour = aNumPatientsFour;
    wasSet = true;
    return wasSet;
  }

  public boolean setNumPatientsFive(int aNumPatientsFive)
  {
    boolean wasSet = false;
    numPatientsFive = aNumPatientsFive;
    wasSet = true;
    return wasSet;
  }

  public int getWaitingCount()
  {
    return waitingCount;
  }

  public int getLongestWaitTime()
  {
    return longestWaitTime;
  }

  public int getAverageWaitTimeOne()
  {
    return averageWaitTimeOne;
  }

  public int getAverageWaitTimeTwo()
  {
    return averageWaitTimeTwo;
  }

  public int getAverageWaitTimeThree()
  {
    return averageWaitTimeThree;
  }

  public int getAverageWaitTimeFour()
  {
    return averageWaitTimeFour;
  }

  public int getAverageWaitTimeFive()
  {
    return averageWaitTimeFive;
  }

  public int getNumPatientsOne()
  {
    return numPatientsOne;
  }

  public int getNumPatientsTwo()
  {
    return numPatientsTwo;
  }

  public int getNumPatientsThree()
  {
    return numPatientsThree;
  }

  public int getNumPatientsFour()
  {
    return numPatientsFour;
  }

  public int getNumPatientsFive()
  {
    return numPatientsFive;
  }
  /* Code from template association_GetOne */
  public Position getPosition()
  {
    return position;
  }

  public void delete()
  {
    Position existingPosition = position;
    position = null;
    if (existingPosition != null)
    {
      existingPosition.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "waitingCount" + ":" + getWaitingCount()+ "," +
            "longestWaitTime" + ":" + getLongestWaitTime()+ "," +
            "averageWaitTimeOne" + ":" + getAverageWaitTimeOne()+ "," +
            "averageWaitTimeTwo" + ":" + getAverageWaitTimeTwo()+ "," +
            "averageWaitTimeThree" + ":" + getAverageWaitTimeThree()+ "," +
            "averageWaitTimeFour" + ":" + getAverageWaitTimeFour()+ "," +
            "averageWaitTimeFive" + ":" + getAverageWaitTimeFive()+ "," +
            "numPatientsOne" + ":" + getNumPatientsOne()+ "," +
            "numPatientsTwo" + ":" + getNumPatientsTwo()+ "," +
            "numPatientsThree" + ":" + getNumPatientsThree()+ "," +
            "numPatientsFour" + ":" + getNumPatientsFour()+ "," +
            "numPatientsFive" + ":" + getNumPatientsFive()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "position = "+(getPosition()!=null?Integer.toHexString(System.identityHashCode(getPosition())):"null");
  }
}