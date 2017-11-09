package annotation.jsr250;

import javax.annotation.Resource;

public class TextEditor {
    private SpellChecker spellChecker;

    @Resource(name = "spellChk")
    public void setSpellChecker( SpellChecker spellChecker ){
        this.spellChecker = spellChecker;
    }
    public SpellChecker getSpellChecker(){
        return spellChecker;
    }
    public void spellCheck(){
        spellChecker.checkSpelling();
    }
}