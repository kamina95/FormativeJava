package motorboat.business;

import java.util.ArrayList;
import java.util.Formatter;

public class Motorboat {

    String name;
    ArrayList<Reserve> reserves = new ArrayList<>();

    public Motorboat(String name) {
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
        for (Reserve reservation : reserves) {
            if (L.equals(reservation)) {
                return false;
            }
        }
        return true;
    }

    void addBooking(Reserve lesson) {
        reserves.add(lesson);
    }
    

    String[][] to2d() {
        String[][] table = new String[7][9];

        for (Reserve reserve : reserves) {
            if (reserve instanceof Lesson) {
                table[reserve.getDate()][reserve.getStartTime()] = "LESSON";
            }
            if (reserve instanceof Hire) {
                table[reserve.getDate()][reserve.getStartTime()] = "HIRE";
            }
        }
        return table;
    }

    @Override
    public String toString() {
        String[][] table = to2d();
        StringBuilder sb = new StringBuilder();
        Formatter fm = new Formatter(sb);
        String[] hours = {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"};
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
