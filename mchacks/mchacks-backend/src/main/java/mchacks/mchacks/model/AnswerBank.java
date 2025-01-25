/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;

// line 15 "model.ump"
// line 46 "model.ump"
public class AnswerBank
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AnswerBank Attributes
  private int id;
  private String text;

  //AnswerBank Associations
  private List<Answer> answers;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public AnswerBank(int aId, String aText)
  {
    id = aId;
    text = aText;
    answers = new ArrayList<Answer>();
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
  /* Code from template association_GetMany */
  public Answer getAnswer(int index)
  {
    Answer aAnswer = answers.get(index);
    return aAnswer;
  }

  public List<Answer> getAnswers()
  {
    List<Answer> newAnswers = Collections.unmodifiableList(answers);
    return newAnswers;
  }

  public int numberOfAnswers()
  {
    int number = answers.size();
    return number;
  }

  public boolean hasAnswers()
  {
    boolean has = answers.size() > 0;
    return has;
  }

  public int indexOfAnswer(Answer aAnswer)
  {
    int index = answers.indexOf(aAnswer);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAnswers()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Answer addAnswer(int aId, String aText, Question aQuestion)
  {
    return new Answer(aId, aText, aQuestion, this);
  }

  public boolean addAnswer(Answer aAnswer)
  {
    boolean wasAdded = false;
    if (answers.contains(aAnswer)) { return false; }
    AnswerBank existingAnswerBank = aAnswer.getAnswerBank();
    boolean isNewAnswerBank = existingAnswerBank != null && !this.equals(existingAnswerBank);
    if (isNewAnswerBank)
    {
      aAnswer.setAnswerBank(this);
    }
    else
    {
      answers.add(aAnswer);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAnswer(Answer aAnswer)
  {
    boolean wasRemoved = false;
    //Unable to remove aAnswer, as it must always have a answerBank
    if (!this.equals(aAnswer.getAnswerBank()))
    {
      answers.remove(aAnswer);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addAnswerAt(Answer aAnswer, int index)
  {  
    boolean wasAdded = false;
    if(addAnswer(aAnswer))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAnswers()) { index = numberOfAnswers() - 1; }
      answers.remove(aAnswer);
      answers.add(index, aAnswer);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAnswerAt(Answer aAnswer, int index)
  {
    boolean wasAdded = false;
    if(answers.contains(aAnswer))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAnswers()) { index = numberOfAnswers() - 1; }
      answers.remove(aAnswer);
      answers.add(index, aAnswer);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAnswerAt(aAnswer, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=answers.size(); i > 0; i--)
    {
      Answer aAnswer = answers.get(i - 1);
      aAnswer.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "text" + ":" + getText()+ "]";
  }
}