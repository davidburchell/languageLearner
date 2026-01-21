public class Term {

    private String englishMeaning;
    private String foreignWord;
    private String language;
    private String learningMode;

    public Term(String englishMeaning, String foreignWord, String language, String learningMode) {
        this.englishMeaning = englishMeaning;
        this.foreignWord = foreignWord;
        this.language = language;
        this.learningMode = learningMode;
    }

    public String getUserVisible(){
        if(learningMode.equals("SEE_FOREIGN")){
            return this.foreignWord;
        }
        return this.englishMeaning;
    }
    public String getTranslatedMeaning(){
        if(learningMode.equals("SEE_FOREIGN")){
            return this.englishMeaning;
        }
        return this.foreignWord;
    }

    public String getEnglishMeaning() {
        return englishMeaning;
    }

    public void setEnglishMeaning(String englishMeaning) {
        this.englishMeaning = englishMeaning;
    }

    public String getForeignWord() {
        return foreignWord;
    }

    public void setForeignWord(String foreignWord) {
        this.foreignWord = foreignWord;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLearningMode() {
        return learningMode;
    }

    public void setLearningMode(String learningMode) {
        this.learningMode = learningMode;
    }
}
