package lotto.domain

enum class Rank(val numberOfMatch: Int, private val winningMoney: Int) {
    FIRST(6, 200_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000);

    fun getTotalWinningMoney(count: Int) = count * winningMoney

    companion object {
        fun valueOf(matches: Int) = values().find { it.numberOfMatch == matches }
    }
}
