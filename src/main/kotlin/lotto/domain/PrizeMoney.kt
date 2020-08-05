package lotto.domain

enum class PrizeMoney(val money: Int, private val countMatch: Int) {
    FIRST(2_000_000_000, 6),
    SECOND(300_000_000, 5),
    THIRD(1_500_000, 5),
    FOURTH(50_000, 4),
    FIFTH(5_000, 3),
    MISS(0, 0);

    fun totalMoney(number: Int): Int = money * number

    fun isIt(countMatch: Int): Boolean = this.countMatch == countMatch
}
