import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Character {
    private final String classname;
    private int level, currentHealth;

    //holds vigor, focus, endurance, strength, dex, int, faith, and luck all in that order
    private List<Integer> charstats;

    //use this for defensive properties, chance to dodge/ignore hit and damage received if hit
    int AC, Defense;

    //use these for currencies, i'll just leave them at 0 for now
    //for debug purposes
    int souls;
    int coins;

    //determine cost per level up
    int soulCost;

    //when the character is loaded from the save file, I will get them set up
    public Character(String classname, int level, List<Integer> charstats, int currentHealth){
        //save the classname, level, the stats (in an array), and health
        this.classname = classname;
        this.level = level;
        this.charstats = charstats;
        this.currentHealth = currentHealth;
        souls = 0;
        coins = 0;
        soulCost = 0;
    }

    //prints out the character's current stats
    void currentStatus(){

    }

    public String getClassname(){
        return classname;
    }

    public int getLevel(){
        return level;
    }

    public int getCurrentHealth(){
        return currentHealth;
    }

    public List<Integer> getCharstats(){
        return charstats;
    }

    //Levels the player up
    void levelUp(Inputter inputter){
        System.out.println("You find the opportunity to focus your mind and channel the power of souls to enhance your abilities \n" +
                "You have " + souls + " souls in your possession, you need 0 souls to level up");
        if(souls < soulCost){
            System.out.println("You do not have enough souls to level up");
        } else{
            System.out.println("What would you like to level up? \n  " +
                    "1: Vigor (Increase max health) \n" +
                    "2: Attunement (Increase max number of prepared spells) \n" +
                    "3: Endurance (Increase max health and stamina) \n" +
                    "4: Strength (Increase damage with heavy weapons) \n" +
                    "5: Dexterity (Increase damage with finesse weapons) \n" +
                    "6: Intelligence (Increase sorcery power) \n" +
                    "7: Faith (Increase miracle power) \n" +
                    "8: Luck (Makes you better at everything) \n");

            switch (inputter.selection(8)){
                case 1:
                    charstats.set(0, charstats.get(0) + 1);
                    break;
                case 2:
                    charstats.set(1, charstats.get(1) + 1);
                    break;
                case 3:
                    charstats.set(2, charstats.get(2) + 1);
                    break;
                case 4:
                    charstats.set(3, charstats.get(3) + 1);
                    break;
                case 5:
                    charstats.set(4, charstats.get(4) + 1);
                    break;
                case 6:
                    charstats.set(5, charstats.get(5) + 1);
                    break;
                case 7:
                    charstats.set(6, charstats.get(6) + 1);
                    break;
                case 8:
                    charstats.set(7, charstats.get(7) + 1);
                    break;
                default:
                    System.out.println("This shouldn't happen, what...?");
            }

            inputter.getSaver().saveGame(this);

        }


    }

    //checks to see if player can rest easily or will be ambushed, for right now I will always set it to player will always be ambushed
    boolean rest(boolean exposure){
        return true;
    }
}
