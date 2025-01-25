/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/



// line 29 "model.ump"
// line 59 "model.ump"
public class Investigation
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Investigation Attributes
  private String status;

  //Investigation Associations
  private Patient patient;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Investigation(String aStatus, Patient aPatient)
  {
    status = aStatus;
    boolean didAddPatient = setPatient(aPatient);
    if (!didAddPatient)
    {
      throw new RuntimeException("Unable to create investigation due to patient. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setStatus(String aStatus)
  {
    boolean wasSet = false;
    status = aStatus;
    wasSet = true;
    return wasSet;
  }

  public String getStatus()
  {
    return status;
  }
  /* Code from template association_GetOne */
  public Patient getPatient()
  {
    return patient;
  }
  /* Code from template association_SetOneToMany */
  public boolean setPatient(Patient aPatient)
  {
    boolean wasSet = false;
    if (aPatient == null)
    {
      return wasSet;
    }

    Patient existingPatient = patient;
    patient = aPatient;
    if (existingPatient != null && !existingPatient.equals(aPatient))
    {
      existingPatient.removeInvestigation(this);
    }
    patient.addInvestigation(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Patient placeholderPatient = patient;
    this.patient = null;
    if(placeholderPatient != null)
    {
      placeholderPatient.removeInvestigation(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "status" + ":" + getStatus()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "patient = "+(getPatient()!=null?Integer.toHexString(System.identityHashCode(getPatient())):"null");
  }
}