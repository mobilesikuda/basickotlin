package homework4

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Task1Test {
    @Test
    fun `функция проверки рекурсии`() {
        val test = sumOfDigits2(1234567890)
        assertEquals(test == 45, true, "Ошибка в функции рекурсии")
    }

    @Test
    fun `функция проверки цикла`() {
        val test = sumOfDigits1(1234567890)
        assertEquals(test == 45, true, "Ошибка в функции цикла")
    }
}