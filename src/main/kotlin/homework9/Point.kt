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

    fun compareX(b: Point) = if (this.x > b.x) 1 else if (this.x == b.x) 0 else -1
    fun compareY(b: Point) = if (this.y > b.y) 1 else if (this.y == b.y) 0 else -1
    fun distanceSq(b: Point) = (this.x - b.x) * (this.x - b.x) + (this.y - b.y) * (this.y - b.y)
    fun distance(b: Point) = sqrt(distanceSq(b))

    fun setLocation(x: Double, y: Double) {
        this.x = x
        this.y = y
    }

    //add function
    fun angleRadian() = atan2(y, x)

    fun angle360(): Double {
        var result = angleRadian()
        if (result < 0) result += 2 * Math.PI
        return result * 180 / Math.PI
    }

    fun rotate(angel: Double): Point {
        val my_angle = angleRadian()
        val len = Point(0.0, 0.0).distance(Point(x, y))
        return Point(len * cos(my_angle + angel), len * sin(my_angle + angel))
    }
}