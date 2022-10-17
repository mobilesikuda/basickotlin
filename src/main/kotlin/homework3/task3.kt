package homework3

import java.util.*

fun main(){

    val scan = Scanner(System.`in`)

    println("Введите сторону треугольника:")
    val a  = scan.nextDouble()
    println("Введите сторону треугольника:")
    val b  = scan.nextDouble()
    println("Введите сторону треугольника:")
    val c  = scan.nextDouble()

    when(triangleKind(a, b, c)){
        typeTriagle.NO_TRIANGLE -> println("Такого треугольника не существует")
        typeTriagle.ACUTE_TRIANGLE -> println("Треугольник остроугольный")
        typeTriagle.RIGHT_TRIANGLE -> println("Треугольник прямоугольный")
        typeTriagle.OBTUSE_TRIANGLE -> println("Треугольник тупоугольный")
    }

}

/**
 *  Типы треугольников
 * */
enum class typeTriagle{
    ACUTE_TRIANGLE,
    RIGHT_TRIANGLE,
    OBTUSE_TRIANGLE,
    NO_TRIANGLE
}

/**
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */
fun triangleKind(a: Double = 0.0, b: Double, c: Double = 0.0) : typeTriagle {
    if ((a > b + c) || (b > a + c) || (c > b + a))
        return typeTriagle.NO_TRIANGLE
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
        typeTriagle.RIGHT_TRIANGLE
    else if (max < sum)
        typeTriagle.ACUTE_TRIANGLE
    else
        typeTriagle.OBTUSE_TRIANGLE
}
