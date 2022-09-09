//package temp.te;
import java.util.*;
// Check null in searching
// Check string array is null or not
// return -1 or msg if not found

import syr.edu.hw1.Greeting;
import syr.edu.hw1.Library;

public class Test{

    static ArrayList<String> s = new ArrayList<>();
    public static void init(String[] list){
        for (String se : list) {
            s.add(se);
        }
    }
    public static String search(String key){
        String returnS = "Key not found :(";
        for(int i = 0; i < s.size(); i++){
            String getS = s.get(i);
            if(getS.toLowerCase().contains(key.toLowerCase())){
                returnS = "Found";
            }
        }
        return returnS;

    }
    public static int i;
    
    static{
        //System.out.println("Hello from static block");
        i = 5;
    }
    public static void main(String[] args) {
        //System.out.println("Hello from main " + i);
        Test3 t = new Test3();
        t.print1();

        // String[] strArray = new String[]{"abc"};
        // Library l = new Library();
        // //l.init(strArray);
        // System.out.println(l.search("a"));
        // System.out.println(search(args[0]));
        //Greeting g = new Greeting();
        //g.greet();
        
    }
}