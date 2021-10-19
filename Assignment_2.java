import java.util.*;
interface Material
{
    public void add_slides(String id);
    public void add_video(String id);
}
interface  assessments
{
    public void  Add_Assignment(String id);
    public void  Add_Quiz(String id);
}
class INSTRUCTOR  implements Material,assessments
{
    Scanner input = new Scanner(System.in);
static HashSet<String> Instructor_Id= new HashSet<>();
static HashMap<String, ArrayList<String>> Slides = new HashMap<>();
static HashMap<String, ArrayList<String>> Video = new HashMap<>();
static HashMap<String, ArrayList<String>> Assignment = new HashMap<>();
static HashMap<String, ArrayList<Integer>> Assignment_Marks = new HashMap<>();
static HashMap<String, ArrayList<String>> Quiz = new HashMap<>();
static HashMap<String,String> DateOFUpload  = new HashMap<>();
static HashMap<String,Integer> Grade = new HashMap<>();
static HashMap<String,String> Topic = new HashMap<>();
    @Override
    public void add_slides(String id) {
        System.out.println("Enter the topic of slides\n");
        ArrayList<String> l = new ArrayList<>();
        String topic = input.next();
        l.add(topic);
        System.out.println("Enter number of slides:\n");
        int slides = input.nextInt();
        String[] sli = new String[slides];

        Date cur = new Date();
        for(int i=0,j=1;i<slides || j<=slides;i++,j++){
            System.out.println("Enter content of slides\n");
            System.out.println("Content of slides\n"+ j);
            sli[i] = input.next();
            l.add(sli[i]);
        }
        l.add(""+cur+ "\n" + "Uploaded By " + id);
        Slides.put(id,l);
        DateOFUpload.put(id,"And" +"\n" + "Date of upload:" + cur);
    }

    @Override
    public void add_video(String id) {
        System.out.println("Enter topic of video:\n");
        String topic = input.next();
        ArrayList<String> l = new ArrayList<>();
        l.add("Title of the Video " +topic);
        System.out.println("Enter filename of video: \n");
        String name = input.next();
        Date curr =new Date();
        String check= name.substring(name.length()-4,name.length());
        if(check.contentEquals(".mp4")){
            l.add("Video file  " + " " +name + "\n" + " Date of upload: " + curr + "\n" + " Uploaded by " + id);
        Video.put(id,l);
        }
        else
            System.out.println("Wrong extension entered");

    }

    @Override
    public void Add_Assignment(String id) {
        System.out.println("Enter problem statement:\n");
        String aases = input.nextLine();
        aases = input.nextLine();
        System.out.println("Enter max marks:\n");
        int max_marks = input.nextInt();
        ArrayList<String> l = new ArrayList<>();
        l.add("Assignment:" + aases);
        ArrayList<Integer> mar = new ArrayList<>();
        mar.add(max_marks);
        Assignment.put(id,l);
        Assignment_Marks.put(id,mar);
    }

    @Override
    public void Add_Quiz(String id) {
        System.out.println("Enter quiz question\n");
        String ques = input.nextLine();
        ques = input.nextLine();
        ArrayList<String> l = new ArrayList<>();
        l.add("Question: "+ques);
        Quiz.put(id,l);
    }

