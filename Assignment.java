
import java.util.*;
interface Word{
    public String toStr();
}
class Text implements Word{
    String s;
    Text(String st){
        s = st;
    }
    public String toStr(){
        System.out.println("In Text");
        return s;
    }
}

class Format implements Word{
    Word fmt;
    Format(Word fmt){
        this.fmt = fmt;
    }
    public String toStr(){
        System.out.println("In Format");
        return fmt.toStr();
    }
}

class Element extends Format{
    Element(Word b){
        super(b);
    }

    public String toStr(){
        return fmt.toStr();
    }
}

class Bold extends Format{
    Bold(Word b){
        super(b);
    }

    public String toStr(){
        return "*" +  fmt.toStr() + "*";
    }
}

class Italic extends Format{
    Italic(Word b){
        super(b);
    }

    public String toStr(){
        return "__" +  fmt.toStr() + "__";
    }
}
public class Assignment{
    public static void main(String[] args) {
        Format[] pangram = new Format[5];
        pangram[0] = new Format(new Text("The"));
        pangram[1] = new Italic(new Text("quick"));
        pangram[2] = new Bold(new Text("bold"));  
        pangram[3] = new Bold(new Italic(new Text("bold")));
        pangram[4] = new Italic(pangram[2]);
        // pangram[5] = new Element("over");
        // pangram[6] = new Element("the");
        // pangram[7] = new Strikethru("lazy");
        // pangram[8] = new Element("dog");
        // Format f = new Format(new Bold(new Element("Test"),"Test"));
        // System.out.println(f.toString());

        StringBuffer justText = new StringBuffer();
        for (Format e: pangram) {
            justText.append(e.toStr());
        }
        System.out.println(justText.toString());
    }
}