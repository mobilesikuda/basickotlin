import h1.yearInMinutes
import kotlin.test.Test
import kotlin.test.assertEquals

class Task2Test {
    @Test
    fun test() {
        val test = yearInMinutes(38578378)
        assertEquals(test.years == 73 && test.months == 4, true, "expected and actual results is not equal")
    }
}


