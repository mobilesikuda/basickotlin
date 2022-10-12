package h1

import java.util.Scanner

fun main(){
    val scan = Scanner(System.`in`)

    println("Введите чиссло:")
    val inputNumber = scan.nextInt()

    //Проверка на трехзначность
    if( inputNumber > 999 || inputNumber < 100) {
        println("Число не трехзначное")
        return
    }

    //Расчет суммы цифр
    val result = sumOfDigits1(inputNumber)
    println("Сумма цифр равна =  $result")

    //simple test
    if(sumOfDigits1(843) != 15) println("error task1")
}

fun sumOfDigits1(value: Int): Int{
    var result = 0
    var handle = value

    while( handle > 0){
        result += handle%10
        handle /= 10
    }
    return result
}