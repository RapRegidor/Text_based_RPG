import java.util.*;
public class RPG
{
  public static void main(String[] args)
  {
    Weapons[][] weapons = {{new Weapons("Rookie Sword", "Sword", 10, 10), new Weapons("Scimitar", "Sword", 15, 40), new Weapons("Machete", "Sword", 35, 100), new Weapons("Rapier", "Sword", 40, 200)},
                           {new Weapons("Katana", "Sword", 60, 500), new Weapons("Greatsword", "Sword", 80, 750), new Weapons("Rookie Staff", "Magic", 10, 10), new Weapons("Book of Skulls", "Magic", 15, 30)},
                           {new Weapons("Netherbane Staff", "Magic", 25, 100), new Weapons("Netherworld Staff", "Magic", 35, 200), new Weapons("Holy Orb", "Magic", 35, 500), new Weapons("Yggdrasil Staff", "Magic", 60, 750)}};

    Armor[][] armors = {{new Armor("Rookie Helmet", "Head", 5, 15), new Armor("Chainmail Helmet", "Helmet", 10, 45), new Armor("Iron helmet", "Helmet", 13, 375), new Armor("Amethyst Helmet", "Helmet", 20, 750)},
                        {new Armor("Rookie Breastplate", "Chest", 7, 20), new Armor("Chainmail Breastplate", "Chest", 11, 60), new Armor("Iron Breastplate", "Chest", 16, 450), new Armor("Amethyst Breastplate", "Chest", 38, 850)},
                        {new Armor("Rookie Boots", "Feet", 3, 10), new Armor("Chainmail Boots", "Feet", 6, 30), new Armor("Iron Boots", "Feet", 11, 300), new Armor("Amethyst Boots", "Feet", 17, 625)}};
    
    Items[][] allWeapons = new Items[3][4];
    Items[][] allArmors = new Items[3][4];
    
    for(int row = 0; row < 3; row++)
    {
      for(int col = 0; col < 4; col++)
      {
        allWeapons[row][col] = new Items(weapons[row][col]);
        allArmors[row][col] = new Items(armors[row][col]);
      }
    }
    
      
  
    
    ArrayList<GuildQuest> guild = new ArrayList<GuildQuest>();
    guild.add(new GuildQuest("Ravagers", 8, 450, 5, 300, "Bandits have been looting \nmerchant's caravan by the road \nheading towards this kingdom. \nReduce their numbers. \n\nCollect 7 bandit heads.", 7));
    guild.add(new GuildQuest("Pesky Rabbits", 1, 50, 10, 25, "It's Spring season, so you know what that means. \nRabbits. Rabbit everywhere in the Solmin forest. \n\nCollect 5 rabbit horns.", 5));
    guild.add(new GuildQuest("Uninvited Guests", 12, 750, 1, 500, "Just kill them please. \n(As usual they're recently spotted in the Solmin forest). \n\nCollect 3 orc fangs", 3));
    guild.add(new GuildQuest("Green Mutts", 4, 120, 5, 75, "Goblins have been spotted \nby the Solmin forest according \nto numerous reports. \nPlease annihilate them. \n\nCollect 10 goblin ears", 10));
    
    
    
    
    //Players
    
    ArrayList<playerClass> classes = new ArrayList<playerClass>();
    classes.add(new playerClass("Swordsman", new Stats(25, 10, 20, 0, 2)));
    classes.add(new playerClass("Mage", new Stats(25, 50, 5, 20, 5)));
    
    //for shop just do incrementcount for player potions - dont put it in inventory
    ArrayList<Potions> playerPotions = new ArrayList<Potions>();
    playerPotions.add(new Potions("Mana Potion", "Mana", 25, 0, "Increases your current mana by 25"));
    playerPotions.add(new Potions("Health Potion", "Health", 0, 25, "Increases your current health by 25"));
    
    
    
    
    //do a method for placing items in the inventory - two parameters the object & the amount
    //when opening inventory place out the whole thing + bank
    //Ask what slot he wants to select or place in close
    //if he selects a number then do a conditional whther its a armor or weapon or misc
    
    Items[][] inventory = new Items[5][7];
    
    for(int row = 0; row < 5; row++)
    {
     for(int col = 0; col < 7; col++)
     {
       inventory[row][col] = null;
     }
    }
    
    clear();
    
    
    
    Scanner input = new Scanner(System.in);
    
    System.out.println("You finally arrived at the Kingdom of O-Ten, where your parents started their job as adventurers."
                         + "\nIt took you days to arrive from your home village. "
                         + "\nNow it is your turn. It is finally your day to start your own travel -"
                         + "\nfighting monsters, discovering new places and meeting new people.");
    
    String temp = input.next();
    clear();
    
    System.out.println("As you enter the kingdom, you immediately spot the guild house."
                         + "\nSurprisingly it is easy to find as it is just right by the entrance of the kingdom."
                         + "\nYou start to walk to it");
    
    temp = input.next();
    clear();
    
    System.out.println("Inside, you were overwhelmed by the crowd. "
                         + "\nYou quickly make your way to the receptionist trying to avoid bumping onto anyone.");
    
    temp = input.next();
    clear();
    
    System.out.println("Receptionist: Welcome! Mmmm you are not from around here are you? "
                         + "\n              I'm assuming you're here to sign up as an adventurer?" 
                         + "\n\n         You: Yes, yes I am."
                         + "\nReceptionist: Good, then just sign up here and pay 25 silvers. Aaand no take backs."
                         + "\n\n        You: What?! 25 silvers??? That's all I got left..."
                         + "\nReceptionist: Well, you can accept quests right away once you sign up. So, are you going to?"
                         + "\n\nYou reluctantly said yes. You couldn't wait any longer and just like what the receptionist says, you can "
                         + "\naccept a quest immediately once you sign up to make up what you have lost anyways. ");
    
    temp = input.next();
    clear();
    
    System.out.println("Receptionist: Alright! So what name would you like to go by?");
    String username = input.next();
    
    clear();
    
    System.out.println("Receptionist: " + username + " is it? Okay, what's your class? (Choose a number)");
 
    boolean repeat = true;
    int choice = 0;
    String accept = "";
    
    while(repeat)
    {
      for(int i = 0; i < classes.size(); i++)
      {
        System.out.println("[" + (i + 1) + "] " + classes.get(i).getName());
      }
      choice = input.nextInt();
      clear();
      if((choice >= 1 && choice <= 2))
      {
        clear();
        System.out.println("Are you sure? (Yes/No)");
        accept = input.next();
        clear();
        if(accept.equalsIgnoreCase("Yes"))
        {
          repeat = false;
          if(choice == 1)
          {
            classes.remove(1);
          }else{
            classes.remove(0);
          }
        }else{
          System.out.println("Choose a class.");
        }
      }else{
        System.out.println("Please choose a number between 1 & 2.");
      }
    }
    
    clear();
    
    
    ArrayList<Items> playerEquipment = new ArrayList<Items>(4);
    
    ArrayList<Attack> possibleSkills = new ArrayList<Attack>(); 
    System.out.println("Possible skills generating for your class...\n\nLearning two new skills...");
    if(classes.get(0).getName().equals("Swordsman"))
    {
      System.out.println("Adding Multi Strike...        " + possibleSkills.add(new Attack("Multi Strike", 10, 4)));
      System.out.println("Adding Enhanced Strike...     " + possibleSkills.add(new Attack("Enhanced Strike", 14, 7)));
      possibleSkills.add(new Attack("Whirlwind", 26, 24));
      possibleSkills.add(new Attack("Ground Pound", 55, 35));
      possibleSkills.add(new Attack("Decapitate", 110, 60));
      possibleSkills.add(new Attack("Sword of Judgement", 300, 90));
      
      playerEquipment.add(allWeapons[0][0]);
      playerEquipment.add(allArmors[0][0]);
      playerEquipment.add(allArmors[1][0]);
      playerEquipment.add(allArmors[2][0]);
    }else if(classes.get(0).getName().equals("Mage")){
      System.out.println("Adding Waterball...      " + possibleSkills.add(new Attack("Waterball", 12, 24)));
      System.out.println("Adding Fireball...       " + possibleSkills.add(new Attack("Fireball", 16, 39)));
      possibleSkills.add(new Attack("Fire Arrows", 37, 46));
      possibleSkills.add(new Attack("Ice Spears", 55, 110));
      possibleSkills.add(new Attack("Lightning Strike", 130, 160));
      possibleSkills.add(new Attack("Hell Spawn", 350, 300));
      playerEquipment.add(allWeapons[1][2]);
      playerEquipment.add(allArmors[0][0]);
      playerEquipment.add(allArmors[1][0]);
      playerEquipment.add(allArmors[2][0]);
    }
    
    ArrayList<Misc> misc = new ArrayList<Misc>(4);
    misc.add(new Misc("Rabbit Horns"));
    misc.add(new Misc("Goblin Ear"));
    misc.add(new Misc("Bandit Head"));
    misc.add(new Misc("Orc Fang"));
    
    playerInfo user = new playerInfo(username, classes.get(0), inventory, playerEquipment, playerPotions, null, possibleSkills, misc);
    
    temp = input.next();
    clear();
    
    System.out.println("Receptionist: Great! All done. Here is your guild card. \n              Just put a droplet of your blood on it and you'll be able to see your status. "
                      + "\n\nYou slice your finger and a droplet of your blood fell on it. \nWords and numbers started to appear magically.");
    
    temp = input.next();
    clear();
      
    System.out.println(user);
    
    temp = input.next();
    clear();
    
    System.out.println("Receptionist: You can pick any quest regardless of your abilities. We have ample of adventurers so it wouldn't hurt if one or two died. \n              Also, if you cancel your quest you will have to pay the penalty stated on the quest. \n              If you can't pay the penalty, you can't cancel it. \n              Also, also, you can only accept one quest at a time. Can't be too greedy now.\n              Now that's done, would you like to take a quest?(Yes/No)");
    String pick = input.next();
    
    clear();
    
    if(pick.equalsIgnoreCase("Yes"))
    {
      System.out.println("\nReceptionist: Good, just pick one of these quests and you are good to go.\n\n");
      
      for(int i = 0; i < guild.size(); i++)
      {
        System.out.println("[" + (i + 1 ) + "]" + "\n" + guild.get(i) + "\n\n");
        temp = input.next();
      }
      
      System.out.println("Receptionist: By the way these aren't sorted so would you like me to sort it out? (Yes/No)");
      
      pick = input.next();
      
      if(pick.equalsIgnoreCase("Yes"))
      {
        clear();
        System.out.println("\nReceptionist: By silver (highest - lowest) or by difficulty (lowest to highest)? (S/D)");
        pick = input.next();
        if(pick.equalsIgnoreCase("S"))
        {
          insertedSortReward(guild);
        }else{
          selectionSortDifficulty(guild);
        }
        clear();
        System.out.println("Receptionist: Alright, here you go.\n");
        for(int i = 0; i < guild.size(); i++)
        {
          System.out.println("[" + (i + 1 ) + "]" + "\n" + guild.get(i) + "\n\n");
          temp = input.next();
        }
        
        System.out.println("Pick a number (1-4)");
        
        choice = input.nextInt() - 1;
        
        if(choice == 0){
          user.setQuest(guild.get(0));
        }else if(choice == 1){
          user.setQuest(guild.get(1));
        }else if(choice == 2){
          user.setQuest(guild.get(2));
        }else{
          user.setQuest(guild.get(3));
        }
        
      }else{
      
        System.out.println("Pick a number (1-4)");
        
        choice = input.nextInt() - 1;
        
        if(choice == 0){
          user.setQuest(guild.get(0));
        }else if(choice == 1){
          user.setQuest(guild.get(1));
        }else if(choice == 2){
          user.setQuest(guild.get(2));
        }else{
          user.setQuest(guild.get(3));
        }
      }
      
      clear();
      
      System.out.println("You picked:\n" + user.getQuest());
      
    }else{
      System.out.println("\nReceptionist: Well then. You can always come back. \n              I guess for now, you can head out to shops or go outside the walls and do your own hunting. \n              See you later or never.");
    }

    System.out.println("\nReceptionist: Oh yeah. Here are two of Health and Mana Potions each. Its a freebie for the new adventurers. \nGood luck, " + user.getName());
    
    user.addPotion(0, 2);
    user.addPotion(1, 2);
    
    temp = input.next();
    clear();
    
    
    ArrayList<String> insideWall = new ArrayList<String>(); 
    insideWall.add("Go to outside the wall.");
    insideWall.add("Go to guild house.");
    insideWall.add("Go to the shopping district.");
    insideWall.add("Go to the cathedral.");
    insideWall.add("Check Inventory.");
    insideWall.add("Check Status.");
    
    ArrayList outsideWall = new ArrayList(); 
    outsideWall.add("Go inside the kingdom.");
    outsideWall.add("Hunt for horned rabbits.");
    outsideWall.add("Hunt for goblins.");
    outsideWall.add("Hunt for bandits.");
    outsideWall.add("Hunt for orcs.");
    outsideWall.add("Check Inventory.");
    outsideWall.add("Check Status.");
    
    choice = 0;
    
    int health = 0;
    int strength = 0;
    int defense = 0;
    
    while(user.getHp() > 0)
    {
      //Go outside the walls. Go to Guild house. Go to Shops (Potions/Armor/Weapons). Check inventory (Bag/Equipment/Money). Check status (Stats/quest).
      
      if(user.getLocation() == 1)
      {
        
        System.out.println("Pick an action\n");
        
        for(int i = 0; i < insideWall.size(); i++)
        {
          System.out.println("[" + (i + 1) + "] " + insideWall.get(i));
        }
        
        choice = input.nextInt();
        clear();
        
        if(choice == 1)
        { 
          user.setLocation(2);
          clear();
        }else{
          
          if(choice == 2)
          {
            goToGuild(user, guild);
          }else if(choice == 3){
            shoppingDistrict(allWeapons, allArmors, user);
          }else if(choice == 4){
            goToCathedral(user);
          }else if(choice == 5){
            checkInventory(user);
          }else {
            
              
            clear();
            System.out.println("[1] Stats \n[2] Skills \n[3] Cancel");
            choice = input.nextInt();
            clear();
            if(choice == 1)
            {
              System.out.println(user);
            }else if(choice == 2){
              for(int i = 0; i < 3; i++)
              {
                if(user.getSkills().get(i) == null)
                {
                  System.out.println("Empty \n");
                }else{
                  System.out.println(user.getSkills().get(i) + "\n");
                }
              }
            }else if(choice == 3){
              if(user.getQuest() == null)
              {
                System.out.println("You didn't accept any quest. Go to the guild house to accept one.");
              }else{
                System.out.println(user.getQuest());
              }
            }
              
            temp = input.next();
            clear();
          }
        }
      }
        
      
      if(user.getLocation() == 2){
          
        System.out.println("Pick an action\n");
        
        for(int i = 0; i < outsideWall.size(); i++)
        {
          System.out.println("[" + (i + 1) + "] " + outsideWall.get(i));
        }
        
        choice = input.nextInt();
        clear();
        if(choice == 1)
        { 
          user.setLocation(1);
          clear();
        }else{
          if(choice == 2)
          {
            
            health = (int)(Math.random()*30) + 15;
            strength = (int)(Math.random()*15) + 6;
            defense = (int)(Math.random()*7) + 4;
            Monsters hornedRabbit = new Monsters("Horned Rabbit", health, strength, defense);
            Battle.start(user, hornedRabbit, allWeapons, allArmors);
            
          }else if(choice == 3){
          
            health = (int)(Math.random()*65) + 50;
            strength = (int)(Math.random()*35) + 25;
            defense = (int)(Math.random()*15) + 10;
            Monsters goblin = new Monsters("Goblin", health, strength, defense);
            Battle.start(user, goblin, allWeapons, allArmors);
            
          }else if(choice == 4){
          
            health = (int)(Math.random()*120) + 100;
            strength = (int)(Math.random()*60) + 45;
            defense = (int)(Math.random()*45) + 20; 
            Monsters bandit = new Monsters("Bandit", health, strength, defense);
            Battle.start(user, bandit, allWeapons, allArmors);
            
          }else if(choice == 5){
          
            health = (int)(Math.random()*200) + 160;
            strength = (int)(Math.random()*90) + 60;
            defense = (int)(Math.random()*60) + 35; 
            Monsters orc = new Monsters("Orcs", health, strength, defense);
            Battle.start(user, orc, allWeapons, allArmors);
            
          }else if(choice == 6)
          {
            checkInventory(user);
          }else{
            
            clear();
            System.out.println("[1] Stats \n[2] Skills \n[3] Current Quest \n[3] Cancel");
            choice = input.nextInt();
            clear();
            if(choice == 1)
            {
              System.out.println(user);
            }else if(choice == 2){
              for(int i = 0; i < 3; i++)
              {
                if(user.getSkills().get(i) == null)
                {
                  System.out.println("Empty \n");
                }else{
                  System.out.println(user.getSkills().get(i) + "\n");
                }
              }
            }else if(choice == 3){
              if(user.getQuest() == null)
              {
                System.out.println("You didn't accept any quest. Go to the guild house to accept one.");
              }else{
                System.out.println(user.getQuest());
              }
            }
            temp = input.next();
            clear();
          }
        }
      }
    }  
  }
  

