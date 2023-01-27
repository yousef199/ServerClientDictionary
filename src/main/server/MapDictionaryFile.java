package main.server;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.HashMap;

public class MapDictionaryFile {
    private HashMap<String , String> dictionary;

    public void initializeMap(String fileName){
        ObjectMapper mapper = new ObjectMapper();
        File dictionaryFile = new File("C:\\Users\\Ideapad Gaming\\Desktop\\ServerClientDictionary\\src\\dictionaries\\"+fileName);
        try{
            dictionary = mapper.readValue(dictionaryFile , HashMap.class);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public HashMap<String, String> getDictionary() {
        return dictionary;
    }
}
