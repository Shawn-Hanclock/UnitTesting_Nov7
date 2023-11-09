import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {
    String str = "";
    Pattern charUpper = Pattern.compile("[A-Z]");
    Pattern letter = Pattern.compile("[A-Za-z]");
    Pattern letters = Pattern.compile("[A-Za-z]*");
    Pattern lettersFirstUpper = Pattern.compile("[A-Z][a-z]*");
    Pattern lettersFirstUpperLastDot = Pattern.compile("[A-Z][a-z]*" + ".");
    Pattern lettersUpper = Pattern.compile("[A-Z]*");
    Pattern lettersLower = Pattern.compile("[a-z]*");
    Pattern notLetter = Pattern.compile("[^A-Za-z]");
    Teacher computer = new Teacher();

    //String nickName unit tests
    @Test
    void nickNameIsEmpty() {
        str = computer.getNickname();
        assertTrue(str.isEmpty());
    }
    @Test
    void nickNameIsEmptyFalse() {
        computer.setNickname("Rio");
        str = computer.getNickname();
        assertFalse(str.isEmpty());
    }
    @Test
    void nickNameIsChar() {
        computer.setNickname("R");
        str = computer.getNickname();
        assertEquals(str.length(), 1);
    }
    @Test
    void nickNameIsCharFalse() {
        computer.setNickname("Rio");
        str = computer.getNickname();
        assertNotEquals(str.length(), 1);
    }
    @Test
    void nickNameLetterIsCaps() {
        computer.setNickname("R");
        str = computer.getNickname();
        assertTrue(str.matches(charUpper + ""));
    }
    @Test
    void nickNameLetterIsCapsFalse() {
        computer.setNickname("r");
        str = computer.getNickname();
        assertFalse(str.matches(charUpper + ""));
    }
    @Test
    void nicknameIsLetter() {
        computer.setNickname("r");
        str = computer.getNickname();
        assertTrue(str.matches(letter + ""));
    }
    @Test
    void nicknameIsLetterFalse() {
        computer.setNickname("%");
        str = computer.getNickname();
        assertFalse(str.matches(letter + ""));
    }
    @Test
    void nicknameIsLetterOther() {
        computer.setNickname("%");
        str = computer.getNickname();
        assertTrue(str.matches(notLetter + ""));
    }
    @Test
    void nicknameIsLetters() {
        computer.setNickname("Rio");
        str = computer.getNickname();
        assertTrue(str.matches(letters + ""));
    }
    @Test
    void nicknameIsLettersFalse() {
        computer.setNickname("R!0");
        str = computer.getNickname();
        assertFalse(str.matches(letters + ""));
    }
    @Test
    void nicknameIsUpperFirst() {
        computer.setNickname("Rio");
        str = computer.getNickname();
        assertTrue(str.matches( lettersFirstUpper + ""));
    }
    @Test
    void nicknameIsUpperFirstFalse() {
        computer.setNickname("rio");
        str = computer.getNickname();
        assertFalse(str.matches( lettersFirstUpper + ""));
    }
    @Test
    void nicknameIsUpperFirstDLast() {
        computer.setNickname("Rio.");
        str = computer.getNickname();
        assertTrue(str.matches( lettersFirstUpperLastDot + ""));
    }
}
