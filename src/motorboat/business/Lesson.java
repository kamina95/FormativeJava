package motorboat.business;

import java.util.Formatter;

public class Lesson extends Reserve {

    Instructor instructor;

    public Lesson(int date, int startTime, Instructor instructor, Motorboat motorboat, String member) {
        this.date = date;
        this.startTime = startTime;
        this.instructor = instructor;
        this.motorboat = motorboat;
        this.memeber = member;
    }

    public Lesson(int date, int startTime) {
        this.date = date;
        this.startTime = startTime;

    }

    @Override
    public String getMember() {
        return memeber;
    }

    @Override
    public int getDate() {
        return date;
    }

    @Override
    public void setMotorboat(Motorboat motorboat) {
        this.motorboat = motorboat;
    }

    @Override
    public Motorboat getMotorboat() {
        return motorboat;
    }

    @Override
    public int getStartTime() {
        return startTime;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    @Override
    public boolean equals(Object obj) {
        final Reserve other = (Reserve) obj;
        if (this.date != other.date && this.startTime != other.startTime) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.date;
        hash = 67 * hash + this.startTime;
        return hash;
    }

    @Override
    public int getTime() {
        Integer value = 10 * this.date + this.startTime;
        return value;
    }

    @Override
    public int compareTo(Reserve other) {

//        if(other.getTime() > this.getTime()){
//            return 1;
//        }
//        if(this.getTime() > other.getTime()){
//            return 1;
//        }
//        return 0;
        Integer value = this.getTime();
        return value.compareTo(other.getTime());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Formatter fm = new Formatter(sb);
        fm.format("| Instructor: %-15s| Day: %-15s| Hour: %-10s| Motorboat: %-15s|",
                this.getInstructor().getName(), date(this.getDate()), hour(this.getStartTime()), this.getMotorboat().getName());
        sb.append("\n--------------------------------------------------------------------------------------------------");
        return sb.toString();
    }

    public String instructorLesson() {
        StringBuilder sb = new StringBuilder();
        Formatter fm = new Formatter(sb);
        fm.format("| Member: %-15s| Day: %-15s| Hour: %-10s| Motorboat: %-15s|",
                this.getMember(), date(this.getDate()), hour(this.getStartTime()), this.getMotorboat().getName());
        sb.append("\n--------------------------------------------------------------------------------------------------");
        return sb.toString();
    }

    //funtions for do the conversion between addresses of a array to date and hour
    @Override
    public String date(int num) {
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Friday"};
        return days[num];
    }

    @Override
    public String hour(int num) {
        String[] hours = {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"};
        return hours[num];
    }

}
