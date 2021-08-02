import java.util.*;
public class playerInfo
{
  private String name;
  private int plevel;
  private int exp;
  private int expReq;
  private int money;
  private int location;
   
  private playerClass pClass;
  private GuildQuest quest;
  private Items[][] inventory;
  private ArrayList<Items> equipped;
  private ArrayList<Potions> potions;
  private ArrayList<Attack> possibleSkills;
  private ArrayList<Attack> playerSkills;
  private ArrayList<Misc> misc;
  
  //getters and setters for potions
  
  public playerInfo(String name, playerClass pClass, Items[][] inventory, ArrayList<Items> equipped, ArrayList<Potions> potions, GuildQuest quest, ArrayList<Attack> possibleSkills, ArrayList<Misc> misc)
  {
    this.name = name;
    this.pClass = pClass;
    plevel = 1;
    exp = 0;
    expReq = 100;
    money = 0;
    location = 1;
    
    this.potions = potions;
    this.inventory = inventory;
    this.equipped = equipped;
    this.quest = quest;
    this.possibleSkills = possibleSkills;
    this.misc = misc;
    playerSkills = new ArrayList<Attack>(3);
    playerSkills.add(possibleSkills.get(0));
    playerSkills.add(possibleSkills.get(1));
    playerSkills.add(null);
  }
  
  public void addItem(Items item)
  {
    boolean stop = true;
    for(int row = 0; row < 5 && stop; row++)
    {
      for(int col = 0; col < 7 && stop; col++)
      {
        if(this.inventory[row][col] == null)
        {
          inventory[row][col] = item;
          stop = false;
        }
      }
    }
  }
  
  public void deleteItem(int row, int col)
  {
    this.inventory[row][col] = null;
  }
  
  public int getEmptyInv()
  {
    int empty = 0;
    for(Items[] array: this.inventory)
    {
      for(Items slot:array)
      {
        if(slot == null)
        {
          empty++;
        }
      }
    }
    return empty;
  }
  
  public void addPotion(int which, int amount)
  {
    potions.get(which).addCount(amount);
  }
  
  public void decreasePotion(int which)
  {
    potions.get(which).decreaseCount();
  }
  
  public ArrayList<Potions> getPotions()
  {
    return potions;
  }
  
  public int getManaPotions()
  {
    return potions.get(0).getCount();
  }
  
  
  public int getHealthPotions()
  {
    return potions.get(1).getCount();
  }
  
  public void setLocation(int i)
  {
    location = i;
  }
  
  public int getLocation()
  {
    return location;
  }
  
  public Items[][] getInventory()
  {
    return inventory;
  }
  
  public ArrayList<Items> getEquipped()
  {
    return equipped;
  }
  
  public GuildQuest getQuest()
  {
    return quest;
  }
  
  public void setQuest(GuildQuest quest)
  {
    quest.decrementCount();
    this.quest = quest;
  }
  
  public void finishQuest()
  {
    //this.misc.decreaseCount(this.quest.getPenalty());
    this.quest = null;
  }
  
  public ArrayList<Misc> getMisc()
  {
    return misc;
  }
  
  public int getCount()
  {
    return quest.getCount();
  }
  
  public void cancelQuest()
  {
    quest.incrementCount();
    this.quest = null;
  }
  public int getRequirement()
  {
    return quest.getRequirement();
  }
  public int getPenalty()
  {
    return quest.getPenalty();
  }
  
  public int getReward()
  {
    return quest.getReward();
  }
  
  public String getName()
  {
    return name;
  }
  public String toString()
  {
    return RPG.dashes() + "\nPlayer Info(" + name + "):\n" + RPG.dashes() + "\nLevel: " + plevel + "\nExperience: " + exp + "/" + expReq + "\n" + RPG.dashes() + pClass.toString() + "\n" + RPG.dashes();
  }
  
  public int getMoney()
  {
    return money;
  }
  
  public void addMoney(int money)
  {
    this.money += money;
  }
  
  public void decreaseMoney(int money)
  {
    this.money -= money;
  }
  
  public void lvlUp()
  {
    
    this.plevel++;
    if(pClass.getName().equals("Mage"))
    {
      this.mageStatsUp();
    }else if(pClass.getName().equals("Swordsman"))
    {
      this.swordsmanStatsUp();
    }
    
      if(this.plevel == 3)
      {
        System.out.println("You learned a new skill, called " + this.possibleSkills.get(2).getName());
        System.out.println("\n" + this.possibleSkills.get(2));
        this.playerSkills.set(2, this.possibleSkills.get(2));
      }
      if(this.plevel == 6)
      {
        this.learn(this.possibleSkills.get(3));
      }
      if(this.plevel == 9)
      {
        this.learn(this.possibleSkills.get(4));
      }
      if(this.plevel == 12)
      {
        this.learn(this.possibleSkills.get(5));
      }
  }
  
