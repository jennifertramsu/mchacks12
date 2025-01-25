/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;

// line 2 "model.ump"
// line 47 "model.ump"
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
  private List<Patient> patients;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ERQueue(int aWaitingCount, int aLongestWaitTime, int aAverageWaitTimeOne, int aAverageWaitTimeTwo, int aAverageWaitTimeThree, int aAverageWaitTimeFour, int aAverageWaitTimeFive, int aNumPatientsOne, int aNumPatientsTwo, int aNumPatientsThree, int aNumPatientsFour, int aNumPatientsFive)
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
    patients = new ArrayList<Patient>();
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
  public Patient addPatient(String aId, DateTime aArrival_time, int aTime_elapsed, String aTriage_category, String aPhase, int aGlobalPosition, int aCategoryPosition)
  {
    return new Patient(aId, aArrival_time, aTime_elapsed, aTriage_category, aPhase, aGlobalPosition, aCategoryPosition, this);
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
            "numPatientsFive" + ":" + getNumPatientsFive()+ "]";
  }
}