import java.util.*

class Order(
    private val date: Date,
    private val status: OrderStatus,
    private val customer: Customer,
    private val details: OrderDetails,
    private val payment: Payment?
) {
    constructor(
        customer: Customer,
        details: OrderDetails,
        payment: Payment? = null
    )
            : this(Date(), OrderStatus.SEND, customer, details, payment)

    fun calcPrice(): Int {
        return 0
    }

    fun calcWeight(): Int {
        return 0
    }

    fun pay(payment: Payment) {}

}

enum class OrderStatus {
    SEND,
    AWAIT_PAYMENT,
    PAID,
    PROCESSED,
    RECEIVED
}

class Customer(
    private val name: String,
    private val address: String? = null,
    private val orders: List<Order> = listOf<Order>()
) {
}

class OrderDetails(private val location: String, private val items: MutableList<OrderItem>) {

    fun calcPrice(): Int {
        return 0
    }

    fun calcWeight(): Int {
        return 0
    }

    fun addItem(item: OrderItem): Unit {
        items.add(item)
    }
}

data class OrderItem(private val name: String, private val weight: Double, private val price: Int)


enum class Currency(s: String) {
    RUBLES("rub"),
    DOLLARS("dollar"),
    EURO("euro"),
    YUAN("yuan")
}

abstract class Payment(open val amount: Int, open val currency: Currency, open val status: PaymentStatus) {
    abstract fun performPayment(): Unit
}

class CashPayment(private val total: Int, override val amount: Int, override val currency: Currency) :
    Payment(amount, Currency.RUBLES, PaymentStatus.NOT_PAID) {
    val change: Int
        get() = total - amount

    override fun performPayment() {
        TODO("Not yet implemented")
    }
}

enum class PaymentStatus {
    NOT_PAID,
    PROCESSING,
    PAID
}

class OnlinePayment(
    private val bankId: String,
    private val bankName: String,
    override val amount: Int,
    private val checkIfSucceed: PaymentStatus
) :
    Payment(amount, Currency.RUBLES, PaymentStatus.NOT_PAID) {

    override fun performPayment() {
        TODO("Not yet implemented")
    }
}

class DelayedPayment(
    private val endDate: Date,
    private val partAmount: String,
    override val amount: Int,
    override val currency: Currency
) :
    Payment(amount, currency, PaymentStatus.NOT_PAID) {

    fun performPartialPayment(amount: Int) {}

    override fun performPayment() {
        TODO("Not yet implemented")
    }
}

