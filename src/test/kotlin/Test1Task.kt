import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Test1Task {

    @Test
    fun test(){

        val fr1 = Fraction(1,3)
        val fr2 = Fraction(3, 9)
        assertEquals(fr1, fr2, "Дроби - Нет приведения к общему знаменателю")

        val fr3 = Fraction(1,2) + Fraction(1, 2)
        val fr4 = Fraction(1, 1)
        assertEquals(fr3, fr4, "Дроби - Сложение не работает")

        val fr5 = Fraction(1,3) - Fraction(1, 6)
        val fr6 = Fraction(1, 6)
        assertEquals(fr5, fr6, "Дроби - Вычитание не работает")

    }

}