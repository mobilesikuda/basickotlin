package homework5

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Task1Test {

    @Test
    fun test() {
        val minVal = minOf(100, -2, 33, 5)
        assertEquals(minVal, -2, "Минимальное значение найдено неверно")
    }
}