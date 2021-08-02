public class Stats
{
  private int maxHealth;
  private int maxMana;
  private int strength;
  private int intelligence;
  private int hp;
  private int mana;
  private int manaRecovery;
  
  public Stats(int maxHealth, int maxMana, int strength, int intelligence, int manaRecovery)
  {
    this.maxHealth = maxHealth;
    this.maxMana = maxMana;
    this.strength = strength;
    this.intelligence = intelligence;
    hp = maxHealth;
    mana = maxMana;
    this.manaRecovery = manaRecovery;
  }
  
  public String toString()
  {
    return "\nHealth:       " + hp + "/" + maxHealth + "\nMana:         " + mana + "/" + maxMana + "\nMana Recovery: " + manaRecovery + " per turn" + "\nStrength:      " + strength + "\nInt:           " + intelligence; 
  }
  
  public int getMaxHealth()
  {
    return maxHealth;
  }
  
  public int getHp()
  {
    return hp;
  }
  
  public void decreaseHp(int hp)
  {
    this.hp -= hp;
  }
  
  public void decreaseMana(int mana)
  {
    this.mana -= mana;
  }
  
  public int getMaxMana()
  {
    return maxMana;
  }
  
  public int getMana()
  {
    return mana;
  }
  
  public int getManaRecovery()
  {
    return manaRecovery;
  }
  
  public int getStrength()
  {
    return strength;
  }
  
  public int getIntelligence()
  {
    return intelligence;
  }
  
  
  

  public void setMaxHealth(int maxHealth)
  {
    this.maxHealth = maxHealth;
  }
  
  public void setHp(int hp)
  {
    this.hp = hp;
  }
  
  public void addHp(int hp)
  {
    if(this.hp + hp > this.maxHealth)
    {
      this.hp = maxHealth;
    }else{
      this.hp += hp;
    }
  }
  
  public void setMaxMana(int maxMana)
  {
    this.maxMana = maxMana;
  }
  
  public void setMana(int mana)
  {
    this.mana = mana;
  }
  
  public void addMana(int mana)
  {
    if(this.mana + mana > this.maxMana)
    {
      this.mana = maxMana;
    }else{
      this.mana += mana;
    }
  }
  
  public void setManaRecovery(int manaRecovery)
  {
    this.manaRecovery = manaRecovery;
  }
  
  public void setStrength(int strength)
  {
    this.strength = strength;
  }
  
  public void setIntelligence(int intelligence)
  {
    this.intelligence = intelligence;
  }
}