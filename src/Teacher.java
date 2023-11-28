public class Teacher
{
    //instance variables
    String email;
    String nickname;
    String roomNum;

    //default constructor
    public Teacher() {
        this.email = "";
        this.nickname = "";
        this.roomNum = "";
    }
    //full constructor
    public Teacher(String subject, String nickname, String roomNum) {
        this.email = subject;
        this.nickname = nickname;
        this.roomNum = roomNum;
    }
    //getters and setter
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getRoomNum() {
        return roomNum;
    }
    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }
}
