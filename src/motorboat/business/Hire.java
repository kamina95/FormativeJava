package motorboat.business;

import java.util.Formatter;

public class Hire extends Reserve implements Comparable<Reserve> {

    String member;

    public Hire(int date, int startTime, Motorboat motorboat, String memeber) {
        this.date = date;
        this.startTime = startTime;
        this.motorboat = motorboat;
    }

    @Override
    public int getDate() {
        return date;
    }

    @Override
    public String getMember() {
        return memeber;
    }

    @Override
    public int getStartTime() {
        return startTime;
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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reserve other = (Reserve) obj;
        if (this.date != other.date && this.startTime != other.startTime) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + this.date;
        hash = 61 * hash + this.startTime;
        return hash;
    }

    @Override
    public int getTime() {
        Integer value = 10 * this.date + this.startTime;
        return value;
    }

    @Override
    public int compareTo(Reserve other) {
        Integer value = this.getTime();
        return value.compareTo(other.getTime());
    }
    
       @Override
    public String toString() {
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
