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

    val result = (sqrt( width * width + height * height)*1000).roundToInt().toDouble() / 1000
    println("Диагональ равна $result")

}