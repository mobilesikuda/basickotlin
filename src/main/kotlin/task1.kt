import java.lang.Long.min
import java.math.BigDecimal

fun main(){

    val fraction1 = Fraction((Int.MAX_VALUE-3),1024)
    val fraction2 = Fraction(Int.MAX_VALUE-1,1000)

    val sum1 = fraction1 + fraction2
    println(sum1)

    val sum2 = Fraction((Long.MAX_VALUE-13),1024L) + Fraction(Long.MAX_VALUE-1000,1000L)
    println(sum2)

    val sum3 = FractionBig(BigDecimal(Long.MAX_VALUE-13),BigDecimal(1024)) + FractionBig(BigDecimal(Long.MAX_VALUE-1000),BigDecimal(1000))
    println(sum3)
}

class Fraction( var numerator: Long, var denumerator: Long ){

    init{
        if (denumerator == 0L)  throw ArithmeticException("Divide by zero")
        normalize()
    }
    constructor(numerator:Int, denumerator:Int) : this(numerator.toLong(), denumerator.toLong())
    private val minOf get() = min(numerator,denumerator)

    operator fun plus(other: Fraction): Fraction {
        val numerator = this.numerator*other.denumerator + this.denumerator*other.numerator
        val enumerator = this.denumerator*other.denumerator
        return Fraction(numerator, enumerator)
    }

    operator fun minus(other: Fraction): Fraction {
        val numerator = this.numerator*other.denumerator -  this.denumerator*other.numerator
        val denumerator = this.denumerator*other.denumerator
        return Fraction(numerator, denumerator)
    }

    private fun normalize(){
       var i = minOf
       while( i > 1 ) {
           if( numerator.mod(i) == 0L && denumerator.mod(i) == 0L ){
               numerator /= i
               denumerator /= i
               i = minOf
           } else i--
       }
    }

    override fun toString(): String {
        return "Fraction($numerator/$denumerator)=${numerator/denumerator.toDouble()}"
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
       return (100000 * numerator / denumerator).toInt()
    }

}

class FractionBig( var numerator: BigDecimal, var denumerator: BigDecimal ){

    init{
        if (denumerator.equals(BigDecimal("0")))  throw ArithmeticException("Divide by zero")
        normalize()
    }
    private val minOf: BigDecimal
    get() {
        if(numerator < denumerator) return numerator
        else return denumerator
    }

    operator fun plus(other: FractionBig): FractionBig {
        val numerator = this.numerator*other.denumerator + this.denumerator*other.numerator
        val enumerator = this.denumerator*other.denumerator
        return FractionBig(numerator, enumerator)
    }

    operator fun minus(other: FractionBig): FractionBig {
        val numerator = this.numerator*other.denumerator -  this.denumerator*other.numerator
        val denumerator = this.denumerator*other.denumerator
        return FractionBig(numerator, denumerator)
    }

    private fun normalize(){
        var i = minOf
        while( i > BigDecimal(1) ) {
            if( numerator%i == BigDecimal(0) && denumerator%i == BigDecimal(0) ){
                numerator /= i
                denumerator /= i
                i = minOf
            } else i--
        }
    }

    override fun toString(): String {
        return "Fraction($numerator/$denumerator)=${numerator.toDouble()/denumerator.toDouble()}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as FractionBig

        if (numerator != other.numerator) return false
        if (denumerator != other.denumerator) return false

        return true
    }

    override fun hashCode(): Int {
        return (100000 * numerator.hashCode() / denumerator.hashCode())
    }

}