  //Go to church
  public static void goToCathedral(playerInfo user)
  {
    Scanner input = new Scanner(System.in);
    clear();
    boolean stay = true;
    System.out.println("Priest: Welcome to the cathedral. Are you here to pray? (Y/N)");
    
    String response = input.next();
    clear();
    //maybe in the future once you accumulate your reputation (by praying) it may lead to a chance of free healings :D
    
    if(response.equalsIgnoreCase("Y"))
    {
      System.out.println("Though you didn't want to do it, you didn't want to be rude either. So you prayed for 5 min.");
    }else{
      System.out.println("The priest eyes on you then immidiately asked what you came here for changing his tone of words \n(This might lead to something in the future so be careful)");
    }
    String temp = input.next();
    clear();
    while(stay)
    {
      System.out.println("[1] Ask for healing \n[2] Leave");
      int choice = input.nextInt();
      clear();
      int cost = (int)((user.getMaxHealth() - user.getHp()) * 3.1);
      if(choice == 1)
      {
        if(user.getHp() != user.getMaxHealth())
        {
          System.out.println("Priest: Ah that would be " + cost + " Silvers.");
          System.out.println("\nReplenish " + (user.getMaxHealth() + user.getHp()) + " for " + cost + "? (Y/N)");
          choice = input.nextInt();
          clear();
          if(choice == 1)
          {
            user.decreaseMoney(cost);
            System.out.println("Hp is fully replenished");
            user.setHp(user.getMaxHealth());
            System.out.println("\n" + user);
          }else{
          System.out.println("Priest: Not enough money? Sorry but I can't give any discounts.");
          }
        }else{
          System.out.println("Priest: You already have full Hp. Having too much that exceeds your max will bring harm rather than good to you.");
        }
      }else{
      stay = false;
      }
    }
    System.out.println("You left the cathedral.");
    temp = input.next();
    clear();
    
  }
  
  
  //Go to guild
  public static void goToGuild(playerInfo user, ArrayList<GuildQuest> quests)
  {
    Scanner input = new Scanner(System.in);
    String temp = "";
    int choice = 0;
    boolean unavailable = true;
    String response = "";
    
    boolean accept = true;
    
    while(accept)
    {
      selectionSortDifficulty(quests);
      int q = 0;
      
      if(user.getQuest() != null)
      {
        if(user.getQuest().getDifficulty() == 1)
        {
          q = 0;
        }else if(user.getQuest().getDifficulty() == 4){
          q = 1;
        }else if(user.getQuest().getDifficulty() == 8){
          q = 2;
        }else if(user.getQuest().getDifficulty() == 12){
          q = 3;
        }
        System.out.println("Receptionist: Back so soon? Are you here to submit a quest or cancel? (S/C) (Type in 0 to leave)");
        response = input.next();
        clear();
        
        if(response.equalsIgnoreCase("S"))
        {
          if(user.getRequirement() > user.getMisc().get(q).getCount())
          {
            System.out.println("Receptionist: Great job! So here is your reward. A total of " + user.getReward());
            user.addMoney(user.getReward());
            System.out.println("You now have: " + user.getMoney() + " Silvers");
            user.getMisc().get(q).decreaseCount(user.getReward());
            user.finishQuest();
            temp = input.next();
            clear();
          }
          
        }else if(response.equalsIgnoreCase("C"))
        {
          System.out.println("Receptionist: That would be a penalty of " + user.getPenalty() + "\n              Are you sure? (Y/N)");
          response = input.next();
          clear();
          if(response.equalsIgnoreCase("Y"))
          {
            if(user.getPenalty() < user.getMoney())
            {
              System.out.println(user.getPenalty() + "silvers deducted from your bank");
              user.cancelQuest();
              user.decreaseMoney(user.getPenalty());
              System.out.println("You now have " + user.getMoney());
            }else{
              System.out.println("Receptionist: You don't even have enough money! Come back here once you do.");
            }
          }else{
            System.out.print("Receptionist: You don't even have enough money do you?");
          }
          temp = input.next();
          clear();
        }
      }else{
        clear();
        System.out.println("Receptionist: Hello there. You want to do a quest? (Y/N)");
        response = input.next();
        
        clear();
        if(response.equalsIgnoreCase("Y"))
        {
          
          System.out.println("Ah here are some available quests then.\n\n");
          for(int i = 0; i < quests.size(); i++)
          {
            System.out.println("[" + (i + 1 ) + "]" + "\n" + quests.get(i) + "\n\n");
            temp = input.next();
          }
          
          while(unavailable)
          {
            
            System.out.println("Pick a number");
            
            choice = input.nextInt();
            clear();
            if(quests.get(choice - 1).getCount() > 0)
            {
              if(choice == 1){
                user.setQuest(quests.get(0));
              }else if(choice == 2){
                user.setQuest(quests.get(1));
              }else if(choice == 3){
                user.setQuest(quests.get(2));
              }else{
                user.setQuest(quests.get(3));
              }
              System.out.println("Reception: Here you go. Good luck again!\n" + user.getQuest());
              unavailable = false;
            }else{
              System.out.println("That quest is currently unavailable");
            }
          }
          temp = input.next();
          clear();
        }else{
          System.out.println("Receptionist: If not, then leave. You are wasting my time.");
          temp = input.next();
          clear();
        }
        accept = false;
      }
    }
  }
  
  
  
  
  //Check Inventory -> when equipping check if its a misc
  
