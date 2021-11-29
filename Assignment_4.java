import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Bucket implements Cloneable
{
private  String store;
    @Override
    public String toString() {
        String result = this.store; // + ...
        return result;
    }
    public void setStore(String store) {
        this.store = store;
    }
    public Object clone()throws  CloneNotSupportedException
    {
        return super.clone();
    }
}

class Calculator<B> extends Bucket
{
private static ArrayList<String> storeToys = new ArrayList<>();
    /**
     * @param a
     * @param b
     * @return
     */
  public static Integer divInteger(Integer a,Integer b)
  {
      return a/b;
  }
    /**
     * @param a
     * @param b
     * @return
     */
  public static String Concat(String a, String b)
  {
      return a + b;
  }

  public static  void Cal(String val)
  {
      Bucket put = new Bucket();
      put.setStore(val);

      if(storeToys.size()==5)
      {
          System.out.println(
                  "Game Over\n" +
                  "Soft toys won by you are:");
          StringBuilder showToys = new StringBuilder(storeToys.toString());
          System.out.println(showToys.substring(1,showToys.length()-1));
          System.exit(1);
      }
      else
      {
          try {
              Bucket display = (Bucket)put.clone();
              storeToys.add(display.toString());

          } catch (CloneNotSupportedException e) {
              e.printStackTrace();
          }
      }


  }

}

