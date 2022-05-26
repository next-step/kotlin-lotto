package lotto.domain

@JvmInline
value class Money(
    val amount: Int
) {
    operator fun plus(other: Money): Money = Money((amount + other.amount))
    operator fun minus(other: Money): Money = Money((amount - other.amount))
    operator fun compareTo(other: Money): Int = amount.compareTo(other.amount)
    operator fun compareTo(other: Int): Int = amount.compareTo(other)
}
