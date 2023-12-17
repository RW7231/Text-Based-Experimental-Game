import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Character {
    String classname;
    int level, currentHealth;

    //holds vigor, focus, endurance, strength, dex, int, faith, and luck all in that order
    List<Integer> charstats = new ArrayList<>(8);

    //use this for defensive properties, chance to dodge/ignore hit and damage received if hit
    int AC, Defense;

    //use these for currencies, i'll just leave them at 0 for now
    //for debug purposes
    int souls = 0;
    int coins = 0;

    //when the character is loaded from the save file, I will get them set up
    public Character(String classname, int level, List<Integer> charstats, int currentHealth){
        //save the classname, level, the stats (in an array), and health
        this.classname = classname;
        this.level = level;
        this.charstats = charstats;
        this.currentHealth = currentHealth;
    }

    //prints out the character's current stats
    void currentStatus(){

    }

    //Levels the player up
    void levelUp(){
        System.out.println("You find the opportunity to focus your mind and channel the power of souls to enhance your abilities \n" +
                "You have " + souls + " souls in your possession, you need 0 souls to level up");
        if(souls < 0){
            System.out.println("You do not have enough souls to level up");
        }
        else{

        }


    }

    //checks to see if player can rest easily or will be ambushed, for right now I will always set it to player will always be ambushed
    boolean rest(boolean exposure){
        return true;
    }
}
