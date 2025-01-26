package mchacks.mchacks.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Answer
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Answer Attributes
  @Id
  @GeneratedValue
  private int id;
  private String text;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Answer(int aId, String aText)
  {
    id = aId;
    text = aText;
  }

  public Answer(int aId, String aText, int aIdForCorrect, String aTextForCorrect, int aPointsForCorrect, Question aIncorrect)
  {
    id = aId;
    text = aText;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(int aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setText(String aText)
  {
    boolean wasSet = false;
    text = aText;
    wasSet = true;
    return wasSet;
  }

  public int getId()
  {
    return id;
  }

  public String getText()
  {
    return text;
  }

  public void delete()
  {}

  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "text" + ":" + getText()+ "]";
  }
}
