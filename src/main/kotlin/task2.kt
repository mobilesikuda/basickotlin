import java.lang.Math.abs
import kotlin.random.Random

fun main() {

    val rnd = Random
    val array1 = IntArray(20) { abs(rnd.nextInt(20)) }
    println(array1.toList())
    val array2 = IntArray(20) { abs(rnd.nextInt(20)) }
    println(array2.toList())

    val arrayPlus = array1 + array2
    println("Один плюс два = ${arrayPlus.toList()}")

    val arrayMinus = array1.toList() - array2.toList()
    println("Есть в первом нет во втором = $arrayMinus")

    val arrayIner = array1.toList().intersect(array2.toList())
    println("Совпадение в одном и во втором = ${arrayIner.toList()}")

}