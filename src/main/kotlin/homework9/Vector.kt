package homework9

import homework9.Line
import homework9.Point

class Vector(b: Point) : Line(Point(0.0, 0.0), b) {

    override var a: Point
        get() = super.a
        set(value) {
            0
        }

    override fun toString(): String {
        return "Vector[x=$b.x, y=$b.y]"
    }

    constructor(x: Double, y: Double) : this(Point(x, y))
    constructor(line: Line) : this(Point(line.b.x - line.a.x, line.b.y - line.a.y))

    //Нет смысла делать все и так работате во всех наследных функциях...
    fun angel() = this.angle()

    //Можно переписать для примера, но наследование для этого и нужно чтобы все работало
    override fun len(): Double = Point.distance(a, b)

    fun add(x: Double, y: Double) = Line(Point(0.0,0.0), Point(b.x + x, b.y + y))

    fun add(line: Line) = Line(Point(0.0,0.0), Point(b.x + line.b.x - line.a.x, line.b.y - line.a.y))


    fun set(x: Double, y: Double) {
        b.x = x
        b.y = y
    }

    fun set(line: Line) {
        b.x = line.b.x - line.a.x
        b.y = line.b.y - line.a.y
    }

    fun setZero() = Line(0.0,0.0,0.0,0.0)
}