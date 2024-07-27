package Day11;
import java.util.*;
import java.io.*;

public class Printanagrams {
    public static List<List<String>> anagram(String[] strs){
        Map<String,List<String>> mp = new HashMap<>();
        for(String word:strs){
            char chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedword = new String(chars);
            if(!mp.containsKey(sortedword)){
                mp.put(sortedword,new ArrayList<>());
            }
            mp.get(sortedword).add(word);
        }
        return new ArrayList<>(mp.values());
    }
}
