/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;

// line 20 "model.ump"
// line 54 "model.ump"
public class Position
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Position Attributes
  private int global;
  private int category;

  //Position Associations
  private ERQueue eRQueue;
  private Patient patient;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetERQueue;
  private boolean canSetPatient;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Position(int aGlobal, int aCategory, ERQueue aERQueue, Patient aPatient)
  {
    cachedHashCode = -1;
    canSetERQueue = true;
    canSetPatient = true;
    global = aGlobal;
    category = aCategory;
    if (aERQueue == null || aERQueue.getPosition() != null)
    {
      throw new RuntimeException("Unable to create Position due to aERQueue. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    eRQueue = aERQueue;
    if (aPatient == null || aPatient.getPosition() != null)
    {
      throw new RuntimeException("Unable to create Position due to aPatient. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    patient = aPatient;
  }

  public Position(int aGlobal, int aCategory, int aWaitingCountForERQueue, int aLongestWaitTimeForERQueue, String aIdForPatient, DateTime aArrival_timeForPatient, int aTime_elapsedForPatient, Dict aCategoryBreakdownForPatient, Dict aAverageWaitTimesForPatient, String aTriage_categoryForPatient, String aPhaseForPatient)
  {
    global = aGlobal;
    category = aCategory;
    eRQueue = new ERQueue(aWaitingCountForERQueue, aLongestWaitTimeForERQueue, this);
    patient = new Patient(aIdForPatient, aArrival_timeForPatient, aTime_elapsedForPatient, aCategoryBreakdownForPatient, aAverageWaitTimesForPatient, aTriage_categoryForPatient, aPhaseForPatient, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setGlobal(int aGlobal)
  {
    boolean wasSet = false;
    global = aGlobal;
    wasSet = true;
    return wasSet;
  }

  public boolean setCategory(int aCategory)
  {
    boolean wasSet = false;
    category = aCategory;
    wasSet = true;
    return wasSet;
  }

  public int getGlobal()
  {
    return global;
  }

  public int getCategory()
  {
    return category;
  }
  /* Code from template association_GetOne */
  public ERQueue getERQueue()
  {
    return eRQueue;
  }
  /* Code from template association_GetOne */
  public Patient getPatient()
  {
    return patient;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Position compareTo = (Position)obj;
  
    if (getERQueue() == null && compareTo.getERQueue() != null)
    {
      return false;
    }
    else if (getERQueue() != null && !getERQueue().equals(compareTo.getERQueue()))
    {
      return false;
    }

    if (getPatient() == null && compareTo.getPatient() != null)
    {
      return false;
    }
    else if (getPatient() != null && !getPatient().equals(compareTo.getPatient()))
    {
      return false;
    }

    return true;
  }

  public int hashCode()
  {
    if (cachedHashCode != -1)
    {
      return cachedHashCode;
    }
    cachedHashCode = 17;
    if (getERQueue() != null)
    {
      cachedHashCode = cachedHashCode * 23 + getERQueue().hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }
    if (getPatient() != null)
    {
      cachedHashCode = cachedHashCode * 23 + getPatient().hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetERQueue = false;
    canSetPatient = false;
    return cachedHashCode;
  }

  public void delete()
  {
    ERQueue existingERQueue = eRQueue;
    eRQueue = null;
    if (existingERQueue != null)
    {
      existingERQueue.delete();
    }
    Patient existingPatient = patient;
    patient = null;
    if (existingPatient != null)
    {
      existingPatient.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "global" + ":" + getGlobal()+ "," +
            "category" + ":" + getCategory()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "eRQueue = "+(getERQueue()!=null?Integer.toHexString(System.identityHashCode(getERQueue())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "patient = "+(getPatient()!=null?Integer.toHexString(System.identityHashCode(getPatient())):"null");
  }
}