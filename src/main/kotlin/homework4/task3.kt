package homework4

import java.util.*

fun main() {
    val scan = Scanner(System.`in`)

    println("Введите число:")
    val inputNumber = scan.nextInt()

    if (inputNumber < 0 ) {
        println("Число отрицательное. Введите положительное")
        return
    }

    drawTriagle(inputNumber)
}

fun drawTriagle(value: Int) {
    for (i in 1..value){
        drawLine(value = i, max = value)
        println()
    }
}

//Рекурсия
fun drawLine(value: Int, max: Int) {
    for (i in  value until max) print(" ")
    for (i in 1 until value) print("* ")
    print("*")
    for (i in value until max) print(" ")
}