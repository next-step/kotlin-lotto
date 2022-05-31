package lotto.domain

data class Money(val amount: Int) : Comparable<Int> by amount {

    operator fun div(other: Int): Int {
        return amount / other
    }
}

fun Int.toMoney(): Money = Money(this)
