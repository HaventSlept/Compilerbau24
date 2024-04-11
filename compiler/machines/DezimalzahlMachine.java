package compiler.machines;

public class DezimalzahlMachine extends compiler.StateMachine {
    
    public void initStateTable() {
        compiler.State startState = new compiler.State("start", false); //Zustand = "start"
        startState.addTransitionRange('0','9', "start"); //Jede Ziffer vor Punkt geht wieder in Zustand "start"
        startState.addTransition('.', "expectP"); //sobald "." kommt gehen wir in Status "expectP"
        addState(startState); //Zustand "start" zur Liste hinzufügen
        compiler.State expectPState = new compiler.State("expectP", false); //Zustand = "expectP"
        expectPState.addTransitionRange('0','9', "expectN"); //erste Ziffer nach dem Punkt, weil wir nach expectenP schauen
        addState(expectPState); //Zustand "expectP" zur Liste hinzufügen
        compiler.State expectNState = new compiler.State("expectN", true); //Zustand = "expectN", final = "true" -> kein weiteres Zeichen möglich
        expectNState.addTransitionRange('0','9', "expectN"); //So oft Ziffern wiederholen wie existieren wegen expectN
        addState(expectNState);

        //addTransitionRange für mehr als 1 char
    }

    @Override
    public String getStartState() {
        return "start";
    }

    public compiler.TokenIntf.Type getType() {
        return compiler.TokenIntf.Type.EOF;
    }
   
}


