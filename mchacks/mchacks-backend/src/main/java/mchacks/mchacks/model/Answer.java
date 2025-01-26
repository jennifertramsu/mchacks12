package mchacks.mchacks.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

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

  public Answer()
  {}

  public Answer(String aText)
  {
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
