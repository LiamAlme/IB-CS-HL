import java.awt.*;
import java.io.FileNotFoundException;

public class Main extends Easyapp{
    public static void main(String[] args) {
        new Main();
    }

    Label lTitle = addLabel("Bank Manager", 20, 30, 290, 60, this);
    Button bFnSearch = addButton("Search by First Name", 20, 100, 220, 60, this);
    Button bLnSearch = addButton("Search by Last Name", 260, 100, 220, 60, this);
    Button bAllNames = addButton("Show All Names", 20, 180, 220, 60, this);
    Button bAddEntry = addButton("Add A Name", 260, 180, 220, 60, this);
    Button bSort = addButton("Sort", 20, 260, 220, 60, this);
    Button bAdmin = addButton("Admin", 260, 260, 220, 60, this);

    public Main()   // Constructor - change window appearance
    {
        setSize(500, 500);
        setTitle("Bank Manager");
        setBackground(new Color(190, 190, 190));
        lTitle.setFont(new Font("Arial", Font.PLAIN, 36));
        lTitle.setBackground(new Color(190, 190, 190));
    }

    public void actions(Object source, String command) throws FileNotFoundException {
        if (source == bFnSearch) {


        }
        if (source == bLnSearch) {

        }
        if (source == bAllNames) {

        }
        if (source == bAddEntry) {

        }
        if (source == bSort) {

        }
        if (source == bAdmin) {
            adminWindow();
        }
    }


}