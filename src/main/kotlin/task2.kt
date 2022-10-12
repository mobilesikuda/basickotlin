package h1

import java.time.LocalDate.now
import java.time.Period
import java.time.Period.between
import java.util.Scanner

fun main(){
    val scan = Scanner(System.`in`)

    println("Введите число минут:")
    val inputMinutes = scan.nextInt()

    val period = yearInMinutes(inputMinutes)

    println("Лет между = ${period.years}")
    println("Месяцев  между = ${period.months}")

    //simple test
    val test = yearInMinutes(38578378)
    if( test.years != 73 || test.months !=4 ) println("error task2")
}

fun yearInMinutes(inputMinutes: Int): Period{
    val days = inputMinutes/60/24
    val nowDay = now()
    val futureDay = nowDay.plusDays(days.toLong())

    return between( nowDay, futureDay)
}
