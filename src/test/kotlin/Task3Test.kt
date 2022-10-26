import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Task3Test {

    @Test
    fun test() {
        val array = intArrayOf(7, 54, 56, 23, 4, 45, 8, 10, 5)

        assertEquals(array.min(), 4, "Ошибка в минимальном значении массива")
        assertEquals(averageElement(array), 10, "Ошибка в средний элементе массива")
        assertEquals(array.max(), 56, "Ошибка в максимальном значении массива")
    }

}