/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;

// line 34 "model.ump"
// line 65 "model.ump"
public class Status
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Status Attributes
  private String current_phase;

  //Status Associations
  private List<Patient> patients;
  private List<Investigation> investigations;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Status(String aCurrent_phase)
  {
    current_phase = aCurrent_phase;
    patients = new ArrayList<Patient>();
    investigations = new ArrayList<Investigation>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCurrent_phase(String aCurrent_phase)
  {
    boolean wasSet = false;
    current_phase = aCurrent_phase;
    wasSet = true;
    return wasSet;
  }

  public String getCurrent_phase()
  {
    return current_phase;
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPatients()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addPatient(Patient aPatient)
  {
    boolean wasAdded = false;
    if (patients.contains(aPatient)) { return false; }
    patients.add(aPatient);
    if (aPatient.indexOfStatus(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aPatient.addStatus(this);
      if (!wasAdded)
      {
        patients.remove(aPatient);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removePatient(Patient aPatient)
  {
    boolean wasRemoved = false;
    if (!patients.contains(aPatient))
    {
      return wasRemoved;
    }

    int oldIndex = patients.indexOf(aPatient);
    patients.remove(oldIndex);
    if (aPatient.indexOfStatus(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aPatient.removeStatus(this);
      if (!wasRemoved)
      {
        patients.add(oldIndex,aPatient);
      }
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfInvestigations()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addInvestigation(Investigation aInvestigation)
  {
    boolean wasAdded = false;
    if (investigations.contains(aInvestigation)) { return false; }
    investigations.add(aInvestigation);
    if (aInvestigation.indexOfStatus(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aInvestigation.addStatus(this);
      if (!wasAdded)
      {
        investigations.remove(aInvestigation);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeInvestigation(Investigation aInvestigation)
  {
    boolean wasRemoved = false;
    if (!investigations.contains(aInvestigation))
    {
      return wasRemoved;
    }

    int oldIndex = investigations.indexOf(aInvestigation);
    investigations.remove(oldIndex);
    if (aInvestigation.indexOfStatus(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aInvestigation.removeStatus(this);
      if (!wasRemoved)
      {
        investigations.add(oldIndex,aInvestigation);
      }
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
    ArrayList<Patient> copyOfPatients = new ArrayList<Patient>(patients);
    patients.clear();
    for(Patient aPatient : copyOfPatients)
    {
      aPatient.removeStatus(this);
    }
    ArrayList<Investigation> copyOfInvestigations = new ArrayList<Investigation>(investigations);
    investigations.clear();
    for(Investigation aInvestigation : copyOfInvestigations)
    {
      aInvestigation.removeStatus(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "current_phase" + ":" + getCurrent_phase()+ "]";
  }
}