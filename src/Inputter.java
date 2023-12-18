import java.util.Scanner;

//a simple class that leverages Java's Scanner so I don't have to repeat input functions everywhere
public class Inputter {

    private Scanner scanner;
    public Inputter(Scanner scanner){
        this.scanner = scanner;
    }

    public int selection(int max){
        int userInput = 100;

        while(userInput > max || userInput < 0){
            String input = scanner.nextLine();
            userInput = Integer.parseInt(input);
        }

        return userInput;
    }

    public char userConfirmation(){

        //initialize an input, default value of 'a'
        char input = 'a';

        //check if user input is valid or if there is an input
        while(input != 'y' && input != 'n'){
            input = scanner.nextLine().charAt(0);
        }

        //return user input
        return input;

    }

    public void close(){
        scanner.close();
    }
}
