import java.util.Scanner;
public class Main {
    public static void main (String[] args) {
    Guess alex = new Guess();
    alex.printBoggle(alex.randomize());
        System.out.println("place your guesses here: ");
        Scanner sc= new Scanner(System.in);
        String guess = sc.nextLine();
        System.out.println(guess);
    }
}