package lotto.auto.vo

enum class LottoScore(private val matchCount: Int, private val rewardMoney: Int) {

    BANG(0, 0),
    FOUR_PLACE(3, 5_000),
    THIRD_PLACE(4, 50_000),
    TWO_PLACE(5, 1_500_000),
    ONE_PLACE(6, 2_000_000_000);

    companion object {

        fun matchCountOf(count: Int): LottoScore {
            if (count in 0..2) {
                return BANG
            }
            return LottoScore.values().find { it.matchCount == count } ?: BANG
        }
    }
}
