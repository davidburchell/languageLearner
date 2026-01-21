import java.util.ArrayList;
import java.util.List;

public class AppMain {

    public static void main(String [] args){

        System.out.println("================");
        System.out.println("LANGUAGE LEARNER");
        System.out.println("================");
        System.out.println();

        List<String> fileNames = new ArrayList<>();
        fileNames.add("unitOneWords.txt");

        List<Term> termList = Utility.readTermsFromFiles(fileNames, "SEE_FOREIGN");
        LanguageLearner languageLearner = new LanguageLearner(10, 6, 2, termList);
        languageLearner.simulateClassroom();

        System.out.println();
        System.out.println("END OF LESSON");
    }
}
