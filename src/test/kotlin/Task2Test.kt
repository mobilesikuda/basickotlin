import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Task2Test {

    @Test
    fun test() {
        val list = makeHaspMap("translations1.txt")

        assertEquals(
            list.filter { it.key == "первобытный" }.values.first().toString(),
            "aboriginal",
            "Поиск по русскому слову"
        )
        assertEquals(
            list.filter { it.key == "absorbing" }.values.first().toString(),
            "всасывающий,впитывающий,захватывающий,всепоглощающий,всасывание,поглощение",
            "Поиск по английскому слову"
        )

    }
}