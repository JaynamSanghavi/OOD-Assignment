package syr.edu.hw6;
public class Italic extends Element{
    Element fmt;
    Italic(String s){
        super(s);
        this.fmt = new Element(s);
    }
    Italic(Element fmt){
        super(fmt.s);
        this.fmt = fmt;
    }

    public String toHtml(){
        return "<i>" +  fmt.toHtml().trim() + "<i> ";
    }

    public String toString(){
        return fmt.toString();
    }

    public String toMarkdown(){
        return "*" +  fmt.toMarkdown().trim() + "* ";
    }
}
