package mchacks.mchacks.model;
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