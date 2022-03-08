package motorboat.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;

public class Instructor {

    String name;
    ArrayList<Reserve> reserves = new ArrayList<>();

    public Instructor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Reserve> getLessons() {
        return reserves;
    }

    boolean checkSpace(int date, int startTime) {
        Lesson L = new Lesson(date, startTime);
        for (Reserve lesson : reserves) {
            if (L.equals(lesson)) {
                return false;
            }
        }
        return true;
    }

    public void addLesson(Lesson lesson) {
        System.out.println("Lesson added here");
        reserves.add(lesson);
        System.out.println(reserves.size());
    }

    String[][] to2d(){
        String[][] table = new String[7][9];

        for (Reserve reserve : reserves) {
                table[reserve.getDate()][reserve.getStartTime()] = "BOOKED";
        }
        return table;
    }
    
    
     public void printLessons() {
        if (reserves.isEmpty()) {
            System.out.println("\n This member dosent have any lesson Booked");
        } else {

            Collections.sort(reserves);
            for (Reserve R : reserves) {
                if (R instanceof Lesson) {
                    System.out.println(((Lesson) R).instructorLesson());
                }
            }

        }
    }
    
    @Override
    public String toString() {
        String[][] table =  to2d();
        StringBuilder sb = new StringBuilder();
        Formatter fm = new Formatter(sb);
        String[] hours = {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00","17:00"};
        sb.append("-------------------------------------------------------------------------------------------------------------------------\n");
        sb.append("|       |     Monday    |    Tuesday    |   Wednesday   |   Thursday    |    Friday     |   Saturday    |    Sunday     |\n");
        sb.append("-------------------------------------------------------------------------------------------------------------------------\n");
        for (int i = 0; i < 9; i++) {
            fm.format("| %-6s|", hours[i]);
            for (int j = 0; j < 7; j++) {
                if (table[j][i] == null) {
                    fm.format(" %-14s|", "Free");
                } else {
                    fm.format(" %-14s|", table[j][i]);
                }
            }
            sb.append("\n-------------------------------------------------------------------------------------------------------------------------\n");

        }

        return sb.toString();
    }

}
