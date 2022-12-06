package homework10

import java.time.LocalDateTime.now
import kotlin.math.max

fun main() {

    val function: () -> Int = {
        println("One execute")
        1
    }

    fun task1(N: Int, F: () -> Int) {
        for (i in 1..N) F()
    }
    task1(10, function)

    fun <T> MAIN_F(F: () -> T): T {
        println(now())
        val res = F()
        println(res)
        println(now())
        return res
    }
    MAIN_F<Int>(function)
    //println(res)

    //remove task3 to test
}

fun knapsack(weights: IntArray, costs: IntArray, needed: Int): Int {
    val n = weights.size
    val dp = Array(needed + 1) { IntArray(n + 1) }
    for (j in 1..n) {
        for (w in 1..needed) {
            val el1 = dp[w][j - 1]
            val el2 = dp[w - weights[j - 1]][j - 1] + costs[j - 1]

            val el2Cost = costs[j - 1]

            if (weights[j - 1] <= w) {
                dp[w][j] = max(el1, el2 + el2Cost)
            } else {
                dp[w][j] = el1
            }
        }
    }
    return dp[needed][n]
}

fun knapsackFunc(weightsFunc: (Int) -> Int, weightsSize: ()-> Int, costsFunc: (Int) -> Int, neededFunc: ()->Int): Int {
    val needed = neededFunc()
    val n = weightsSize()
    val dp = Array(needed + 1) { IntArray(n + 1) }
    for (j in 1..n) {
        for (w in 1..needed) {
            val el1 = dp[w][j - 1]
            val el2 = dp[w - weightsFunc(j - 1)][j - 1] + costsFunc(j - 1)
            val el2Cost = costsFunc(j - 1)

            if (weightsFunc(j - 1) <= w) {
                dp[w][j] = max(el1, el2 + el2Cost)
            } else {
                dp[w][j] = el1
            }
        }
    }
    return dp[needed][n]
}
