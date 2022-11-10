import java.util.*

class Order(
    val date: Date,
    val status: OrderStatus,
    val customer: Customer,
    val details: OrderDetails,
    val payment: Payment?
) {
    constructor(customer: Customer, details: OrderDetails, payment: Payment? = null)
            : this(Date(), OrderStatus.SEND, customer, details, payment) {

    }

    fun calcPrice(): Int {
        return 1
    }

    fun calcWeight(): Int {
        return 1
    }

    fun pay(payment: Payment): Unit {}

}

enum class OrderStatus {
    SEND,
    AWAIT_PAIMENT,
    PAID,
    PROCESSED,
    RECEIVED
}

class Customer(val name: String, val address: String, orders: List<Order>) {
}

class OrderDetails(val location: String, var items: MutableList<OrderItem>) {

    fun calcPrice(): Int {
        return 1
    }

    fun calcWeight(): Int {
        return 1
    }

    fun addItem(item: OrderItem): Unit {
        items.add(item)
    }
}

data class OrderItem(val name: String, val weight: Double, val price: Int) {

}


enum class Currency(s: String) {
    RUBLES("rub"),
    DOLLARS("dollar"),
    EURO("euro"),
    YUAN("yuan")
}

abstract class Payment(open val amount: Int, val currency: Currency) {
    abstract fun performPayment(): Unit
}

class CashPayment(val total: Int) : Payment(total, Currency.RUBLES) {
    val change: Int
        get() = total - amount

    override fun performPayment() {
        TODO("Not yet implemented")
    }
}

enum class PaymentStatus {
    NONE,
    PAID
}

class OnlinePaiment(override val amount: Int, val bankId: String, val bankName: String, val checkIfSucceed: PaymentStatus) :
    Payment(amount, Currency.RUBLES) {

    override fun performPayment() {
        TODO("Not yet implemented")
    }
}

class DelayedPayment(override val amount: Int, val endDate: Date, val partAmount: String) :
    Payment(amount, Currency.RUBLES) {

    override fun performPayment() {
        TODO("Not yet implemented")
    }
}

