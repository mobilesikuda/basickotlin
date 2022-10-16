package homework3

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Task3Test {
    @Test
    fun test() {
        val test1 = triangleKind(3.0,4.0,5.0)
        assertEquals(test1 == 1, true, "expected and actual results is not equal")

        val test2 = triangleKind(4.0,4.0,5.0)
        assertEquals(test2 == 0, true, "expected and actual results is not equal")

        val test3 = triangleKind(2.0,4.0,5.0)
        assertEquals(test3 == 2, true, "expected and actual results is not equal")
    }
}