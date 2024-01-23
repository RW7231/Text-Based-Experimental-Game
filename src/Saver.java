import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Saver {
    public void createSave(){
        try{
            File newFile = new File("Save.txt");
            if(newFile.createNewFile()){
                System.out.println("Save File Created");
                characterMaker();
            } else{
                newFile.delete();
                newFile.createNewFile();
                System.out.println("Save File Created");
                characterMaker();
            }
        }catch (IOException e){
            System.out.println("Failed to make file");
            e.printStackTrace();
        }
    }

    private void characterMaker(){

        try{
            FileWriter playerFile = new FileWriter("Save.txt");
            System.out.println("CHARACTER MAKER TEST:");
            String classname = "Test";
            int level = 1;
            List<Integer> charstats = new ArrayList<>(Collections.nCopies(8, 10));

            //stopping player from being made with 1 hp, but don't want to hard code the number
            int currHealth = ((level * 2) + (charstats.get(0) * 30) + (charstats.get(2) * 10));

            //write values
            playerFile.write(classname + "\n");
            playerFile.write(String.valueOf(level) + "\n");
            playerFile.write(String.valueOf(currHealth) + "\n");
            for(int i = 0; i < charstats.size(); i++){
                playerFile.write(String.valueOf(charstats.get(i)) + "\n");
            }

            //add in souls now
            playerFile.write(String.valueOf(0));

            playerFile.close();

        }catch (IOException e){
            System.out.println("Error Making Character");
            e.printStackTrace();
        }
    }

    //get player save file and write current data to it
    public void overwriteSave(Character player){
        try{
            FileWriter save = new FileWriter("Save.txt");
            save.write(player.classname + "\n");
            save.write(String.valueOf(player.level) +"\n");

            //new check, if player is dead save with full health
            if(player.currentHealth <= 0){
                save.write(player.maxHealth);
            }
            //otherwise save with current health
            else{
                save.write(player.currentHealth + "\n");
            }

            List<Integer> stats = player.charstats;
            for(int i = 0; i < stats.size(); i++){
                save.write(stats.get(i) + "\n");
            }

            save.write(player.souls + "\n");

            save.close();
        } catch (IOException e){
            System.out.println("Something has gone wrong");
            e.printStackTrace();
        }

    }
}
