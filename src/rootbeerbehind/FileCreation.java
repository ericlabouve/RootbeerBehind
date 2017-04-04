package rootbeerbehind;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author lenoyavidan
 * @author ericlabouve
 */
/*
 * Class to create files based on the answers to the users questions
 */
public class FileCreation implements Runnable {

    private String name; // name of the person
    private String gender; // gender of the person
    /*
     * Defualt constructor
     */
    public FileCreation() {
        name = "";
        gender = "";
    }

    /*
     * Constructor for Strings name and gender
     * Parameters:
     * String name
     * String gender
     */
    public FileCreation(String name, String gender) {
        this.name = name;
        this.name = name;
    }

    /*
     * Method to set the name of the person
     */
    protected void setName(String name) {
        this.name = name;
    }
    
    protected String getName() {
        return name;
    }

    /*
     * Method to set the gender of the person
     */
    protected void setGender(String gender) {
        this.gender = gender;
    }
    
    protected String getGender() {
        return gender;
    }

    /*
     * Method to create files with 1000 lines on the User's computer
     * Paramters:
     * int numFiles: the number of files to create
     */
    protected void CreateFiles(int numFiles) {
        String adjective = "";
        String filename = "";
        if (gender.toLowerCase().equals("male")) {
            adjective = "Gayest";
        }
        else if (gender.toLowerCase().equals("female")) {
            adjective = "Dumbest";
        }
        else {
            adjective = "Most Annoying";
        }
        for (int i=0; i < numFiles; i++) {
            filename = name.replaceAll(" ", "") + "IsSuperGay" + (i+1) + ".txt";
            File file;
            PrintWriter printWriter;
            try {
                file = new File("../Desktop/" + filename);
                printWriter = new PrintWriter(file);
            } catch (Exception ex) {
                //Logger.getLogger(FileCreation.class.getName()).log(Level.SEVERE, null, ex);
                try {
                    file = new File(filename);
                    printWriter = new PrintWriter(file);
                } catch (Exception ex2) {
                    Logger.getLogger(FileCreation.class.getName()).log(Level.SEVERE, null, ex2);
                    return;
                }
            }
            
            for (int j=0; j < 10000; j++) {
                printWriter.println(name + " is the " + adjective);
            }
            
            System.out.println("DONE");
            printWriter.close();
        }
    }

    /*
    @Override
    public void execute() {
        System.out.println("EXECUTE");
        CreateFiles(10000);
    }
    */

    @Override
    public void run() {
        System.out.println("EXECUTE");
        CreateFiles(10);
        JOptionPane.showMessageDialog(null, "ERROR: Virus Detected\n" + 
                                            "Recommended course of action: Go Fuck Yourself");
        System.exit(0);
    }
}