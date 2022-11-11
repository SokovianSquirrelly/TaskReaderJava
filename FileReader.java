import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;

/******************************************************************************
 * Class: FileReader
 * Purpose: Handles all of the file work, such as saving, loading, and deleting
 *  files.
 *****************************************************************************/

public class FileReader
{
    String filename;

    /**************************************************************************
     * Method: FileReader()
     * Purpose: The constructor for a FileReader object.
     *************************************************************************/

    public FileReader(String filename)
    {
        this.filename = filename;
    }

    /**************************************************************************
     * Method: LoadFile()
     * Purpose: Opens an existing file and puts its contents into a TaskList
     *  object.  If this fails, it returns a null value.
     *************************************************************************/

    public TaskList LoadFile()
    {
        try
        {
            File file = new File(filename);
            TaskList taskList = new TaskList();
            Scanner loadScanner = new Scanner(file);
            ArrayList<String> data = new ArrayList<String>();
            while (loadScanner.hasNextLine())
            {
                String line = loadScanner.nextLine();
                data.add(line);
            }

            for (String line : data)
            {
                String[] dualStrings = line.split("@", 2);

                int prNumber = Integer.parseInt(dualStrings[0]);
                Task task = new Task(dualStrings[1], prNumber);
                taskList.tasks.add(task);
            }
            return taskList;
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Could not open " + filename + ".");
            return null;
        }
    }

    /**************************************************************************
     * Method: SaveFile()
     * Purpose: Puts contents from a TaskList object into a text file.
     *************************************************************************/

    public void SaveFile(TaskList taskList)
    {
        try
        {
            File file = new File(filename);
            if (file.createNewFile())
            {
                System.out.println("Created new file: " + filename);
            }

            FileWriter sav = new FileWriter(filename);

            for (Task task : taskList.tasks)
            {
                sav.write(task.priority + "@" + task.taskName + "\n");
            }
            
            sav.close();
        }
        catch (Exception e)
        {
            System.out.println("An error occured.");
        }
    }

    /**************************************************************************
     * Method: DeleteFile()
     * Purpose: Deletes an existing file.
     *************************************************************************/

    public void DeleteFile()
    {
        File file = new File(filename);
        if (file.delete())
        {
            System.out.println("Successfully deleted " + filename + ".");
        }
        else
        {
            System.out.println("Could not delete " + filename + ".");
        }
    }

    /**************************************************************************
     * Method: Exists()
     * Purpose: Only called if the user tries to create a new file.  This makes
     *  sure that the "new file" doesn't already exist.
     *************************************************************************/

    public boolean Exists()
    {
        File file = new File(filename);
        if (file.exists())
        {
            return true;
        }

        else
        {
            return false;
        }
    }
}