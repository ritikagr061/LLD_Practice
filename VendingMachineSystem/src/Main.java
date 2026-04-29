import entities.VendingMachine;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();
        machine.getVendingMachineState().printProducts(machine);
    }
}