  public static void checkInventory(playerInfo user)
  {
    Scanner input = new Scanner(System.in);
    String tempo = "";
    System.out.println("Pick an action\n\n[1] Bag \n[2] Equipment \n[3] Money \n[4] Quest Items \n[5] Close");
    int choice = input.nextInt();
    String response = "";
    boolean inBag = true;
    int num = 0;
    clear();
    if(choice == 1)
    {
      while(inBag)
      {
        String space = "";
        int pos = 1;
        int width = 20;
        for(int row = 0; row < 5; row++)
        {
          for(int col = 0; col < 7; col++)
          {
            int length = 0;
            if(user.getInventory()[row][col] == null)
            {
              length = 8;
              
              for(int i = 0; i < width - length; i++)
              {
                space += " ";
              }
              System.out.print("[" + pos + "] Empty" + space);
            }else{
              length = 4 + user.getInventory()[row][col].getName().length();
              for(int i = 0; i < width - length; i++)
              {
                space += " ";
              }
              System.out.print("[" + pos + "] " + user.getInventory()[row][col].getName() + space);
            }
            pos++;
            space = "";
            
          }
          System.out.println("\n");
        }
        System.out.println("Mana Potions Owned: " + user.getManaPotions() + "\nHealth Potions Owned: " + user.getHealthPotions());
        
        System.out.println("Pick a number to be equipped or be disposed. Type -1 to close. Type 0 to use a potion");
        choice = input.nextInt();
        clear();
        
        if(choice == -1)
        {
          inBag = false;
        }else if(choice == 0){
          System.out.println("[1] Mana Potion \n[2] Health Potion \n[3] Cancel");
          choice = input.nextInt();
          clear();
          if(choice == 1)
          {
            if(user.getManaPotions() > 0)
            {
              user.useManaPotion();
              System.out.println("Mana has been replenished by 25. \nYour mana is now: " + user.getMana() +"\nMana Potion Owned: " + user.getManaPotions());
            }else{
              System.out.println("You do not have any more Mana Potions.");
            }
          }else if(choice == 2)
          {
            if(user.getHealthPotions() > 0)
            {
              user.useHealthPotion();
              System.out.println("HP has been replenished by 25. \nYour HP is now: " + user.getHp() + "\nHealth Potion Owned: " + user.getHealthPotions());
            }else{
              System.out.println("You do not have any more Health Potion"); 
            }
          }
          tempo = input.next();
          clear();
        }else{
          
          int r = 0;
          int c = 0;
          int p = 1;
          
          while(p != choice)
          {
            p++;
            c++;
            if(c == 7)
            {
              c = 0;
              r++;
            }
          }
          
          if(user.getInventory()[r][c] == null)
          {
            System.out.println("This is an empty slot");
          }else{
            System.out.println(user.getInventory()[r][c] + "\n\n[1] Dispose \n[2] Equip");
            choice = input.nextInt(); 
            clear();
            if(choice == 1)
            {
              System.out.println("Are you sure? (Yes/No)");
              response = input.next();
              clear();
              if(response.equalsIgnoreCase("Yes"))
              {
                user.deleteItem(r, c);
              }
            }else if(choice == 2){
              
              
              
              
              
              for(int i = 0; i < 4; i++)
              {
                if(user.getEquipped().get(i).getType().equals(user.getInventory()[r][c].getType()) && user.getEquipped().get(i).getClass() == user.getInventory()[r][c].getClass())
                {
                  System.out.println(user.getEquipped().get(i));
                  num = i;
                  System.out.println("Replace? (Yes/No)");
                  response = input.next();
                  clear();
                  if(response.equalsIgnoreCase("Yes"))
                  {
                    if(user.getEquipped().get(num).getType().equals(user.getInventory()[r][c].getType()))
                    {
                      Items temp = user.getInventory()[r][c];
                      user.getInventory()[r][c] = user.getEquipped().get(num);
                      user.getEquipped().set(num, temp);
                      System.out.println("Item equipped.");
                    }else{
                      System.out.println("The item is not compatible with you!");
                      break;
                    }
                  }else if(response.equalsIgnoreCase("No"))
                  {
                    break;
                  }
                  break;
                }
                
              }
            }
          }
        }
      }
    }else if(choice == 2)
    {
      for(int i = 0; i < 4; i++)
      {
        System.out.println(user.getEquipped().get(i));
        tempo = input.next();
        clear();
      }
    }else if(choice == 3)
    {
      System.out.println("You own " + user.getMoney() + " Silver(s)");
      tempo = input.next();
      clear();
    }else if(choice == 4)
    {
      for(int i = 0; i < 4; i++)
      {
        System.out.println("[" + (i + 1) + "] " + user.getMisc().get(i).getName() + ": " + user.getMisc().get(i).getCount());
      }
      tempo = input.next();
      clear();
    }
  }
  
