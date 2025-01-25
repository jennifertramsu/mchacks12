/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;

// line 39 "model.ump"
// line 70 "model.ump"
public class Investigation
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Investigation Associations
  private List<Status> statuses;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Investigation()
  {
    statuses = new ArrayList<Status>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Status getStatus(int index)
  {
    Status aStatus = statuses.get(index);
    return aStatus;
  }

  public List<Status> getStatuses()
  {
    List<Status> newStatuses = Collections.unmodifiableList(statuses);
    return newStatuses;
  }

  public int numberOfStatuses()
  {
    int number = statuses.size();
    return number;
  }

  public boolean hasStatuses()
  {
    boolean has = statuses.size() > 0;
    return has;
  }

  public int indexOfStatus(Status aStatus)
  {
    int index = statuses.indexOf(aStatus);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfStatuses()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addStatus(Status aStatus)
  {
    boolean wasAdded = false;
    if (statuses.contains(aStatus)) { return false; }
    statuses.add(aStatus);
    if (aStatus.indexOfInvestigation(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aStatus.addInvestigation(this);
      if (!wasAdded)
      {
        statuses.remove(aStatus);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeStatus(Status aStatus)
  {
    boolean wasRemoved = false;
    if (!statuses.contains(aStatus))
    {
      return wasRemoved;
    }

    int oldIndex = statuses.indexOf(aStatus);
    statuses.remove(oldIndex);
    if (aStatus.indexOfInvestigation(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aStatus.removeInvestigation(this);
      if (!wasRemoved)
      {
        statuses.add(oldIndex,aStatus);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addStatusAt(Status aStatus, int index)
  {  
    boolean wasAdded = false;
    if(addStatus(aStatus))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStatuses()) { index = numberOfStatuses() - 1; }
      statuses.remove(aStatus);
      statuses.add(index, aStatus);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStatusAt(Status aStatus, int index)
  {
    boolean wasAdded = false;
    if(statuses.contains(aStatus))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStatuses()) { index = numberOfStatuses() - 1; }
      statuses.remove(aStatus);
      statuses.add(index, aStatus);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStatusAt(aStatus, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Status> copyOfStatuses = new ArrayList<Status>(statuses);
    statuses.clear();
    for(Status aStatus : copyOfStatuses)
    {
      aStatus.removeInvestigation(this);
    }
  }

}