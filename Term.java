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

    public String format(int spacing){
        String formatSpace = "%-" + spacing + "s";
        String english = String.format(formatSpace, this.englishMeaning);
        String foreign = String.format(formatSpace, this.foreignWord);
        return " " + english + " ---- " + foreign;
    }

    public String getUntranslatedMeaning(){
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

    public boolean equals(Term other){
        return (this.englishMeaning.equals(other.getEnglishMeaning()) && this.foreignWord.equals(other.getForeignWord()));
    }
}
