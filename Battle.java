import java.util.*;
public class Battle
{
  //Add Items paramater
  public static void start(playerInfo user, Monsters monster, Items[][] weapons, Items[][] armors)
  {
    Scanner input = new Scanner(System.in);
    boolean ran = false;
    String temp = "";
    
    ArrayList<Attack> monsterAttack = new ArrayList<Attack>();

    int rewardExp = 0;
    if(monster.getName().equalsIgnoreCase("Horned Rabbit"))
    {
      monsterAttack.add(new Attack("Stab", 10));
      monsterAttack.add(new Attack("Tackle", 12));
      rewardExp = (int)(Math.random()*40) + 25;
    }else if(monster.getName().equalsIgnoreCase("Goblin"))
    {
      monsterAttack.add(new Attack("Weapon Slam", 25));
      monsterAttack.add(new Attack("Spear Lunge", 31));
      rewardExp = (int)(Math.random()*60) + 50;
    }else if(monster.getName().equalsIgnoreCase("Bandit"))
    {
      monsterAttack.add(new Attack("Backstab", 56));
      monsterAttack.add(new Attack("Critical Strike", 69));
      rewardExp = (int)(Math.random()*125) + 90;
    }else{
      monsterAttack.add(new Attack("Devour", 110));
      monsterAttack.add(new Attack("Rampage", 147));
      rewardExp = (int)(Math.random()*250) + 190;
    }
    
    System.out.println("You encountered a " + monster.getName());
    
    System.out.println("\n\n" + monster);
    
    temp = input.next();
    RPG.clear();
    
    int playerDamage = user.getEquipped().get(0).getEffect() * (1 + user.getStrength() / 100) * (1 - monster.getDefense() / 100);
    int monsterDamage = 0;
    int manaCon = 0;
    int randomizeAtt = 0;
    int randomizeDrop = 0;
    while(user.getHp() > 0 && monster.getHealth() > 0)
    {
      boolean turn = true;
      while(turn)
      {
        System.out.println("Pick an action. \n\n[1] Weapon Bash \n[2] Skills \n[3] Use potions \n[4] Run away");
        int choice = input.nextInt();
        RPG.clear();
        if(choice == 1)
        {
          playerDamage = user.getEquipped().get(0).getEffect() * (1 + user.getStrength() / 100) * (1 - monster.getDefense() / 100);
          System.out.println("You dealt " + playerDamage +  " damage to the enemy.");
          monster.decreaseHealth(playerDamage);
          
          if(monster.getHealth() <= 0)
          {
            monster.setHp(0);
          }
          System.out.println("The " + monster.getName() + " now has " + monster.getHealth() + "/" + monster.getMaxHealth());
          
          turn = false;
        }else if(choice == 2)
        {
          System.out.println("Current Mana: " + user.getMana() + "/" + user.getMaxMana());
          for(int i = 0; i < 3; i++)
          {
            if(user.getSkills().get(i) == null)
            {
              System.out.println("[" + (i + 1) + "]" + " Empty \n");
            }else{
              playerDamage =  user.getSkills().get(i).getDamage();
              manaCon = user.getSkills().get(i).getManaConsume();
              System.out.println("[" + (i + 1) + "]" + user.getSkills().get(i).getName() + " - " + playerDamage + " damage, " + manaCon + " mana\n");
            }
          }
          System.out.println("Pick a number. Type 0 to cancel");
          playerDamage = (int)(user.getEquipped().get(0).getEffect() * (1 + user.getPlayerSkillInd() / 100));
          choice = input.nextInt();
          RPG.clear();
          
          if(choice == 1)
          {
            if(user.getMana() < user.getSkills().get(0).getManaConsume())
            {
              System.out.println("You don't have enough mana.");
            }else{
              playerDamage = (int)(playerDamage + ((Math.random() + 0.7) * user.getSkills().get(0).getDamage()));
              System.out.println("You dealt " + playerDamage + " to the enemy.");
              monster.decreaseHealth(playerDamage);
              user.decreaseMana(user.getSkills().get(0).getManaConsume());
              
              
              if(monster.getHealth() <= 0)
              {
                monster.setHp(0);
              }
              
              if(monster.getHealth() <= 0)
              {
                monster.setHp(0);
              }
              
              System.out.println("The " + monster.getName() + " now has " + monster.getHealth() + "/" + monster.getMaxHealth());
              turn = false;
            }
          }else if(choice == 2)
          {
            if(user.getMana() < user.getSkills().get(1).getManaConsume())
            {
              System.out.println("You don't have enough mana.");
            }else{
              playerDamage = (int)(playerDamage + ((Math.random() + 0.7) * user.getSkills().get(1).getDamage()));
              System.out.println("You dealt " + playerDamage + " to the enemy.");
              monster.decreaseHealth(playerDamage);
              user.decreaseMana(user.getSkills().get(1).getManaConsume());
              
              
              if(monster.getHealth() <= 0)
              {
                monster.setHp(0);
              }
              
              
              System.out.println("The " + monster.getName() + " now has " + monster.getHealth() + "/" + monster.getMaxHealth());
              turn = false;
            }
            
          }else if(choice == 3)
          {
            if(user.getSkills().get(2) == null)
            {
              System.out.println("This is an empty slot.");
            }else{
              if(user.getMana() < user.getSkills().get(0).getManaConsume())
              {
                System.out.println("You don't have enough mana.");
              }else{
                playerDamage = (int)(playerDamage + ((Math.random() + 0.7) * user.getSkills().get(0).getDamage()));
                System.out.println("You dealt " + playerDamage + " to the enemy.");
                monster.decreaseHealth(playerDamage);
                user.decreaseMana(user.getSkills().get(2).getManaConsume());
                
                
                if(monster.getHealth() <= 0)
                {
                  monster.setHp(0);
                }
                
                
                System.out.println("The " + monster.getName() + " now has " + monster.getHealth() + "/" + monster.getMaxHealth());
                turn = false;
              }
            }
          }
          System.out.println("Mana Remaining: " + user.getMana() + "/" + user.getMaxMana());
          temp = input.next();
          RPG.clear();
        }else if(choice == 3){
          
          System.out.println("[1] Mana Potion \n[2] Health Potion \n[3] Cancel");
          choice = input.nextInt();
          RPG.clear();
          if(choice == 1)
          {
            if(user.getManaPotions() > 0)
            {
              user.useManaPotion();
              System.out.println("Mana has been replenished by 25. \nYour mana is now: " + user.getMana() + "\nYou have " + user.getManaPotions() + " left");
            }else{
              System.out.println("You do not have any more Mana Potions.");
            }
          }else if(choice == 2)
          {
            if(user.getHealthPotions() > 0)
            {
              user.useHealthPotion();
              System.out.println("HP has been replenished by 25. \nYour HP is now: " + user.getHp() + " \nYou have " + user.getHealthPotions() + "left");
            }else{
              System.out.println("You do not have any more Health Potion"); 
            }
          }
          temp = input.next();
          RPG.clear();
        }else{
          System.out.println("You ran as fast as you could with your tail in between you legs.");
          turn = false;
          ran = true;
          temp = input.next();
          RPG.clear();
          break; 
        }
      }
      
      if(ran)
      {
        break;
      }
      //Monster's turn
      
      
      if(monster.getHealth() > 0)
      {
        randomizeAtt = (int)(Math.random()*3) + 1;
        System.out.println("The enemy attacked.");
        
        if(randomizeAtt <= 2)
        {
          monsterDamage = monsterAttack.get(0).getDamage() * (1 + monster.getStrength() / 100) * (1 - user.getDefense() / 100);
          System.out.println(monster.getName() + " did " + monsterAttack.get(0).getName() + " to you and dealt " + monsterDamage);
        }else{
          monsterDamage = monsterAttack.get(1).getDamage() * (1 + monster.getStrength() / 100) * (1 - user.getDefense() / 100);
          System.out.println(monster.getName() + " did " + monsterAttack.get(1).getName() + " to you and dealt " + monsterDamage);
        }
        user.decreaseHp(monsterDamage);
        if(user.getHp() <= 0)
        {
          user.setHp(0);
        }
        System.out.println("\nYou now have " + user.getHp() + " Hp.");
        user.increaseMana();
        temp = input.next();
        RPG.clear();
      }
    }
      
    
    //I need to put drops here too. do a variable random drop -> int value then make a method that increases the particular item by that var
    int q = 0;
    randomizeDrop = (int)(Math.random()*5) + 1;
    int amount = 0;
    if(randomizeDrop <= 3)
    {
      amount = 1;
    }else{
      amount = 2;
    }
    if(user.getHp() > 0 && monster.getHealth() <= 0)
    {
      if(monster.getName().equalsIgnoreCase("Horned Rabbit"))
      {
        q = 0;
      }else if(monster.getName().equalsIgnoreCase("Goblin")){
        q = 1;
      }else if(monster.getName().equalsIgnoreCase("Bandit")){
        q = 2;
      }else if(monster.getName().equalsIgnoreCase("Orc")){
        q = 3;
      }
      
      System.out.println("You have defeated the monster. \nYou received " + rewardExp + " exp.");
      user.addExp(rewardExp);
      System.out.println("\nLoot Acquired:");
      System.out.println("+" + user.getMisc().get(q).getName());
      user.getMisc().get(q).increaseCount(amount);
    }else if(user.getHp() <= 0)
    {
      death();
    }
    temp = input.next();
    RPG.clear();
  }



  public static void death()
  {   
    System.out.println("You fought so hard just to die. Your body has been devoured by the monster. \nNow your associates or even your famly can't even see your body nor can't even know if you died.\n\nRIP. ");
    System.exit(1);
  }
}