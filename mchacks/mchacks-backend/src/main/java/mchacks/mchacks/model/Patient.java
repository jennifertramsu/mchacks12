/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;

// line 19 "model.ump"
// line 58 "model.ump"
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
  private String id;
  private DateTime arrival_time;
  private int time_elapsed;
  private String triage_category;
  private String phase;

  //Patient Associations
  private List<Investigation> investigations;
  private Position position;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Patient(String aId, DateTime aArrival_time, int aTime_elapsed, String aTriage_category, String aPhase, Position aPosition)
  {
    arrival_time = aArrival_time;
    time_elapsed = aTime_elapsed;
    triage_category = aTriage_category;
    phase = aPhase;
    if (!setId(aId))
    {
      throw new RuntimeException("Cannot create due to duplicate id. See https://manual.umple.org?RE003ViolationofUniqueness.html");
    }
    investigations = new ArrayList<Investigation>();
    if (aPosition == null || aPosition.getPatient() != null)
    {
      throw new RuntimeException("Unable to create Patient due to aPosition. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    position = aPosition;
  }

  public Patient(String aId, DateTime aArrival_time, int aTime_elapsed, String aTriage_category, String aPhase, int aGlobalForPosition, int aCategoryForPosition, ERQueue aERQueueForPosition)
  {
    if (!setId(aId))
    {
      throw new RuntimeException("Cannot create due to duplicate id. See https://manual.umple.org?RE003ViolationofUniqueness.html");
    }
    arrival_time = aArrival_time;
    time_elapsed = aTime_elapsed;
    triage_category = aTriage_category;
    phase = aPhase;
    investigations = new ArrayList<Investigation>();
    position = new Position(aGlobalForPosition, aCategoryForPosition, aERQueueForPosition, this);
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
  /* Code from template association_GetOne */
  public Position getPosition()
  {
    return position;
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
    for(int i=investigations.size(); i > 0; i--)
    {
      Investigation aInvestigation = investigations.get(i - 1);
      aInvestigation.delete();
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
            "time_elapsed" + ":" + getTime_elapsed()+ "," +
            "triage_category" + ":" + getTriage_category()+ "," +
            "phase" + ":" + getPhase()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "arrival_time" + "=" + (getArrival_time() != null ? !getArrival_time().equals(this)  ? getArrival_time().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "position = "+(getPosition()!=null?Integer.toHexString(System.identityHashCode(getPosition())):"null");
  }
}