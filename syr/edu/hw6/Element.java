package syr.edu.hw6;
public class Element{
    String s;   
    Element(String st){
        if(!st.isEmpty() || !st.isBlank()) 
            s = st;
        else
            s = "";
    }

    public String toHtml(){
        return s + " ";
    }

    public String toString(){
        return s + " ";
    }
    public String toMarkdown(){
        return s + " ";
    }
}