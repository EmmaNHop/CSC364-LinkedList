//Emma Hopkins -- this code reads the file's data
import java.io.*;
import java.util.*;
public class  Driver2  {
    public static myLinkedList list;   // altered line for linked list implementation
    public static Scanner  inp;
    public static File f;
    public static String  fname;
    public static void main( String [ ] args)
    {
        System.out.print("Please enter a path or name of input file : ");
        inp = new Scanner(System.in);
        fname = inp.nextLine();
        f = new File(fname);
        try {
            inp = new Scanner(f);
        } catch (Exception E) { System.out.println("File not found"); }
        String line;
        String [  ] tokens;
        list = new  myLinkedList( );    // NEW line for linked list implementation
        while ( inp.hasNextLine() )
        {
            int pos = 0;
            int val = 0;
            Node n = null;    // New line for linked list implementation!!!
            line = inp.nextLine( );
            tokens = line.split("\\s+");

            switch ( tokens[0] )  {
                case "IF" :
                    val = Integer.parseInt( tokens[1] );
                    n = new Node(val);       // new line for linked list implementation
                    list.insertFront(n);       // altered line
                    break;
                case "IR" :
                    // code for calling insertRear() should go here
                    val = Integer.parseInt( tokens[1] );
                    n = new Node(val);       // new line for linked list implementation
                    list.insertRear(n);
                    break;
                case  "IP" :
                    pos = Integer.parseInt( tokens[1] );
                    val = Integer.parseInt( tokens[2] );

                    n = new Node(val);      // new line for linked list implementation
                    if ( pos > 0 && pos <= list.getSize() + 1)
                        list.insertPos(n,pos);
                    break;
                case  "DF"  :
                    if ( ! list.isEmpty() )
                        System.out.println("### " + list.deleteFront( ) + " ###");
                    else
                        System.out.println("CANNOT DELETE FROM EMPTY LIST");
                    break;
                case  "DR"  :
                    // code for calling deleteRear( ) and printing output in proper format goes here
                    if ( ! list.isEmpty() )
                        System.out.println("@@@ " + list.deleteRear( ) + " @@@");
                    else
                        System.out.println("CANNOT DELETE FROM EMPTY LIST");
                    break;
                case  "DP"   :
                    // code for deletePos() and proper output should go here
                    if ( ! list.isEmpty() )
                        System.out.println("*** " + list.deletePos(pos) + " ***");
                    else
                        System.out.println("LIST IS EMPTY");
                    break;
                case "PL" :
                    if ( ! list.isEmpty() )
                        list.printList(n);
                    else
                        System.out.println("CANNOT DELETE FROM EMPTY LIST");

                    break;
                case "GS" :
                    // code for calling getSize() and printing out appropriately should go here
                    System.out.println("Size : " + list.getSize());
                    break;
                case  "GI"  :
                    pos = Integer.parseInt(tokens[1]);
                    if ( pos <= list.getSize( ) && pos > 0){
                        System.out.println("Position " + pos + " : " + list.getItem(pos));
                    }
                    else{
                        System.out.println("LIST IS EMPTY");
                    }
                    break;
                default :
                    System.out.println("Command not recognized : " + tokens[0]);
            }   // end switch
        }  // end while
    }   // end main()
}    // end class
