import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Task1Test {

    @Test
    fun test() {
        val array = intArrayOf(6, 45, 2, 5, 65, 7, 672, 3, 12, 9, 87, 45, 76, 355, 326)
        val arraySort = intArrayOf(2, 3, 5, 6, 7, 9, 12, 45, 45, 65, 76, 87, 326, 355, 672)
        assertEquals(arraySort.toList(), sortArray(array), "Сортировка массива не удалась")
    }
}