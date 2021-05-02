import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringExcersise {
    public static void main(String[] args){
        String name = "Mariam Safwat";
        StringBuilder result = new StringBuilder();

        List<String> namelist = new ArrayList<>(Arrays.asList(name.split(" ")));

        //String[] namelist = name.split(" ");
        System.out.println(namelist.get(1));
        for (String s : name.split(" ")) {
            result.append(s.charAt(0));
        }
        System.out.println(result);
    }
}
