package syr.edu.hw6;

public class Strikethru extends Element{
    Element fmt;
    Strikethru(String s){
        super(s);
        this.fmt = new Element(s);
    }
    Strikethru(Element fmt){
        super(fmt.s);
        this.fmt = fmt;
    }

    public String toHtml(){
        return "<s>" +  fmt.toHtml().trim() + "<s> ";
    }

    public String toString(){
        return fmt.toString();
    }

    public String toMarkdown(){
        return "~~" +  fmt.toMarkdown().trim() + "~~ ";
    }
}

