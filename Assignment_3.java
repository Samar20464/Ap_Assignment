import java.util.Random;
import java.util.Scanner;

class Dice
{
    int Random_nos_1_and_2()
    {
        Random rand = new Random();
        int generate = rand.nextInt(2) + 1 ;
        return generate;
    }
}
class Game extends Dice
{
    static int points =1;
    static int floor = 0;
void SnakeGame(int Dice,String name)
{
    floor+=Dice;
    System.out.println("Dice gave " + Dice);
    for (int i =0;i<=13;i++)
    {
        if(floor==1)
        {
            System.out.println("Player position reached floor-" + floor);
            System.out.println(name + " has reached an Empty Floor");
            System.out.println("Total Points " + points);
            break;
        }
        if(floor==2)
        {
            System.out.println("Player position reached floor-" + floor);
            System.out.println(name + " has reached an  Elevator Floor");
            floor+=8;
            points+=5;
            System.out.println("Player Position Floor-" + floor);
            System.out.println(name + " has reached an Empty Floor");
            System.out.println("Total Points " + points);
            break;
        }
        if(floor == 3)
        {
            System.out.println("Player position reached floor-" + floor);
            System.out.println(name + " has reached an Empty Floor");
            points+=1;
            System.out.println("Total Points " + points);
            break;
        }
        if(floor == 4)
        {
            System.out.println("Player position reached floor-" + floor);
            System.out.println(name + " has reached an Empty Floor");
            points+=1;
            System.out.println("Total Points " + points);
            break;
        }
        if(floor ==5)
        {
            System.out.println("Player position reached floor-" + floor);
            System.out.println(name + " has reached an  Snake  Floor");
            floor-=4;
            System.out.println("Player Position Floor-" + floor);
            System.out.println(name + " has reached an Empty Floor");
            System.out.println("Total Points " + points);
            break;
        }
        if(floor == 6)
        {
            System.out.println("Player position reached floor-" + floor);
            System.out.println(name + " has reached an Empty Floor");
            points+=1;
            System.out.println("Total Points " + points);
            break;
        }
        if(floor == 7)
        {
            System.out.println("Player position reached floor-" + floor);
            System.out.println(name + " has reached an Empty Floor");
            points+=1;
            System.out.println("Total Points " + points);
            break;
        }
        if(floor==8)
        {
            System.out.println("Player position reached floor-" + floor);
            System.out.println(name + " has reached an  Elevator Floor");
            floor+=4;
            points+=5;
            System.out.println("Player Position Floor-" + floor);
            System.out.println(name + " has reached an Empty Floor");
            System.out.println("Total Points " + points);
            break;
        }
        if(floor == 9)
        {
            System.out.println("Player position reached floor-" + floor);
            System.out.println(name + " has reached an Empty Floor");
            points+=1;
            System.out.println("Total Points " + points);
            break;
        }
        if(floor == 10)
        {
            System.out.println("Player position reached floor-" + floor);
            System.out.println(name + " has reached an Empty Floor");
            points+=1;
            System.out.println("Total Points " + points);
            break;
        }
        if(floor ==11)
        {
            System.out.println("Player position reached floor-" + floor);
            System.out.println(name + " has reached an  Snake  Floor");
            floor-=8;
            System.out.println("Player Position Floor-" + floor);
            System.out.println(name + " has reached an Empty Floor");
            System.out.println("Total Points " + points);
            break;
        }
        if(floor == 12)
        {
            System.out.println("Player position reached floor-" + floor);
            System.out.println(name + " has reached an Empty Floor");
            points+=1;
            System.out.println("Total Points " + points);
            break;
        }
        if(floor == 13)
        {
            System.out.println("Player position reached floor-" + floor);
            System.out.println(name + " has reached an Empty Floor");
            points+=1;
            System.out.println("Total Points " + points);
            System.out.println("Game over");
            System.out.println(name + " accumulated " + points + " points ");
            System.exit(0);
        }
        if(floor==14 && Dice==2)
        {
            floor-=2;
            System.out.println("Player cannot move\n");
            break;
        }
    }

}

}

public class Assignment_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the player name and hit enter");
        String name;
        name = input.nextLine();
        System.out.println(name);
        System.out.println("The game setup is ready");
        System.out.println("Hit enter to roll the dice");
        boolean loop_terminate = true;
        while (loop_terminate)
        {
            try{System.in.read();
                Game dice = new Game();
                int generate = dice.Random_nos_1_and_2();
                switch (generate)
                {
                    case 1:
                        System.out.println("Dice gave " + generate);
                        System.out.println("Player position Floor - 0");
                        System.out.println(name + " has reached an Empty Floor ");
                        System.out.println("has reached an Empty Floor");
                        loop_terminate= false;
                        break;
                    case 2:
                        System.out.println("" +
                                "Dice gave 2\n" +
                                "Game cannot start until you get 1\n");
                        break;
                }
            }
            catch(Exception e){}
        }
        while (true)
        {
            System.out.println("Hit Enter to roll the dice");
            try{System.in.read();
                Game play = new Game();
                Game Dice = new Game();
                int generate = Dice.Random_nos_1_and_2();
                play.SnakeGame(generate,name);
            }
            catch(Exception e){}
        }
    }
}
