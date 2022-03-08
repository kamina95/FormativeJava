package motorboat.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MBLH extends Member {

    int hireLimit;

    public MBLH(String name) {
        this.name = name;
        licence = true;
        this.lessonLimit = 3;
        hireLimit = 2;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    boolean hasLicence() {
        return licence;
    }

    @Override
    public List<Reserve> getLessons() {
        return lessons;
    }

    @Override
    boolean checkSpace(int date, int startTime, Instructor instructor) {
        Lesson L = new Lesson(date, startTime);
        for (Reserve lesson : lessons) {
            if (L.equals(lesson)) {
                return false;
            }
        }
        return instructor.checkSpace(date, startTime);
    }

    boolean checkSpace(int date, int startTime) {
        Lesson L = new Lesson(date, startTime);
        for (Reserve lesson : lessons) {
            if (L.equals(lesson)) {
                return false;
            }
        }
        return true;
    }

    @Override
    boolean checkLimit() {
        return lessonLimit > 0;
    }

    boolean checkHireLimit() {
        return hireLimit > 0;
    }

    public void addLesson(int date, int startTime, Instructor instructor, Motorboat motorboat) {

        Lesson L = new Lesson(date, startTime, instructor, motorboat, this.getName());
        lessons.add(L);
        instructor.addLesson(L);
        motorboat.addBooking(L);
        System.out.println("Booking Succesfull   Details:");
        System.out.println(L.toString());
        lessonLimit--;

    }

    public void addHire(int date, int startTime, Motorboat motorboat){
        Hire H = new Hire( date, startTime, motorboat, this.getName());
        lessons.add(H);
        motorboat.addBooking(H);
        H.toString();
    }
//    void addHire(int date, int startTime, Motorboat[] motorboats) {
//        if (hireLimit > 0) {
//            Motorboat motorboat = selectMotorboat(date, startTime, motorboats);
//            if (checkSpace(date, startTime)) {
//                Motorboat motorboat = selectMotorboat(date, startTime, motorboats);
//                Lesson L = new Lesson(date, startTime, instructor, motorboat);
//                lessons.add(L);
//                instructor.addLesson(L);
//                motorboat.addLesson(L);
//                lessonLimit--;
//            } else {
//                System.out.println("Instructor is not avalibe in that time slot");
//            }
//        } else {
//            System.out.println("This memeber already reach his limit of sessions");
//        }
//    }
    Instructor selectInstructor(int date, int startTime, ArrayList<Instructor> instructors) {
        Scanner input = new Scanner(System.in);
        ArrayList<Instructor> freesInstructors = new ArrayList<>();
        int count = 1;
        for (Instructor I : instructors) {
            if (I.checkSpace(date, startTime)) {
                System.out.println(count + ". " + I.getName());
                freesInstructors.add(I);
                count++;
            }
        }
        System.out.print("Please introduce the number of the motorboat selected: ");
        int decision = input.nextInt();
        return freesInstructors.get(decision - 1);

    }

    @Override
    Motorboat selectMotorboat(int date, int startTime, Motorboat[] motorboats) {
        Scanner input = new Scanner(System.in);
        ArrayList<Motorboat> freesMotorboat = new ArrayList<>();
        int count = 1;
        for (Motorboat m : motorboats) {
            if (m.checkSpace(date, startTime)) {
                System.out.println(count + ". " + m.getName());
                freesMotorboat.add(m);
                count++;
            }
        }
        System.out.print("Please introduce the number of the motorboat selected: ");
        int decision = input.nextInt();
        return freesMotorboat.get(decision - 1);

    }

    @Override
    public void printLessons() {
        if (lessons.isEmpty()) {
            System.out.println("\n This member dosent have any lesson Booked");
        } else {

            Collections.sort(lessons);
            for (Reserve L : lessons) {
                if (L instanceof Lesson) {
                    System.out.println(L.toString());
                }
            }

        }
    }

}
