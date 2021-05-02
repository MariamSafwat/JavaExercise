import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Collections {

    static List<ArrayList<String>> sortCities(String countryCode, Map<String, List<ArrayList<String>>> citiesMap){
        List<ArrayList<String>> citiesListToSort;
        citiesListToSort =  citiesMap.get(countryCode);

        citiesListToSort.sort(Comparator.comparing(l -> l.get(2)));
        System.out.println("Sorted Cities: ");
        System.out.println(citiesListToSort);
        return citiesListToSort;
    }

    static void highestPopulation(String countryCode, Map<String, List<ArrayList<String>>> citiesMap){
        List<ArrayList<String>> sorted = sortCities(countryCode,citiesMap);
        System.out.println("Highest population: ");
        System.out.println(sorted.get(sorted.size()-1).get(2)); //97929


    }

    public static void main(String[] args) throws FileNotFoundException {
        Map<String, List<ArrayList<String>>> citiesMap = new HashMap<>();
        Scanner citiesFile = new Scanner(new FileInputStream("src/Cities.txt"));
        List<ArrayList<String>> AllCities = new ArrayList<ArrayList<String>>();

        while (citiesFile.hasNextLine()){
            String line = citiesFile.nextLine();
            ArrayList<String> citiesList = new ArrayList<>(Arrays.asList(line.split(",")));
            AllCities.add(citiesList);

            List<ArrayList<String>> valuesList;

            //check if country code exists as key in citiesMap
            //if true then add city name to string list
            //if false add it as new key
            if(citiesMap.containsKey(citiesList.get(3))){
                valuesList = citiesMap.get(citiesList.get(3));
                valuesList.add(citiesList);

            }
            else{
                valuesList = new ArrayList<>();
                valuesList.add(citiesList);
                citiesMap.put(citiesList.get(3), valuesList);
            }

        }
        System.out.println("Cities Map: ");
        System.out.println(citiesMap);


        //System.out.println(citiesMap.keySet());
        String country = " POL";
        sortCities(country,citiesMap);
        highestPopulation(country,citiesMap);

    }
}


