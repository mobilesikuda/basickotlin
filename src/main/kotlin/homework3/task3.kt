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
        -1 -> println("Такого треугольника не существует")
        0 -> println("Треугольник остроугольный")
        1 -> println("Треугольник прямоугольный")
        2 -> println("Треугольник тупоугольный")
    }

}

/**
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */
fun triangleKind(a: Double, b: Double, c: Double): Int {
    if ((a > b + c) || (b > a + c) || (c > b + a))
        return -1
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
        1
    else if (max < sum)
        0
    else
        2
}
