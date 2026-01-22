import java.util.ArrayList;
import java.util.List;

public class AppMain {

    public static void main(String [] args){

        System.out.println("================");
        System.out.println("LANGUAGE LEARNER");
        System.out.println("================");
        System.out.println();

        List<String> fileNames = new ArrayList<>();
        fileNames.add("C:\\Users\\david\\Desktop\\languageLearner\\pbwl_A0");
        fileNames.add("C:\\Users\\david\\Desktop\\languageLearner\\pbwl_A1L");

        List<String> cefrLevels = new ArrayList<>();
        cefrLevels.add("A0");

        List<Term> termList = Utility.readTermsFromFiles(fileNames, "SEE_FOREIGN", cefrLevels);
        LanguageLearner languageLearner = new LanguageLearner(10, 6, 2, termList);
        languageLearner.simulateClassroom();

        System.out.println();
        System.out.println("END OF LESSON");
    }
}
