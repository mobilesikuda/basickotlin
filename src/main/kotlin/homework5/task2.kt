package homework5

import java.util.*
import kotlin.math.sqrt

fun main() {
    val scan = Scanner(System.`in`)

    println("Введите число X1:")
    val inputX1 = scan.nextInt()

    println("Введите число Y1:")
    val inputY1 = scan.nextInt()

    println("Введите число X2:")
    val inputX2 = scan.nextInt()

    println("Введите число Y2:")
    val inputY2 = scan.nextInt()

    //Проверки на диапазон
    val minVal = minOf(inputX1, inputY1, inputX2, inputY2)
    if (minVal <= -10000) {
        println("Минимальное значение должно быть больше -10000")
        return
    }
    val maxVal = maxOf(inputX1, inputY1, inputX2, inputY2)
    if (maxVal >= 10000) {
        println("Максимальное значение не должно быть больше 10000")
        return
    }

    //расчет
    val len = lengthOf(inputX1, inputY1, inputX2, inputY2)
    println("Длина отрезка равна $len")

}

fun lengthOf(x1: Int, y1: Int, x2: Int, y2: Int): Any {
    return sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2).toDouble())
}

fun maxOf(x1: Int, x2: Int, x3: Int, x4: Int): Int {
    return maxOf(maxOf(x1, x2), maxOf(x3, x4))
}