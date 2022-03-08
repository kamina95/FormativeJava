
package motorboat.business;

import java.util.LinkedList;
import java.util.List;


public abstract class Member {
    String name;
    boolean licence;
    List<Reserve> lessons = new LinkedList<>();
    int lessonLimit;
 
    abstract public String getName();
    abstract boolean hasLicence();
    abstract public List<Reserve> getLessons();
    abstract boolean checkLimit();
    abstract boolean checkSpace(int date, int startTime,Instructor instructor);
    abstract public void addLesson(int date, int startTime, Instructor instructor, Motorboat motorboat);
    abstract Motorboat selectMotorboat(int date, int startTime,Motorboat[] motorboats);
    abstract public void printLessons();
}
