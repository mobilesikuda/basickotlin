package homework9

class BrokenCurve(override val a: Point, override val b: Point, val c: Point) : Line(a, b) {

    override fun len() = b.distance(a) + b.distance(c)

    //остальные методы остаются неизменными

    fun angleMiddle(): Double {
        val basePoint = Point(a.x - b.x, a.y - b.y)
        val angle = basePoint.angleRadian()
        val endPoint = Point(c.x - b.x, c.y - b.y)
        val newPoint = endPoint.rotate(360 - angle)
        return newPoint.angle360()
    }

    override fun toString(): String {
        return "Line[x=$a.x, y=$a.y -> x=$b.x, y=$b.y -> x=$c.x, y=$c.y]"
    }
}