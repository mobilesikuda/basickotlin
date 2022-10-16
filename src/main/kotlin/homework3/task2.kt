package homework3

import java.util.*

fun main() {
    val scan = Scanner(System.`in`)

    println("Введите число до 100:")
    val inputN  = scan.nextInt()

    println("Число по римски "+ roman(inputN))
}

/**
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
  * Например: 23 = XXIII, 44 = XLIV
 */
fun roman(n: Int): String {
    var str = ""
    val romNumb = listOf( 90, 50, 40, 10, 9, 5, 4, 1)
    val romAbc = listOf("XC", "L", "XL", "X", "IX", "V", "IV", "I")
    var n1 = n
    var i = 0
    while (n1 > 0) {
        while (n1 - romNumb[i] >= 0) {
            str += romAbc[i]
            n1 -= romNumb[i]
        }
        i += 1
    }
    return str
}