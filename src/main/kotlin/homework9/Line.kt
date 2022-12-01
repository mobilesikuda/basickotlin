package homework9

import kotlin.math.abs

open class Line(var a: Point, var b: Point) {

    init {
        if (a == b) throw IllegalArgumentException()
    }

    constructor(x1: Double, y1: Double, x2: Double, y2: Double) : this(Point(x1, y1), Point(x2, y2))
    constructor(line: Line) : this(line.a, line.b)

    fun angle() = Point(b.getX() - a.getX(), b.getY() - a.getY()).angle360()

    open fun len(): Double = a.distance(b)
    fun rotate(angle: Double) = Line(a.rotate(angle), b.rotate(angle))

    fun rotate90(dir: Int): Line {
        val newA = when (dir >= 0) {
            true -> Point(-a.getY(), a.getX())
            false -> Point(a.getY(), -a.getX())
        }
        val newB = when (dir >= 0) {
            true -> Point(-b.getY(), b.getX())
            false -> Point(b.getY(), -b.getX())
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

    fun len(line2: Line): Double {
        if (this.angle() == line2.angle()) return 0.0
        else return abs((this.a.getX() - line2.a.getX()) * (this.b.getY() - line2.a.getY()) - (this.b.getX() - line2.a.getX()) * (this.a.getY() - line2.a.getY())) /
                this.a.distance(this.b)
    }

}