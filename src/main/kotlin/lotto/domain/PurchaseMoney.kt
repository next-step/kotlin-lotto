package lotto.domain

data class PurchaseMoney(val amount: Int) : Comparable<Int> by amount {

    override fun toString(): String = amount.toString()
}

fun Int.toPurchaseMoney(): PurchaseMoney = PurchaseMoney(this)