  public void learn(Attack skill)
  {
    Scanner input = new Scanner(System.in);
    boolean again = true;
    System.out.println("You learned a new Skill, called " + skill.getName() + "! \n[1] Information \n[2] Learn Skill \n[3] Don't learn");
    int choice = input.nextInt();
    String response = "";
    
    while(again)
    {
      if(choice == 1)
      {
        System.out.println(skill);
      }else if(choice == 2)
      {
        System.out.println("You have no slots left in your skill set. (Only up to 3). \nDo you want to replace on of them? (Y/N)");
        response = input.next();
        if(response.equalsIgnoreCase("Y"))
        {
          for(int i = 0; i < 3; i++)
          {
            System.out.println("[" + (i + 1) + "]\n" + this.playerSkills.get(0));
          }
          System.out.println("Pick a number to replace. Type 0 to cancel.");
          choice = input.nextInt();
          if(choice == 1)
          {
            playerSkills.set(0, skill);
            again = false;
          }else if(choice == 2)
          {
            playerSkills.set(1, skill);
            again = false;
          }else if(choice == 3){
            playerSkills.set(2, skill);
            again = false;
          }
        }
      }else if(choice == 3)
      {
        System.out.println("Are you sure? This won't ever come back. (Y/N)");
        response = input.next();
        if(response.equalsIgnoreCase("Y"))
        {
          again = false;
        }
      }
    } 
  }
  
  public ArrayList<Attack> getSkills()
  {
    return playerSkills;
  }
  public void addExp(int exp)//use this in the battle methods
  {
    this.exp += exp;
    while(this.exp >= expReq)
    {
      this.lvlUp();
      this.exp = this.getExp() - this.getExpReq();
      this.setExpReq(this.getExpReq() * 1.25);
      System.out.println("You leveled up! You are now level " + this.getLevel() + ". \n" + this);
      RPG.time(4000);
    }
  }
  
  public int getExp()
  {
    return exp;
  }
  
  public void setExpReq(double req)
  {
    expReq = (int)req;
  }
  
  public int getExpReq()
  {
    return expReq;
  }
  
  public int getLevel()
  {
    return plevel;
  }
  
  public void mageStatsUp()
  {
    pClass.setMaxHealth((int)(pClass.getMaxHealth() * 1.1));
    pClass.setMaxMana(pClass.getMaxMana() + 20);
    pClass.setStrength(pClass.getStrength() + 1);
    pClass.setIntelligence(pClass.getIntelligence() + 6);
    pClass.setManaRecovery(pClass.getManaRecovery() + pClass.getMaxMana() / 5);
    
    pClass.setHp(pClass.getMaxHealth());
    pClass.setMana(pClass.getMaxMana());
  }
  public void swordsmanStatsUp()
  {
    pClass.setMaxHealth((int)(pClass.getMaxHealth() * 1.1));
    pClass.setMaxMana(pClass.getMaxMana() + 10);
    pClass.setStrength(pClass.getStrength() + 6);
    pClass.setManaRecovery(pClass.getManaRecovery() + pClass.getMaxMana() / 5);
    
    pClass.setHp(pClass.getMaxHealth());
    pClass.setMana(pClass.getMaxMana());
  }
  
  
  public void setHp(int hp)
  {
    pClass.setHp(hp);
  }
  
  
  public int getMaxHealth()
  {
    return pClass.getMaxHealth();
  }
  
  public int getHp()
  {
    return pClass.getHp();
  }
  
  public void decreaseHp(int hp)
  {
    pClass.decreaseHp(hp);
  }
  
  public void decreaseMana(int mana)
  {
    pClass.decreaseMana(mana);
  }
  
  public void useHealthPotion()
  {
    potions.get(1).decreaseCount();
    pClass.addHp(50);
  }
  
  public int getMaxMana()
  {
    return pClass.getMaxMana();
  }
  
  public int getMana()
  {
    return pClass.getMana();
  }
  
  public void useManaPotion()
  {
    potions.get(0).decreaseCount();
    pClass.addMana(50);
  }
  
  public void increaseMana()
  {
    pClass.addMana(this.getManaRecovery());
  }
  
  public int getManaRecovery()
  {
    return pClass.getManaRecovery();
  }
  
  public int getStrength()
  {
    return pClass.getStrength();
  }
  
  public int getIntelligence()
  {
    return pClass.getIntelligence();
  }
  
  public int getPlayerSkillInd()
  {
    if(pClass.getName().equals("Mage"))
    {
      return this.pClass.getIntelligence();
    }else if (pClass.getName().equals("Swordsman")){
      return this.pClass.getStrength();
    }
    return 1;
  }
  
  public int getDefense()
  {
    int def = 0;
    for(int i = 0; i < 4; i++)
    {
      if(equipped.get(i).getIsArmor())
      {
        def += equipped.get(i).getEffect();
      }
    }
    return def;
  }
}