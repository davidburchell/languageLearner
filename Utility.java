import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utility {

    public static List<Term> readTermsFromFiles(List<String> fileNames, String learningMode){
        List<Term> terms = new ArrayList<>();
        for(int lcv = 0; lcv < fileNames.size(); lcv ++){
            File fileReader = new File(fileNames.get(lcv));
            try {
                Scanner fileScanner = new Scanner(fileReader);
                String language = fileScanner.nextLine();
                while(fileScanner.hasNextLine()){
                    String pairing = fileScanner.nextLine();
                    String [] englishAndForeign = pairing.split(" -- ");
                    String englishMeaning = englishAndForeign[0];
                    String foreignWord = englishAndForeign[1];
                    Term newTerm = new Term(englishMeaning, foreignWord, language, learningMode);
                    terms.add(newTerm);
                }

            } catch (FileNotFoundException e){
                System.out.println("file not found : " + e);
            }
        }
        return terms;
    }
}
