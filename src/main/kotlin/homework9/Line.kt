package homework9

import kotlin.math.abs

open class Line(open var a: Point, var b: Point) {

    init {
        if (a == b) throw IllegalArgumentException()
    }

    constructor(x1: Double, y1: Double, x2: Double, y2: Double) : this(Point(x1, y1), Point(x2, y2))
    constructor(line: Line) : this(line.a, line.b)

    fun angle() = Point(b.x - a.x, b.y - a.y).angle360()

    open fun len(): Double = Point.distance(a, b)
    fun rotate(angle: Double) = Line(a.rotate(angle), b.rotate(angle))

    fun rotate90(dir: Int): Line {
        val newA = when (dir >= 0) {
            true -> Point(-a.y, a.x)
            false -> Point(a.y, -a.x)
        }
        val newB = when (dir >= 0) {
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

    companion object {
        fun len(line1: Line, line2: Line): Double {
            if (line1.angle() == line2.angle()) return 0.0
            else return abs((line1.a.x - line2.a.x) * (line1.b.y - line2.a.y) - (line1.b.x - line2.a.x) * (line1.a.y - line2.a.y)) / Point.distance(
                line1.a,
                line1.b
            )
        }

        fun len(a: Point, b: Point, c: Point, d: Point) = len(Line(a, b), Line(c, d))

    }


}