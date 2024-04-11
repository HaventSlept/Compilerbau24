import compiler.StateMachine;

public class TestDezimalzahlMachine {

  public static void main(String[] args) throws Exception {
    System.out.println("HelloWorld");
    StateMachine dezimalzahlMachine = new compiler.machines.DezimalzahlMachine();
    java.io.OutputStreamWriter outWriter = new java.io.OutputStreamWriter(System.out);
    dezimalzahlMachine.process("1.1", outWriter);
    System.out.print(dezimalzahlMachine.asDot());
  }
}
