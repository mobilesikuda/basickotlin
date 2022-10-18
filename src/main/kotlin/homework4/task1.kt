package homework4

import java.util.Scanner

fun main() {
    val scan = Scanner(System.`in`)

    println("Введите чиссло:")
    val inputNumber = scan.nextInt()

    //Расчет суммы цифр
    val result = sumOfDigits2(inputNumber)
    println("Сумма цифр равна =  $result")

}

//Рекурсия
tailrec fun sumOfDigits2(value: Int, sum: Int = 0): Int {

    if (value == 0 ) return sum
    else return sumOfDigits2(value/10, sum + value%10)

}

//Простой цикл
fun sumOfDigits1(value: Int): Int {
    var result = 0
    var handle = value

    while (handle > 0) {
        result += handle % 10
        handle /= 10
    }
    return result
}