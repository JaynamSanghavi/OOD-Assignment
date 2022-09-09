package syr.edu.hw1;

import java.util.ArrayList;
import java.util.List;


public class Library {
    private List<String> catalog;

    // initialize the arraylist and add the string array in the list.

    public void init(String[] publication){
        catalog = new ArrayList<String>();
        for (String publicationName : publication) {
            catalog.add(publicationName);
        }
    }

    /* 
    
        Check if arraylist is initialized else throw the error message.
        Else, check if key is null or not, if its null then throw error message.
        Else. check if arraylist size is greater then 0, if not then throw error message.
        Else. check if the key is in the list. If found send positive message else send negative message.
    
    */
    public String search(String key){
        String answer = "";
        int flag = 0;
        if(catalog != null){
            if(key.length() > 0){
                if(catalog.size() > 0){
                    for(int i = 0;i<catalog.size();i++){
                        if(catalog.get(i).toLowerCase().contains(key.toLowerCase())){
                            answer = "Publication found in the library";
                            flag = 1;
                            break;
                        }
                    }
                    if(flag == 0){
                        answer = "Publication not found in the library";
                    }
                }else{
                    answer = "No item in library catalog";
                }   
            }else{
                answer = "Please give publication name to find";
            }
        }else{
            answer = "Please call init method first";
        }
        return answer;
    }
}
