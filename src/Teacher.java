public class Teacher
{
    //instance variables
    String name;
    String subject;
    double height;
    int roomNum;

    //empty constructor
    public Teacher() {
        this.name = "";
        this.subject = "";
        this.height = 0;
        this.roomNum = 0;
    }

    //full constructor
    public Teacher(String name, String subject, double height, int roomNum) {
        this.name = name;
        this.subject = subject;
        this.height = height;
        this.roomNum = roomNum;
    }

    //getters and setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    public int getRoomNum() {
        return roomNum;
    }
    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }
}
