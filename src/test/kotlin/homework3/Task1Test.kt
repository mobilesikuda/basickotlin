package homework3

import beforeNewYear
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Task1Test {
    @Test
    fun test() {
        val test = beforeNewYear(3, 1)
        assertEquals(test == 306, true, "expected and actual results is not equal")
    }
}