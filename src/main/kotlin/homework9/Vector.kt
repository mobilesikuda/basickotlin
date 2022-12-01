package homework9

class Vector(inputB: Point) : Line(Point(0.0, 0.0), inputB) {

    override fun toString(): String {
        return "Vector[x=$b.x, y=$b.y]"
    }

    constructor(x: Double, y: Double) : this(Point(x, y))
    constructor(line: Line) : this(Point(line.b.getX() - line.a.getX(), line.b.getY() - line.a.getY()))

    //Нет смысла делать все и так работате во всех по наследованию...
    //fun angel() = this.angle()
    //override fun len(): Double = Point.distance(a, b)
    //override fun rotate(angle: Double) = this.rotate(angle)
    //override fun rotate90(dir: Int) = this.rotate90(dir: Int)
    //override fun isOnLine(a: Point) = this.isOnLine(a)
    //override fun isOnLine(x: Double, y: Double) = this.isOnLine(x, y)

    fun add(x: Double, y: Double) = Line(Point(0.0, 0.0), Point(b.getX() + x, b.getY() + y))

    fun add(line: Line) =
        Line(Point(0.0, 0.0), Point(b.getX() + line.b.getX() - line.a.getX(), line.b.getY() - line.a.getY()))

    fun set(x: Double, y: Double) {
        b.setLocation(x, y)
    }

    fun set(line: Line) {
        b.setLocation(line.b.getX() - line.a.getX(), line.b.getY() - line.a.getY())
    }

    fun setZero() = Line(0.0, 0.0, 0.0, 0.0)
}