import h1.sumOfDigits1
import kotlin.test.Test
import kotlin.test.assertEquals

class Task1Test {
    @Test
    fun testSum() {
        val actualResult = sumOfDigits1(843)
        assertEquals(15, actualResult, "expected and actual results is not equal")
    }
}