/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/



// line 21 "model.ump"
// line 90 "model.ump"
public class CategoryStats
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CategoryStats Attributes
  private String categoryBreakdown;
  private String averageWaitTimes;

  //CategoryStats Associations
  private ERQueue eRQueue;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CategoryStats(String aCategoryBreakdown, String aAverageWaitTimes, ERQueue aERQueue)
  {
    categoryBreakdown = aCategoryBreakdown;
    averageWaitTimes = aAverageWaitTimes;
    if (aERQueue == null || aERQueue.getCategoryStats() != null)
    {
      throw new RuntimeException("Unable to create CategoryStats due to aERQueue. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    eRQueue = aERQueue;
  }

  public CategoryStats(String aCategoryBreakdown, String aAverageWaitTimes, String aWaitingCountForERQueue, String aLongestWaitTimeForERQueue, Position aPositionForERQueue)
  {
    categoryBreakdown = aCategoryBreakdown;
    averageWaitTimes = aAverageWaitTimes;
    eRQueue = new ERQueue(aWaitingCountForERQueue, aLongestWaitTimeForERQueue, this, aPositionForERQueue);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCategoryBreakdown(String aCategoryBreakdown)
  {
    boolean wasSet = false;
    categoryBreakdown = aCategoryBreakdown;
    wasSet = true;
    return wasSet;
  }

  public boolean setAverageWaitTimes(String aAverageWaitTimes)
  {
    boolean wasSet = false;
    averageWaitTimes = aAverageWaitTimes;
    wasSet = true;
    return wasSet;
  }

  public String getCategoryBreakdown()
  {
    return categoryBreakdown;
  }

  public String getAverageWaitTimes()
  {
    return averageWaitTimes;
  }
  /* Code from template association_GetOne */
  public ERQueue getERQueue()
  {
    return eRQueue;
  }

  public void delete()
  {
    ERQueue existingERQueue = eRQueue;
    eRQueue = null;
    if (existingERQueue != null)
    {
      existingERQueue.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "categoryBreakdown" + ":" + getCategoryBreakdown()+ "," +
            "averageWaitTimes" + ":" + getAverageWaitTimes()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "eRQueue = "+(getERQueue()!=null?Integer.toHexString(System.identityHashCode(getERQueue())):"null");
  }
}