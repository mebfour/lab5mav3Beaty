import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
// https://skillbox.ru/media/code/junit-modulnoe-testirovanie-v-java-i-testdriven-development/ - вроде норм статья по тестам
class TestClassTest {

    @Test
    void mult() {
        TestClass tc = new TestClass();

        tc.x = 10;
        tc.y = 5;

        int expected = 50;
        int actual = tc.mult();

        //assertEquals(50, tc.mult(10, 5)); - если б передавали сразу внутрь
        assertEquals(expected, actual, "Эта штука не умеет умножать");
    }
}