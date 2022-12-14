import java.util.*

fun main() {
    val scan = Scanner(System.`in`)

    println("Введите строку для разбора:")
    val str = scan.next()

    collectString(str).forEach{
        println("Symbol ${it.key} - ${it.value} time(s)")
    }
}

fun collectString(str: String): HashMap<Char, Int>{
    val hash = HashMap<Char, Int>()

    str.forEach{ elem ->
        hash.put(elem, hash[elem]?.plus(1) ?: 1)
    }

    return hash
}

