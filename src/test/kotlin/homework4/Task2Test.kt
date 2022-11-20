package homework4

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Task2Test {
    @Test
    fun test1() {
        val test = factorial(16)
        assertEquals(test == 20922789888000, true, "Ошибка в функции факториал")
    }

    @Test
    fun test2() {
        val test = factorial(32)
        assertEquals(test == -1L, true, "Ошибка в функции факториал")
    }

}