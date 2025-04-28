package Driver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;

import AbstractFactory.*;
import DataStore.*;
import InputProcessor.*;
import MDAEFSM.*;
import OutputProcessor.*;

/**
 * ----------------------------------------------------------
 * Driver.java
 * ----------------------------------------------------------
 * Entry point for the vending machine simulation.
 * Allows user to select between VM-1 and VM-2, and interact
 * with the vending machine using appropriate operations.
 *
 * Design Patterns Demonstrated:
 * - Abstract Factory: Used to provide VM-specific components
 * - Strategy: Executed through OutputProcessor
 * - State: Managed within MDAEFSM
 */
public class Driver {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        int ch = 1;

        System.out.println("******** Select Vending Machine ********");
        System.out.println(" 1. Vending Machine - 1");
        System.out.println(" 2. Vending Machine - 2");

        input = bufferedReader.readLine();

        // ---------------- VM-1 Flow ---------------- //
        if (input.equalsIgnoreCase("1")) {

            // Abstract Factory for VM-1
            AbstractFactory af = new Vending1Factory();
            DataStore ds = af.getDataStore();
            OutputProcessor op = new OutputProcessor(af, ds);
            MDAEFSM mda = new MDAEFSM(op);
            VendingMachine1 vm1 = new VendingMachine1(mda, ds);

            float p, v, x;
            int n;

            System.out.println("\n---------------------------");
            System.out.println(" Vending Machine-1");
            System.out.println(" MENU of Operations");
            System.out.println(" 0. create(float)");
            System.out.println(" 1. coin(float)");
            System.out.println(" 2. sugar()");
            System.out.println(" 3. cappuccino()");
            System.out.println(" 4. chocolate()");
            System.out.println(" 5. insert_cups(int)");
            System.out.println(" 6. set_price(float)");
            System.out.println(" 7. cancel()");
            System.out.println(" 8. card(float)");
            System.out.println(" q. Quit the demo program");
            System.out.println("---------------------------");
            System.out.println(" Vending Machine-1 Execution");

            while (true) {
                System.out.print("\nSelect Operation: ");
                System.out.print("\n0-create, 1-coin, 2-sugar, 3-cappuccino, 4-chocolate, 5-insert_cups, 6-set_price, 7-cancel, 8-card, q-Quit\n");
                input = bufferedReader.readLine();

                if (input.isEmpty()) continue;
                if (input.equalsIgnoreCase("q")) break;

                try {
                    ch = Integer.parseInt(input);
                } catch (Exception e) {
                    System.out.println("That's not a valid option (0-8 or q). Try again.");
                    continue;
                }

                switch (ch) {
                    case 0:
                        System.out.println("Operation selected: create(float)");
                        System.out.print("Enter value of parameter p: ");
                        try {
                            p = in.nextFloat();
                            if (p > 0) vm1.create(p);
                            else System.out.println("Value must be greater than 0.");
                        } catch (Exception e) {
                            in.next();
                            System.out.println("Enter a valid float value.");
                        }
                        break;

                    case 1:
                        System.out.println("Operation selected: coin(float)");
                        System.out.print("Enter value of parameter v: ");
                        try {
                            v = in.nextFloat();
                            if (v > 0) vm1.coin(v);
                            else System.out.println("Value must be greater than 0.");
                        } catch (Exception e) {
                            in.next();
                            System.out.println("Enter a valid float value.");
                        }
                        break;

                    case 2:
                        System.out.println("Operation selected: sugar()");
                        vm1.sugar();
                        break;

                    case 3:
                        System.out.println("Operation selected: cappuccino()");
                        vm1.cappuccino();
                        break;

                    case 4:
                        System.out.println("Operation selected: chocolate()");
                        vm1.chocolate();
                        break;

                    case 5:
                        System.out.println("Operation selected: insert_cups(int)");
                        System.out.print("Enter number of cups: ");
                        try {
                            n = in.nextInt();
                            if (n > 0) vm1.insert_cups(n);
                            else System.out.println("Value must be greater than 0.");
                        } catch (Exception e) {
                            in.next();
                            System.out.println("Enter a valid integer.");
                        }
                        break;

                    case 6:
                        System.out.println("Operation selected: set_price(float)");
                        System.out.print("Enter new price: ");
                        try {
                            p = in.nextFloat();
                            if (p > 0) vm1.set_price(p);
                            else System.out.println("Value must be greater than 0.");
                        } catch (Exception e) {
                            in.next();
                            System.out.println("Enter a valid float value.");
                        }
                        break;

                    case 7:
                        System.out.println("Operation selected: cancel()");
                        vm1.cancel();
                        break;

                    case 8:
                        System.out.println("Operation selected: card(float)");
                        System.out.print("Enter card value: ");
                        try {
                            x = in.nextFloat();
                            if (x > 0) vm1.card(x);
                            else System.out.println("Value must be greater than 0.");
                        } catch (Exception e) {
                            in.next();
                            System.out.println("Enter a valid float value.");
                        }
                        break;

                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            }
        }

        // ---------------- VM-2 Flow ---------------- //
        else if (input.equalsIgnoreCase("2")) {

            AbstractFactory af = new Vending2Factory();
            DataStore ds = af.getDataStore();
            OutputProcessor op = new OutputProcessor(af, ds);
            MDAEFSM mda = new MDAEFSM(op);
            VendingMachine2 vm2 = new VendingMachine2(mda, ds);

            int p, v, n;

            System.out.println("\n---------------------------");
            System.out.println(" Vending Machine-2");
            System.out.println(" MENU of Operations");
            System.out.println(" 0. CREATE(int)");
            System.out.println(" 1. COIN(int)");
            System.out.println(" 2. SUGAR()");
            System.out.println(" 3. CREAM()");
            System.out.println(" 4. COFFEE()");
            System.out.println(" 5. InsertCups(int)");
            System.out.println(" 6. SetPrice(int)");
            System.out.println(" 7. CANCEL()");
            System.out.println(" q. Quit the demo program");
            System.out.println("---------------------------");
            System.out.println(" Vending Machine-2 Execution");

            while (true) {
                System.out.print("\nSelect Operation: ");
                System.out.print("\n0-CREATE, 1-COIN, 2-SUGAR, 3-CREAM, 4-COFFEE, 5-InsertCups, 6-SetPrice, 7-CANCEL, q-Quit\n");
                input = bufferedReader.readLine();

                if (input.isEmpty()) continue;
                if (input.equalsIgnoreCase("q")) break;

                try {
                    ch = Integer.parseInt(input);
                } catch (Exception e) {
                    System.out.println("That's not a valid option (0-7 or q). Try again.");
                    continue;
                }

                switch (ch) {
                    case 0:
                        System.out.println("Operation selected: CREATE(int)");
                        System.out.print("Enter value of p: ");
                        try {
                            p = in.nextInt();
                            if (p > 0) vm2.CREATE(p);
                            else System.out.println("Value must be greater than 0.");
                        } catch (Exception e) {
                            in.next();
                            System.out.println("Enter a valid integer.");
                        }
                        break;

                    case 1:
                        System.out.println("Operation selected: COIN(int)");
                        System.out.print("Enter value of v: ");
                        try {
                            v = in.nextInt();
                            if (v > 0) vm2.COIN(v);
                            else System.out.println("Value must be greater than 0.");
                        } catch (Exception e) {
                            in.next();
                            System.out.println("Enter a valid integer.");
                        }
                        break;

                    case 2:
                        System.out.println("Operation selected: SUGAR()");
                        vm2.SUGAR();
                        break;

                    case 3:
                        System.out.println("Operation selected: CREAM()");
                        vm2.CREAM();
                        break;

                    case 4:
                        System.out.println("Operation selected: COFFEE()");
                        vm2.COFFEE();
                        break;

                    case 5:
                        System.out.println("Operation selected: InsertCups(int)");
                        System.out.print("Enter number of cups: ");
                        try {
                            n = in.nextInt();
                            vm2.InsertCups(n);
                        } catch (Exception e) {
                            in.next();
                            System.out.println("Enter a valid integer.");
                        }
                        break;

                    case 6:
                        System.out.println("Operation selected: SetPrice(int)");
                        System.out.print("Enter new price: ");
                        try {
                            p = in.nextInt();
                            if (p > 0) vm2.SetPrice(p);
                            else System.out.println("Value must be greater than 0.");
                        } catch (Exception e) {
                            in.next();
                            System.out.println("Enter a valid integer.");
                        }
                        break;

                    case 7:
                        System.out.println("Operation selected: CANCEL()");
                        vm2.CANCEL();
                        break;

                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            }
        }

        // ---------------- Invalid VM Option ---------------- //
        else {
            System.out.println("No such Vending Machine implemented.");
            System.out.println("Restart and select either VM-1 or VM-2.");
        }
    }
}
