public class Items
{
  private Weapons weapons;
  private Armor armors;
  private boolean armor;
  private boolean weapon;
  
  public Items(Weapons weapons)
  {
    this.weapons = weapons; 
    armor = false;
    weapon = true;
  }
  
  public Items(Armor armors)
  {
    this.armors = armors; 
    armor = true;
    weapon = false;
  }
  
  public boolean getIsArmor()
  {
    return armor;
  }
  
  public boolean getIsWeapon()
  {
    return weapon;
  }
  
  public String toString()
  {
    if(armor)
    {
      return armors + "";
    }
    return weapons + "";
  }
  
  public String getName()
  {
    if(armor)
    {
      return armors.getName();
    }
    return weapons.getName();
  }
  
  public String getType()
  {
    if(armor)
    {
      return armors.getType();
    }
    return weapons.getType();
  }
  
  public int getCost()
  {
    if(armor)
    {
      return armors.getCost();
    }
    return weapons.getCost();
  }
  
  public int getValue()
  {
    if(armor)
    {
      return armors.getValue();
    }
    return weapons.getValue();
  }
  
  public int getEffect()
  {
    if(armor)
    {
      return armors.getDefense();
    }
    return weapons.getDamage();
  }
}