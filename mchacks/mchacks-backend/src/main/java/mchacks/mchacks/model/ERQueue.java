/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/



// line 2 "model.ump"
// line 44 "model.ump"
public class ERQueue
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ERQueue Attributes
  private int waitingCount;
  private int longestWaitTime;

  //ERQueue Associations
  private Position position;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ERQueue(int aWaitingCount, int aLongestWaitTime, Position aPosition)
  {
    waitingCount = aWaitingCount;
    longestWaitTime = aLongestWaitTime;
    if (aPosition == null || aPosition.getERQueue() != null)
    {
      throw new RuntimeException("Unable to create ERQueue due to aPosition. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    position = aPosition;
  }

  public ERQueue(int aWaitingCount, int aLongestWaitTime, int aGlobalForPosition, int aCategoryForPosition, Patient aPatientForPosition)
  {
    waitingCount = aWaitingCount;
    longestWaitTime = aLongestWaitTime;
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

  public int getWaitingCount()
  {
    return waitingCount;
  }

  public int getLongestWaitTime()
  {
    return longestWaitTime;
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
            "longestWaitTime" + ":" + getLongestWaitTime()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "position = "+(getPosition()!=null?Integer.toHexString(System.identityHashCode(getPosition())):"null");
  }
}