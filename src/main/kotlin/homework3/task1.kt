import java.time.DateTimeException
import java.time.LocalDate
import java.time.LocalDate.now
import java.util.*

fun main() {
    val scan = Scanner(System.`in`)

    println("Введите номер месяца:")
    val inputMonth = scan.nextInt()

    println("Введите номер Дня:")
    val inputDay = scan.nextInt()

    val days = beforeNewYear(inputMonth, inputDay)
    if (days == -1) println("Day and Month input incorrect")
    else println("Before Happy New Year $days")
}

//Return days before New Year
//incorrect date return -1
fun beforeNewYear(inputMonth: Int, inputDay: Int): Int {
    val nowYear = now().year
    val setDate = try {
        LocalDate.of(nowYear, inputMonth, inputDay)
    } catch (e: DateTimeException) {
        return -1
    }
    var days = 365 - setDate.dayOfYear
    if (setDate.isLeapYear) days++
    return days + 1

    //Если мы считаем по месяцы по 30 дней
    //return 30 - inputDay + (12-inputMonth)*30 + 1
}
