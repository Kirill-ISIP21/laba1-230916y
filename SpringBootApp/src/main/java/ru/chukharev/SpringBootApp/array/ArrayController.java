package ru.chukharev.SpringBootApp.array;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ArrayController {
    List<String> someList;
    Map<Integer, String> someMap;
    int n = 0;

    @GetMapping("/update-array")
    public void updateArrayList(@RequestParam(value = "val") String value){
        if(someList == null) someList = new ArrayList<>();
        else someList.add(value);
    }
    @GetMapping("/show-array")
    public ArrayList<String> showArrayList(){
        return (ArrayList<String>) someList;
    }

    @GetMapping("/update-map")
    public void updateHashMap(@RequestParam(value = "val") String value){
        if(someMap == null) someMap = new HashMap<>();
        else someMap.put(n++, value);
    }

    @GetMapping("/show-map")
    public HashMap<Integer, String> showHashMap(){
        return (HashMap<Integer, String>) someMap;
    }

    @GetMapping("/show-all-length")
    public String showAllLength(){
        int i = 0;
        for (String s : someList) i++;
        for (Map.Entry<Integer, String> entry : someMap.entrySet()) i++;
        return String.format(i + " количество всех элементов");
    }
}
