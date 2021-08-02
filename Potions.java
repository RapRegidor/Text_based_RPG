import java.util.*;
public class Potions
{
  private String name;
  private int manaInc;
  private int hpInc;
  private String description;
  private String type;
  private int count;
  
  public Potions(String name, String type, int manaInc, int hpInc, String description)
  {
    this.name = name;
    this.manaInc = manaInc;
    this.hpInc = hpInc;
    this.description = description;
    this.type = type;
    count = 0;
  }
  
  public int getCount()
  {
    return count;
  }
  
  public void addCount(int count)
  {
    this.count += count;
  }
  
  public void decreaseCount()
  {
    this.count -= 1;
  }
  
  public String toString()
  {
    return RPG.dashes() + "\nPotion Info\n" + RPG.dashes() + "\nName: " + name + "\n+" + (manaInc + hpInc) + " " + type + "\n\nDescription:\n" + description + "\n\nOwned: " + count + "\nCan't be sold.\n" + RPG.dashes();
  }
}