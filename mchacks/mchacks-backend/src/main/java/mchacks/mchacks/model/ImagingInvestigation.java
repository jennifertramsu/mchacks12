/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/



// line 40 "model.ump"
// line 67 "model.ump"

import jakarta.persistence.Entity;

@Entity
public class ImagingInvestigation extends Investigation
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ImagingInvestigation(String aStatus, Patient aPatient)
  {
    super(aStatus, aPatient);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {
    super.delete();
  }

}