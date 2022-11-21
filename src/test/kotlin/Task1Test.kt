import homework9.Point
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class Task1Test {

    @Test
    fun testPoint(){

        val point1 = Point(20.0,20.0)
        assertEquals(point1.angle(), 45.0, "Угол 45 прошел")

        val point2 = Point(20.0,-20.0)
        assertEquals(point1.angle(), 135.0, "Угол 45 прошел")

        val point3 = Point(-20.0,-20.0)
        assertEquals(point1.angle(), 45.0, "Угол 45 прошел")

        val point4 = Point(20.0,20.0)
        assertEquals(point1.angle(), 45.0, "Угол 45 прошел")

    }
}