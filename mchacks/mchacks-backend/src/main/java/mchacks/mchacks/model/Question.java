/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/



// line 7 "model.ump"
// line 36 "model.ump"
public class Question
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Question Attributes
  private int id;
  private String text;
  private int points;

  //Question Associations
  private Answer correct;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Question(int aId, String aText, int aPoints, Answer aCorrect)
  {
    id = aId;
    text = aText;
    points = aPoints;
    if (aCorrect == null || aCorrect.getQuestion() != null)
    {
      throw new RuntimeException("Unable to create Question due to aCorrect. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    correct = aCorrect;
  }

  public Question(int aId, String aText, int aPoints, int aIdForCorrect, String aTextForCorrect, AnswerBank aAnswerBankForCorrect)
  {
    id = aId;
    text = aText;
    points = aPoints;
    correct = new Answer(aIdForCorrect, aTextForCorrect, this, aAnswerBankForCorrect);
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

  public boolean setPoints(int aPoints)
  {
    boolean wasSet = false;
    points = aPoints;
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

  public int getPoints()
  {
    return points;
  }
  /* Code from template association_GetOne */
  public Answer getCorrect()
  {
    return correct;
  }

  public void delete()
  {
    Answer existingCorrect = correct;
    correct = null;
    if (existingCorrect != null)
    {
      existingCorrect.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "text" + ":" + getText()+ "," +
            "points" + ":" + getPoints()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "correct = "+(getCorrect()!=null?Integer.toHexString(System.identityHashCode(getCorrect())):"null");
  }
}