/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/



// line 22 "model.ump"
// line 41 "model.ump"
public class Answer
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Answer Attributes
  private int id;
  private String text;

  //Answer Associations
  private Question question;
  private AnswerBank answerBank;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Answer(int aId, String aText, Question aQuestion, AnswerBank aAnswerBank)
  {
    id = aId;
    text = aText;
    if (aQuestion == null || aQuestion.getCorrect() != null)
    {
      throw new RuntimeException("Unable to create Answer due to aQuestion. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    question = aQuestion;
    boolean didAddAnswerBank = setAnswerBank(aAnswerBank);
    if (!didAddAnswerBank)
    {
      throw new RuntimeException("Unable to create answer due to answerBank. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  public Answer(int aId, String aText, int aIdForQuestion, String aTextForQuestion, int aPointsForQuestion, AnswerBank aAnswerBank)
  {
    id = aId;
    text = aText;
    question = new Question(aIdForQuestion, aTextForQuestion, aPointsForQuestion, this);
    boolean didAddAnswerBank = setAnswerBank(aAnswerBank);
    if (!didAddAnswerBank)
    {
      throw new RuntimeException("Unable to create answer due to answerBank. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
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
  /* Code from template association_GetOne */
  public Question getQuestion()
  {
    return question;
  }
  /* Code from template association_GetOne */
  public AnswerBank getAnswerBank()
  {
    return answerBank;
  }
  /* Code from template association_SetOneToMany */
  public boolean setAnswerBank(AnswerBank aAnswerBank)
  {
    boolean wasSet = false;
    if (aAnswerBank == null)
    {
      return wasSet;
    }

    AnswerBank existingAnswerBank = answerBank;
    answerBank = aAnswerBank;
    if (existingAnswerBank != null && !existingAnswerBank.equals(aAnswerBank))
    {
      existingAnswerBank.removeAnswer(this);
    }
    answerBank.addAnswer(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Question existingQuestion = question;
    question = null;
    if (existingQuestion != null)
    {
      existingQuestion.delete();
    }
    AnswerBank placeholderAnswerBank = answerBank;
    this.answerBank = null;
    if(placeholderAnswerBank != null)
    {
      placeholderAnswerBank.removeAnswer(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "text" + ":" + getText()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "question = "+(getQuestion()!=null?Integer.toHexString(System.identityHashCode(getQuestion())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "answerBank = "+(getAnswerBank()!=null?Integer.toHexString(System.identityHashCode(getAnswerBank())):"null");
  }
}