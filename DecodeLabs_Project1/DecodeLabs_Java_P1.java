import java.util.Random;
import java.util.Scanner;
public class DecodeLabs_Java_P1 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        Random random=new Random();
        char playagain;
        do {
            int randomNumber = random.nextInt(100) + 1;
            int guess = 0;
            int attempt = 0;
            int score = 100;
            System.out.println("===============================");
            System.out.println("Welcome to Number Guessing Game");
            System.out.println("Guess a number between 1 to 100");
            while (guess != randomNumber) {
                System.out.println("Enter your guess:");
                try {
                    guess = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Enter only numbers");
                    scanner.next();
                    continue;
                }
                attempt++;
                score -= 5;
                if (score < 0)
                    score = 0;
                if (guess > randomNumber) {
                    System.out.println("Too High");
                } else if (guess < randomNumber) {
                    System.out.println("Too Low");
                } else {
                    System.out.println("🎊Congratulations🎉");
                    System.out.println("You guessed correctly in " + attempt + " Attempts");
                    System.out.println("Your Score is " + score);
                }
            }
            System.out.println("Do you want to Play Again[y/n]");
            playagain = scanner.next().charAt(0);
        }while(playagain=='y'||playagain=='Y');
        scanner.close();
    }
}