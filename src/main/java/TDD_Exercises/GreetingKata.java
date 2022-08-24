package TDD_Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GreetingKata {

    String greetName(Object name) {
        StringBuilder greeting = new StringBuilder();

        if (name == null) {
            greeting.append("Hello, my friend.");
        }
        if (name instanceof String) {
            if (name.equals(((String) name).toUpperCase())) {
                greeting.append("HELLO "+name+"!");
            } else {
                greeting.append("Hello "+name+".");
            }
        } else if (name instanceof String[]) {
            List<String> names = Arrays.asList((String[]) name);
            List<String> namesLower = new ArrayList<String>();
            List<String> namesUpper = new ArrayList<String>();

            Pattern p7 = Pattern.compile("(\\w)*,\\s(\\w)*");
            Pattern p8 = Pattern.compile("\\\".*");
            for (String iName: names) {
                System.out.println(iName);
                if (p7.matcher(iName).matches()) {
                    System.out.println("the ', ' found");
                    String[] splitted = iName.split(", ");
                    for (String inSplitted : splitted) {
                        toUpperOrLower(namesLower,namesUpper,inSplitted);
                    }
                    continue;
                } else if (p8.matcher(iName).matches()) {
                    iName = iName.replaceAll("\\\"", "");
                }
                toUpperOrLower(namesLower,namesUpper,iName);
            }

            String add = "";
            if (namesLower.size() == 1) {
                add = " "+namesLower.get(0)+".";
            } else {
                for (String iName: namesLower) {
                    add += ", "+iName;
                }
                String theLastName = namesLower.get(namesLower.size()-1);
                String[] splitted = add.split(", "+theLastName);
                add = splitted[0] + " and "+theLastName+".";
            }
            String shoutingAdd = " AND HELLO";
            if (namesUpper.size() == 1) {
                shoutingAdd += " "+namesUpper.get(0)+"!";
                add += shoutingAdd;
            } else if (namesUpper.size() > 1) {
                for (String iName: namesUpper) {
                    shoutingAdd += ", "+iName;
                }
                String theLastName = namesUpper.get(namesUpper.size()-1);
                String[] splitted = shoutingAdd.split(", "+theLastName);
                add = splitted[0] + " AND "+theLastName+"!";
            }

            greeting.append("Hello"+add);
        }
        return String.valueOf(greeting);
    }

    private void toUpperOrLower(List<String> namesLower, List<String> namesUpper, String iName) {
        if (iName.equals(iName.toUpperCase())) {
            namesUpper.add(iName);
        } else {
            namesLower.add(iName);
        }
    }

}
