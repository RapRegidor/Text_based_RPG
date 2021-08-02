public class Misc
{
  private String name;
  private int count;
  
  public Misc(String name)
  {
    this.name = name;
    count = 0;
  }
  public String getName()
  {
    return name;
  }
  public int getCount()
  {
    return count;
  }
  public void increaseCount(int inc)
  {
    count += inc;
  }
  
  public void decreaseCount(int dec)
  {
    count -= dec;
  }
  
  public String toString()
  {
    return RPG.dashes() + "\nQuest Item: " + name + " Count: " + count + "\n" + RPG.dashes();
  }
}