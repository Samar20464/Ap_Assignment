import java.util.*;

class COVIN {
    Scanner input = new Scanner(System.in);
    private static HashMap<Integer, String> pincode = new HashMap<>();
    private static HashMap<Integer,Integer> pin = new HashMap<>();
    private static HashMap<String, ArrayList<String>> HostpitalVaccine = new HashMap<>();
    private static  HashMap<Integer, ArrayList<String>> HospitalInfo = new HashMap<>();
    private static ArrayList<String> l1 = new ArrayList<>();
    private static HashMap<Integer, Integer> HospitalDay = new HashMap<>();
    private static HashMap<Double,ArrayList<String>> Status = new HashMap<>();
    private static HashMap<Double,Integer> Check= new HashMap<>();
   private static HashSet<Integer> Id = new HashSet<>();
   private static  ArrayList<Integer> Slots = new ArrayList<>();
   private static HashMap<Double,ArrayList<String>> Citizen = new HashMap<>();
   private static int var=0;

    public void Vaccine(String vaccine, int doses, int gap) {
        if ((doses > 0 && doses <= 2) && (gap >= 0 && gap <= 2)) {
            System.out.print("Vaccine Name:" + vaccine + "Number of Doses:" + doses + " Gap Between Doses: " + gap+"\n");

        } else
            System.out.println("Wrong Detail entered try again\n");
    }

    public void Hospital(String name, int Pincode) {
        if (100000 <= Pincode && Pincode <= 999999) {
            pincode.put(110091, 123456 + name);
            pin.put(110091,123456);
            ArrayList<String> vac = new ArrayList<>();
            vac.add("123456 + name");
            vac.add("111111 HealthCenter");
            HostpitalVaccine.put("Covax", vac);
            for (Map.Entry<Integer, Integer> search : pin.entrySet()) {

                if (search.getKey() == Pincode) {
                    System.out.println("Hospital Name:" + name + " PinCode: " + Pincode + " Unique ID " + search.getValue() + "\n");
                    break;
                }
            }
        } else
            System.out.println("Wrong Pincode entered");
    }

    public void Register_Citizen(String name, int age, double UNIQUE_ID) {
        if (age >= 18 && (Math.pow(10, 11) <= UNIQUE_ID && UNIQUE_ID <= Math.pow(10, 12) - 1)) {
            System.out.println("REGISTERED");
            ArrayList<String> n = new ArrayList<>();
            n.add(name);
            Check.put(UNIQUE_ID,var);
            Citizen.put(UNIQUE_ID,n);
        } else
            System.out.println("Not Eligible");
    }

    public void Slots(int ID, int slots, int day, int Quantity) {

        int i =0;
        while (i!=day) {
            Id.add(ID);
            i++;
            System.out.println("Select Vaccine");
            System.out.println("0. Covax");
            System.out.println("1. Covi");
            int vaccine = input.nextInt();
            switch (vaccine) {
                case 0:
                    System.out.println("Slot added by Hospital " + ID + " for Day: " + i + " Available Quantity: " + Quantity + " of Vaccine Covax\n");
                    l1.add(" Day " + i + " Available Qty " + Quantity + " Vaccine: Covax ");
                    HospitalInfo.put(ID, l1);
                    HospitalDay.put(ID, day);
                    Slots.add(i);
                    break;
                case 1:
                    System.out.println("Slot added by Hospital " + ID + " for Day:  " + i + " Available Quantity: " + Quantity + " of Vaccine Covi\n");
                    l1.add(" Day " + i + " Available Qty " + Quantity + " Vaccine: Covi ");
                    HospitalInfo.put(ID, l1);
                    HospitalDay.put(ID, day);
                    Slots.add(i);
                    break;
            }
        }
        System.out.println("---------------------------------");
    }

