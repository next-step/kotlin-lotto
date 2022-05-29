package lotto.domain

data class PurchaseMoney(val amount: Int) : Comparable<Int> by amount

fun Int.toPurchaseMoney(): PurchaseMoney = PurchaseMoney(this)
