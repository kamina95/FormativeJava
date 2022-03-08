package motorboat.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Novice extends Member {

    Instructor instructor;

    public Novice(String name, Instructor instructor) {
        this.name = name;
        licence = false;
        this.instructor = instructor;
        this.lessonLimit = 3;
       
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

    @Override
    boolean checkLimit() {
        return lessonLimit > 0;
    }

    @Override
    public void addLesson(int date, int startTime,Instructor instructor, Motorboat motorboat) {
            Lesson L = new Lesson(date, startTime,this.getInstructor(),motorboat,this.getName());
            lessons.add(L);
            //instructor.addLesson(L);
            motorboat.addBooking(L);
            System.out.println("Booking succesfull   Details:");
            System.out.println(L.toString());
            lessonLimit--;

    }

    Instructor getInstructor() {
        return instructor;
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



    @Override
    Motorboat selectMotorboat(int date, int startTime,Motorboat[] motorboats) {
        Scanner input = new Scanner(System.in);
        ArrayList<Motorboat> freesMotorboat = new ArrayList<>();
        int count = 1;
        for (Motorboat m : motorboats) {
            if(m.checkSpace(date, startTime)){
                System.out.println(count + ". " + m.getName());
                freesMotorboat.add(m);
                count++;
            }
        }
        System.out.print("Please introduce the number of the motorboat selected: ");
        int decision = input.nextInt();
        return freesMotorboat.get(decision -1);
        
    }

}