    public void Add_Class_Material(String Id)
    {
Instructor_Id.add(Id);
boolean terminate = true;
        while (terminate)
        {
            System.out.println("Welcome\n"+ Id +
                    "{INSTRUCTOR MENU}\n" +
                    "1. Add Lecture Slide\n" +
                    "2. Add Lecture Video\n" +
                    "3. Do you want to go back\n");
            int choices = input.nextInt();
            switch (choices)
            {
                case 1:
                    add_slides(Id);
                    break;
                case 2:
                    add_video(Id);
                    break;
                case 3:
                    terminate= false;
                  break;
                default:
                    System.out.println("InValid Option");
            }
            if(!terminate)
                continue;
        }
    }
    public void Add_class_Assesment(String id)
    {
        Instructor_Id.add(id);
        boolean terminate = true;
        while (terminate)
        {
            System.out.println("Welcome\n"+ id +
                    "{INSTRUCTOR MENU}\n" +
                    "1. Add  Assignment\n" +
                    "2. Add Quiz\n" +
                    "3. Do you want to go back\n");
            int choices = input.nextInt();
            switch (choices)
            {
                case 1:
                    Add_Assignment(id);
                    break;
                case 2:
                    Add_Quiz(id);
                    break;
                case 3:
                    terminate= false;
                    break;
                default:
                    System.out.println("InValid Option");
            }
            if(!terminate)
                continue;
        }
    }
    public void View_Assesment(String id)
    {

        for(int i=0,j=0,k=0;i<Assignment.get(id).size() || j<Assignment_Marks.get(id).size()||k<Quiz.get(id).size();i++,j++,k++)
        {
            int g =1;
            System.out.println("ID: "+ g + Assignment.get(id).get(i) + " Max Marks : " + Assignment_Marks.get(id).get(j));
            System.out.println("----------------");
            g++;
            System.out.println(" ID " + g + Quiz.get(id).get(k));
            System.out.println("----------------");
        }

    }
    public void View_Lecture_Material(String id) {
        boolean terminate = true;
        while (terminate) {
            System.out.println("Which you want to view");
            System.out.println("1. Slides");
            System.out.println("2. Video");
            System.out.println("3. Go back");
            int choices = input.nextInt();
            switch (choices){
                case 1:
                        for (int i = 0; i < Slides.get(id).size(); i++) {
                        System.out.println(Slides.get(id).get(i));
                        }
                break;
                case 2:
                        for (int j = 0; j < Video.get(id).size(); j++) {
                            System.out.println(Video.get(id).get(j));
                        }
                break;
                case 3:
                    terminate= false;
                    break;
                default:
                    System.out.println("Invalid Options");
        }
    }

    }
    public void Grade_Assesment(String id)
    {

    }
}

class Students extends INSTRUCTOR
{
static HashMap<String,ArrayList<String>> Submit_Assignment = new HashMap<>();
static HashMap<String,String> Grade_Assignment = new HashMap<>();
static HashMap<String,String> Comment_Teacher = new HashMap<>();
static HashMap<String,String> Comment_Student = new HashMap<>();
    public void View_Lecture_and_Material()
    {
        for(int i=0,j=0;i< Assignment.size()|| j<Quiz.size();i++,j++)
        {
            System.out.println(Assignment.values() + " " + Quiz.values());
        }
    }
    public void View_assessments()
    {
        for(int i=0,j=0;i< Slides.size()|| j<Video.size();i++,j++)
        {
            System.out.println(Slides.values() + " "+ Video.values());
        }
    }
    public void Submit_Assesments(String id)
    {
        System.out.println("Enter which Instructor assignment");
        System.out.println("Write Instructor I0 or I1");
        String choose = input.next();
        int i=0,j=0;
        for(Map.Entry<String,ArrayList<String>> search : Assignment.entrySet())
        {
            for(Map.Entry<String,ArrayList<Integer>> get : Assignment_Marks.entrySet())
             {
                 for(Map.Entry<String,ArrayList<String>> ques: Quiz.entrySet())
                 {
                     if(search.getKey().contains(choose) && get.getKey().contains(choose) && ques.getKey().contains(choose))
                     {
                         System.out.println(" ID " + i + " Assignment " + search.getValue().get(j) + " Max Marks: " + get.getValue().get(j));
                         i++;
                         System.out.println(" ID " + i + " Question: " + ques.getValue().get(j));
                         i++;
                         j++;
                     }
else
                         System.out.println("Wrong Id entered");
                 }
             }
        }

        System.out.println("Enter filename of assignment:");
        String filename = input.next();
        String file = filename.substring(filename.length()-4,filename.length());
        if(file.contentEquals(".zip"))
        {
            ArrayList<String> l = new ArrayList<>();
            l.add(filename);
            Submit_Assignment.put(id,l);
        }
else
            System.out.println("Wrong extension entered");
    }

