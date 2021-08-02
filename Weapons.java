public class Weapons
{
  private String name;
  private int damage;
  private int value;
  private String type;

  
  public Weapons(String name, String type, int damage, int value)
  {
    this.name = name;
    this.value = value;
    this.damage = damage;
    this.type = type;

  }
  
  public String getName()
  {
    return name;
  }
  
  public int getDamage()
  {
    return damage;
  }
  
  public int getCost()
  {
    return (int)(value * 1.5);
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
    return RPG.dashes() + "\nWeapon Info\n" + RPG.dashes() + "\nName: " + name + "\nDamage: " + damage + "\nValue: " + value + " Silver(s)\nCost: " + (int)(value * 1.5) + " Silver(s)\n" + RPG.dashes();
  }
}