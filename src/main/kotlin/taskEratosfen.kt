import java.lang.Math.sqrt
import kotlin.system.measureTimeMillis

fun main(){

    println("mls:"+ measureTimeMillis( { calculate1() }))
    println("mls:"+ measureTimeMillis( { calculate2() }))
    println("mls:"+ measureTimeMillis( { calculate3() }))

}

fun calculate1() {
    val n = 50_000_000
    val array = IntArray(n + 1){ 1 }

    val max_int = sqrt(Int.MAX_VALUE.toDouble()).toInt()

    val timeBegin = System.currentTimeMillis()
    var i = 2
    while ( i <= n ) {
        if (array[i] == 1) {
            if (i > max_int) break
            val sq = i * i
            if( sq > n ) break
            //if (sq <= n) {
                var m: Int = sq
                while (m <= n) {
                    array[m] = 0
                    m += i
                }
            //}
        }
        //if(array[i] == 1 && i < 1000) print("$i ")
        i++
    }
    //println()
    val timeEnd = System.currentTimeMillis()
    val diff: Double = (timeEnd.toDouble() - timeBegin) / 1_000
    println(diff.toString()+" sec.")

}

fun calculate2() {
    val n = 50_000_000
    val array = Array(n + 1){ 1 }

    val timeBegin = System.currentTimeMillis()
    var i = 2
    while ( i <= n ) {
        if (array[i] == 1) {
            val sq: Long = i.toLong() * i
            if (sq <= n) {
                var m: Int = sq.toInt()
                while (m <= n) {
                    array[m] = 0
                    m += i
                }
            }
        }
        //if(array[i] == 1 && i < 1000) print("$i ")
        i++
    }
    //println()
    val timeEnd = System.currentTimeMillis()
    val diff: Double = (timeEnd.toDouble() - timeBegin) / 1_000
    println(diff.toString()+" sec.")
}

private fun calculate3(){
    val n = 50_000_000
    val list = mutableListOf(0,0)
    for (i in 2 .. n) list.add(1)

    val timeBegin = System.currentTimeMillis()
    var i = 2
    while ( i <= n ) {
        if (list[i] == 1) {
            val sq: Long = i.toLong() * i
            if (sq <= n) {
                var m: Int = sq.toInt()
                while (m <= n) {
                    list[i] = 0
                    m += i
                }
            }
        }
        i += 1
    }
    val timeEnd = System.currentTimeMillis()
    val diff: Double = (timeEnd.toDouble() - timeBegin) / 1_000
    println("$diff sec.")
}