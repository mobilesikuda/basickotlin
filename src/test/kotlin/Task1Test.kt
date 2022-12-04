import homework10.knapsack
import homework10.knapsackFunc
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.abs
import kotlin.random.Random

class Task1Test {

    @Test
    fun test() {

        val rnd = Random(100)

        val weights = IntArray(10) { if (rnd.nextBoolean()) 1 else 0 }
        val costs = IntArray(10) { abs(rnd.nextInt()) }

        val weightsFunc: (Int) -> Int = { weights[it] }
        val costsFunc: (Int) -> Int = { costs[it] }

        val resultArray = knapsack(weights, costs, 2)
        val resultFunc = knapsackFunc(weightsFunc, 10, costsFunc, 2)

        Assertions.assertEquals(resultArray, resultFunc, "Что-то пошло не так")

    }
}