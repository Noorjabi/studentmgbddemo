
import com.decipherzone.studentmgnt.task.TaskSql;
import com.decipherzone.studentmgnt.task.Task;
import java.io.BufferedReader;
import java.io.InputStreamReader;


/*
    main class
*/
public class Mymain {
    /**
     * main method
     * purpose: taking input from the  user for different task such as adding student , update student etc
     *excception may occur due tp invalid input
     */
    public static void main(String args[])//main method
    {

        int option=0;
        int choice=0;


        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        Task task=new Task();
        TaskSql taskSql=new TaskSql();

        do {
            System.out.println("Enter 1:Work on MySql  \n" +
                    "Enter 2:Work on MongoDB\n" +
                    "Enter 3:exit\n");
            System.out.println("Enter your choice:");
            try {
                choice = 0;
                choice = Integer.parseInt(bufferedReader.readLine());//scanner.nextInt();

            } catch (Exception ex) {
                System.out.println("Invalid user input");
                choice = 0;
            }
            if(choice==1)
            {

                do {
                    System.out.println("Enter 1:Add Student \n" +
                            "Enter 2:Display student\n" +
                            "Enter 3:Update Student\n" +
                            "Enter 4:Remove Studentexit\n" +
                            "Enter 5:exit\n");
                    System.out.println("Enter your choice:");
                    try {
                        option = 0;
                        option = Integer.parseInt(bufferedReader.readLine());//scanner.nextInt();

                    } catch (Exception ex) {
                        System.out.println("Invalid user input");
                        option = 0;
                    }

                    if (option == 1) {

                        taskSql.addStudent();

                    } else if (option == 2) {
                        taskSql.display();

                    } else if (option == 3) {
                        taskSql.update();
                    } else if (option == 4) {
                        taskSql.removeStudent();
                    } else if (option == 5) {



                    } else
                        System.out.println("Wrong choice");

                } while (option != 5);
            }
            else if(choice==2)
            {
                do {
                    System.out.println("Enter 1:Add Student \n" +
                            "Enter 2:Display student\n" +
                            "Enter 3:Update Student\n" +
                            "Enter 4:Remove Studentexit\n" +
                            "Enter 5:exit\n");
                    System.out.println("Enter your choice:");
                    try {
                        option = 0;
                        option = Integer.parseInt(bufferedReader.readLine());//scanner.nextInt();

                    } catch (Exception ex) {
                        System.out.println("Invalid user input");
                        option = 0;
                    }

                    if (option == 1) {

                        task.addStudent();

                    } else if (option == 2) {
                        task.display();

                    } else if (option == 3) {
                        task.update();
                    } else if (option == 4) {
                        task.removeStudent();
                    } else if (option == 5) {


                    } else
                        System.out.println("Wrong choice");

                } while (option != 5);
            }
            else if(choice==3)
            {
                System.exit(0);
            }else
                System.out.println("Wrong choice");
        }while (choice != 3);

    }
}
