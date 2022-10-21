import java.util.*

fun main() {
    val scan = Scanner(System.`in`)

    println("Введите число X1:")
    val inputX1 = scan.nextInt()

    println("Введите число X2:")
    val inputX2 = scan.nextInt()

    println("Введите число X3:")
    val inputX3 = scan.nextInt()

    println("Введите число X4:")
    val inputX4 = scan.nextInt()

    val minVal = minOf(inputX1,inputX2, inputX3,inputX4)
    println("Минимальное число равно $minVal")

}

fun minOf(x1: Int, x2: Int, x3: Int, x4: Int): Int {
    return minOf(minOf(x1,x2), minOf(x3,x4))
}