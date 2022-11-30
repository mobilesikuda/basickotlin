package homework9

@Suppress("UNUSED_PARAMETER")
class Vector(override var b: Point) : Line(Point(0.0, 0.0), b) {

    override fun toString(): String {
        return "Vector[x=$b.x, y=$b.y]"
    }

    constructor(x: Double, y: Double) : this(Point(x, y))
    constructor(line: Line) : this(Point(line.b.x - line.a.x, line.b.y - line.a.y))

    //Нет смысла делать все и так работате во всех по наследованию...
    //fun angel() = this.angle()
    //override fun len(): Double = Point.distance(a, b)
    //override fun rotate(angle: Double) = this.rotate(angle)
    //override fun rotate90(dir: Int) = this.rotate90(dir: Int)
    //override fun isOnLine(a: Point) = this.isOnLine(a)
    //override fun isOnLine(x: Double, y: Double) = this.isOnLine(x, y)

    fun add(x: Double, y: Double) = Line(Point(0.0, 0.0), Point(b.x + x, b.y + y))

    fun add(line: Line) = Line(Point(0.0, 0.0), Point(b.x + line.b.x - line.a.x, line.b.y - line.a.y))


    fun set(x: Double, y: Double) {
        b.x = x
        b.y = y
    }

    fun set(line: Line) {
        b.x = line.b.x - line.a.x
        b.y = line.b.y - line.a.y
    }

    fun setZero() = Line(0.0, 0.0, 0.0, 0.0)
}