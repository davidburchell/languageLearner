import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utility {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BOLD = "\u001b[1m";

    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";

    public static List<Term> readTermsFromFiles(List<String> fileNames, String learningMode, List<String> cefrLevels){
        List<Term> terms = new ArrayList<>();
        for(int lcv = 0; lcv < fileNames.size(); lcv ++){
            File fileReader = new File(fileNames.get(lcv));
            try {
                Scanner fileScanner = new Scanner(fileReader);
                String language = fileScanner.nextLine();
                while(fileScanner.hasNextLine()){
                    String row = fileScanner.nextLine();
                    String [] rowSplit = row.split(" -- ");
                    String cefrLevel = rowSplit[0];
                    if(!cefrLevels.contains(cefrLevel)){
                        continue;
                    }
                    String foreignWord = rowSplit[1];
                    String englishMeaning = rowSplit[2];
                    Term newTerm = new Term(englishMeaning, foreignWord, language, cefrLevel, learningMode);
                    terms.add(newTerm);
                }

            } catch (FileNotFoundException e){
                System.out.println("file not found : " + e);
            }
        }
        return terms;
    }
}
