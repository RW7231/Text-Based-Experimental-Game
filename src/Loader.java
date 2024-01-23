import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loader {
    //Another possible location to load in character
    //intention is to return a Character
    public Character charLoad(){
        //need these to hold character data
        String classname = null;
        int level = 0;
        int currentHealth = 0;
        List<Integer> charstats = new ArrayList<>(8);
        int souls = 0;

        //read the file
        try {
            File charFile = new File("Save.txt");
            Scanner filereader = new Scanner(charFile);
            //if there is any data, go line by line to get important data
            classname = filereader.next();
            level = filereader.nextInt();
            currentHealth = filereader.nextInt();
            for(int i = 0; i < 8; i ++){
                charstats.add(i, filereader.nextInt());
            }

            souls = filereader.nextInt();

        }catch (FileNotFoundException e){
            System.out.println("File could not be found");
            e.printStackTrace();
        }

        //finally, create and return the player
        Character player = new Character(classname, level, charstats, currentHealth, souls);

        return player;

    }

    //for right now, I will leave this blank, but it is a place to load monsters
    public void monsterLoad(){

    }

    //feature way out in the future, load up maps. It's just a pipe dream at the moment :(
    public void mapLoad(){

    }
}
