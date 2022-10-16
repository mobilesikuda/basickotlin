package homework3

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Task2Test {
    @Test
    fun test() {
        val test = roman(99)
        assertEquals(test == "XCIX", true, "expected and actual results is not equal")
    }

}