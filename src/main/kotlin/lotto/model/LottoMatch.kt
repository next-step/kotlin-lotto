package lotto.model

enum class LottoMatch(val matchCount: Int, val prizeAmount: Int) {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 150000),
    SIX(6, 2000000000),
    ;

    companion object {
        private val map = entries.associateBy(LottoMatch::matchCount)

        fun fromMatchCount(matchCount: Int): LottoMatch? = map[matchCount]
    }
}
