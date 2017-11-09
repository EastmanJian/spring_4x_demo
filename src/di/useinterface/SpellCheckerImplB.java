package di.useinterface;

public class SpellCheckerImplB implements SpellChecker{
    public SpellCheckerImplB(){
        System.out.println("Inside SpellCheckerImplB constructor." );
    }
    public void checkSpelling() {
        System.out.println("Inside SpellCheckerImplB checkSpelling." );
    }
}