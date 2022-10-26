import kotlin.random.Random

fun main() {

    //val array = intArrayOf(7, 54, 56, 23, 4, 45, 8, 10, 5)
    val rnd = Random
    val array = IntArray(20) { Math.abs(rnd.nextInt(100)) }
    println(array.toList())

    val sum = array.fold(0, { sum, elem -> sum + elem })
    println("Sum of $sum")

    val minOfArray = array.min()
    println("Min value: $minOfArray")

    val maxOfArray = array.max()
    println("Max value: $maxOfArray")

    //val averageOfArray = array.average()
    val averageOfArray = averageElement(array)
    println("Average value: $averageOfArray")

}

//Элемент примерно посередине отсортированного списка
fun averageElement(array: IntArray): Int? {
    if (array.size == 0) return null
    val sortArr = array.sorted()
    return sortArr[sortArr.size / 2]
}