  //Actions - shopping district -> I have to include miscellaneous stuff for selling
  
  public static void shoppingDistrict(Items[][] weapons, Items[][] armors, playerInfo user)
  {
    System.out.println("You entered the shopping district.\n");
    
    Scanner input = new Scanner(System.in);
    
    ArrayList<String> shops = new ArrayList<String>();
    shops.add("Leave Shopping district");
    shops.add("Suspicious Merchant");
    shops.add("Potion Shop");
    shops.add("Weapon Shop");
    shops.add("Armor shop");
    
    boolean stay = true;
    
    while(stay)
    {
      
      System.out.println("Pick an action.\n");
      
      
      if(user.getLevel() != 1)
      {
        for(int i = 0; i < shops.size(); i++)
        {
          if(shops.get(i).equals("Suspicious Merchant"));
          {
            shops.remove(i);
            i--;
          }
          System.out.println("[" + (i + 1) + "] " + shops.get(i));
        }
      }
      
      for(int i = 0; i < shops.size(); i++)
      {
        System.out.println("[" + (i + 1) + "] " + shops.get(i));
      }
      
      int choice = input.nextInt();
      clear();
      if(choice != 1)
      {
        if(shops.size() == 5)
        {
        if(choice == 2)
        {
          
          sus(user);
          shops.remove(1);
          
        }else if(choice == 3){
          
          potionShop(user);
          
        }else if(choice == 4){
          
          weaponShop(weapons, user);
          
        }else{
          
          armorShop(armors, user);
          
        }
        }else{
          if(choice == 2)
          {
            potionShop(user);
          }else if(choice == 3){
            weaponShop(weapons, user);
          }else{
            armorShop(armors, user);
          }
        }
      }else{
        stay = false;
      }
    }
    
    
    System.out.println("\nYou left the shopping district.");
    String temp = input.next();
    clear();
  }
  
