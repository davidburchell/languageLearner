import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LanguageLearner {

    private int roundsToRun;
    private int maxSentenceLength;
    private int minSentenceLength;
    private List<Term> termList;

    private Random randomNumber;

    public LanguageLearner(int roundsToRun, int maxSentenceLength, int minSentenceLength, List<Term> termList) {
        this.roundsToRun = roundsToRun;
        this.maxSentenceLength = maxSentenceLength;
        this.minSentenceLength = minSentenceLength;
        this.termList = termList;

        randomNumber = new Random();
    }

    public void simulateClassroom(){
        Scanner userScanner = new Scanner(System.in);
        for(int lcv = 0; lcv < roundsToRun; lcv ++){
            List<Term> randomTermTest = buildTermTest();
            System.out.println(untranslatedTerms(randomTermTest));
            String userTranslation = userScanner.nextLine();
            System.out.println(validateUserTranslation(randomTermTest, translatedTerms(randomTermTest), userTranslation));
        }
    }

    private String validateUserTranslation(List<Term> terms, String realTranslation, String userTranslation){
        String result = "";
        if(realTranslation.equalsIgnoreCase(userTranslation)){
            result += "-- FULLY CORRECT --\n\n";
        }

        List<Term> correctTerms = new ArrayList<>();
        List<Term> incorrectTerms = new ArrayList<>();
        int longestTerm = 0;
        for(Term term : terms){
            if(userTranslation.contains(term.getTranslatedMeaning())){
                correctTerms.add(term);
            } else {
                incorrectTerms.add(term);
            }
            longestTerm = Math.max(longestTerm, Math.max(term.getTranslatedMeaning().length(), term.getUntranslatedMeaning().length()));
        }

        result += "correct : " + correctTerms.size() + "\n";
        result += "incorrect : " + incorrectTerms.size() + "\n\n";

        for(Term correct : correctTerms){
            result += Utility.ANSI_GREEN_BACKGROUND + Utility.ANSI_BLACK + Utility.ANSI_BOLD;
            result += correct.format(longestTerm+1);
            result += Utility.ANSI_RESET + "\n";
        }
        result += "\n";
        for(Term incorrect : incorrectTerms){
            result += Utility.ANSI_RED_BACKGROUND + Utility.ANSI_BLACK + Utility.ANSI_BOLD;
            result += incorrect.format(longestTerm+1);
            result += Utility.ANSI_RESET + "\n";
        }
        return result;
    }

    private String untranslatedTerms(List<Term> terms){
        String untranslated = "";
        for(Term term : terms){
            untranslated += term.getUntranslatedMeaning() + " ";
        }
        return untranslated.trim();
    }
    private String translatedTerms(List<Term> terms){
        String translated = "";
        for(Term term : terms){
            translated += term.getTranslatedMeaning() + " ";
        }
        return translated.trim();
    }

    private List<Term> buildTermTest(){
        List<Term> randomTermTest = new ArrayList<>();
        int sentenceLength = randomNumber.nextInt(maxSentenceLength - minSentenceLength + 1) + minSentenceLength;
        for(int lcv = 0; lcv < sentenceLength; lcv ++){
            int randomTermIndex = randomNumber.nextInt(termList.size());
            randomTermTest.add(termList.get(randomTermIndex));
        }
        return randomTermTest;
    }
}
