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
            }
            else{
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
            int level = 0;
            int currHealth = 0;
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
}
