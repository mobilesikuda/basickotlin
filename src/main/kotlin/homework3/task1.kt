import java.time.DateTimeException
import java.time.LocalDate
import java.time.LocalDate.now
import java.util.*

fun main() {
    val scan = Scanner(System.`in`)

    println("Введите номер месяца:")
    val inputMonth = scan.nextInt()
    if (inputMonth > 12) {
        println("Месяц введен не корректно")
        return
    }

    println("Введите номер Дня:")
    val inputDay = scan.nextInt()
    if (inputDay > 31) {
        println("День введен не корректно")
        return
    }

    val days = beforeNewYear(inputMonth, inputDay)
    if (days == -1) println("День и месяц введен не корректно")
    else println("До Нового года осталось $days дней(дня)")
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

    //Второе решение
    //var days2 = 365 - Month.of(inputMonth).firstDayOfYear(false)

}
