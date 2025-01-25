package mchacks.mchacks.model;

import jakarta.persistence.Entity;

@Entity
public class LabInvestigation extends Investigation
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public LabInvestigation(String aStatus, Patient aPatient)
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