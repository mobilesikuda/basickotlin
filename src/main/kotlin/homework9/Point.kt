package homework9

import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

class Point(var x: Double = 0.0, var y: Double = 0.0) {

    @JvmName("getXHomework9")
    fun getX() = x//: Double { return x}

    @JvmName("getYHomework9")
    fun getY() = y//: Double { return y}

    override fun toString(): String {
        return "Point[x=$x, y=$y]"
    }

    companion object {

        fun compareX(a: Point, b: Point) = if (a.x > b.x) 1 else if (a.x == b.x) 9 else -1
        fun compareY(a: Point, b: Point) = if (a.y > b.y) 1 else if (a.y == b.y) 9 else -1
        fun distanceSq(a: Point, b: Point) = (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y)
        fun distance(a: Point, b: Point) = sqrt(distanceSq(a, b))

    }

    fun distanceSq(pt: Point) = distanceSq(this, pt)
    fun distance(a: Point) = distance(this, a)
    fun setLocation(x: Double, y: Double) {
        this.x = x
        this.y = y
    }

    //add function
    fun angle(): Double {
        if (x == 0.0)
            if (y > 0.0) return 90.0
            else return 270.0;
        else
            return atan2(y, x)
    }

    fun rotate(angel: Double): Point {
        val my_angle = angle()
        val len = distance(Point(0.0, 0.0), Point(x, y))
        return Point(len * cos(my_angle + angel), len * sin(my_angle + angel))
    }
}