/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.time.LocalDate;
import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// line 19 "model.ump"
// line 52 "model.ump"
@Entity
public class Patient
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<String, Patient> patientsById = new HashMap<String, Patient>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Patient Attributes
  @Id
  private String id;
  private LocalDate arrival_time;
  private int time_elapsed;
  private String triage_category;
  private String phase;
  private int globalPosition;
  private int categoryPosition;

  //Patient Associations
  private ERQueue eRQueue;
  private List<Investigation> investigations;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Patient(String aId, LocalDate aArrival_time, int aTime_elapsed, String aTriage_category, String aPhase, int aGlobalPosition, int aCategoryPosition, ERQueue aERQueue)
  {
    arrival_time = aArrival_time;
    time_elapsed = aTime_elapsed;
    triage_category = aTriage_category;
    phase = aPhase;
    globalPosition = aGlobalPosition;
    categoryPosition = aCategoryPosition;
    if (!setId(aId))
    {
      throw new RuntimeException("Cannot create due to duplicate id. See https://manual.umple.org?RE003ViolationofUniqueness.html");
    }
    boolean didAddERQueue = setERQueue(aERQueue);
    if (!didAddERQueue)
    {
      throw new RuntimeException("Unable to create patient due to eRQueue. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    investigations = new ArrayList<Investigation>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    String anOldId = getId();
    if (anOldId != null && anOldId.equals(aId)) {
      return true;
    }
    if (hasWithId(aId)) {
      return wasSet;
    }
    id = aId;
    wasSet = true;
    if (anOldId != null) {
      patientsById.remove(anOldId);
    }
    patientsById.put(aId, this);
    return wasSet;
  }

  public boolean setArrival_time(DateTime aArrival_time)
  {
    boolean wasSet = false;
    arrival_time = aArrival_time;
    wasSet = true;
    return wasSet;
  }

  public boolean setTime_elapsed(int aTime_elapsed)
  {
    boolean wasSet = false;
    time_elapsed = aTime_elapsed;
    wasSet = true;
    return wasSet;
  }

  public boolean setTriage_category(String aTriage_category)
  {
    boolean wasSet = false;
    triage_category = aTriage_category;
    wasSet = true;
    return wasSet;
  }

  public boolean setPhase(String aPhase)
  {
    boolean wasSet = false;
    phase = aPhase;
    wasSet = true;
    return wasSet;
  }

  public boolean setGlobalPosition(int aGlobalPosition)
  {
    boolean wasSet = false;
    globalPosition = aGlobalPosition;
    wasSet = true;
    return wasSet;
  }

  public boolean setCategoryPosition(int aCategoryPosition)
  {
    boolean wasSet = false;
    categoryPosition = aCategoryPosition;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }
  /* Code from template attribute_GetUnique */
  public static Patient getWithId(String aId)
  {
    return patientsById.get(aId);
  }
  /* Code from template attribute_HasUnique */
  public static boolean hasWithId(String aId)
  {
    return getWithId(aId) != null;
  }

  public DateTime getArrival_time()
  {
    return arrival_time;
  }

  public int getTime_elapsed()
  {
    return time_elapsed;
  }

  public String getTriage_category()
  {
    return triage_category;
  }

  public String getPhase()
  {
    return phase;
  }

  public int getGlobalPosition()
  {
    return globalPosition;
  }

  public int getCategoryPosition()
  {
    return categoryPosition;
  }
  /* Code from template association_GetOne */
  public ERQueue getERQueue()
  {
    return eRQueue;
  }
  /* Code from template association_GetMany */
  public Investigation getInvestigation(int index)
  {
    Investigation aInvestigation = investigations.get(index);
    return aInvestigation;
  }

  public List<Investigation> getInvestigations()
  {
    List<Investigation> newInvestigations = Collections.unmodifiableList(investigations);
    return newInvestigations;
  }

  public int numberOfInvestigations()
  {
    int number = investigations.size();
    return number;
  }

  public boolean hasInvestigations()
  {
    boolean has = investigations.size() > 0;
    return has;
  }

  public int indexOfInvestigation(Investigation aInvestigation)
  {
    int index = investigations.indexOf(aInvestigation);
    return index;
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfInvestigations()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Investigation addInvestigation(String aStatus)
  {
    return new Investigation(aStatus, this);
  }

  public boolean addInvestigation(Investigation aInvestigation)
  {
    boolean wasAdded = false;
    if (investigations.contains(aInvestigation)) { return false; }
    Patient existingPatient = aInvestigation.getPatient();
    boolean isNewPatient = existingPatient != null && !this.equals(existingPatient);
    if (isNewPatient)
    {
      aInvestigation.setPatient(this);
    }
    else
    {
      investigations.add(aInvestigation);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeInvestigation(Investigation aInvestigation)
  {
    boolean wasRemoved = false;
    //Unable to remove aInvestigation, as it must always have a patient
    if (!this.equals(aInvestigation.getPatient()))
    {
      investigations.remove(aInvestigation);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addInvestigationAt(Investigation aInvestigation, int index)
  {  
    boolean wasAdded = false;
    if(addInvestigation(aInvestigation))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfInvestigations()) { index = numberOfInvestigations() - 1; }
      investigations.remove(aInvestigation);
      investigations.add(index, aInvestigation);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveInvestigationAt(Investigation aInvestigation, int index)
  {
    boolean wasAdded = false;
    if(investigations.contains(aInvestigation))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfInvestigations()) { index = numberOfInvestigations() - 1; }
      investigations.remove(aInvestigation);
      investigations.add(index, aInvestigation);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addInvestigationAt(aInvestigation, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    patientsById.remove(getId());
    ERQueue placeholderERQueue = eRQueue;
    this.eRQueue = null;
    if(placeholderERQueue != null)
    {
      placeholderERQueue.removePatient(this);
    }
    for(int i=investigations.size(); i > 0; i--)
    {
      Investigation aInvestigation = investigations.get(i - 1);
      aInvestigation.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "time_elapsed" + ":" + getTime_elapsed()+ "," +
            "triage_category" + ":" + getTriage_category()+ "," +
            "phase" + ":" + getPhase()+ "," +
            "globalPosition" + ":" + getGlobalPosition()+ "," +
            "categoryPosition" + ":" + getCategoryPosition()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "arrival_time" + "=" + (getArrival_time() != null ? !getArrival_time().equals(this)  ? getArrival_time().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "eRQueue = "+(getERQueue()!=null?Integer.toHexString(System.identityHashCode(getERQueue())):"null");
  }
}