  public static void sus(playerInfo user)
  {
    Scanner input = new Scanner(System.in);
    System.out.println("You decided to go near the suspicious merchant. \nAs you approch, he sees you and starts to run away."
                      + "\nWhile running, he drops a bag of silvers. You try to catch up to him but you never did. \nYou decided to keep the money for yourself since you are currently broke.\nA total of 60 silvers acquired.");
    user.addMoney(60);
    System.out.println("\nYou now have " + user.getMoney() + " Silvers");
    String temp = input.next();
    clear();
  }
  
  public static void potionShop(playerInfo user)
  {
    Scanner input = new Scanner(System.in);
    boolean stay = true;
    String temp = "";

    
    
    while(stay)
    {
      System.out.println("Shop Keeper: Welcome to the potion shop. How may I help you?");
      System.out.println("\n[1] Buy Mana Potion - 70 Silvers \n[2] Buy Health Potion - 70 Silvers \n[3] Leave");
      int choice = input.nextInt();
      clear();
      int amount = 0;
      System.out.println("\nCurrent Money: " + user.getMoney());
        
      if(choice == 1 || choice == 2)
      {
        if(user.getMoney() >= 75)
        {
          System.out.println("Shop Keeper: How many would you like? (Type 0 to stop the action) \nCurrent bank: " + user.getMoney() + " Silvers");
          amount = input.nextInt();
          clear();
          
          if(amount > 0)
          {
            if(amount * 75 <= user.getMoney())
            {
              user.decreaseMoney(75 * amount);
              if(choice == 1)
              {
                user.addPotion(1, amount);
                System.out.println("Bought " + amount + " mana potions. \nYou now have " + user.getMoney() + " Silver(s) and " + user.getManaPotions() + " Mana Potions.");
              }else{
                user.addPotion(1, amount);
                System.out.println("Bought " + amount + " health potions. \nYou now have " + user.getMoney() + " Silver(s) and " + user.getHealthPotions() + " Helath Potions.");
              }
              
    
            }else{
            
              System.out.println("Shop Keeper: I'm sorry but you don't have enough money for that. \n\nYou only have: " + user.getMoney() + " Silvers");
            
            }
            temp = input.next();
            clear();
            
          }
        }else{
          
        System.out.println("Shop Keeper: I'm sorry but you don't have enough money for that. \n\nYou only have: " + user.getMoney() + " Silvers");
        temp = input.next();
        clear();
        }      
      }else{
        stay = false;
      }
    }
    System.out.println("You left the shop.");
    temp = input.next();
    clear();
  }
  
  
 
