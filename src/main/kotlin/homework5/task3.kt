package homework5

import java.util.*

fun main() {
    val scan = Scanner(System.`in`)

    println("Введите пароль:")
    val password = scan.nextLine()

    val res = if (checkPassword(password)) "" else " не  "
    println("Проверка пароля $res пройдена")


}

fun checkPassword(password: String?): Boolean {

    password?.let {

        if (it.length < 6) return false

        val digits = mutableListOf<Char>()
        for (i in it.indices) digits.add(it[i])

        if (!digits.any { it in '0'..'9' }) return false
        if (!digits.any { Character.isUpperCase(it) }) return false

        val maxIndex = digits.size - 2
        for (i in 0 until maxIndex) {
            if (digits[i] == digits[i + 1] && digits[i] == digits[i + 2]) return false
        }
        return true
    }

    return false
}
