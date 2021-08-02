
public class Monsters
{
  private String name;
  private int health;
  private int strength;
  private int defense;
  private int maxHealth;
    
  public Monsters(String name, int maxHealth, int strength, int defense)
  {
    this.name = name;
    this.strength = strength;
    this.defense = defense;
    this.maxHealth = maxHealth;
    health = maxHealth;
  }
  
  public String getName()
  {
    return name;
  }
  public int getHealth()
  {
    return health;
  }
  public int getMaxHealth()
  {
    return maxHealth;
  }
  public int getDefense()
  {
    return defense;
  }
  public int getStrength()
  {
    return strength;
  }
  
  public void setHp(int hp)
  {
    health = hp;
  }
  
  public void decreaseHealth(int health)
  {
    this.health -= health;
  }
  
  public String toString()
  {
    return RPG.dashes() + "\n(Monster) " + name + "\n" + RPG.dashes() + "\nHealth:   " + health + "/" + maxHealth +"\nStrength: " + strength + "\nDefense:  " + defense + "%\n" + RPG.dashes();
  }
}