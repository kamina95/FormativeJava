package motorboat.presentation;

import java.util.ArrayList;
import java.util.Scanner;
import motorboat.business.Coordinator;
import motorboat.business.Instructor;
import motorboat.business.Lesson;
import motorboat.business.MBLH;
import motorboat.business.Member;
import motorboat.business.Motorboat;
import motorboat.business.Novice;

public class View {

    private Coordinator coord;

    public View(Coordinator c) {

        coord = c;
    }

    public static void printMenu() {
        System.out.print("----------------------------------------\n");
        System.out.print("|                                      |\n");
        System.out.print("| 1.Book Lesson for Member             |\n");
        System.out.print("|                                      |\n");
        System.out.print("| 2.List member lesson                 |\n");
        System.out.print("|                                      |\n");
        System.out.print("| 3.List instructor lessons            |\n");
        System.out.print("|                                      |\n");
        System.out.print("| 4.Hire motorboat for MBLH            |\n");
        System.out.print("|                                      |\n");
        System.out.print("| 5.Display motorboat week             |\n");
        System.out.print("|                                      |\n");
        System.out.print("| 6.Exit                               |\n");
        System.out.print("|                                      |\n");
        System.out.print("----------------------------------------\n\n");

        System.out.print("Please select a option: ");
    }

    //option 1
    public void bookLesson() {

        Member member = selectMember();
        Instructor instructor;
        if (coord.checkLimitMember(member)) {
            if (member instanceof Novice) {
                instructor = coord.getInstructor((Novice) member);
            } else {
                instructor = selectInstructor();
            }

            System.out.println(coord.instructorName(instructor));
            System.out.println("");
            System.out.println(coord.InstructorTable(instructor));
            coord.printInsLess(instructor);

            System.out.println("Please introduce the Time Slots");
            int day = day();
            int hour = hour();
            if (coord.checkAvaliability(member, day, hour, instructor)) {
                Motorboat motorboat = coord.selectMotorboat(day, hour, member);   //missing add the empty statusssssss
                if (member instanceof Novice) {
                    ((Novice) member).addLesson(day, hour,instructor, motorboat );
                    instructor.addLesson(coord.createLesson(day, hour, instructor, motorboat, member.getName()));
                    System.out.println(instructor);
                } else if (member instanceof MBLH) {
                    ((MBLH) member).addLesson(day, hour, instructor, motorboat);
                }
            } else {
                System.out.println("This member has already another booking in that time slot");
            }

        } else {
            System.out.println("This member has alredy reach the limit of lessons per week");
        }

    }

    //option 2
    public void ListMember() {
        Member member = selectMember();
        member.printLessons();
    }

    //options 3
    public void ListInstructor() {
        Instructor instructor = selectInstructor();//check the dstate of empty
        coord.printInsLess(instructor);
    }

    //option 4 
    public void hireMotorboat() {
        MBLH member = selectMBLH();

        if (coord.checkHires(member)) {
            System.out.println("Please introduce the Time Slots");
            int day = day();
            int hour = hour();
            if (coord.checkMGLHSpace(day, hour, member)) {
                Motorboat motorboat = coord.selectMotorboat(day, hour, member);   //check when ther is not motorboalts fiiiiiiiiiiiiiiiiiiiiiiiiiiix 3b(i)
                coord.addHire(day, hour, motorboat, member);
            } else {
                System.out.println("\n This member has no space at that time");
            }
        } else {
            System.out.println("\nThis MBLH has alreafy book all his avalibly motorboats.");
        }
    }

    //option 5
    public void listMotorboats() {
        Motorboat motorboat = selectMotorboat();
        coord.weekMotorboat(motorboat);
    }

    public Member selectMember() {
        Scanner input = new Scanner(System.in);
        ArrayList<Member> members = coord.getMembers();
        int count = 1;
        for (Member m : members) {
            System.out.println(count + ". " + m.getName());
            count++;
        }
        System.out.print("\n Introduce the number of the member: ");
        int decision = input.nextInt();
        return members.get(decision - 1);
    }

    public MBLH selectMBLH() {
        Scanner input = new Scanner(System.in);
        ArrayList<Member> members = coord.getMembers();
        ArrayList<MBLH> mbs = new ArrayList<>();
        int count = 1;
        for (Member m : members) {
            if (m instanceof MBLH) {
                System.out.println(count + ". " + m.getName());
                mbs.add(((MBLH) m));
                count++;
            }
        }
        System.out.print("\n Introduce the number of the MBLH: ");
        int decision = input.nextInt();
        return mbs.get(decision - 1);
    }

    public Instructor selectInstructor() {
        Scanner input = new Scanner(System.in);
        ArrayList<Instructor> instructors = coord.getInstructors();
        int count = 1;
        for (Instructor m : instructors) {
            System.out.println(count + ". " + m.getName());
            count++;
        }
        System.out.print("\n Introduce the number of the intructor: ");
        int decision = input.nextInt();
        return instructors.get(decision - 1);
    }

    public Motorboat selectMotorboat() {
        Scanner input = new Scanner(System.in);
        Motorboat[] motorboat = coord.getMotorboats();
        int count = 1;
        for (Motorboat m : motorboat) {
            System.out.println(count + ". " + m.getName());
            count++;
        }
        System.out.print("\n Introduce the number of the intructor: ");
        int decision = input.nextInt();
        return motorboat[decision - 1];
    }

    public static int day() {
        Scanner input = null;
        int decision = 0;
        int day = 0;
        System.out.println("1.Monday                5.Friday");
        System.out.println("2.Tuesday               6.Saturday");
        System.out.println("3.Wednesday             7.Sunday");
        System.out.println("4.Thursday");

        System.out.println("\nPlease decide the day: ");
        while (decision == 0) {
            try {
                input = new Scanner(System.in);
                decision = input.nextInt();
            } catch (java.util.InputMismatchException nfe) {
                System.out.println("\nNot a proper input\n");
            }
            if (decision >= 1 && decision <= 7) {
                day = decision - 1;
            } else {
                System.out.print("Please introduce a number from 1 to 7:> ");
                decision = 0;
            }

        }
        return day;
    }

    public int hour() {

        Scanner input = null;

        System.out.println("1. 09:00                4. 12:00               7. 15:00");
        System.out.println("2. 10:00                5. 13:00               8. 16:00");
        System.out.println("3. 11:00                6. 14:00               9. 17:00");

        System.out.print("\nPlease select a Hour: ");

        int decision = 0;
        int hour = 0;
        while (decision == 0) {
            try {
                input = new Scanner(System.in);
                decision = input.nextInt();
            } catch (java.util.InputMismatchException nfe) {
                System.out.println("\nNot a proper input\n");
            }
            if (decision >= 1 && decision <= 8) {
                hour = decision - 1;
            } else {
                System.out.print("Please introduce a number from 1 to 8:> ");
                decision = 0;
            }
        }
        return hour;

    }
}
