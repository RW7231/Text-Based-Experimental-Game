import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Saver {
    public void saveGame(Character player){

    }
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
            int currHealth = 1;
            List<Integer> charstats = new ArrayList<>(Collections.nCopies(8, 10));

            //write values
            playerFile.write(classname + "\n");
            playerFile.write(String.valueOf(level) + "\n");
            playerFile.write(String.valueOf(currHealth) + "\n");
            for(int i = 0; i < charstats.size(); i++){
                playerFile.write(String.valueOf(charstats.get(i)) + "\n");
            }
            playerFile.close();

        }catch (IOException e){
            System.out.println("Error Making Character");
            e.printStackTrace();
        }
    }

    //get player save file and write current data to it
    private void overwriteSave(Character player){
        try{
            FileWriter save = new FileWriter("Save.txt");
            save.write(player.getClassname() + "\n");
            save.write(String.valueOf(player.getLevel()) +"\n");
            save.write(player.getCurrentHealth() + "\n");
            List<Integer> stats = player.getCharstats();
            for(int i = 0; i < stats.size(); i++){
                save.write(stats.get(i) + "\n");
            }
            save.close();
        } catch (IOException e){
            System.out.println("Something has gone wrong");
            e.printStackTrace();
        }

    }
}