  public static void weaponShop(Items[][] weapons, playerInfo user)
  {
    Scanner input = new Scanner(System.in);
    boolean stay = true;
    String temp = "";
    
    
    while(stay)
    {
      System.out.println("Shop Keeper: Welcome to the weapon shop. How may I help you?");
      System.out.println("[1] Buy \n[2] Sell \n[3] Leave");
      System.out.println("\nCurrent Money: " + user.getMoney());
      int choice = input.nextInt();
      clear();
      boolean buy = true;
      boolean sell = true;
      
      
      //Buy
      if(choice == 1){
        while(buy)
        {
          String space = "";
          int pos = 1;
          int width = 25;
          for(int row = 0; row < 3; row++)
          {
            for(int col = 0; col < 4; col++)
            {
              int length = 4 + weapons[row][col].getName().length();
              if(pos >= 9)
              {
                length--;
                width--;
              }
              for(int i = 0; i < width - length; i++)
              {
                space += " ";
              }
              System.out.print("[" + pos + "] " + weapons[row][col].getName() + space);
              pos++;
              space = "";
              
            }
            System.out.println("\n");
          }
          
          System.out.println("Shop Keeper: Choose what you want to buy. (Type 0 to go back)");
          choice = input.nextInt();
          clear();
          if(choice != 0)
          {
            int r = 0;
            int c = 0;
            int p = 1;
            
            while(p != choice)
            {
              p++;
              c++;
              if(c == 4)
              {
                c = 0;
                r++;
              }
            }
            
            if(weapons[r][c].getCost() > user.getMoney())
            {
              System.out.println("Shop Keeper: I'm sorry but you don't have enough money for that. \n\nYou only have: " + user.getMoney() + " Silvers");
            }else{
              
              System.out.println("\n" + weapons[r][c]);
              System.out.println("\n[1] Buy \n[2] Cancel");
              choice = input.nextInt();
              clear();
              if(choice == 1)
              {
                if(user.getEmptyInv() != 0)
                {
                  user.decreaseMoney(weapons[r][c].getCost());
                  System.out.println("Shop Keeper: Here is your " + weapons[r][c].getName() + "\nYou now have: " + user.getMoney() + " Silver(s)");
                  user.addItem(weapons[r][c]);
                }else{
                  System.out.println("Shop Keeper: You don't have enough space in your inventory! Sell or dispose some of your items.");
                }
              }
            }
          }else{
            buy = false;
          }
        }
      }else if(choice == 2){
        while(sell)
        {
          String space = "";
          int pos = 1;
          int width = 20;
          for(int row = 0; row < 5; row++)
          {
            for(int col = 0; col < 7; col++)
            {
              int length = 0;
              if(user.getInventory()[row][col] == null)
              {
                length = 9;
                
                for(int i = 0; i < width - length; i++)
                {
                  space += " ";
                }
                System.out.print("[" + pos + "] Empty" + space);
              }else{
                length = 4 + user.getInventory()[row][col].getName().length();
                
                for(int i = 0; i < width - length; i++)
                {
                  space += " ";
                }
                System.out.print("[" + pos + "] " + user.getInventory()[row][col].getName() + space);
              }
              pos++;
              space = "";
              
            }
            System.out.println("\n");
          }
          
          System.out.println("Select what you want to sell. Type 0 to cancel");
          
          choice = input.nextInt();
          clear();
          if(choice != 0)
          {
            int r = 0;
            int c = 0;
            int p = 1;
            
            while(p != choice)
            {
              p++;
              c++;
              if(c == 7)
              {
                c = 0;
                r++;
              }
            }
            
            if(user.getInventory()[r][c] == null)
            {
              System.out.println("This is an empty slot");
            }else if(user.getInventory()[r][c].getIsWeapon()){
              System.out.println("This is not a weapon.");
            }else{
              System.out.println(user.getInventory()[r][c] + "\n\n[1] Sell \n[2] Cancel");
              choice = input.nextInt(); 
              clear();
              if(choice == 1)
              {
                System.out.println("Shop Keeper: Here are your silvers. \nAcquired " + user.getInventory()[r][c].getValue() + " Silvers");
                user.addMoney(user.getInventory()[r][c].getValue());
                System.out.println("You have a total of " + user.getMoney());
              }
            }
            
          }else{
            sell = false;
          }
        }
      }else{
        stay = false;
      }
    }
    System.out.println("You left the shop.");
    temp = input.next();
    clear();
  }
  
  
  //THEN change the weapons to armors
  public static void armorShop(Items[][] armors, playerInfo user)
  {
    Scanner input = new Scanner(System.in);
    boolean stay = true;
    String temp = "";
    
    
    while(stay)
    {
      System.out.println("Shop Keeper: Welcome to the armor shop. How may I help you?");
      System.out.println("[1] Buy \n[2] Sell \n[3] Leave");
      System.out.println("\nCurrent Money: " + user.getMoney());
      int choice = input.nextInt();
      clear();
      boolean buy = true;
      boolean sell = true;
      
      //Buy
      if(choice == 1){
        while(buy)
        {
          String space = "";
          int pos = 1;
          int width = 25;
          for(int row = 0; row < 3; row++)
          {
            for(int col = 0; col < 4; col++)
            {
              int length = 4 + armors[row][col].getName().length();
              if(pos >= 9)
              {
                length--;
                width--;
              }
              for(int i = 0; i < width - length; i++)
              {
                space += " ";
              }
              System.out.print("[" + pos + "] " + armors[row][col].getName() + space);
              pos++;
              space = "";
              
            }
            System.out.println("\n");
          }
          
          System.out.println("Shop Keeper: Choose what you want to buy. (Type 0 to go back)");
          choice = input.nextInt();
          clear();
      
          if(choice != 0)
          {
            int r = 0;
            int c = 0;
            int p = 1;
            
            while(p != choice)
            {
              p++;
              c++;
              if(c == 4)
              {
                c = 0;
                r++;
              }
            }
            
            if(armors[r][c].getCost() > user.getMoney())
            {
              System.out.println("Shop Keeper: I'm sorry but you don't have enough money for that. \n\nYou only have: " + user.getMoney() + " Silvers");
            }else{
              
              System.out.println("\n" + armors[r][c]);
              System.out.println("\n[1] Buy \n[2] Cancel");
              choice = input.nextInt();
              clear();
              if(choice == 1)
              {
                if(user.getEmptyInv() != 0)
                {
                  user.decreaseMoney(armors[r][c].getCost());
                  System.out.println("Shop Keeper: Here is your " + armors[r][c].getName() + "\nYou now have: " + user.getMoney() + " Silver(s)");
                  user.addItem(armors[r][c]);
                }else{
                  System.out.println("Shop Keeper: You don't have enough space in your inventory! Sell or dispose some of your items.");
                }
              }
            }
          }else{
            buy = false;
          }
        }
      }else if(choice == 2){
        while(sell)
        {
          String space = "";
          int pos = 1;
          int width = 20;
          for(int row = 0; row < 5; row++)
          {
            for(int col = 0; col < 7; col++)
            {
              int length = 0;
              if(user.getInventory()[row][col] == null)
              {
                length = 9;
                
                for(int i = 0; i < width - length; i++)
                {
                  space += " ";
                }
                System.out.print("[" + pos + "] Empty" + space);
              }else{
                length = 4 + user.getInventory()[row][col].getName().length();
                
                for(int i = 0; i < width - length; i++)
                {
                  space += " ";
                }
                System.out.print("[" + pos + "] " + user.getInventory()[row][col].getName() + space);
              }
              pos++;
              space = "";
              
            }
            System.out.println("\n");
          }
          
          System.out.println("Select what you want to sell. Type 0 to cancel");
          
          choice = input.nextInt();
          clear();
          if(choice != 0)
          {
            int r = 0;
            int c = 0;
            int p = 1;
            
            while(p != choice)
            {
              p++;
              c++;
              if(c == 7)
              {
                c = 0;
                r++;
              }
            }
            
            if(user.getInventory()[r][c] == null)
            {
              System.out.println("This is an empty slot");
            }else if(user.getInventory()[r][c].getIsArmor()){
              System.out.println("This is not an armor.");
            }else{
              System.out.println(user.getInventory()[r][c] + "\n\n[1] Sell \n[2] Cancel");
              choice = input.nextInt(); 
              clear();
              if(choice == 1)
              {
                System.out.println("Shop Keeper: Here is your silvers. \nAcquired " + user.getInventory()[r][c].getValue() + " Silvers");
                user.addMoney(user.getInventory()[r][c].getValue());
                System.out.println("You have a total of " + user.getMoney());
              }
            }
          }else{
            sell = false;
          }
        }
      }else{
        stay = false;
      }
      
    }
    System.out.println("You left the shop.");
    temp = input.next();
    clear();
  }
  
  
  
  
  //Sorting stuff    
  public static void insertedSortReward(ArrayList<GuildQuest> quests)
  {
    for (int i = 1; i < quests.size(); i++)
    {
      int index = i;
      while (index > 0 && quests.get(i).getReward() > quests.get(index - 1).getReward())
      {  
        index--;
      }    
      quests.add(index, quests.remove(i));  
    }
  }
  
