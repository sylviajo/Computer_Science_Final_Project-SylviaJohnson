import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
public class Guess extends Boggle{
    private int score;//number of guessed words that are valid
    private ArrayList<String> guesses;

    public boolean valid (String guess) {
        int row = 0;
        int col = 0;
         int row2 = 0;
         int col2 = 0;
        int count = 0;
        while (guess.length() > 1) {
            String first = guess.substring(1);
            String second = (guess.substring(1, 2));
        }
        String[][] array = new String[8][8];
        for (int r = 0; r < array.length; r++) {
            for (int c = 0; c < array[r].length; c++) {
                if (array[r][c].equalsIgnoreCase("first")) {
                    row = r;
                    col = c;
                }
                if (array[r][c].equalsIgnoreCase("second")) {
                    row2 = r;
                    col2 = c;
                }
            }
            if (array[row+1][col].equalsIgnoreCase("second")||array[row-1][col].equalsIgnoreCase("second")||array[row][col+1].equalsIgnoreCase("second")||array[row][col-1].equalsIgnoreCase("second")){
                count++;
            }
        }
        if (count == guess.length()){
            return true;
        }
        return false;
    }
    public String getGuess (String guess){
        return guess;
    }
    public boolean dictionary (String guess) throws FileNotFoundException {
        File myObj = new File("dictionary.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            if (guess.equalsIgnoreCase(data)){
                return true;
            }
        }
        return false;
    }
    public int getScore (){
        return score;
    }
    public void increment (String guess){
        if (valid(guess)){
            score++;
        }
    }
    public void output (String guess){
        System.out.println("Time is up!" + "Total list of words guessed: " + guesses + "Total points scored: " + score + "Thanks for playing!");
    }
    public boolean addAnswers (String guess){
        if (valid(guess) && error(guess)){
            guesses.add(guess);
            return true;
        }
        return false;
    }
    public boolean error (String guess){
        for (int i = 0; i < guesses.size(); i++){
            if (guesses.get(i).equalsIgnoreCase(guess)){
                System.out.println("Already Guessed");
                return false;
            }
        }
        return true;
    }
}
