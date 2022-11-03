import java.lang.Integer.min

fun main(){

    val fraction1 = Fraction(1024,1022)
    val fraction2 = Fraction(1023,1021)

    val sum = fraction1 + fraction2
    println(sum)

}


class Fraction( var numerator:Int, var denumerator: Int ){

    init{
        if (denumerator == 0)  throw ArithmeticException("Divide by zero")
        normalize()
    }

    private val minpart get() = min(numerator,denumerator)

    operator fun plus(other: Fraction): Fraction {
        val numerator = this.numerator*other.denumerator + this.denumerator*other.numerator
        val denumerator = this.denumerator*other.denumerator
        return Fraction(numerator, denumerator)
    }

    operator fun minus(other: Fraction): Fraction {
        val numerator = this.numerator*other.denumerator - this.denumerator*other.numerator
        val denumerator = this.denumerator*other.denumerator
        return Fraction(numerator, denumerator)
    }

    private fun normalize(){
       var i = minpart
       while( i > 1 ) {
           if(numerator%i == 0 && denumerator%i == 0 ){
               numerator /= i
               denumerator /= i
               i = minpart
           } else i--
       }
    }

    override fun toString(): String {
        return "Fraction($numerator/$denumerator)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Fraction

        if (numerator != other.numerator) return false
        if (denumerator != other.denumerator) return false

        return true
    }

    override fun hashCode(): Int {
       return 100000 * numerator / denumerator
    }

}