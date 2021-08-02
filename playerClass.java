import java.util.*;
public class playerClass
{//use map to associate each class
  private String name;
  private Stats stats;
  
  public playerClass(String name, Stats stats)
  {
    this.name = name;
    this.stats = stats;
  }
  
  public String toString()
  {
    return "\nClass: " + name + stats; 
  }
  
  //setter
  
  public void setMaxHealth(int maxHealth)
  {
    stats.setMaxHealth(maxHealth);
  }
  
  public void setHp(int hp)
  {
    stats.setHp(hp);
  }
  
  public void addHp(int hp)
  {
    stats.addHp(hp);
  }
  
  public void decreaseHp(int hp)
  {
    stats.decreaseHp(hp);
  }
  
  public void decreaseMana(int mana)
  {
    stats.decreaseMana(mana);
  }
  
  
  public void setMaxMana(int maxMana)
  {
    stats.setMaxMana(maxMana);
  }
  
  public void setMana(int mana)
  {
    stats.setMana(mana);
  }
  
  public void addMana(int mana)
  {
    stats.addMana(mana);
  }
  
  public void setManaRecovery(int manaRecovery)
  {
    stats.setManaRecovery(manaRecovery);
  }
  
  public void setStrength(int strength)
  {
    stats.setStrength(strength);
  }
  
  public void setIntelligence(int intelligence)
  {
    stats.setIntelligence(intelligence);
  }

  //get methods for each stat
  
  public String getName()
  {
    return name;
  }
  
  public int getMaxHealth()
  {
    return stats.getMaxHealth();
  }
  
  public int getHp()
  {
    return stats.getHp();
  }
  
  public int getMaxMana()
  {
    return stats.getMaxMana();
  }
  
  public int getMana()
  {
    return stats.getMana();
  }
  
  public int getManaRecovery()
  {
    return stats.getManaRecovery();
  }
  
  public int getStrength()
  {
    return stats.getStrength();
  }
  
  public int getIntelligence()
  {
    return stats.getIntelligence();
  } 
}