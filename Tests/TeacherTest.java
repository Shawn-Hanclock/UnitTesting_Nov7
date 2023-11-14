import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {

   //instance variables/ teacher object at use for regex checks
    String str = "";
    Teacher computer = new Teacher();

    //int roomNum unit test
    @Test
    void roomNumIs0()
    {
        int rm = computer.getRoomNum();
        assertEquals(rm, 0);
    }
    @Test
    void roomNumIsNot0()
    {
        computer.setRoomNum(504);
        int rm = computer.getRoomNum();
        assertFalse(rm == 0);
    }

    @Test
    void roomNumIsAtSchool() {
        computer.setRoomNum(504);
        String rm = computer.getRoomNum() + "";
        assertTrue(rm.length() == 3 && rm.matches("^([1-5]).*"));
    }

    //String nickname unit tests
    @Test
    void nicknameIsEmpty() {
        str = computer.getNickname();
        assertTrue(str.isEmpty());
    }
    @Test
    void nicknameIsEmptyFalse() {
        computer.setNickname("Rio");
        str = computer.getNickname();
        assertFalse(str.isEmpty());
    }
    @Test
    void nicknameIsChar() {
        computer.setNickname("R");
        str = computer.getNickname();
        assertEquals(str.length(), 1);
    }
    @Test
    void nicknameIsCharFalse() {
        computer.setNickname("Rio");
        str = computer.getNickname();
        assertNotEquals(str.length(), 1);
    }
    @Test
    void nicknameLetterIsCaps() {
        computer.setNickname("R");
        str = computer.getNickname();
        assertTrue(str.matches("[A-Z]"));
    }
    @Test
    void nicknameLetterIsCapsFalse() {
        computer.setNickname("r");
        str = computer.getNickname();
        assertFalse(str.matches("[A-Z]"));
    }
    @Test
    void nicknameIsLetter() {
        computer.setNickname("r");
        str = computer.getNickname();
        assertTrue(str.matches( "[A-Za-z]"));
    }
    @Test
    void nicknameIsLetterFalse() {
        computer.setNickname("1");
        str = computer.getNickname();
        assertFalse(str.matches("[A-Za-z]"));
    }
    @Test
    void nicknameIsLetterNum() {
        computer.setNickname("1");
        str = computer.getNickname();
        assertTrue(str.matches( "\\w"));
    }
    @Test
    void nicknameIsLetterNumFalse() {
        computer.setNickname("%");
        str = computer.getNickname();
        assertTrue(str.matches( "\\W"));
    }
    @Test
    void nicknameIsLetterOther() {
        computer.setNickname("%");
        str = computer.getNickname();
        assertTrue(str.matches( "[^A-Za-z]"));
    }
    @Test
    void nicknameIsLetters() {
        computer.setNickname("Rio");
        str = computer.getNickname();
        assertTrue(str.matches( "[A-Za-z]*"));
    }
    @Test
    void nicknameIsLettersFalse() {
        computer.setNickname("R!0");
        str = computer.getNickname();
        assertFalse(str.matches("[A-Za-z]*"));
    }
    @Test
    void nicknameIsUpperFirst() {
        computer.setNickname("Rio");
        str = computer.getNickname();
        assertTrue(str.matches(  "[A-Z][a-z]*"));
    }
    @Test
    void nicknameIsUpperFirstFalse() {
        computer.setNickname("rio");
        str = computer.getNickname();
        assertFalse(str.matches(  "[A-Z][a-z]*"));
    }
    @Test
    void nicknameIsUpperFirstDLast() {
        computer.setNickname("Rio.");
        str = computer.getNickname();
        assertTrue(str.matches(  "[A-Z][a-z]*."));
    }
    @Test
    void nicknameIsUpperFirstDLastFalse() {
        computer.setNickname("Rio");
        str = computer.getNickname();
        assertTrue(str.matches( "[A-Z][a-z]*."));
    }
    @Test
    void nicknameIsAllCaps() {
        computer.setNickname("RIO");
        str = computer.getNickname();
        assertTrue(str.matches("[A-Z]*"));
    }
    @Test
    void nicknameIsAllCapsFalse() {
        computer.setNickname("RiO");
        str = computer.getNickname();
        assertFalse(str.matches("[A-Z]*"));
    }
    @Test
    void nicknameIsAllLow() {
        computer.setNickname("rio");
        str = computer.getNickname();
        assertTrue(str.matches( "[a-z]*"));
    }
    @Test
    void nicknameIsAllLowFalse() {
        computer.setNickname("RiO");
        str = computer.getNickname();
        assertFalse(str.matches( "[a-z]*"));
    }
    @Test
    void nicknameFirstCap()
    {
        computer.setNickname("Rio");
        str = computer.getNickname();
        assertTrue(str.matches("^[A-Z].*"));
    }
    @Test
    void nicknameFirstCapFalse()
    {
        computer.setNickname("rio");
        str = computer.getNickname();
        assertFalse(str.matches("^[A-Z].*"));
    }
}
