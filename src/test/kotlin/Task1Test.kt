import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Task1Test {

    @Test
    fun test() {
        val list = fillListFiles("test1.txt")

        assertEquals(checkPermission(list[0], "DELETE"), false, "Первый элемент не модификатора DELETE")
        assertEquals(list[0].second.size, 0, "У первого элемента нет модификаторов")

    }
}