public class Armor
{
  private String name;
  private int defense;
  private int value;
  private String type;

  
  public Armor(String name, String type, int defense, int value)
  {
    this.name = name;
    this.value = value;
    this.defense = defense;
    this.type = type;
  }
  
  public String getName()
  {
    return name;
  }
  
  public int getDefense()
  {
    return defense;
  }
  
  public int getCost()
  {
    return (int)(value*1.5);
  }
  
  public int getValue()
  {
    return value;
  }
  
  public String getType()
  {
    return type;
  }
  
  public String toString()
  {
    return RPG.dashes() + "\nArmor Info\n" + RPG.dashes() + "\nName: " + name + "\nDefense: " + defense + "\nValue: " + value + " Silver(s)\nCost: " + (int)(value * 1.5) + " Silver(s)\n" + RPG.dashes();
  }
  
}