    @Override
    public void Grade_Assesment(String id) {
        System.out.println("Enter the Students id S0, S1 or S2");
        String stuId = input.next();
        int i =0;
        for(Map.Entry<String,ArrayList<String>> search : Submit_Assignment.entrySet())
        {
            if(search.getKey().contains(stuId))
            {
                int k=1;
                System.out.println("Pending Assignment");
                System.out.println("Here are the assignment "+ k +" " + search.getValue().get(i));
                k++;
                i++;

            }
            int a[] = new int[i];
            System.out.println("Now choose which assignment you want to grade");
            int choose = input.nextInt();
            for(int j =1;j<=a.length;j++)
            {
                if(choose==j)
                {
                    System.out.println("Now How Many Marks You Want to give");
                    int marks = input.nextInt();
                    Grade_Assignment.put(id,id +"Graded Assignment "+ " Marks are :" +marks);
                }
                else
                    System.out.println("Not a valid option");
            }

        }
    }
    //teacher ki id jayegi
    public void View_Grade(String id)
    {
        System.out.println("Enter which Teacher id I0 or I1");
        String idT = input.next();
        if(Grade_Assignment.containsKey(idT))
        {
            for(Map.Entry<String,ArrayList<String>> search : Submit_Assignment.entrySet())
            {int i=0;
                System.out.println(search.getValue().get(i));
                System.out.println(" Graded by " + Grade_Assignment.get(idT));
                i++;
            }
        }
    }
    //student ki id ayegi
    public void  Add_Comment_Teacher(String idT)
    {
        System.out.println("Which Student id S0,S1 or S2");
        String StI =input.next();
        if(Submit_Assignment.containsKey(StI))
        {int j =0;
            for(int i =0;i<Submit_Assignment.values().size();i++)
            {
                System.out.println(i + "Here are the assignmnet " + Submit_Assignment.values());
            j++;
            }
            System.out.println("Now choose which you want to comment");
            int choose = input.nextInt();
            int a[] = new int[j];
            for(int i =0;i<a.length;j++)
            {
                if(j==choose)
                {
                    System.out.println("Now add comment");
                    String comm = input.next();
                    Comment_Teacher.put(idT,Submit_Assignment.get(j)+" "+comm);
                }
            }
        }
    }
    public void View_Comment_teacher(String id)
    {

        if(Comment_Teacher.containsKey(id))
        {int j =0;
            for(int i =0;i<Submit_Assignment.values().size();i++)
            {
                System.out.println(i + "Here are the assignment " + Submit_Assignment.values());
                j++;
            }
            System.out.println("Which comment you want to see");
            int choose = input.nextInt();
            int a[] = new int[j];
            for(int i =0;i<a.length;j++)
            {
                if(j==choose)
                {
                    System.out.println(Comment_Teacher.get(j) +" "+ Comment_Teacher.values());
                }
            }
        }
    }
    public void  Add_Comment_Student(String idT,String StI)
    {
        if(Submit_Assignment.containsKey(StI))
        {int j =0;
            for(int i =0;i<Submit_Assignment.values().size();i++)
            {

                System.out.println(i + "Here are the assignment " + Submit_Assignment.values());
                j++;
            }
            System.out.println("Now choose which you want to comment");
            int choose = input.nextInt();
            int a[] = new int[j];
            for(int i =0;i<a.length;j++)
            {
                if(j==choose)
                {
                    System.out.println("Now add comment");
                    String comm = input.next();
                    Comment_Student.put(idT,Submit_Assignment.get(j)+" "+comm);
                }
            }
        }
    }
    public void View_Comment_student(String idT,String StI)
    {

        if(Submit_Assignment.containsKey(StI))
        {int j =0;
            for(int i =0;i<Submit_Assignment.values().size();i++)
            {
                System.out.println(i + "Here are the assignmnet " + Submit_Assignment.values());
                j++;
            }
            System.out.println("Which comment you want to see");
            int choose = input.nextInt();
            int a[] = new int[j];
            for(int i =0;i<a.length;j++)
            {
                if(j==choose)
                {
                    System.out.println(Comment_Student.get(j) +" "+ Comment_Student.values());
                }
            }
        }
    }
}


