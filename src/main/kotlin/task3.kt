package h1

import java.util.*
import kotlin.math.roundToInt
import kotlin.math.sqrt

fun main() {
    val scan = Scanner(System.`in`)

    println("Введите ширину:")
    val width = scan.nextDouble()

    println("Введите высоту:")
    val height = scan.nextDouble()

    val result = diagonal(width, height)
    println("Диагональ равна $result")
}

fun diagonal(width: Double, height: Double): Double {
    return (sqrt(width * width + height * height) * 1000).roundToInt().toDouble() / 1000
}