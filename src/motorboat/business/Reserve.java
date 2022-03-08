package motorboat.business;

public abstract class Reserve implements Comparable<Reserve> {

    int date;
    int startTime;
    Motorboat motorboat;
    String memeber;

    abstract public String getMember();

    abstract public void setMotorboat(Motorboat motorboat);

    abstract public Motorboat getMotorboat();

    abstract public int getDate();

    abstract public int getStartTime();

    abstract public String date(int num);

    abstract public String hour(int num);

    @Override
    abstract public boolean equals(Object obj);

    @Override
    abstract public int hashCode();

    abstract public int getTime();

    @Override
    abstract public int compareTo(Reserve other);

}
