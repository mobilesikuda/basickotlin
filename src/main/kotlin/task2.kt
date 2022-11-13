import java.util.*

class Order(
    val date: Date,
    val status: OrderStatus,
    val customer: Customer,
    val details: OrderDetails,
    val payment: Payment?
) {
    constructor(customer: Customer, details: OrderDetails, payment: Payment? = null)
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

class Customer(val name: String, val address: String, orders: List<Order>) {
}

class OrderDetails(val location: String, var items: MutableList<OrderItem>) {

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

data class OrderItem(val name: String, val weight: Double, val price: Int)


enum class Currency(s: String) {
    RUBLES("rub"),
    DOLLARS("dollar"),
    EURO("euro"),
    YUAN("yuan")
}

abstract class Payment(open val amount: Int, open val currency: Currency) {
    abstract fun performPayment(): Unit
}

class CashPayment(val total: Int, override val amount: Int, override val currency: Currency) :
    Payment(amount, Currency.RUBLES) {
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
    val bankId: String,
    val bankName: String,
    override val amount: Int,
    val checkIfSucceed: PaymentStatus
) :
    Payment(amount, Currency.RUBLES) {

    override fun performPayment() {
        TODO("Not yet implemented")
    }
}

class DelayedPayment(
    val endDate: Date,
    val partAmount: String,
    override val amount: Int,
    override val currency: Currency
) :
    Payment(amount, currency) {

    fun performPartialPayment(amount: Int) {}

    override fun performPayment() {
        TODO("Not yet implemented")
    }
}

