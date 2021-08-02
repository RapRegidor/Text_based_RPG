public class GuildQuest
{
  private String name;
  private int difficulty;
  private int reward;
  private String description;
  private int limit;
  private int count;
  private int penalty;
  private int requirement;
  
  public GuildQuest(String name, int difficulty, int reward, int limit, int penalty, String description, int requirement)
  {
    this.name = name;
    this.difficulty = difficulty;
    this.reward = reward;
    this.limit = limit;
    this.description = description;
    this.penalty = penalty;
    count = limit;
    this.requirement = requirement;
  }
  
  //do a cencellation of a quest when the player goes to the guild. Put a penalty too.
  public int getRequirement()
  {
    return requirement;
  }
  
  public String getName()
  {
    return name;
  }
  public int getPenalty()
  {
    return penalty;
  }
  
  public int getDifficulty()
  {
    return difficulty;
  }
  
  public int getReward()
  {
    return reward;
  }
  
  public int getCount()
  {
    return count;
  }
  
  public void decrementCount()
  {
    count--;
  }
  
  public void incrementCount()
  {
    count++;
  }
  
  public String toString()
  {
    String x = "";
    if(count == 0)
    {
      x = " - UNAVAILABLE";
    }
    return RPG.dashes() + "\nQuest: " + name + " (Limit: " + count + "/" + limit + ")" + x + "\n" + RPG.dashes() + "\nRecommended Level: " + difficulty + "\nReward: " + reward + " Silvers" + "\nPenalty: " + penalty + " Silvers" + "\n\n" + description + "\n" + RPG.dashes();
  }
}