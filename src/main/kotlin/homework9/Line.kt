package homework9

import kotlin.math.atan2

open class Line(open var a: Point, var b: Point) {

    constructor(x1: Double, y1: Double, x2: Double, y2: Double) : this(Point(x1, y1), Point(x2, y2))
    constructor(line: Line) : this(line.a, line.b)

    fun angle(): Double {
        return if (a.x == b.x)
            if (a.y < b.y) 90.0
            else 270.0
        else
            atan2(b.y - a.y, b.x - b.y)
    }

    open fun len(): Double = Point.distance(a, b)
    fun rotate(angle: Double):Line {
        return Line(a.rotate(angle), b.rotate(angle))
    }

    fun rotate90(dir: Int): Line {
        val newA =  when(dir >= 0) {
            true -> Point(-a.y, a.x)
            false -> Point(a.y, -a.x)
        }
        val newB =  when(dir >= 0) {
            true -> Point(-b.y, b.x)
            false -> Point(b.y, -b.x)
        }
        return Line(newA, newB)
    }

    fun isOnLine(a: Point): Boolean {
        if (this.a == a) return true
        return angle() == Line(this.a, a).angle()
    }

    fun isOnLine(x: Double, y: Double): Boolean {
        return isOnLine(Point(x, y))
    }

    override fun toString(): String {
        return "Line[x=$a.x, y=$a.y -> x=$b.x, y=$b.y]"
    }


}