package lotto.domain.value

enum class WinLotto(private val index: Int, val money: Money, private var count: Int = 0) {
    ZERO(0, Money(0)),
    ONE(1, Money(0)),
    TWO(2, Money(0)),
    THREE(3, Money(5_000)),
    FOUR(4, Money(50_000)),
    FIVE(5, Money(1_500_000)),
    SIX(6, Money(2_000_000_000));

    override fun toString(): String {
        return "${index}개 일치 ($money)- ${count}개\n"
    }

    companion object {
        private const val ZERO = 0
        private const val THREE = 3

        operator fun invoke(index: Int) = values()[index]

        fun plusCount(index: Int) {
            invoke(index).count++
        }

        fun getCount(index: Int) = invoke(index).count

        fun resultList() = values().filter { it.index >= THREE }.toList()

        fun totalIncome() = values().fold(Money(ZERO)) { total, lotto -> total + (lotto.money * lotto.count) }
    }
}
