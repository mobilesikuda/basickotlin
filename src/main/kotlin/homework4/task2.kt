package homework4

import java.math.BigInteger
import java.util.*

fun main() {
    val scan = Scanner(System.`in`)

    println("Введите число:")
    val inputNumber = scan.nextLong()

    if (inputNumber < 0 ) {
        println("Число отрицательное. Введите положительное")
        return
    }

    //Расчет суммы цифр
    val result = factorial(inputNumber)
    if ( result == -1L ) {
        println("Переполнение числа Long, но")
        println("Факториал числа $inputNumber равен  ${factorialBig(inputNumber)}")
    }
    else println("Факториал числа $inputNumber равен  $result")

}

//Рекурсия
tailrec fun factorial(value: Long, sum: Long = 1): Long {

    //debug
    //println("$sum * $value")
    if(Long.MAX_VALUE / value < sum)  return factorial(1, -1)

    if (value <= 1 ) return sum
    else return factorial(value-1, sum * value)

}

tailrec fun factorialBig(value: Long, sum: BigInteger = BigInteger.ONE): BigInteger {

    //debug
    //println("$sum * $value")

    if (value <= 1 ) return sum
    else return factorialBig(value-1, sum.multiply(BigInteger.valueOf(value)))

}

