/******************************************************************************
 * Class: Task
 * Purpose: Contains a name and priority number of a task that will be part of
 *  the TaskList class.
 *****************************************************************************/

public class Task {
    String taskName;
    int priority;
    String priorityMarker;

    /**************************************************************************
     * Method: Task()
     * Purpose: The constructor for a Task object.
     *************************************************************************/

    public Task(String taskName, int priority) {
        this.taskName = taskName;
        this.priority = priority;

        SetPriorityMarker();
    }

    /**************************************************************************
     * Method: SetPriorityMarker
     * Purpose: Depending on the priority number, a different priority marker
     *  will be displayed on screen when Display() is called.
     *************************************************************************/

    public void SetPriorityMarker() {
        if (priority == 3) {
            priorityMarker = "!!!";
        }

        else if (priority == 2) {
            priorityMarker = "_!!";
        }

        else if (priority == 1) {
            priorityMarker = "__!";
        }

        else {
            priorityMarker = "___";
        }
    }

    /**************************************************************************
     * Method: Display()
     * Purpose: Sets out the format of how to display each Task.
     *************************************************************************/

    public void Display(int listNumber)
    {
        if (listNumber < 10)
        {
            System.out.print(" " + listNumber + ") " + priorityMarker + " ");
            System.out.print(taskName + "\n");
        }
        
        else
        {
            System.out.print(listNumber + ") " + priorityMarker + " " );
            System.out.print(taskName + "\n");
        }

    }
}