public class Assignment_4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String no_of_hops[] = {
                                "one","two","three","four","five",
                                "six","seven","eight","nine","ten",
                                "eleven","twelve","thirteen","fourteen","fifteen",
                                "seventeen","eighteen","nineteen","twenty"
        };

        System.out.println(
                "Hit enter to initialize the game\n" +
                        "Game is ready"
                        );

        boolean loop_terminate = true;
        while (loop_terminate)
        {
            try {
                System.in.read();
                System.out.println(
                                          "Hit enter for your first hop\n" +
                        "You are too energetic and zoomed past all the tiles. Muddy Puddle Splash!");
                loop_terminate= false;
            }
            catch (Exception e){}
        }
        int i =1;
        while (true)
        {
            Random rand = new Random();
            int hop = rand.nextInt(20)+ 1;

            try{
                System.in.read();
                System.out.println("Hit enter for your " + no_of_hops[i] + " hop");
                System.out.println("You landed on tile " + hop);
                if(hop==1)
                {
                    System.out.println("Question answer round. Integer or Strings?");
                    String ans = input.next();
                    if(ans.contentEquals("Integer"))
                    {
                        System.out.println("Calculate the result of 2000 divided by 100");
                        int answer = input.nextInt();
                        int Value = Calculator.divInteger(2000,100);
                        if(Value==answer)
                        {
                            System.out.println("" +
                                    "Correct answer\n" +
                                    "You won a Jerry soft toy");
                            Calculator.Cal("Jerry");

                        }
                        else
                        {
                            System.out.println("Wrong Entered");
                            System.out.println("You didn't won this time better luck try again");
                        }
                    }
                    else if(ans.contentEquals("Strings"))
                    {
                        System.out.println("Calculate the concatenation of strings abCD and ZxyL");
                        String answer = input.next();
                        String Con = Calculator.Concat("abCD","ZxyL");
                        if(answer.contentEquals(Con))
                        {
                            System.out.println("" +
                                    "Correct answer\n" +
                                    "You won a Jerry soft toy");
                            Calculator.Cal("Jerry");
                        }
                        else
                        {
                            System.out.println("Wrong Entered");
                            System.out.println("You didn't won this time better luck try again");
                        }
                    }
                    else
                        System.out.println("Wrong entered try again");
                }
                if(hop==2)
                {
                    System.out.println("" +
                            "You won a Donald Duck soft toy");
                    Calculator.Cal("Donald Duck");
                }
                if(hop==3)
                {
                    System.out.println("Question answer round. Integer or Strings?");
                    String ans = input.next();
                    if(ans.contains("Integer"))
                    {
                        System.out.println("Calculate the result of 2000 divided by 100");
                        int answer = input.nextInt();
                        int Value = Calculator.divInteger(2000,100);
                        if(Value==answer)
                        {
                            System.out.println("" +
                                    "Correct answer\n" +
                                    "You won a Aeroplane soft toy");
                            Calculator.Cal("Aeroplane");

                        }
                        else
                        {
                            System.out.println("Wrong Entered");
                            System.out.println("You didn't won this time better luck try again");
                        }
                    }
                    else if(ans.contentEquals("Strings"))
                    {
                        System.out.println("Calculate the concatenation of strings abCD and ZxyL");
                        String answer = input.next();
                        String Con = Calculator.Concat("abCD","ZxyL");
                        if(answer.contentEquals(Con))
                        {
                            System.out.println("" +
                                    "Correct answer\n" +
                                    "You won a Aeroplane soft toy");
                            Calculator.Cal("Aeroplane");
                        }
                        else
                        {
                            System.out.println("Wrong Entered");
                            System.out.println("You didn't won this time better luck try again");
                        }
                    }
                    else
                        System.out.println("Wrong entered try again");
                }
                if(hop==4)
                {
                    System.out.println("" +
                            "You won a Minion soft toy");
                    Calculator.Cal("Minion");
                }
                if(hop==5)
                {
                    System.out.println("Question answer round. Integer or Strings?");
                    String ans = input.next();
                    if(ans.contains("Integer"))
                    {
                        System.out.println("Calculate the result of 2000 divided by 100");
                        int answer = input.nextInt();
                        int Value = Calculator.divInteger(2000,100);
                        if(Value==answer)
                        {
                            System.out.println("" +
                                    "Correct answer\n" +
                                    "You won a Piano soft toy");
                            Calculator.Cal("Piano");

                        }
                        else
                        {
                            System.out.println("Wrong Entered");
                            System.out.println("You didn't won this time better luck try again");
                        }
                    }
                    else if(ans.contentEquals("Strings"))
                    {
                        System.out.println("Calculate the concatenation of strings abCD and ZxyL");
                        String answer = input.next();
                        String Con = Calculator.Concat("abCD","ZxyL");
                        if(answer.contentEquals(Con))
                        {
                            System.out.println("" +
                                    "Correct answer\n" +
                                    "You won a Piano soft toy");
                            Calculator.Cal("Piano");
                        }
                        else
                        {
                            System.out.println("Wrong Entered");
                            System.out.println("You didn't won this time better luck try again");
                        }
                    }
                    else
                        System.out.println("Wrong entered try again");
                }
                if(hop==6)
                {
                    System.out.println("" +
                            "You won a Tennis Racket soft toy");
                    Calculator.Cal("Tennis Racket");
                }
                if(hop==7)
                {
                    System.out.println("Question answer round. Integer or Strings?");
                    String ans = input.next();
                    if(ans.contentEquals("Integer"))
                    {
                        System.out.println("Calculate the result of 2000 divided by 100");
                        int answer = input.nextInt();
                        int Value = Calculator.divInteger(2000,100);
                        if(Value==answer)
                        {
                            System.out.println("" +
                                    "Correct answer\n" +
                                    "You won a Train soft toy");
                            Calculator.Cal("Train");

                        }
                        else
                        {
                            System.out.println("Wrong Entered");
                            System.out.println("You didn't won this time better luck try again");
                        }
                    }
                    else if(ans.contentEquals("Strings"))
                    {
                        System.out.println("Calculate the concatenation of strings abCD and ZxyL");
                        String answer = input.next();
                        String Con = Calculator.Concat("abCD","ZxyL");
                        if(answer.contentEquals(Con))
                        {
                            System.out.println("" +
                                    "Correct answer\n" +
                                    "You won a Train soft toy");
                            Calculator.Cal("Train");
                        }
                        else
                        {
                            System.out.println("Wrong Entered");
                            System.out.println("You didn't won this time better luck try again");
                        }
                    }
                    else
                        System.out.println("Wrong entered try again");
                }
                if(hop==8)
                {
                    System.out.println("" +
                            "You won a Tennis Racket soft toy");
                    Calculator.Cal("Tennis Racket");
                }
                if(hop==9)
                {
                    System.out.println("Question answer round. Integer or Strings?");
                    String ans = input.next();
                    if(ans.contentEquals("Integer"))
                    {
                        System.out.println("Calculate the result of 2000 divided by 100");
                        int answer = input.nextInt();
                        int Value = Calculator.divInteger(2000,100);
                        if(Value==answer)
                        {
                            System.out.println("" +
                                    "Correct answer\n" +
                                    "You won a Rocking Horse soft toy");
                            Calculator.Cal("Rocking Horse");

                        }
                        else
                        {
                            System.out.println("Wrong Entered");
                            System.out.println("You didn't won this time better luck try again");
                        }
                    }
                    else if(ans.contentEquals("Strings"))
                    {
                        System.out.println("Calculate the concatenation of strings abCD and ZxyL");
                        String answer = input.next();
                        String Con = Calculator.Concat("abCD","ZxyL");
                        if(answer.contentEquals(Con))
                        {
                            System.out.println("" +
                                    "Correct answer\n" +
                                    "You won a Rocking Horse soft toy");
                            Calculator.Cal("Rocking Horse");
                        }
                        else
                        {
                            System.out.println("Wrong Entered");
                            System.out.println("You didn't won this time better luck try again");
                        }
                    }
                    else
                        System.out.println("Wrong entered try again");
                }
                if(hop==10)
                {
                    System.out.println("" +
                            "You won a Mickey Mouse soft toy");
                    Calculator.Cal("Mickey Mouse");
                }
                if(hop==11)
                {
                    System.out.println("Question answer round. Integer or Strings?");
                    String ans = input.next();
                    if(ans.contentEquals("Integer"))
                    {
                        System.out.println("Calculate the result of 2000 divided by 100");
                        int answer = input.nextInt();
                        int Value = Calculator.divInteger(2000,100);
                        if(Value==answer)
                        {
                            System.out.println("" +
                                    "Correct answer\n" +
                                    "You won a Car Horse soft toy");
                            Calculator.Cal("Car");
                        }
                        else
                        {
                            System.out.println("Wrong Entered");
                            System.out.println("You didn't won this time better luck try again");
                        }
                    }
                    else if(ans.contentEquals("Strings"))
                    {
                        System.out.println("Calculate the concatenation of strings abCD and ZxyL");
                        String answer = input.next();
                        String Con = Calculator.Concat("abCD","ZxyL");
                        if(answer.contentEquals(Con))
                        {
                            System.out.println("" +
                                    "Correct answer\n" +
                                    "You won a Car Horse soft toy");
                            Calculator.Cal("Car");
                        }
                        else
                        {
                            System.out.println("Wrong Entered");
                            System.out.println("You didn't won this time better luck try again");
                        }
                    }
                    else
                        System.out.println("Wrong entered try again");
                }
                if(hop==12)
                {
                    System.out.println("" +
                            "You won a Teddy Bear soft toy");
                    Calculator.Cal("Teddy Bear");
                }
                if(hop==13)
                {
                    System.out.println("Question answer round. Integer or Strings?");
                    String ans = input.next();
                    if(ans.contentEquals("Integer"))
                    {
                        System.out.println("Calculate the result of 2000 divided by 100");
                        int answer = input.nextInt();
                        int Value = Calculator.divInteger(2000,100);
                        if(Value==answer)
                        {
                            System.out.println("" +
                                    "Correct answer\n" +
                                    "You won a Doll soft toy");
                            Calculator.Cal("Doll");
                        }
                        else
                        {
                            System.out.println("Wrong Entered");
                            System.out.println("You didn't won this time better luck try again");
                        }
                    }
                    else if(ans.contentEquals("Strings"))
                    {
                        System.out.println("Calculate the concatenation of strings abCD and ZxyL");
                        String answer = input.next();
                        String Con = Calculator.Concat("abCD","ZxyL");
                        if(answer.contentEquals(Con))
                        {
                            System.out.println("" +
                                    "Correct answer\n" +
                                    "You won a Doll soft toy");
                            Calculator.Cal("Doll");
                        }
                        else
                        {
                            System.out.println("Wrong Entered");
                            System.out.println("You didn't won this time better luck try again");
                        }
                    }
                    else
                        System.out.println("Wrong entered try again");
                }
                if(hop==14)
                {
                    System.out.println("" +
                            "You won a Boll soft toy");
                    Calculator.Cal("Boll");
                }
                if(hop==15)
                {
                    System.out.println("Question answer round. Integer or Strings?");
                    String ans = input.next();
                    if(ans.contentEquals("Integer"))
                    {
                        System.out.println("Calculate the result of 2000 divided by 100");
                        int answer = input.nextInt();
                        int Value = Calculator.divInteger(2000,100);
                        if(Value==answer)
                        {
                            System.out.println("" +
                                    "Correct answer\n" +
                                    "You won a Bycicle soft toy");
                            Calculator.Cal("Bycicle");
                        }
                        else
                        {
                            System.out.println("Wrong Entered");
                            System.out.println("You didn't won this time better luck try again");
                        }
                    }
                    else if(ans.contentEquals("Strings"))
                    {
                        System.out.println("Calculate the concatenation of strings abCD and ZxyL");
                        String answer = input.next();
                        String Con = Calculator.Concat("abCD","ZxyL");
                        if(answer.contentEquals(Con))
                        {
                            System.out.println("" +
                                    "Correct answer\n" +
                                    "You won a Doll soft toy");
                            Calculator.Cal("Doll");
                        }
                        else
                        {
                            System.out.println("Wrong Entered");
                            System.out.println("You didn't won this time better luck try again");
                        }
                    }
                    else
                        System.out.println("Wrong entered try again");
                }
                if(hop==16)
                {
                    System.out.println("" +
                            "You won a Shark soft toy");
                    Calculator.Cal("Shark");
                }
                if(hop==17)
                {
                    System.out.println("Question answer round. Integer or Strings?");
                    String ans = input.next();
                    if(ans.contentEquals("Integer"))
                    {
                        System.out.println("Calculate the result of 2000 divided by 100");
                        int answer = input.nextInt();
                        int Value = Calculator.divInteger(2000,100);
                        if(Value==answer)
                        {
                            System.out.println("" +
                                    "Correct answer\n" +
                                    "You won a Turtle soft toy");
                            Calculator.Cal("Turtle");
                        }
                        else
                        {
                            System.out.println("Wrong Entered");
                            System.out.println("You didn't won this time better luck try again");
                        }
                    }
                    else if(ans.contentEquals("Strings"))
                    {
                        System.out.println("Calculate the concatenation of strings abCD and ZxyL");
                        String answer = input.next();
                        String Con = Calculator.Concat("abCD","ZxyL");
                        if(answer.contentEquals(Con))
                        {
                            System.out.println("" +
                                    "Correct answer\n" +
                                    "You won a Turtle soft toy");
                            String store = "Turtle";
                            Calculator.Cal("Turtle");
                        }
                        else
                        {
                            System.out.println("Wrong Entered");
                            System.out.println("You didn't won this time better luck try again");
                        }
                    }
                    else
                        System.out.println("Wrong entered try again");
                }
                if(hop==18)
                {
                    System.out.println("" +
                            "You won a Crab soft toy");
                    Calculator.Cal("Crab");
                }
                if(hop==19)
                {
                    System.out.println("Question answer round. Integer or Strings?");
                    String ans = input.next();
                    if(ans.contentEquals("Integer"))
                    {
                        System.out.println("Calculate the result of 2000 divided by 100");
                        int answer = input.nextInt();
                        int Value = Calculator.divInteger(2000,100);
                        if(Value==answer)
                        {
                            System.out.println("" +
                                    "Correct answer\n" +
                                    "You won Drum soft toy");
                            Calculator.Cal("Drum");
                        }
                        else
                        {
                            System.out.println("Wrong Entered");
                            System.out.println("You didn't won this time better luck try again");
                        }
                    }
                    else if(ans.contentEquals("Strings"))
                    {
                        System.out.println("Calculate the concatenation of strings abCD and ZxyL");
                        String answer = input.next();
                        String Con = Calculator.Concat("abCD","ZxyL");
                        if(answer.contentEquals(Con))
                        {
                            System.out.println("" +
                                    "Correct answer\n" +
                                    "You won Drum soft toy");
                            Calculator.Cal("Drum");
                        }
                        else
                        {
                            System.out.println("Wrong Entered");
                            System.out.println("You didn't won this time better luck try again");
                        }
                    }
                    else
                        System.out.println("Wrong entered try again");
                }
                if (hop==20)
                {
                    System.out.println("" +
                            "You won a Zebra soft toy");
                    Calculator.Cal("Zebra");
                }
            }
            catch (Exception e){}
            i++;
        }


    }
}