  public static void selectionSortDifficulty(ArrayList<GuildQuest> quests)
  {
    
    for (int i = 0; i < quests.size(); i++)
    {
      int index = 0; 
      while(index + 1 < quests.size() && quests.get(i).getDifficulty() > quests.get(index).getDifficulty()) 
      {
        index++;
      }
      GuildQuest temp = quests.get(index);
      quests.set(index, quests.get(i));
      quests.set(i, temp);
      i = index;
    }
  }
  
    
    
  //just requirements:
  public static void selectionSortDifficulty(Items[][] weapons)
  {
    for(int col = 0; col < weapons[0].length; col++)
    {
      for(int row = 0; row < weapons.length; row++)
      {
        System.out.print("[" + (row + 1) + "] " + weapons[row][col].getName());
      }
      System.out.println();
    }
  }
  //comparing which one is faster when trying to get lowest to highest diffculty
  public static void compareSort(ArrayList<GuildQuest> quests)
  {
    int selS = 0;
    for (int i = 0; i < quests.size(); i++)
    {
      int index = 0; 
      while(index + 1 < quests.size() && quests.get(i).getDifficulty() > quests.get(index).getDifficulty()) 
      {
        index++;
      }
      GuildQuest temp = quests.get(index);
      quests.set(index, quests.get(i));
      quests.set(i, temp);
      i = index;
      selS++;
    }
    
    int insS = 0;
    for (int i = 1; i < quests.size(); i++)
    {
      int index = i;
      while (index > 0 && quests.get(i).getDifficulty() < quests.get(index - 1).getDifficulty())
      {  
        index--;
      }    
      quests.add(index, quests.remove(i));
      insS++;
    }
    
    if(insS < selS)
    {
      System.out.println("Insertion Sort did it with less execution count");
    }else if(insS > selS){
      System.out.println("Selection Sort did it with less execution count");
    }else{
      System.out.println("Both had the same statement execution count");
    }
  }
  
  //Texts
  public static void clear()
  {
    for(int i = 0; i < 30; i++)
    {
      System.out.println();
    }
  }
  
  public static String dashes()
    {
    return "==================================";
  }
  
  public static void time(int millisecond)
  {
    millisecond = 0;
    try { 
      Thread.sleep(millisecond); 
    } catch(InterruptedException ex){ 
      System.exit(0); 
    } 
  }
}