public class Assignment_2 {
    public static void main(String[] args) {
        while (true) {
            Scanner input = new Scanner(System.in);
            INSTRUCTOR Put = new INSTRUCTOR();
            Students Get = new Students();
            System.out.println("Welcome to Backpack\n" +
                    "1. Enter as instructor\n" +
                    "2. Enter as student\n" +
                    "3. Exit");
            int choices = input.nextInt();
            switch (choices) {
                case 1:
                    boolean termiNATE = true;
                    while (termiNATE) {
                        System.out.println("Instructors:\n" +
                                "0 - I0\n" +
                                "1 - I1\n" +
                                "2. Go to main menu");
                        int choose = input.nextInt();

                        switch (choose) {
                            case 0:
                                boolean ter = true;
                                while (ter) {
                                    System.out.println("What you want to do");
                                    System.out.println(
                                            "1. Add class material\n" +
                                                    "2. Add assessments\n" +
                                                    "3. View lecture materials\n" +
                                                    "4. View assessments\n" +
                                                    "5. Grade assessments\n" +
                                                    "6. Close assessment\n" +
                                                    "7. View comments\n" +
                                                    "8. Add comments\n" +
                                                    "9. Logout");
                                    int choice = input.nextInt();
                                    switch (choice) {
                                        case 1:
                                            Put.Add_Class_Material("I0");
                                            break;
                                        case 2:
                                            Put.Add_class_Assesment("I0");
                                            break;
                                        case 3:
                                            Put.View_Lecture_Material("I0");
                                            break;
                                        case 4:
                                            Put.View_Assesment("I0");
                                            break;
                                        case 5:
                                            Get.Grade_Assesment("I0");
                                            break;
                                        case 6:
                                            System.exit(0);
                                        case 7:
                                            Get.View_Comment_teacher("I0");
                                            break;
                                        case 8:
                                            Get.Add_Comment_Teacher("I0");
                                            break;
                                        case 9:
                                            ter = false;
                                            break;
                                        default:
                                            System.out.println("Invalid Input");

                                    }
                                }
                                break;
                            case 1:
                                boolean term = true;
                                while (term) {
                                    System.out.println("What you want to do");
                                    System.out.println(
                                            "1. Add class material\n" +
                                                    "2. Add assessments\n" +
                                                    "3. View lecture materials\n" +
                                                    "4. View assessments\n" +
                                                    "5. Grade assessments\n" +
                                                    "6. Close assessment\n" +
                                                    "7. View comments\n" +
                                                    "8. Add comments\n" +
                                                    "9. Logout");
                                    int choice = input.nextInt();
                                    switch (choice) {
                                        case 1:
                                            Put.Add_Class_Material("I1");
                                            break;
                                        case 2:
                                            Put.Add_class_Assesment("I1");
                                            break;
                                        case 3:
                                            Put.View_Lecture_Material("I1");
                                            break;
                                        case 4:
                                            Put.View_Assesment("I1");
                                            break;
                                        case 5:
                                            Get.Grade_Assesment("I1");
                                            break;
                                        case 6:
                                            System.exit(0);
                                        case 7:
                                            Get.View_Comment_teacher("I1");
                                            break;
                                        case 8:
                                            Get.Add_Comment_Teacher("I0");
                                            break;
                                        case 9:
                                            term = false;
                                            break;
                                        default:
                                            System.out.println("Invalid Input");

                                    }
                                }
                                break;
                            case 2:
                                termiNATE = false;
                                break;

                            default:
                                System.out.println("Invalid Options");

                        }

                    }
                    if(!termiNATE)
                        continue;
                case 2:
                    boolean Ter = true;
                    while (Ter){
                        System.out.println(
                                "Students:\n" +
                                        "0 - S0\n" +
                                        "1 - S1\n" +
                                        "2 - S2\n" +
                                        "3. Go Back\n" +
                                        "4. Exit ");

                    int StudChoose = input.nextInt();
                    switch (StudChoose) {
                        case 0:
                            boolean loopterMinate = true;
                            while (loopterMinate) {
                                System.out.println("" +
                                        "1. View lecture materials\n" +
                                        "2. View assessments\n" +
                                        "3. Submit assessment\n" +
                                        "4. View grades\n" +
                                        "5. View comments\n" +
                                        "6. Add comments\n" +
                                        "7. Logout");
                                int chose = input.nextInt();
                                switch (chose) {
                                    case 1:
                                        System.out.println("Which Teacher I0 or I1");
                                        String Teach = input.next();
                                        Put.View_Lecture_Material(Teach);
                                        break;
                                    case 2:
                                        System.out.println("Which Teacher I0 or I1");
                                        String Teac = input.next();
                                        Put.View_Assesment(Teac);
                                        break;
                                    case 3:
                                        Get.Submit_Assesments("S0");
                                        break;
                                    case 4:
                                        Get.View_Grade("S1");
                                        break;
                                    case 5:
                                        System.out.println("which teacher I0 or I1");
                                        String cho = input.next();
                                        Get.View_Comment_student(cho, "S0");
                                        break;
                                    case 6:
                                        System.out.println("which teacher I0 or I1");
                                        String ch = input.next();
                                        Get.Add_Comment_Student(ch, "S0");
                                        break;
                                    case 7:
                                        loopterMinate = false;
                                        break;
                                    default:
                                        System.out.println("Invalid Option");
                                }
                            }
                            break;
                        case 1:
                            boolean loop = true;
                            while (loop) {
                                System.out.println("" +
                                        "1. View lecture materials\n" +
                                        "2. View assessments\n" +
                                        "3. Submit assessment\n" +
                                        "4. View grades\n" +
                                        "5. View comments\n" +
                                        "6. Add comments\n" +
                                        "7. Logout");
                                int chose = input.nextInt();
                                switch (chose) {
                                    case 1:
                                        System.out.println("Which Teacher I0 or I1");
                                        String Teach = input.next();
                                        Put.View_Lecture_Material(Teach);
                                        break;
                                    case 2:
                                        System.out.println("Which Teacher I0 or I1");
                                        String Teac = input.next();
                                        Put.View_Assesment(Teac);
                                        break;
                                    case 3:
                                        Get.Submit_Assesments("S1");
                                        break;
                                    case 4:
                                        Get.View_Grade("S1");
                                        break;
                                    case 5:
                                        System.out.println("which teacher I0 or I1");
                                        String cho = input.next();
                                        Get.View_Comment_student(cho, "S1");
                                        break;
                                    case 6:
                                        System.out.println("which teacher I0 or I1");
                                        String ch = input.next();
                                        Get.Add_Comment_Student(ch, "S1");
                                        break;
                                    case 7:
                                        loop = false;
                                        break;
                                    default:
                                        System.out.println("Invalid Option");

                                }

                            }
                            break;
                        case 2:
                            boolean loop_ter = true;
                            while (loop_ter) {
                                System.out.println("" +
                                        "1. View lecture materials\n" +
                                        "2. View assessments\n" +
                                        "3. Submit assessment\n" +
                                        "4. View grades\n" +
                                        "5. View comments\n" +
                                        "6. Add comments\n" +
                                        "7. Logout");
                                int chose = input.nextInt();
                                switch (chose) {
                                    case 1:
                                        System.out.println("Which Teacher I0 or I1");
                                        String Teach = input.next();
                                        Put.View_Lecture_Material(Teach);
                                        break;
                                    case 2:
                                        System.out.println("Which Teacher I0 or I1");
                                        String Teac = input.next();
                                        Put.View_Assesment(Teac);
                                        break;
                                    case 3:
                                        Get.Submit_Assesments("S2");
                                        break;
                                    case 4:
                                        Get.View_Grade("S2");
                                        break;
                                    case 5:
                                        System.out.println("which teacher I0 or I1");
                                        String cho = input.next();
                                        Get.View_Comment_student(cho, "S2");
                                        break;
                                    case 6:
                                        System.out.println("which teacher I0 or I1");
                                        String ch = input.next();
                                        Get.Add_Comment_Student(ch, "S2");
                                        break;
                                    case 7:
                                        loop_ter = false;
                                        break;
                                    default:
                                        System.out.println("Invalid option");

                                }

                            }
                            break;
                        case 3:
                            Ter = false;
                            break;
                        case 4:
                            System.exit(0);
                        default:
                            System.out.println("Invalid Option");
                    }

                    }

                    if(!Ter)
                        continue;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid Option");
            }

        }
    }
}