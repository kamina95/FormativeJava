/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motorboat;

import java.util.Scanner;
import motorboat.business.Coordinator;
import motorboat.business.Motorboat;
import motorboat.presentation.View;

/**
 *
 * @author anton
 */
public class ApplicationRunner {

    public static void main(String[] args) {
        Coordinator coord = new Coordinator();
        View v = new View(coord);
        boolean quit = false;


        Scanner input = null;

        int selection = 0;

        //menu selector
        System.out.println("\n\t WELCOME TO MOTORBOAT GROUP\n");

        while (!quit) {
            try {
                input = new Scanner(System.in);
                View.printMenu();

                selection = input.nextInt();
            } catch (java.util.InputMismatchException nfe) {

                System.out.println("\nNot a proper Input.\n");
            }

            switch (selection) {
                case 1:
                    v.bookLesson();
                    break;
                case 2:
                    v.ListMember();
                    break;
                case 3:
                    v.ListInstructor();
                    break;
                case 4:
                    v.hireMotorboat();
                    break;
                case 5:
                    v.listMotorboats();
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    System.out.println("\nNot a proper Input.\n");

            }
        }
    }
}
