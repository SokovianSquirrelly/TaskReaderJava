import java.util.Scanner;

/******************************************************************************
 * Class: Main
 * Purpose: This is the driving class of the whole program.
 *****************************************************************************/

public class Main {

    /**************************************************************************
     * Method: HandleData()
     * Purpose: This handles the data taken from Main() in order to read and
     *  write files.
     *************************************************************************/

    public static void HandleData(TaskList taskList, String filename,
        Scanner scanner) {
        int choice = 3;

        while (choice != 0) {
            System.out.println();
            System.out.println("Here are some options.");
            System.out.println("1 - Display tasks");
            System.out.println("2 - Add Task");
            System.out.println("3 - Remove Task");
            System.out.println("0 - Save and return to Main Menu");
            System.out.print("What would you like to do with " + filename);
            System.out.print("?\n");
            System.out.print(">> ");
            try
            {
                choice = Integer.parseInt(scanner.nextLine());
            }
            catch (Exception e)
            {
                choice = 4;
            }

            switch (choice) {
                case 0:
                    FileReader file = new FileReader(filename);
                    file.SaveFile(taskList);
                    break;

                case 1:
                    taskList.DisplayTasks();
                    break;

                case 2:
                    taskList.AddTask();
                    break;

                case 3:
                    taskList.RemoveTask();
                    break;

                default:
                    System.out.println("That isn't a valid response.");
                    break;
            }
        }
    }

    /**************************************************************************
     * Method: Main()
     * Purpose: This is the entry point of the program and the driving force
     *  behind everything.
     *************************************************************************/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Task Reader!");
        System.out.println();

        int response = 4;

        while (response != 0) {
            System.out.println("Here are your options...");
            System.out.println("1 - Load a task list");
            System.out.println("2 - Create a new task list");
            System.out.println("3 - Delete a file");
            System.out.println("0 - Quit");
            System.out.print(">> ");
            try
            {
                response = Integer.parseInt(scanner.nextLine());
            }
            catch (Exception e)
            {
                response = 4;
            }


            switch (response) {
                case 0:
                    System.out.print("Thank you!  Have a good day!");
                    break;

                case 1:
                    System.out.print("What is the file you want to use? ");
                    String loadFilename = scanner.nextLine();

                    FileReader loadedFile = new FileReader(loadFilename);
                    TaskList loadTaskList = loadedFile.LoadFile();
                    if (loadTaskList != null)
                    {
                        HandleData(loadTaskList, loadFilename, scanner);
                    }

                    break;

                case 2:
                    System.out.print("What do you want to name your new ");
                    System.out.print("file? ");
                    String newFilename = scanner.nextLine();

                    FileReader newFileCheck = new FileReader(newFilename);
                    if (newFileCheck.Exists())
                    {
                        System.out.println("That file already exists.");
                    }
                    else
                    {
                        TaskList newTaskList = new TaskList();
                        HandleData(newTaskList, newFilename, scanner);
                    }

                    break;

                case 3:
                    System.out.print("Please enter the file you'd like to ");
                    System.out.print("delete: ");
                    String delFilename = scanner.nextLine();

                    FileReader deadFile = new FileReader(delFilename);
                    deadFile.DeleteFile();

                    break;

                default:
                    System.out.println("That isn't a valid response.");
                    break;
            }

            System.out.println();
        }
        scanner.close();
    }
}