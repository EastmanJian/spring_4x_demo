package di.useinterface;

public class SpellCheckerImplA implements SpellChecker{
    public SpellCheckerImplA(){
        System.out.println("Inside SpellCheckerImplA constructor." );
    }
    public void checkSpelling() {
        System.out.println("Inside SpellCheckerImplA checkSpelling." );
    }
}