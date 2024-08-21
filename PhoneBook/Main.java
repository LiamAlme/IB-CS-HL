import java.awt.*;
import java.io.*;

class PhoneEntry
{
    String firstName;
    String lastName;
    String phone;   // their phone number

    PhoneEntry( String fn, String ln, String p )
    {
        firstName = fn;
        lastName = ln;
        phone = p;
    }
}

class PhoneBook
{
    PhoneEntry[] phoneBook;    //declare an array


    PhoneBook()   // constructor for the phone book
    {

        phoneBook = new PhoneEntry[50] ;
        phoneBook[0] = new PhoneEntry( "Stew","Pid", "(418)665-1223");
        phoneBook[1] = new PhoneEntry( "Ima","Knob", "(860)399-3044");
        phoneBook[2] = new PhoneEntry("Ug","Lee", "(815)439-9271");
        phoneBook[3] = new PhoneEntry(  "Ali","Katt","(312)223-1937");
        phoneBook[4] = new PhoneEntry(  "Jo","King", "(913)883-2874");
    }

    public PhoneEntry fnSearch( String targetFirstName)
    {
        for (PhoneEntry phoneEntry : phoneBook) {
            if (phoneEntry.firstName.equalsIgnoreCase(targetFirstName))
                return phoneEntry;
        }
        return null;
    }
    public PhoneEntry lnSearch(String targetLastName)
    {
        for (PhoneEntry phoneEntry : phoneBook) {
            if (phoneEntry.lastName.equalsIgnoreCase(targetLastName))
                return phoneEntry;
        }
        return null;
    }
}



//////////////////////////////////////////////////////////////////////////////////

public class Main extends Easyapp {
    public static void main(String[] args) {
        new Main();
    }

        Label lTitle = addLabel("Phone Book", 20, 30, 290, 60, this);
        Button bFnSearch =addButton("Search by First Name",20, 100, 220, 60,this);
        Button bLnSearch =addButton("Search by Last Name",260, 100, 220, 60,this);
        Button bAllNames =addButton("Show All Names",20, 180, 220, 60,this);
        Button bAddEntry =addButton("Add A Name",260, 180, 220, 60,this);
        Button bSort =addButton("Sort",20, 260, 220, 60,this);
        Button bSave =addButton("Save Phonebook",260, 260, 220, 60,this);
        PhoneBook pb = new PhoneBook();
    public Main()   // Constructor - change window appearance
    {
        setSize(500, 500);
        setTitle("Phone Book");
        setBackground(new Color(190, 190, 190));
        lTitle.setFont(new Font("Arial", Font.PLAIN,36));
        lTitle.setBackground(new Color(190, 190, 190));
    }

    public void actions(Object source, String command) throws FileNotFoundException {
        if (source == bFnSearch) {
            FnSearch();
        }
        if (source == bLnSearch) {
            LnSearch();
        }
        if (source == bAllNames) {
            ShowAll();
        }
        if(source == bAddEntry){
            addEntry();
        }
        if(source == bSort){
            sort();
        }
        if(source== bSave){
            saveToFile();
        }
    }

    public void FnSearch(){
        String firstName = inputString("Enter the first name:");
        PhoneEntry entry = pb.fnSearch(firstName);
        if(entry==null){
            output("Not Found");
        }
        else{
            output(entry.firstName + " " + entry.lastName + " " + entry.phone);
        }
    }

    public void LnSearch(){
        String lastName = inputString("Enter the last name:");
        PhoneEntry entry = pb.lnSearch(lastName);
        if(entry==null){
            output("Not Found");
        }
        else {
            output(entry.firstName + " " + entry.lastName + " " + entry.phone);
        }
    }

    public void ShowAll(){
        StringBuilder allNames = new StringBuilder();
        for(int i = 0; i < pb.phoneBook.length; i ++){
            PhoneEntry entry = pb.phoneBook[i];
            if(entry != null){
                allNames.append(entry.firstName).append(" ").append(entry.lastName).append(" ").append(entry.phone).append("\n");
            }
        }
        output(allNames.toString());
    }

    public void addEntry(){
        String firstName = inputString("Enter the first name:");
        String lastName = inputString("Enter the last name:");
        String phoneNumber = inputString("Enter the Phone Number:");
        for(int i = 0; i < pb.phoneBook.length; i ++) {
            if (pb.phoneBook[i] == null) {
                pb.phoneBook[i] = new PhoneEntry(firstName, lastName, phoneNumber);
                break;
            }
        }
    }

    public void sort(){
        for(int j = 0; j < pb.phoneBook.length; j ++){
            for(int i = 0; i < pb.phoneBook.length; i++){
                if(pb.phoneBook[i] != null && pb.phoneBook[i+1] !=null){
                    if(pb.phoneBook[i].lastName.compareTo(pb.phoneBook[i + 1].lastName) > 0){
                        PhoneEntry temp = new PhoneEntry(pb.phoneBook[i+1].firstName,pb.phoneBook[i+1].lastName,pb.phoneBook[i+1].phone);
                        pb.phoneBook[i+1] = pb.phoneBook[i];
                        pb.phoneBook[i] = temp;

                    }
                }
            }
        }
    }
    public void saveToFile() throws FileNotFoundException {
        PrintWriter outputStream = new PrintWriter(new FileOutputStream("out.txt"));
        for(int i = 0; i < pb.phoneBook.length; i ++){
           if(pb.phoneBook[i] != null){
               outputStream.println(pb.phoneBook[i].firstName + " " + pb.phoneBook[i].lastName + " " + pb.phoneBook[i].phone);
           }
        }
        outputStream.close();
    }
}
