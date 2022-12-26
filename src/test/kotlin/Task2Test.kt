import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Task2Test {

    @Test
    fun test() {

        assertEquals(
            translateWord("первобытный").first().toString(),
            "aboriginal",
            "Поиск по русскому слову"
        )
        assertEquals(
            translateWord( "absorbing" ).first().toString(),
            "всасывающий",
            "Поиск по английскому слову"
        )

    }
}