public class Teacher
{
    //instance variables
    String name;
    String subject;
    String nickname;
    int roomNum;

    //empty constructor
    public Teacher() {
        this.name = "";
        this.subject = "";
        this.roomNum = 0;
    }

    //full constructor
    public Teacher(String name, String subject, String nickname, int roomNum) {
        this.name = name;
        this.subject = subject;
        this.nickname = nickname;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getRoomNum() {
        return roomNum;
    }
    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }
}
