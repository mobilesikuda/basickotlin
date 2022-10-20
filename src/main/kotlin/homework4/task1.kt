package homework4

import java.util.*

fun main() {
    val scan = Scanner(System.`in`)

    println("Введите чиссло:")
    val inputNumber = scan.nextInt()

    val strNotPolidrome = if (polyndrome(inputNumber)) "" else "не"
    println("Число $inputNumber $strNotPolidrome является полидромом")
}

fun polyndrome(value: Int): Boolean {
    val arrayDigits = listDigits(value)
    val size = arrayDigits.size - 1
    for (i in 0..size) {
        if (arrayDigits[i] != arrayDigits[size - i])
            return false
    }
    return true
}

fun listDigits(value: Int): List<Int> {
    var handle = value
    val array = mutableListOf<Int>()

    while (handle > 0) {
        array.add(handle % 10)
        handle /= 10
    }
    return array.toList()
}