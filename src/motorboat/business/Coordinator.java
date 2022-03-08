package motorboat.business;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import motorboat.data.DAO;
import motorboat.data.DAOImplementation;

public class Coordinator {

    private final DAO dao;
    ArrayList<Member> members;
    ArrayList<Instructor> instructors;
    Motorboat[] motorboats;
    public Coordinator() {
        dao = new DAOImplementation();
        this.members = dao.getMembers();
        this.instructors = dao.getInstructors();
        this.motorboats = dao.getMotorboat();
    }

    public Motorboat[] getMotorboats() {
        return motorboats;
    }

    public ArrayList<Instructor> getInstructors() {
        //return instructors;
        Set<Instructor> setI = new HashSet<>();
        for (Member m : members) {
            if(m instanceof Novice){
                setI.add(((Novice) m).getInstructor());
            }
        }
        ArrayList<Instructor> list = new ArrayList<>(setI);
        
        ArrayList<Instructor> ins = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            ins.add(list.get(i));
        }
        return ins;
    }

    
    public ArrayList<Member> getMembers() {
        return members;
    }
    
    public void printInsLess(Instructor I){
        I.printLessons();
    }

    public boolean checkLimitMember(Member member) {
        return member.checkLimit();
    }

    public Instructor getInstructor(Novice N) {
        return N.getInstructor();
    }

    public String instructorName(Instructor I) {
        return I.getName();
    }

    public String InstructorTable(Instructor I) {
        return I.toString();
    }

    public boolean checkAvaliability(Member M, int date, int startTime, Instructor instructor) {
        return M.checkSpace(date, startTime, instructor);
    }

    public Motorboat selectMotorboat(int date, int startTime, Member M) {
        return M.selectMotorboat(date, startTime, this.getMotorboats());
    }

    public void addLessonNovice(Novice N, int date, int startTime,Motorboat motorboat) {
        N.addLesson(date, startTime, N.getInstructor(), motorboat);
    }

    public void addLessonMGLH(MBLH M, int date, int startTime, Instructor instructor, Motorboat motorboat) {
        M.addLesson(date, startTime, instructor, motorboat);
    }
    
    public void addHire(int date,int startTime,Motorboat motorboat, MBLH M){
        M.addHire( date,  startTime,  motorboat);
        System.out.println("Booking Succesfull");
        
    }
    public void addLessonInstructor(Lesson L, Instructor I){
        I.addLesson(L);
    }
    
    public Lesson createLesson(int date, int startTime, Instructor instructor, Motorboat motorboat,String member){
        return new Lesson(date,startTime, instructor, motorboat, member);
    }
    
    public void printLessonHire(Member m){
       if(m instanceof Novice){
           ((Novice) m).printLessons();
       }
    }
    
    public boolean checkHires(MBLH mb){
        return mb.checkHireLimit();
    }
    
    public boolean checkMGLHSpace(int date, int startTime,MBLH m){
        return m.checkSpace( date,  startTime);
    }
    
    public void weekMotorboat(Motorboat M){
        System.out.println(M.toString());
    }
    
}
