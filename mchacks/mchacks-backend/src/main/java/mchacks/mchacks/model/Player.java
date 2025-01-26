package mchacks.mchacks.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Player
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Player Attributes
  private int score;
  @Id
  private String id;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Player(int aScore, Patient patient)
  {
    score = aScore;
    id = patient.getId();
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

  public int getScore()
  {
    return score;
  }

  public String getPatient_id()
  {
    return id;
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