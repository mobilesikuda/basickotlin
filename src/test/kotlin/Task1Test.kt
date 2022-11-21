import homework9.Point
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class Task1Test {

    @Test
    fun testPoint_angle360(){

        val point1 = Point(20.0,20.0)
        assertEquals(point1.angle360(), 45.0, "Угол не 45 прошел")

        val point2 = Point(-20.0,20.0)
        assertEquals(point2.angle360(), 135.0, "Угол не 135 прошел")

        val point3 = Point(-20.0,-20.0)
        assertEquals(point3.angle360(), 225.0, "Угол не 225 прошел")

        val point4 = Point(20.0,-20.0)
        assertEquals(point4.angle360(), 315.0, "Угол не 270 прошел")

    }
}