import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Task1Test {

    @Test
    fun test(){
        val list = listOf(
            "test1.txt" to listOf(Modificator.READ),
            "test2.txt" to listOf(Modificator.READ, Modificator.WRITE),
            "test3.txt" to listOf(Modificator.EXECUTE),
        )

        assertEquals(checkPermission(list[0]), listOf(Modificator.READ to true), "Первый элемент не совпал")
        assertEquals(checkPermission(list[1]), listOf(Modificator.READ to true, Modificator.WRITE to true), "Второй элемент не совпал")
        assertEquals(checkPermission(list[2]), listOf(Modificator.EXECUTE to false), "Третий элемент не совпал")

    }
}