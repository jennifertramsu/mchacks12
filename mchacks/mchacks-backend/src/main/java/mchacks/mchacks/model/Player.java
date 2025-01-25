/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/



// line 2 "model.ump"
// line 31 "model.ump"
public class Player
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Player Attributes
  private int score;
  private String patient_id;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Player(int aScore, String aPatient_id)
  {
    score = aScore;
    patient_id = aPatient_id;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setScore(int aScore)
  {
    boolean wasSet = false;
    score = aScore;
    wasSet = true;
    return wasSet;
  }

  public boolean setPatient_id(String aPatient_id)
  {
    boolean wasSet = false;
    patient_id = aPatient_id;
    wasSet = true;
    return wasSet;
  }

  public int getScore()
  {
    return score;
  }

  public String getPatient_id()
  {
    return patient_id;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "score" + ":" + getScore()+ "," +
            "patient_id" + ":" + getPatient_id()+ "]";
  }
}