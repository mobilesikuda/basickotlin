import java.util.*

fun main() {
    val scan = Scanner(System.`in`)

    println("Введите число N:")
    val inputN = scan.nextInt()

    //Заполняем массив вручную
    val array = IntArray(inputN)
    for (i in 0 until inputN) {

        var res: Int
        do {
            res = scan.nextInt()
            val fNotCheck = res >= 100000 || res <= 0
            if (fNotCheck) {
                println("Число должно быть больше 0 и меньше 100000")
            }
        } while (fNotCheck)
        array[i] = res
    }

    //Или заполняем массив случайными элементами
    //val rnd = Random
    //val array = IntArray(inputN) { abs(rnd.nextInt(100000)) }

    println(array.toList())

    println(sortArray(array))

}

fun sortArray(array: IntArray): List<Int> {
    return array.sorted()
}