package homework4

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Task1Test {
    @Test
    fun test1() {
        val test = polyndrome(162261)
        assertEquals(test == true, true, "Ошибка в функции рекурсии")
    }

    @Test
    fun test2() {
        val test = polyndrome(1234567890)
        assertEquals(test == false, true, "Ошибка в функции цикла")
    }
}