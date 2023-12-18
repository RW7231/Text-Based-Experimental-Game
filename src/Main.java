import java.io.File;
import java.util.Scanner;

//Experimental Game Java Edition
//Created by Robert Walsh
public class Main {
    public static void main(String[] args) {

        //Saver and Loader, use these to save and load files
        Loader loader = new Loader();
        Saver saver = new Saver();

        //inputter that will follow the player around, it waits for your inputs
        Scanner scanner = new Scanner(System.in);
        Inputter inputter = new Inputter(scanner);

        //This is the initial boot section, check for saves and see if the user wants to load
        System.out.println("Checking for Saves...");
        File save = new File("Save.txt");
        if(save.exists()){
            System.out.println("Save found, would you like to load? (y/n)");
            //When the user finally puts in y or n, we can then move on to either loading the save or making a new one
            if(inputter.userConfirmation() == 'y'){
                //load save and enter the main game
                Character player = loader.charLoad();
                mainGame(player, inputter);
                System.exit(0);
            }else{
                saver.createSave();
                Character player = loader.charLoad();
                mainGame(player, inputter);
                System.exit(0);
            }
        }else{
            System.out.println("No save found, would you like to make one? (y/n)");
            if(inputter.userConfirmation() == 'y'){
                //create save and enter the main game
                saver.createSave();
                Character player = loader.charLoad();
                mainGame(player, inputter);
                System.exit(0);
            }else{
                System.out.println("Then I really don't know what you want from me then");
                new Scanner(System.in).nextLine();
                System.exit(0);
            }
        }
    }

    public static void mainGame(Character player, Inputter inputter){
        boolean wannaPlay = true;
        while(wannaPlay){
            System.out.println("So what do you want to do?");
            System.out.println("Test Fight (1)");
            System.out.println("Level up Test (2)");
            System.out.println("Quit (3)");

            int userInput = inputter.selection(3);

            switch (userInput){
                case 1:
                    Monster testMonster = new Monster(100, 100, 10, 100,1);
                    System.out.println("Not Yet Implemented");
                    break;
                case 2:
                    player.levelUp(inputter);
                    break;
                case 3:
                    wannaPlay = false;
                    inputter.close();
                    break;
                default:
                    System.out.println("Not an option");
            }
        }
    }
}