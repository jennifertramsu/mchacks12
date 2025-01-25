/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;

// line 2 "model.ump"
// line 95 "model.ump"
public class ERQueue
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ERQueue Attributes
  private String waitingCount;
  private String longestWaitTime;

  //ERQueue Associations
  private List<Patient> patients;
  private CategoryStats categoryStats;
  private Position position;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ERQueue(String aWaitingCount, String aLongestWaitTime, CategoryStats aCategoryStats, Position aPosition)
  {
    waitingCount = aWaitingCount;
    longestWaitTime = aLongestWaitTime;
    patients = new ArrayList<Patient>();
    if (aCategoryStats == null || aCategoryStats.getERQueue() != null)
    {
      throw new RuntimeException("Unable to create ERQueue due to aCategoryStats. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    categoryStats = aCategoryStats;
    if (aPosition == null || aPosition.getERQueue() != null)
    {
      throw new RuntimeException("Unable to create ERQueue due to aPosition. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    position = aPosition;
  }

  public ERQueue(String aWaitingCount, String aLongestWaitTime, String aCategoryBreakdownForCategoryStats, String aAverageWaitTimesForCategoryStats, String aGlobalForPosition, String aCategoryForPosition, Patient aPatientForPosition)
  {
    waitingCount = aWaitingCount;
    longestWaitTime = aLongestWaitTime;
    patients = new ArrayList<Patient>();
    categoryStats = new CategoryStats(aCategoryBreakdownForCategoryStats, aAverageWaitTimesForCategoryStats, this);
    position = new Position(aGlobalForPosition, aCategoryForPosition, this, aPatientForPosition);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setWaitingCount(String aWaitingCount)
  {
    boolean wasSet = false;
    waitingCount = aWaitingCount;
    wasSet = true;
    return wasSet;
  }

  public boolean setLongestWaitTime(String aLongestWaitTime)
  {
    boolean wasSet = false;
    longestWaitTime = aLongestWaitTime;
    wasSet = true;
    return wasSet;
  }

  public String getWaitingCount()
  {
    return waitingCount;
  }

  public String getLongestWaitTime()
  {
    return longestWaitTime;
  }
  /* Code from template association_GetMany */
  public Patient getPatient(int index)
  {
    Patient aPatient = patients.get(index);
    return aPatient;
  }

  public List<Patient> getPatients()
  {
    List<Patient> newPatients = Collections.unmodifiableList(patients);
    return newPatients;
  }

  public int numberOfPatients()
  {
    int number = patients.size();
    return number;
  }

  public boolean hasPatients()
  {
    boolean has = patients.size() > 0;
    return has;
  }

  public int indexOfPatient(Patient aPatient)
  {
    int index = patients.indexOf(aPatient);
    return index;
  }
  /* Code from template association_GetOne */
  public CategoryStats getCategoryStats()
  {
    return categoryStats;
  }
  /* Code from template association_GetOne */
  public Position getPosition()
  {
    return position;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPatients()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Patient addPatient(String aId, String aArrival_time, String aTime_elapsed, Triage aTriage, Position aPosition)
  {
    return new Patient(aId, aArrival_time, aTime_elapsed, this, aTriage, aPosition);
  }

  public boolean addPatient(Patient aPatient)
  {
    boolean wasAdded = false;
    if (patients.contains(aPatient)) { return false; }
    ERQueue existingERQueue = aPatient.getERQueue();
    boolean isNewERQueue = existingERQueue != null && !this.equals(existingERQueue);
    if (isNewERQueue)
    {
      aPatient.setERQueue(this);
    }
    else
    {
      patients.add(aPatient);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePatient(Patient aPatient)
  {
    boolean wasRemoved = false;
    //Unable to remove aPatient, as it must always have a eRQueue
    if (!this.equals(aPatient.getERQueue()))
    {
      patients.remove(aPatient);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPatientAt(Patient aPatient, int index)
  {  
    boolean wasAdded = false;
    if(addPatient(aPatient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPatients()) { index = numberOfPatients() - 1; }
      patients.remove(aPatient);
      patients.add(index, aPatient);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePatientAt(Patient aPatient, int index)
  {
    boolean wasAdded = false;
    if(patients.contains(aPatient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPatients()) { index = numberOfPatients() - 1; }
      patients.remove(aPatient);
      patients.add(index, aPatient);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPatientAt(aPatient, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=patients.size(); i > 0; i--)
    {
      Patient aPatient = patients.get(i - 1);
      aPatient.delete();
    }
    CategoryStats existingCategoryStats = categoryStats;
    categoryStats = null;
    if (existingCategoryStats != null)
    {
      existingCategoryStats.delete();
    }
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
            "  " + "categoryStats = "+(getCategoryStats()!=null?Integer.toHexString(System.identityHashCode(getCategoryStats())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "position = "+(getPosition()!=null?Integer.toHexString(System.identityHashCode(getPosition())):"null");
  }
}