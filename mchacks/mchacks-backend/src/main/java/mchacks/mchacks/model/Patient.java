/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;

// line 8 "model.ump"
// line 55 "model.ump"
public class Patient
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Patient Attributes
  private String id;
  private String arrival_time;
  private String time_elapsed;

  //Patient Associations
  private ERQueue eRQueue;
  private Triage triage;
  private List<Status> statuses;
  private Position position;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Patient(String aId, String aArrival_time, String aTime_elapsed, ERQueue aERQueue, Triage aTriage, Position aPosition)
  {
    id = aId;
    arrival_time = aArrival_time;
    time_elapsed = aTime_elapsed;
    boolean didAddERQueue = setERQueue(aERQueue);
    if (!didAddERQueue)
    {
      throw new RuntimeException("Unable to create patient due to eRQueue. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddTriage = setTriage(aTriage);
    if (!didAddTriage)
    {
      throw new RuntimeException("Unable to create patient due to triage. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    statuses = new ArrayList<Status>();
    if (aPosition == null || aPosition.getPatient() != null)
    {
      throw new RuntimeException("Unable to create Patient due to aPosition. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    position = aPosition;
  }

  public Patient(String aId, String aArrival_time, String aTime_elapsed, ERQueue aERQueue, Triage aTriage, String aGlobalForPosition, String aCategoryForPosition, ERQueue aERQueueForPosition)
  {
    id = aId;
    arrival_time = aArrival_time;
    time_elapsed = aTime_elapsed;
    boolean didAddERQueue = setERQueue(aERQueue);
    if (!didAddERQueue)
    {
      throw new RuntimeException("Unable to create patient due to eRQueue. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddTriage = setTriage(aTriage);
    if (!didAddTriage)
    {
      throw new RuntimeException("Unable to create patient due to triage. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    statuses = new ArrayList<Status>();
    position = new Position(aGlobalForPosition, aCategoryForPosition, aERQueueForPosition, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setArrival_time(String aArrival_time)
  {
    boolean wasSet = false;
    arrival_time = aArrival_time;
    wasSet = true;
    return wasSet;
  }

  public boolean setTime_elapsed(String aTime_elapsed)
  {
    boolean wasSet = false;
    time_elapsed = aTime_elapsed;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }

  public String getArrival_time()
  {
    return arrival_time;
  }

  public String getTime_elapsed()
  {
    return time_elapsed;
  }
  /* Code from template association_GetOne */
  public ERQueue getERQueue()
  {
    return eRQueue;
  }
  /* Code from template association_GetOne */
  public Triage getTriage()
  {
    return triage;
  }
  /* Code from template association_GetMany */
  public Status getStatus(int index)
  {
    Status aStatus = statuses.get(index);
    return aStatus;
  }

  public List<Status> getStatuses()
  {
    List<Status> newStatuses = Collections.unmodifiableList(statuses);
    return newStatuses;
  }

  public int numberOfStatuses()
  {
    int number = statuses.size();
    return number;
  }

  public boolean hasStatuses()
  {
    boolean has = statuses.size() > 0;
    return has;
  }

  public int indexOfStatus(Status aStatus)
  {
    int index = statuses.indexOf(aStatus);
    return index;
  }
  /* Code from template association_GetOne */
  public Position getPosition()
  {
    return position;
  }
  /* Code from template association_SetOneToMany */
  public boolean setERQueue(ERQueue aERQueue)
  {
    boolean wasSet = false;
    if (aERQueue == null)
    {
      return wasSet;
    }

    ERQueue existingERQueue = eRQueue;
    eRQueue = aERQueue;
    if (existingERQueue != null && !existingERQueue.equals(aERQueue))
    {
      existingERQueue.removePatient(this);
    }
    eRQueue.addPatient(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setTriage(Triage aTriage)
  {
    boolean wasSet = false;
    if (aTriage == null)
    {
      return wasSet;
    }

    Triage existingTriage = triage;
    triage = aTriage;
    if (existingTriage != null && !existingTriage.equals(aTriage))
    {
      existingTriage.removePatient(this);
    }
    triage.addPatient(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfStatuses()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addStatus(Status aStatus)
  {
    boolean wasAdded = false;
    if (statuses.contains(aStatus)) { return false; }
    statuses.add(aStatus);
    if (aStatus.indexOfPatient(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aStatus.addPatient(this);
      if (!wasAdded)
      {
        statuses.remove(aStatus);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeStatus(Status aStatus)
  {
    boolean wasRemoved = false;
    if (!statuses.contains(aStatus))
    {
      return wasRemoved;
    }

    int oldIndex = statuses.indexOf(aStatus);
    statuses.remove(oldIndex);
    if (aStatus.indexOfPatient(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aStatus.removePatient(this);
      if (!wasRemoved)
      {
        statuses.add(oldIndex,aStatus);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addStatusAt(Status aStatus, int index)
  {  
    boolean wasAdded = false;
    if(addStatus(aStatus))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStatuses()) { index = numberOfStatuses() - 1; }
      statuses.remove(aStatus);
      statuses.add(index, aStatus);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStatusAt(Status aStatus, int index)
  {
    boolean wasAdded = false;
    if(statuses.contains(aStatus))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStatuses()) { index = numberOfStatuses() - 1; }
      statuses.remove(aStatus);
      statuses.add(index, aStatus);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStatusAt(aStatus, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ERQueue placeholderERQueue = eRQueue;
    this.eRQueue = null;
    if(placeholderERQueue != null)
    {
      placeholderERQueue.removePatient(this);
    }
    Triage placeholderTriage = triage;
    this.triage = null;
    if(placeholderTriage != null)
    {
      placeholderTriage.removePatient(this);
    }
    ArrayList<Status> copyOfStatuses = new ArrayList<Status>(statuses);
    statuses.clear();
    for(Status aStatus : copyOfStatuses)
    {
      aStatus.removePatient(this);
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
            "id" + ":" + getId()+ "," +
            "arrival_time" + ":" + getArrival_time()+ "," +
            "time_elapsed" + ":" + getTime_elapsed()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "eRQueue = "+(getERQueue()!=null?Integer.toHexString(System.identityHashCode(getERQueue())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "triage = "+(getTriage()!=null?Integer.toHexString(System.identityHashCode(getTriage())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "position = "+(getPosition()!=null?Integer.toHexString(System.identityHashCode(getPosition())):"null");
  }
}