    public void Book_A_Slot(double UNIQUE_ID) {

        if (Citizen.containsKey(UNIQUE_ID)) {

            if (true) {
                System.out.println("1. Search by area\n" +
                                   "2. Search by Vaccine\n" +
                                   "3. Exit");
                int Choices = input.nextInt();
                switch (Choices) {
                    case 1:
                        System.out.println("Enter Pincode");
                        int pin = input.nextInt();
                        if (100000 <= pin && pin <= 999999) {
                            for (Map.Entry<Integer, String> search : pincode.entrySet()) {

                                if (search.getKey() == pin) {
                                    System.out.println(search.getValue());
                                    break;
                                }
                            }
                        }
                        System.out.println("Enter Hospital Id");
                        int id = input.nextInt();
                        if (100000 <= id && id <= 999999) {
                            for (Map.Entry<Integer, ArrayList<String>> search : HospitalInfo.entrySet()) {

                                if (search.getKey() == id) {

                                    for(int i=0;i<HospitalInfo.get(id).size();i++)
                                    { System.out.println(i + " -> "+ search.getValue().get(i));
                                    }
                                    System.out.println("---------------------------------");
                                    System.out.println("Now choose slot");
                                    int slot = input.nextInt();
                                    for(int i=0;i<HospitalInfo.get(id).size();i++)
                                    {
                                        if(i==slot)
                                        {
                                            if(search.getValue().get(i).contains("Covax")) {
                                                for (Map.Entry<Double, ArrayList<String>>s : Citizen.entrySet()){
                                                    if (Citizen.containsKey(UNIQUE_ID)) {
                                                           var+=1;
                                                           Check.put(UNIQUE_ID,var);
                                                        System.out.println(s.getValue().get(i) + " vaccinated with Covax\n ");
                                                        ArrayList<String> l = new ArrayList<>();
                                                        l.add(    "Vaccine Given: Covax\n" +
                                                                "Number of Doses given:" + var +"\n");
                                                        Status.put(UNIQUE_ID,l);
                                                        break;
                                                    }
                                                        }
                                            }
                                            else if(search.getValue().get(i).contains("Covi"))
                                            {
                                                for (Map.Entry<Double, ArrayList<String>>s : Citizen.entrySet()){
                                                    if (Citizen.containsKey(UNIQUE_ID)) {
                                                        var+=1;
                                                        Check.put(UNIQUE_ID,var);
                                                        System.out.println(s.getValue().get(i) + " vaccinated with Covi\n ");
                                                        ArrayList<String> l = new ArrayList<>();
                                                        l.add(    "Vaccine Given: Covi\n" +
                                                                "Number of Doses given:" + var +"\n");
                                                        Status.put(UNIQUE_ID,l);
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }


                                }
                                else
                                    System.out.println("No slots Available\n");
                            }

                        }
                        break;
                    case 2:
                        System.out.println("Enter the Vaccine Name");
                        String vacc = input.next();
                        for (Map.Entry<String, ArrayList<String>> search : HostpitalVaccine.entrySet()) {

                            if (vacc.equals(search.getKey())) {
                                System.out.println(search.getValue());
                            }
                        }
                        System.out.println("Enter Hospital Id");
                        int ID = input.nextInt();
                        if (100000 <= ID && ID <= 999999) {
                            for (Map.Entry<Integer, ArrayList<String>> search : HospitalInfo.entrySet()) {

                                if (search.getKey() == ID) {

                                    for(int i=0;i<HospitalInfo.get(ID).size();i++)
                                    { System.out.println(i + " -> "+ search.getValue().get(i));
                                    }
                                    System.out.println("---------------------------------");
                                    System.out.println("Now choose slot");
                                    int slot = input.nextInt();
                                    for(int i=0;i<HospitalInfo.get(ID).size();i++)
                                    {
                                        if(i==slot)
                                        {
                                            if(search.getValue().get(i).contains("Covax")) {
                                                for (Map.Entry<Double, ArrayList<String>>s : Citizen.entrySet()){
                                                    if (Citizen.containsKey(UNIQUE_ID)) {
                                                        var+=1;
                                                        Check.put(UNIQUE_ID,var);
                                                        System.out.println(s.getValue().get(i) + " vaccinated with Covax\n ");
                                                        ArrayList<String> l = new ArrayList<>();
                                                        l.add(    "Vaccine Given: Covax\n" +
                                                                "Number of Doses given:" + var +"\n");
                                                        Status.put(UNIQUE_ID,l);
                                                        break;
                                                    }
                                                }
                                            }
                                            else if(search.getValue().get(i).contains("Covi"))
                                            {
                                                for (Map.Entry<Double, ArrayList<String>>s : Citizen.entrySet()){
                                                    if (Citizen.containsKey(UNIQUE_ID)) {
                                                        var+=1;
                                                        Check.put(UNIQUE_ID,var);
                                                        System.out.println(s.getValue().get(i) + " vaccinated with Covi\n ");
                                                        ArrayList<String> l = new ArrayList<>();
                                                        l.add(    "Vaccine Given: Covi\n" +
                                                                "Number of Doses given:" + var +"\n");
                                                        Status.put(UNIQUE_ID,l);
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }


                                }
                                else
                                    System.out.println("No slots Available\n");
                            }

                        }
                        break;
                    case 3:
                        System.exit(0);
                }
            }
        }
else{
            System.out.println("Unique ID entered wrong\n");
            System.out.println("---------------------------------");
    }

    }
    public  void Available_slots(int ID)
    {
        if(Id.contains(ID)) {
        if (100000 <= ID && ID <= 999999) {
            for (Map.Entry<Integer, ArrayList<String>> search : HospitalInfo.entrySet()) {

                if (search.getKey() == ID) {
                    for(int i=0;i<HospitalInfo.get(ID).size();i++)
                    { System.out.println(search.getKey());
                    }
                    System.out.println("---------------------------------");
                }
            }
        }
    }
        else{
            System.out.println("Wrong ID entered");
            System.out.println("---------------------------------");
        }

    }
    public void Status(double ID)
    {
       if( Math.pow(10, 11) <= ID && ID <= Math.pow(10, 12) - 1)
       {
           for (Map.Entry<Double,Integer> search : Check.entrySet()) {

               if (search.getKey() == ID) {
                  if(search.getValue()==0){
                      System.out.println("Not Vaccined");
                      for (Map.Entry<Double,ArrayList<String>> s : Status.entrySet())
                      {
                          if(s.getKey()==ID)
                              System.out.println(s.getValue().get(0)+ "\n");
                          break;
                      }
                      System.out.println("Next Dose due "+ 0);
                  }
                  else if(search.getValue()==1){
                      System.out.println("Partially vaccinaed");
                      for (Map.Entry<Double,ArrayList<String>> s : Status.entrySet())
                      {
                          if(s.getKey()==ID)
                              System.out.println(s.getValue().get(0)+ "\n");
                          break;
                      }
                      System.out.println("Next Dose due "+ 3);
                  }
                  else if(search.getValue()==2){
                      System.out.println("FULLY VACCINATEd\n");
                      for (Map.Entry<Double,ArrayList<String>> s : Status.entrySet())
                      {
                          if(s.getKey()==ID)
                              System.out.println(s.getValue().get(0)+ "\n");
                          break;
                      }
                  }
                  else
                      System.out.println("Your are fully Vaccinated No Need to Take more");
               }
           }
       }
       else
           System.out.println("Wrong id entered");
    }

}

    public class Assignment_1 {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            while (true) {
                System.out.println("CoWin Portal initialized....");
                System.out.println("---------------------------------");
                System.out.print(
                        "1. Add Vaccine\n" +
                                "2. Register Hospital\n" +
                                "3. Register Citizen\n" +
                                "4. Add Slot for Vaccination\n" +
                                "5. Book Slot for Vaccination\n" +
                                "6. List all slots for a hospital\n" +
                                "7. Check Vaccination Status\n" +
                                "8. Exit");
                System.out.println("---------------------------------");
                int choices = input.nextInt();
                COVIN Register = new COVIN();
                switch (choices) {
                    case 1:
                        System.out.println("Vaccine name");
                        String vaccine = input.next();
                        System.out.println("Number of Doses:");
                        int doses = input.nextInt();
                        System.out.println("Gap between Doses:");
                        int gap = input.nextInt();
                        Register.Vaccine(vaccine, doses, gap);
                        break;
                    case 2:
                        System.out.println("Hospital Name");
                        String hos = input.next();
                        System.out.println("Enter the Pincode");
                        int pin = input.nextInt();
                        Register.Hospital(hos, pin);
                        break;
                    case 3:
                        System.out.println("Enter Name");
                        String Name = input.next();
                        System.out.println("Enter age");
                        int age = input.nextInt();
                        System.out.println("Enter Unique ID");
                        double UNIQUE_ID = input.nextDouble();
                        Register.Register_Citizen(Name, age, UNIQUE_ID);
                        break;
                    case 4:
                        System.out.println("Enter Hospital ID: ");
                        int id = input.nextInt();
                        System.out.println("Enter number of Slots to be added: ");
                        int slots = input.nextInt();
                        System.out.println("Enter Day Number:");
                        int day = input.nextInt();
                        System.out.println("Enter Quantity:");
                        int quanti = input.nextInt();
                        Register.Slots(id, slots, day, quanti);
                        break;
                    case 5:
                        System.out.println("Enter UNIQUE ID");
                        double UNI = input.nextDouble();
                        Register.Book_A_Slot(UNI);
                        break;
                    case 6:
                        System.out.println("Enter the ID");
                        int ID = input.nextInt();
                        Register.Available_slots(ID);
                        break;
                    case  7:
                        System.out.println("Enter the Patient ID");
                        Double ID_ = input.nextDouble();
                        Register.Status(ID_);
                        break;
                    case 8:
                        System.exit(0);
                }


            }
        }
    }
