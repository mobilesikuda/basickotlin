import kotlin.math.atan2

class Line(var a: Point, var b: Point) {

    constructor(x1: Double, y1: Double, x2: Double, y2: Double) : this(Point(x1, y1), Point(x2, y2))
    constructor(line: Line) : this(line.a, line.b)

    fun angle(): Double {
        if (a.x == b.x)
            if (a.y < b.y) return 90.0
            else return 270.0
        else
            return atan2(b.y - a.y, b.x - b.y)
    }

    fun len(): Double = Point.distance(a, b)
    fun rotate(angle: Double) {
        this.a = a.rotate(angle)
        this.b = b.rotate(angle)
    }

    fun rotate90(dir: Int) {
        if (dir >= 0) this.a = Point(-a.y, a.x)
        else this.a = Point(a.y, -a.x)
    }

    fun isOnLine(a: Point): Boolean {
        if (this.a == a) return true
        if (angle() == Line(this.a, a).angle()) return true
        else return false
    }

    fun isOnLine(x: Double, y: Double): Boolean {
        return isOnLine(Point(x, y))
    }

    override fun toString(): String {
        return "Line[a=$a, b=$b]"
    }


}