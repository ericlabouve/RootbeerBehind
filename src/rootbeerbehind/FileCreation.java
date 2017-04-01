package rootbeerbehind;

/**
 * @author lenoyavidan
 * @author ericlabouve
 */
private String name; // name of the person
private String gender; // gender of the person

/*
 * Class to create files based on the answers to the users questions
 */
public class FileCreation {

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

    /*
     * Method to set the gender of the person
     */
    protected void setGender(String gender) {
        this.gender = gender;
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
            adjective = "Gay";
        }
        else if (gender.toLowerCase().equals("female")) {
            adjective = "Slutty";
        }
        else {
            adjective = "Annoying";
        }
        for (int i=0; i < numFiles; i++) {
            filename = name + "Super" + adjective + (i+1) + ".txt";
            PrintWriter printWriter = new PrintWriter(filename, "UTF-8");
            for (int i=0; i < 1000; i++) {
                printWriter.println(name + " is SUPER " + adjective);
            }
        }
    }
}