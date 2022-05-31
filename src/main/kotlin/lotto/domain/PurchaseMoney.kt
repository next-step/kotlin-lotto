package lotto.domain

data class PurchaseMoney(val amount: Int) : Comparable<Int> by amount {

    operator fun div(other: Int): Int {
        return amount / other
    }
}

fun Int.toPurchaseMoney(): PurchaseMoney = PurchaseMoney(this)
