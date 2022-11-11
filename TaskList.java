import java.util.ArrayList;
import java.util.Scanner;

/******************************************************************************
 * Class: TaskList
 * Purpose: Contains the whole to-do list and handles adding, deleting,
 *  sorting, and displaying the tasks.
 *****************************************************************************/

public class TaskList
{
    ArrayList<Task> tasks = new ArrayList<Task>();
    Scanner scan = new Scanner(System.in);

    /**************************************************************************
     * Method: AddTask()
     * Purpose: Goes through the user input on creating a new task to put in
     *  the list.
     *************************************************************************/

    public void AddTask()
    {
        System.out.println();
        System.out.print("Please enter a task: ");
        String taskName = scan.nextLine();
        System.out.println();
        int priority = 4;

        System.out.println("0 - No Priority");
        System.out.println("1 - Low Priority");
        System.out.println("2 - Medium Priority");
        System.out.println("3 - High Priority");
        System.out.print("Please enter a priority number: ");
        try
        {
            priority = Integer.parseInt(scan.nextLine());
        }
        catch (Exception c)
        {
            priority = 4;
        }
        
        if (priority < 0 || priority > 3)
        {
            System.out.println("Invalid input.");
        }

        else
        {
            Task task = new Task(taskName, priority);
            tasks.add(task);
        }
    }

    /**************************************************************************
     * Method: SortTasks()
     * Purpose: Sorts the tasks in the task list based on their priority
     *  numbers.  Highest priority tasks will be at the top of the list while
     *  lowest priority will be at the bottom.
     *************************************************************************/

    public void SortTasks()
    {
        ArrayList<Task> newList = new ArrayList<Task>();
        for (Task task : tasks)
        {
            if (task.priority == 3)
            {
                newList.add(task);
            }
        }

        for (Task task : tasks)
        {
            if (task.priority == 2)
            {
                newList.add(task);
            }
        }

        for (Task task : tasks)
        {
            if (task.priority == 1)
            {
                newList.add(task);
            }
        }

        for (Task task : tasks)
        {
            if (task.priority == 0)
            {
                newList.add(task);
            }
        }

        tasks = newList;
    }

    /**************************************************************************
     * Method: RemoveTask()
     * Purpose: Displays the list, and lets the user pick which task they want
     *  to remove.
     *************************************************************************/

    public void RemoveTask()
    {
        if (tasks.size() == 0)
        {
            System.out.print("Your task list is empty.  Try adding some ");
            System.out.print("tasks.\n");
        }
        else
        {
            DisplayTasks();
            System.out.println("Which task number would you like to remove? ");
            try
            {
                int taskToDelete = Integer.parseInt(scan.nextLine());
                tasks.remove(taskToDelete - 1);
                System.out.println("Task successfully deleted.");
            }
            catch(Exception e)
            {
                System.out.println("Invalid input");
            }
        }
    }

    /**************************************************************************
     * Method: DisplayTasks()
     * Purpose: Sorts the tasks, and then displays them in descending order
     *  according to their priority.
     *************************************************************************/

    public void DisplayTasks()
    {
        if (tasks.size() == 0)
        {
            System.out.print("Your task list is empty.  Try adding some ");
            System.out.print("tasks.\n");
        }

        else
        {
            SortTasks();
            System.out.println("Here are your current tasks: ");

            for (int i = 0; i < tasks.size(); i++)
            {
                tasks.get(i).Display(i + 1);
            }
        }
    }
}
