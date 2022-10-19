import h1.diagonal
import kotlin.test.Test
import kotlin.test.assertEquals

class Task3Test {
    @Test
    fun test() {
        val value = diagonal(10.0, 3.0)
        assertEquals(value, 10.440, "expected and actual results is not equal")
    }
}