package homework3

import java.util.*

enum class TypeOfTriangles{
    ACUTE, OBTUSE, RIGHT, NOT_EXISTED
}
fun main(){
    val scan = Scanner(System.`in`)

    println("Введите сторону треугольника:")
    val a  = scan.nextDouble()
    println("Введите сторону треугольника:")
    val b  = scan.nextDouble()
    println("Введите сторону треугольника:")
    val c  = scan.nextDouble()

    when(triangleKind(a, b, c)){
        TypeOfTriangles.NOT_EXISTED -> println("Такого треугольника не существует")
        TypeOfTriangles.ACUTE -> println("Треугольник остроугольный")
        TypeOfTriangles.RIGHT -> println("Треугольник прямоугольный")
        TypeOfTriangles.OBTUSE -> println("Треугольник тупоугольный")
    }

}

/**
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */
fun triangleKind(a: Double, b: Double, c: Double): TypeOfTriangles {
    if ((a > b + c) || (b > a + c) || (c > b + a))
        return TypeOfTriangles.NOT_EXISTED
    val max: Double
    val sum: Double
    if (a > b && a > c) {
        max = a * a
        sum = b * b + c * c
    } else if (b > c) {
        max = b * b
        sum = a * a + c * c
    } else {
        max = c * c
        sum = a * a + b * b
    }
    return if (max == sum)
        TypeOfTriangles.RIGHT
    else if (max < sum)
        TypeOfTriangles.ACUTE
    else
        TypeOfTriangles.OBTUSE
}
