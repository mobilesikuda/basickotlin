package homework9

class BrokenCurve(a: Point, b: Point, val c: Point) : Line(a, b) {

    override fun len() = b.distance(a) + b.distance(c)

    //остальные методы остаются неизменными

    fun angleMiddle(): Double {
        val basePoint = Point(a.getX() - b.getX(), a.getY() - b.getY())
        val angle = basePoint.angleRadian()
        val endPoint = Point(c.getX() - b.getX(), c.getY() - b.getY())
        val newPoint = endPoint.rotate(360 - angle)
        return newPoint.angle360()
    }

    override fun toString(): String {
        return "Line[x=$a.x, y=$a.y -> x=$b.x, y=$b.y -> x=$c.x, y=$c.y]"
    }
}