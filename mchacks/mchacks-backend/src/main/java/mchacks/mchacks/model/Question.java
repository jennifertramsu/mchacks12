package mchacks.mchacks.model;

import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

// line 7 "model.ump"
// line 31 "model.ump"
@Entity
public class Question
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Question Attributes
  @Id
  @GeneratedValue
  private int id;
  private String text;
  private int points;

  //Question Associations
  @OneToOne
  private Answer correct;
  @OneToMany
  private List<Answer> bank;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Question(int aId, String aText, int aPoints, Answer aCorrect)
  {
    id = aId;
    text = aText;
    points = aPoints;
    correct = aCorrect;
    bank = new ArrayList<Answer>();
  }

  public Question(int aId, String aText, int aPoints, int aIdForCorrect, String aTextForCorrect, Question aIncorrectForCorrect)
  {
    id = aId;
    text = aText;
    points = aPoints;
    correct = new Answer(aIdForCorrect, aTextForCorrect);
    bank = new ArrayList<Answer>();
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
  /* Code from template association_GetMany */
  public Answer getBank(int index)
  {
    Answer aBank = bank.get(index);
    return aBank;
  }

  public List<Answer> getBank()
  {
    List<Answer> newBank = Collections.unmodifiableList(bank);
    return newBank;
  }

  public int numberOfBank()
  {
    int number = bank.size();
    return number;
  }

  public boolean hasBank()
  {
    boolean has = bank.size() > 0;
    return has;
  }

  public int indexOfBank(Answer aBank)
  {
    int index = bank.indexOf(aBank);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfBank()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Answer addBank(int aId, String aText, Question aCorrect)
  {
    return new Answer(aId, aText);
  }

  public boolean addBank(Answer aBank)
  {
    boolean wasAdded = false;
    if (bank.contains(aBank)) { return false; }
    bank.add(aBank);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeBank(Answer aBank)
  {
    boolean wasRemoved = false;
    //Unable to remove aBank, as it must always have a incorrect
    if (bank.contains(aBank))
    {
      bank.remove(aBank);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addBankAt(Answer aBank, int index)
  {  
    boolean wasAdded = false;
    if(addBank(aBank))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBank()) { index = numberOfBank() - 1; }
      bank.remove(aBank);
      bank.add(index, aBank);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveBankAt(Answer aBank, int index)
  {
    boolean wasAdded = false;
    if(bank.contains(aBank))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBank()) { index = numberOfBank() - 1; }
      bank.remove(aBank);
      bank.add(index, aBank);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addBankAt(aBank, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    Answer existingCorrect = correct;
    correct = null;
    if (existingCorrect != null)
    {
      existingCorrect.delete();
    }
    for(int i=bank.size(); i > 0; i--)
    {
      Answer aBank = bank.get(i - 1);
      aBank.delete();
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