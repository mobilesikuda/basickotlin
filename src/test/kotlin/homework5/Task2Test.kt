package homework5

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Task2Test {

    @Test
    fun test() {
        val len = lengthOf(0, 0, 4, 3)
        assertEquals(len, 5.0, "Длина отрезка неправильно считается")
    }
}
