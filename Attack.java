public class Attack
{
  private String name;
  private int damage;
  private int manaConsume;
    
    
  public Attack(String name, int damage)
  {
    this.name = name;
    this.damage = damage;
  }
  
  //Skill Attacks
  public Attack(String name, int damage, int manaConsume)
  {
    this.name = name;
    this.damage = damage;
    this.manaConsume = manaConsume;
  }
  public String getName()
  {
    return name;
  }
  public int getDamage()
  {
    return damage;
  }
  public int getManaConsume()
  {
    return manaConsume;
  }
  
  public String toString()
  {
    return RPG.dashes() + "\nSkill Info: " + name + "\n" + RPG.dashes() + "\nDamage: " + damage + "\nMana:   " + manaConsume + "\n" + RPG.dashes();
  }
}