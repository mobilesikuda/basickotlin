package homework10

import java.time.LocalDateTime.now

fun main(){

    val function: () -> Int = {
        println("One execute")
        1
    }

    fun task1(N: Int, F: () -> Int){
        for (i in 1..N) F()
    }
    task1(10, function)

    fun <T>MAIN_F(F: () -> T): T {
        println(now())
        val res = F()
        println(now())
        return res
    }
    val res = MAIN_F<Int>(function)
    println(res)

}
