package lotto.domain.value

import java.math.BigInteger

enum class WinLotto(private val index: Int, val money: Money, private var count: Int = 0) {
    ZERO(0, Money(0.toBigInteger())),
    ONE(1, Money(0.toBigInteger())),
    TWO(2, Money(0.toBigInteger())),
    THREE(3, Money(5_000.toBigInteger())),
    FOUR(4, Money(50_000.toBigInteger())),
    FIVE(5, Money(1_500_000.toBigInteger())),
    SIX(6, Money(2_000_000_000.toBigInteger()));

    fun getCount() = count

    override fun toString(): String {
        return "${index}개 일치 ($money)- ${count}개\n"
    }

    companion object {
        private const val ZERO = 0L
        private const val THREE = 3

        operator fun invoke(index: Int) = values()[index]

        fun plusCount(index: Int) {
            invoke(index).count++
        }

        fun getCount(index: Int) = invoke(index).count

        fun resultList() = values().filter { it.index >= THREE }.toList()

        fun totalIncome() = values().fold(Money(BigInteger.ZERO)) { total, lotto -> total + (lotto.money * lotto.count) }
    }
}
