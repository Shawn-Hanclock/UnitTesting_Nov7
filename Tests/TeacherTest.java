import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {
    String str = "";//add 'better' readability
    Teacher computer = new Teacher();//default object, computer teacher

    //Tests for Combo: email
    @Test
    void emailNone() {
        str = computer.getEmail();
        assertTrue(str.isEmpty());
    }
    @Test
    void emailIsSomething() {
        computer.setEmail("jrioux@mvusd.net");
        str = computer.getEmail();
        assertFalse(str.isEmpty());
    }
    @Test
    void emailIsValid() {
        computer.setEmail("jrioux@mvusd.net");
        str = computer.getEmail();
        assertTrue(str.matches("([a-zA-z]){1,}@mvusd\\.net.*"));
    }
    @Test
    void emailIsInvalid() {
        computer.setEmail("jrio@ux@muvsd.nt");
        str = computer.getEmail();
        assertFalse(str.matches("([a-zA-z]){1,}@mvusd\\.net"));
    }
    @Test
    void emailIsValidNumbers() {
        computer.setEmail("jrioux1@mvusd.net");
        str = computer.getEmail();
        assertTrue(str.matches("([a-zA-z0-9]){1,}@mvusd\\.net.*"));
    }
    @Test
    void emailIsInValidNumbers() {
        computer.setEmail("jrioux1@mvusd.net");
        str = computer.getEmail();
        assertFalse(str.matches("(?!.*[0-9])([a-zA-z]){1,}@mvusd\\.net.*"));
    }
    @Test
    void emailIsValidStudent() {
        computer.setEmail("91100232@mvusd.net");
        str = computer.getEmail();
        assertTrue(str.matches("([0-9]){8}@mvusd\\.net.*"));
    }
    @Test
    void emailIsInvalidStudent() {
        computer.setEmail("hello@mvusd.net");
        str = computer.getEmail();
        assertFalse(str.matches("([0-9]){8}@mvusd\\.net.*"));
    }
    @Test
    void emailIsValidJustNumbers() {
        computer.setEmail("789043290@mvusd.net");
        str = computer.getEmail();
        assertTrue(str.matches("([0-9]){1,}@mvusd\\.net.*"));
    }
    @Test
    void emailIsValidNotJustNumbers() {
        computer.setEmail("7432sdfg8904 2321j90@mvusd.net");
        str = computer.getEmail();
        assertFalse(str.matches("([0-9]){1,}@mvusd\\.net.*"));
    }
    @Test
    void emailIsDistrictGmail() {
        computer.setEmail("jrioux@g.mvusd.com");
        str = computer.getEmail();
        assertTrue(str.matches("([a-zA-z]){1,}@g\\.mvusd\\.com"));
    }
    @Test
    void emailIsGmail() {
        computer.setEmail("jrioux@gmail.com");
        str = computer.getEmail();
        assertTrue(str.matches("([a-zA-z]){1,}@gmail\\.com"));
    }
    @Test
    void emailIsNotGmail() {
        computer.setEmail("jrioux@mvusd.net");
        str = computer.getEmail();
        assertFalse(str.matches("([a-zA-z]){1,}@gmail\\.com"));
    }
    @Test
    void emailIsSomeMailKnown() {
        computer.setEmail("jrioux@mvusd.net");
        str = computer.getEmail();
        assertTrue(str.matches("([a-zA-z]){1,}@((gmail\\.com)|(mvusd\\.net)|(yahoo\\.com)|(proton\\.me))"));
    }
    @Test
    void emailIsSomeMailUnknown() {
        computer.setEmail("jrioux@hotmail.net");
        str = computer.getEmail();
        assertFalse(str.matches("([a-zA-z]){1,}@((gmail\\.com)|(mvusd\\.net)|(yahoo\\.com)|(proton\\.me))"));
    }
    @Test
    void emailIsSomeMailOther() {
        computer.setEmail("jrioux@mvusd.net");
        str = computer.getEmail();
        assertTrue(str.matches("([a-zA-z]){1,}@([A-Za-z]){1,}\\.([A-Za-z]){1,}"));
    }
    @Test
    void emailIsTeacher() {
        computer.setEmail("jrioux@mvusd.net");
        str = computer.getEmail();
        assertTrue(str.matches("(?=.*rio)([a-zA-Z]){1}([a-zA-Z]){1,}@mvusd\\.net"));
    }
    @Test
    void emailIsNotTeacher() {
        computer.setEmail("Rioj1@mvusd.net");
        str = computer.getEmail();
        assertFalse(str.matches("(?=.*rio)([a-z]){1}([a-z]){1,}@mvusd\\.net"));
    }
    @Test
    void emailIsWrongTeacher() {
        computer.setEmail("vracataian@mvusd.net");
        str = computer.getEmail();
        assertTrue(str.matches("(?=.*raca)([a-z]){1}([a-z]){1,}(@mvusd\\.net)"));
    }

    //Tests for Number Type string: roomNum
    @Test
    void roomNumNone() {
        str = computer.getRoomNum();
        assertTrue(str.isEmpty());
    }
    @Test
    void roomNumIsAtSomeBuilding() {
        computer.setRoomNum("504");
        String rm = computer.getRoomNum() + "";
        assertTrue(rm.length() == 3 && rm.matches("^([1-5]).*"));
    }
    @Test
    void roomNumIsNotAtSomeBuilding() {
        computer.setRoomNum("004");
        String rm = computer.getRoomNum() + "";
        assertFalse(rm.length() == 3 && rm.matches("^([1-5]).*"));
    }
    @Test
    void roomNumIsFake() {
        computer.setRoomNum("604");
        String rm = computer.getRoomNum() + "";
        assertTrue(rm.length() == 3 && rm.matches("^([6-9]0).*"));
    }
    @Test
    void roomNumIsInWall() {
        computer.setRoomNum("504.5");
        String rm = computer.getRoomNum() + "";
        assertTrue(rm.matches("^([1-5])(([0-1][0-9])|([2][0-4])){1}\\.([0-9]){1,}"));
    }
    @Test
    void roomNumIsWhole() {
        computer.setRoomNum("504");
        String rm = computer.getRoomNum() + "";
        assertFalse(rm.matches("^([1-5])(([0-1][0-9])|([2][0-4])){1}\\.([0-9]){1,}"));
    }
    @Test
    void roomNumIsNotFake() {
        computer.setRoomNum("504");
        String rm = computer.getRoomNum() + "";
        assertTrue(rm.length() == 3 && rm.matches("^([1-5])(([0-1][0-9])|([2][0-4])){1}"));
    }
    @Test
    void roomNumIsPortable() {
        computer.setRoomNum("418");
        String rm = computer.getRoomNum() + "";
        assertTrue(rm.length() == 3 && rm.matches("^([4]).*"));
    }
    @Test
    void roomNumIsNotPortable() {
        computer.setRoomNum("504");
        String rm = computer.getRoomNum() + "";
        assertFalse(rm.length() == 3 && rm.matches("^([4]).*"));
    }
    @Test
    void roomNumIsGym() {
        computer.setRoomNum("201");
        String rm = computer.getRoomNum() + "";
        assertTrue(rm.length() == 3 && rm.matches("^([2]).*"));
    }
    @Test
    void roomNumIsNotGym() {
        computer.setRoomNum("504");
        String rm = computer.getRoomNum() + "";
        assertFalse(rm.length() == 3 && rm.matches("^([2]).*"));
    }
    @Test
    void roomNumIsNew() {
        computer.setRoomNum("504");
        String rm = computer.getRoomNum() + "";
        assertTrue(rm.length() == 3 && rm.matches("^([5]).*"));
    }
    @Test
    void roomNumIsNotNew() {
        computer.setRoomNum("418");
        String rm = computer.getRoomNum() + "";
        assertTrue(rm.length() == 3 && rm.matches("^([4]).*"));
    }
    @Test
    void roomNumIsUpstairs() {
        computer.setRoomNum("520");
        String rm = computer.getRoomNum() + "";
        assertTrue(rm.length() == 3 && rm.matches("^([5]){1}(13|14|15|16|17|18|19|20|21|22|23|24){1}"));
    }
    @Test
    void roomNumIsNotUpstairs() {
        computer.setRoomNum("504");
        String rm = computer.getRoomNum() + "";
        assertFalse(rm.length() == 3 && rm.matches("^([5]){1}(13|14|15|16|17|18|19|20|21|22|23|24){1}"));
    }
    @Test
    void roomNumIsUnderConstruction() {
        computer.setRoomNum("111");
        String rm = computer.getRoomNum() + "";
        assertTrue(rm.length() == 3 && rm.matches("^([1])([0-2])([0-9]){1}"));
    }
    @Test
    void roomNumIsNotNumber() {
        computer.setRoomNum("Commons");
        String rm = computer.getRoomNum() + "";
        assertFalse(rm.length() == 3 && rm.matches("[^0-9].*"));
    }
    @Test
    void roomNumIsNotNumberRoom() {
        computer.setRoomNum("Club room");
        String rm = computer.getRoomNum() + "";
        assertTrue(rm.matches("(?!.*([0-9]))^([a-zA-Z]{1,}\\s(room|Room))$"));
    }
    @Test
    void roomNumIsNotNumberNotRoom() {
        computer.setRoomNum("Club place");
        String rm = computer.getRoomNum() + "";
        assertFalse(rm.matches("(?!.*([0-9]))^([a-zA-Z]{1,}\\s(room|Room))$"));
    }
    @Test
    void roomNumIsNotNumberField() {
        computer.setRoomNum("Baseball field");
        String rm = computer.getRoomNum() + "";
        assertTrue(rm.matches("(?!.*([0-9]))^([a-zA-Z]{1,}\\s(field|Field))$"));
    }
    @Test
    void roomNumIsNotNumberNotField() {
        computer.setRoomNum("Baseball place");
        String rm = computer.getRoomNum() + "";
        assertFalse(rm.matches("(?!.*([0-9]))^([a-zA-Z]{1,}\\s(field|Field))$"));
    }

    //Tests for String: nickname
    @Test
    void nicknameNone() {
        str = computer.getNickname();
        assertTrue(str.isEmpty());
    }
    @Test
    void nicknameThere() {
        str = computer.getNickname();
        assertTrue(str.isEmpty());
    }
    @Test
    void nicknameIsAbbreviation() {
        computer.setNickname("R.");
        str = computer.getNickname();
        assertTrue(str.matches("[A-Za-z]{1,}\\."));
    }
    @Test
    void nicknameIsLong() {
        computer.setNickname("Rioux");
        str = computer.getNickname();
        assertFalse(str.matches("[A-Za-z]{1,5}\\."));
    }
    @Test
    void nicknameIsLetters() {
        computer.setNickname("Rio");
        str = computer.getNickname();
        assertTrue(str.matches("[A-Za-z]{1,5}"));
    }
    @Test
    void nicknameIsNotLetters() {
        computer.setNickname("R!0");
        str = computer.getNickname();
        assertFalse(str.matches("[A-Za-z]{1,5}"));
    }
    @Test
    void nicknameIsAllCaps() {
        computer.setNickname("RIO");
        str = computer.getNickname();
        assertTrue(str.matches("[A-Z]{1,5}"));
    }
    @Test
    void nicknameIsAllLower() {
        computer.setNickname("rio");
        str = computer.getNickname();
        assertTrue(str.matches("[a-z]{1,5}"));
    }
    @Test
    void nicknameIsNumber() {
        computer.setNickname("#1");
        str = computer.getNickname();
        assertTrue(str.matches("#([0-9]){1}"));
    }
    @Test
    void nicknameIsOther() {
        computer.setNickname("|2!0");
        str = computer.getNickname();
        assertTrue(str.matches("[^\\w_].*"));
    }
    @Test
    void nicknameFirstCap() {
        computer.setNickname("Rio");
        str = computer.getNickname();
        assertTrue(str.matches("^[A-Z].*"));
    }
    @Test
    void nicknameFirstNotCap() {
        computer.setNickname("rio");
        str = computer.getNickname();
        assertFalse(str.matches("^[A-Z].*"));
    }
    @Test
    void nickNameIsTwoWord() {
        computer.setNickname("Mz. Rio");
        str = computer.getNickname();
        assertTrue(str.matches("([a-zA-Z]){1,3}\\.\\s([a-zA-Z]){1,5}"));
    }
    @Test
    void nickNameIsNotNickname() {
        computer.setNickname("Jeanine Rioux");
        str = computer.getNickname();
        assertTrue(str.matches("([a-zA-Z]){1,}\\s([a-zA-Z]){1,}"));
    }
    @Test
    void nickNameIsSoftware() {
        computer.setNickname("Software gal");
        //I vaguely remember hearing this one before
        str = computer.getNickname();
        assertTrue(str.matches(".*(software|Software).*"));
    }
    @Test
    void nickNameIsNotSoftware() {
        computer.setNickname("Hardware guy");
        str = computer.getNickname();
        assertFalse(str.matches(".*(software|Software).*"));
    }
    @Test
    void nickNameOnSomedays() {
        computer.setNickname("Dungeon Master");
        str = computer.getNickname();
        assertTrue(str.matches(".*(dungeon|Dungeon).*"));
    }
    @Test
    void nickNameWrongTeacher() {
        computer.setNickname("The Racattack");
        str = computer.getNickname();
        assertTrue(str.matches(".*(raca|Raca).*"));
    }
    @Test
    void nickNameIsDoubleAbbreviation() {
        computer.setNickname("Ms. R.");
        str = computer.getNickname();
        assertTrue(str.matches("([a-zA-Z]){1,3}\\.\\s([a-zA-Z]){1}\\."));
    }
    @Test
    void nickNameIsNotDoubleAbbreviation() {
        computer.setNickname("Ms. Rioux");
        str = computer.getNickname();
        assertFalse(str.matches("([a-zA-Z]){1,3}\\.\\s([a-zA-Z]){1}\\."));
    }
}
