/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;

// line 16 "model.ump"
// line 85 "model.ump"
public class Triage
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Triage Attributes
  private String triage_category;

  //Triage Associations
  private List<Patient> patients;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Triage(String aTriage_category)
  {
    triage_category = aTriage_category;
    patients = new ArrayList<Patient>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTriage_category(String aTriage_category)
  {
    boolean wasSet = false;
    triage_category = aTriage_category;
    wasSet = true;
    return wasSet;
  }

  public String getTriage_category()
  {
    return triage_category;
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPatients()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Patient addPatient(String aId, String aArrival_time, String aTime_elapsed, ERQueue aERQueue, Position aPosition)
  {
    return new Patient(aId, aArrival_time, aTime_elapsed, aERQueue, this, aPosition);
  }

  public boolean addPatient(Patient aPatient)
  {
    boolean wasAdded = false;
    if (patients.contains(aPatient)) { return false; }
    Triage existingTriage = aPatient.getTriage();
    boolean isNewTriage = existingTriage != null && !this.equals(existingTriage);
    if (isNewTriage)
    {
      aPatient.setTriage(this);
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
    //Unable to remove aPatient, as it must always have a triage
    if (!this.equals(aPatient.getTriage()))
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
  }


  public String toString()
  {
    return super.toString() + "["+
            "triage_category" + ":" + getTriage_category()+ "]";
  }
}