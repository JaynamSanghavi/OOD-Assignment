package syr.edu.hw6;
public class Bold extends Element{
    Element fmt;
    Bold(String s){
        super(s);
        this.fmt = new Element(s);
    }
    Bold(Element fmt){
        super(fmt.s);
        this.fmt = fmt;
    }

    public String toHtml(){
        return "<b>" +  fmt.toHtml().trim() + "<b> ";
    }

    public String toString(){
        return fmt.toString();
    }

    public String toMarkdown(){
        return "**" +  fmt.toMarkdown().trim() + "** ";
    }
}